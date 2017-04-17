package excute.register;

import static common.Common.*;
import static common.constant.ChanceConstants.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import excute.bean.AccountBean;
import excute.excel.Output;
import excute.excel.Output_Excel;

/**
 * =====================================================================================================================
 * 【チャンスイット】：新規登録し、WEB診断URLを取得する
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Register{
	/** 「WEBドライバー」 */
	WebDriver driver;
	/** 「診断URL」 */
	String shindan_url  = StringUtils.EMPTY;
	/** 「出力診断URL」 */
	String output_shindan_url  = StringUtils.EMPTY;
	/** 「獲得ポイント」 */
	int point_count = 0;
	/** 「再スタートフラグ」 */
	Boolean restart_flag = Boolean.FALSE;
	/** 「WEB診断開始番号」 */
	int start = 0;
	/** 「WEB診断終了番号」 */
	int end = 50;
	/** 「アカウントBean」 */
	AccountBean bean = new AccountBean();
	/** 「出力アカウントリスト」 */
	List<AccountBean> outputList = new ArrayList<AccountBean>();
	/** 「JavaScript」 */
	JavascriptExecutor jse;
	/** 「登録日付」 */
	String register_data  = StringUtils.EMPTY;
	/** 「獲得ポイント」 */
	String point  = "0";
	/** 「ID」 */
	String id  = "";
	/** 「パスワード」 */
	String pass  = "";
	/** 「UID」 */
	String uid  = "";


	/**
	 * コンストラクタ
	 */
	public Register(String pId, String pPass, String pUid) {
		// Chromeドライバーをプロパティへ設定
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		// 現在日付
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		register_data = sdf.format(nowDate);
		this.id = pId;     // ID
		this.pass = pPass; // パスワード
		this.uid = pUid;   // UID
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：新規登録し、WEB診断URLを取得する
	 * =================================================================================================================
	 *
	 * @return int point_couont 獲得済みポイント
	 *
	 * @author kimC
	 *
	 */
	public Integer execute(List<AccountBean> list) {
		for (int i = 0; i < list.size(); i++) {
			// アカウントBean
			bean = list.get(i);
			// Chromeドライバー
			driver = new ChromeDriver();
			jse = (JavascriptExecutor) driver;
			// 「登録URL」
			driver.get(PC_REGISTER_URL);
			// 1.5秒待ち
			sleep(1500);
			// 仮登録
			if(!this.register()){
				// 出力アカウント情報を設定する
				outputList.add(bean);
				// ブラウザを終了する
				driver.quit();
				continue;
			}
			// 1秒待ち
			sleep(1000);
			// メール確認
			if(!this.mail_confirm()){
				// 出力アカウント情報を設定する
				outputList.add(bean);
				// ブラウザを終了する
				driver.quit();
				continue;
			}
			// WEB診断一覧画面
			if(!this.getShindanList()){
				this.getShindanList();
			}
			// WEB診断URLを設定する
			bean.setUrl(this.output_shindan_url);
			// 登録日付を設定する
			bean.setData(this.register_data);
			// 出力アカウント情報を設定する
			outputList.add(bean);
			this.wifiRestart();
			// ブラウザを終了する
			driver.quit();
			if(i == 40){
				// アカウント情報出力する
				this.output_account(this.outputList,"");
			}else if(i == 80){

			}else if(i == (list.size() - 1)){

			}

		}
		// アカウント情報出力する
		this.output_all_account();
		return point_count;
	}

	/**
	 * =================================================================================================================
	 * 個人情報登録処理
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public Boolean register() {
		try{
			// メールアドレス
			driver.findElement(By.name("email")).sendKeys(bean.getEmail());
			// パスワード
			driver.findElement(By.name("password")).sendKeys(bean.getPassword());
			// ニックネーム
			driver.findElement(By.name("nickname")).sendKeys(bean.getNickname());
			// 年
			Select year = new Select(driver.findElement(By.name("birthday.0")));
			year.selectByValue(bean.getYear());
			// 月
			Select month = new Select(driver.findElement(By.name("birthday.1")));
			month.selectByValue(bean.getMonth());
			// 日
			Select day = new Select(driver.findElement(By.name("birthday.2")));
			day.selectByValue(bean.getDay());
			// 性別
			driver.findElements(By.name("sex")).get(getIndex(bean.getSex())).click();
			// 登録
			driver.findElement(By.id("register1")).click();
			// 仮登録
			driver.findElement(By.id("register2")).click();
			return Boolean.TRUE;
		}catch (Exception e){
			System.out.println("【エラー】：個人情報登録処理失敗");
			return Boolean.FALSE;
		}

	}

	/**
	 * =================================================================================================================
	 * チャンスイット：メール確認
	 * =================================================================================================================
	 *
	 * @return Boolean 処理結果
	 *
	 * @author kimC
	 *
	 */
	public Boolean mail_confirm() {
		try {
			Boolean flag = Boolean.FALSE;
			// メールログイン処理
			flag = this.mail_login();
			if(flag){
				// メール内容確認処理
				flag = this.mail_text_confirm();
			}
			return flag;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：メールログイン
	 * =================================================================================================================
	 *
	 * @return Boolean 処理結果
	 *
	 * @author kimC
	 *
	 */
	public Boolean mail_login() {
		try {
			// 使い捨てメール画面
			driver.get(MAIL_URL);
			// 1秒待ち
			sleep(1000);
			// 「他のアカウントにログイン（復元／同期）」をクリック
			driver.findElement(By.id("link_loginform")).click();
		    // 「ID」を入力する
			driver.findElement(By.id("user_number")).sendKeys(this.id);
		    // 「パスワード」を入力する
			driver.findElement(By.id("user_password")).sendKeys(this.pass);
		    // 2秒待ち
			sleep(2000);
		    // 「ログインする」ボタンのクリック
			jse.executeScript("checkLogin();");
			// 1秒待ち
			sleep(1000);
		    // 「確認」をクリックする
			jse.executeScript("okConfirmDialog();");
			// 1秒待ち
			sleep(1000);
			driver.switchTo().alert().accept();
			// 2秒待ち
			sleep(2000);
			driver.switchTo().alert().accept();
			return Boolean.TRUE;
		} catch (Exception e) {
			try {
				// 1秒待ち
				sleep(1000);
				driver.switchTo().alert().accept();
				return Boolean.TRUE;
			}catch(Exception r_e){
				System.out.println("【エラー】：チャンスイットメールログイン失敗");
				return Boolean.FALSE;
			}
		}
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：メール確認
	 * =================================================================================================================
	 *
	 * @return Boolean 処理結果
	 *
	 * @author kimC
	 *
	 */
	public Boolean mail_text_confirm() {
		try {
			// 3秒待ち
			sleep(3000);
			// 「受信トレイ」をクリックする
			jse.executeScript("location.href='recv.php';");
			// 1秒待ち
			sleep(1000);
			String mail_title = driver.findElements(By.className("ui-listview")).get(1).getText().split("\n")[0];
			if(mail_title.matches(".*【チャンスイット】仮登録完了のご案内.*")){
				return this.register_url(1);
			}else{
				Boolean flag = Boolean.FALSE;
				Boolean break_flag = Boolean.FALSE;
				for(int n = 0; n < 2; n++){
					for(int i = 2; i < 101; i++){
						String title = driver.findElements(By.className("ui-listview")).get(i).getText().split("\n")[0];
						if(title.matches(".*【チャンスイット】仮登録完了のご案内.*")){
							flag = this.register_url(i);
							break_flag = Boolean.TRUE;
							break;
						}
					}
					if(break_flag){
						break;
					}else{
						// 「ALL」
						driver.findElement(By.xpath("//img[@src='img/chkall.png']")).click();
						// 「削除」
						driver.findElement(By.id("link_checkmenu_delele")).click();
						// 1秒待ち
						sleep(500);
						driver.switchTo().alert().accept();
						// 1秒待ち
						sleep(1000);
					}
				}
				return flag;
			}

		} catch (Exception e) {
			try {
				// 使い捨てメール画面
				driver.get(MAIL_URL);
				// 3秒待ち
				sleep(3000);
				// 「受信トレイ」をクリックする
				jse.executeScript("location.href='recv.php';");
				// 1秒待ち
				sleep(1000);
				String mail_title = driver.findElements(By.className("ui-listview")).get(1).getText().split("\n")[0];
				if(mail_title.matches(".*【チャンスイット】仮登録完了のご案内.*")){
					return this.register_url(1);
				}
				return Boolean.FALSE;
			} catch (Exception r_e) {
				System.out.println("【エラー】：チャンスイットメール確認失敗");
				return Boolean.FALSE;
			}

		}
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：メール確認
	 * =================================================================================================================
	 *
	 * @return Boolean 処理結果
	 *
	 * @author kimC
	 *
	 */
	public Boolean register_url(int i) {
		// メール内容詳細参照用ドライバー
		WebDriver mail_detail = new ChromeDriver();
		try {
			String mail_id = driver.findElements(By.className("ui-listview")).get(i).findElement(By.tagName("li")).getAttribute("id");
			String mail_num = mail_id.split("_", 0)[2];
			String mail_detail_url = "https://m.kuku.lu/smphone.app.recv.data.php?UID=" + this.uid + "&num=" + mail_num + "&detailmode=1";
			// メール内容詳細参照へ遷移する
			mail_detail.get(mail_detail_url);
			// 「チャンスイット」本登録用URLを取得する
			String chance_register_url = mail_detail.findElement(By.partialLinkText("https://www.chance.com/member/vcampaign.srv")) .getText();
			mail_detail.quit();
			driver.get(chance_register_url);
			return Boolean.TRUE;
		} catch (Exception e) {
			mail_detail.quit();
			return Boolean.FALSE;
		}
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：WEB診断一覧画面へ遷移
	 * =================================================================================================================
	 *
	 * @return Boolean 処理結果
	 *
	 * @author kimC
	 *
	 */
	public Boolean getShindanList() {
		try {
			// 1秒待ち
			sleep(1000);
			driver.get("http://www.chance.com/research/shindan/play.jsp");
			// 1.5秒待ち
			sleep(1500);
			output_shindan_url = driver.getCurrentUrl();
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("【エラー】：WEB診断一覧画面へ遷移失敗");
			return Boolean.FALSE;
		}
	}

	/**
	 * =================================================================================================================
	 * Wifiを再起動する
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public void wifiRestart() {
		try{
			driver.get("http://admin:20110119Jjz@192.168.179.1/index.cgi/reboot_main");
			driver.findElement(By.id("UPDATE_BUTTON")).click();
			driver.switchTo().alert().accept();
			// 12秒待ち
			sleep(100000);
			driver.switchTo().alert().accept();
			System.out.println("Wifi再起動成功！");
		}catch (Exception e) {
			System.out.println("【エラー】：Wifi再起動失敗！");
		}
	}

	/**
	 * =================================================================================================================
	 * アカウント情報を出力する
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public void output_all_account() {
		try{
			Output output_url = new Output();
			output_url.execute(outputList);
			System.out.println("アカウント・WEB診断URL出力成功！");
		}catch (Exception e) {
			System.out.println("【エラー】：アカウント・WEB診断URL出力失敗！");
		}
	}

	/**
	 * =================================================================================================================
	 * アカウント情報を出力する
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public void output_account(List<AccountBean> list, String name) {
		try{
			Output_Excel output_url = new Output_Excel();
			output_url.execute(list, name);
			System.out.println("アカウント・WEB診断URL出力成功！");
		}catch (Exception e) {
			System.out.println("【エラー】：アカウント・WEB診断URL出力失敗！");
		}
	}

	/**
	 * sleep処理
	 *
	 * @param long 秒数
	 */
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
