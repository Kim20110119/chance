package excute.register;

import static common.Common.*;
import static common.constant.ChanceConstants.*;
import static common.constant.HtmlConstants.*;

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

import common.shindan.WebShindan;
import excute.bean.AccountBean;
import excute.excel.Output;

/**
 * =====================================================================================================================
 * 【チャンスイット】：登録
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Chance_Register{
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
	/** 「登録日付」 */
	String register_data  = StringUtils.EMPTY;
	/** 「獲得ポイント」 */
	String point  = "0";


	/**
	 * コンストラクタ
	 */
	public Chance_Register() {
		// Chromeドライバーをプロパティへ設定
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		// 現在日付
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		register_data = sdf.format(nowDate);
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：WEB診断
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
			// 「登録URL」
			driver.get(PC_REGISTER_URL);
			// 0.5秒待ち
			sleep(500);
			// 仮登録
			if(!this.register()){
				continue;
			}
			// メール確認
			if(!this.mail_confirm()){
				continue;
			}
			// WEB診断一覧画面
			if(!this.getShindanList()){
				this.getShindanList();
			}
			for (int shindan_index = start; shindan_index < end; shindan_index++) {
				// 0.5秒待ち
				sleep(500);
				// 診断URL
				shindan_url = driver.findElements(By.xpath("//a[@role='button']")).get(shindan_index).getAttribute(A_HREF);
				// WEB診断
				driver.get(shindan_url);
				if (!start()) {
					restart();
				}
				// 「WEB診断一覧」
				driver.get("http://www.chance.com/research/shindan/play.jsp");
			}
			// 獲得済みポイントを取得する
			this.getPoint();
			// WEB診断URLを設定する
			bean.setUrl(this.output_shindan_url);
			// 登録日付を設定する
			bean.setData(this.register_data);
			// 獲得済みポイントを設定する
			bean.setPoint(this.point);
			// 出力アカウント情報を設定する
			outputList.add(bean);
			this.wifiRestart();
			// ブラウザを終了する
			driver.quit();
		}
		// アカウント情報出力する
		this.output_account();
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
			// 使い捨てメール画面
			driver.get(MAIL_URL);
			// 2秒待ち
			sleep(2000);
			// 「他のアカウントにログイン（復元／同期）」をクリック
			driver.findElement(By.id("link_loginform")).click();
		    // 「ID」を入力する
			driver.findElement(By.id("user_number")).sendKeys(MAIL_ID);
		    // 「パスワード」を入力する
			driver.findElement(By.id("user_password")).sendKeys(MAIL_PASS);
		    // 1秒待ち
			sleep(1000);
		    // 「ログインする」ボタンのクリック
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("checkLogin();");
			// 1秒待ち
			sleep(1000);
		    // 「確認」をクリックする
			jse.executeScript("okConfirmDialog();");
			// 1秒待ち
			sleep(1000);
			driver.switchTo().alert().accept();
			// 1秒待ち
			sleep(1000);
			driver.switchTo().alert().accept();
			// 2秒待ち
			sleep(2000);
			// 「受信トレイ」をクリックする
			jse.executeScript("location.href='recv.php';");
			// 1秒待ち
			sleep(1000);
			String mail_id = driver.findElements(By.className("ui-listview")).get(1).findElement(By.tagName("li")).getAttribute("id");
			String mail_num = mail_id.split("_", 0)[2];
			String mail_detail_url = "https://m.kuku.lu/smphone.app.recv.data.php?UID=6cef1fd801a0985e4cef8d5c7b2c7e35&num=" + mail_num + "&detailmode=1";
			// メール内容詳細参照用ドライバー
			WebDriver mail_detail = new ChromeDriver();
			// メール内容詳細参照へ遷移する
			mail_detail.get(mail_detail_url);
			// 「トラフィック」仮登録用URLを取得する
			String chance_register_url = mail_detail.findElement(By.partialLinkText("https://www.chance.com/member/vcampaign.srv")) .getText();
			mail_detail.quit();
			driver.get(chance_register_url);
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("【エラー】：チャンスイットメール確認失敗");
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
			// 3秒待ち
			sleep(1000);
			driver.get("http://www.chance.com/research/shindan/play.jsp");
			sleep(2000);
			output_shindan_url = driver.getCurrentUrl();
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("【エラー】：WEB診断一覧画面へ遷移失敗");
			return Boolean.FALSE;
		}
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：WEB診断スタート
	 * =================================================================================================================
	 *
	 * @return Boolean 処理結果
	 *
	 * @author kimC
	 *
	 */
	public Boolean start() {
		try {
			WebShindan.execute(driver);
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("【エラー】：WEB診断失敗");
			return Boolean.FALSE;
		}

	}

	/**
	 * =================================================================================================================
	 * チャンスイット：WEB診断再スタート
	 * =================================================================================================================
	 *
	 * @return Boolean 処理結果
	 *
	 * @author kimC
	 *
	 */
	public void restart() {
		try {
			// WEB診断
			driver.get(shindan_url);
			WebShindan.execute(driver);
		} catch (Exception e) {
			System.out.println("【エラー】：WEB診断再スタート失敗");
		}

	}

	/**
	 * =================================================================================================================
	 * チャンスイット：獲得済みポイントを取得する
	 * =================================================================================================================
	 *
	 * @return Boolean 処理結果
	 *
	 * @author kimC
	 *
	 */
	public Boolean getPoint() {
		try {
			// 3秒待ち
			sleep(1000);
			driver.get("http://www.chance.com/");
			point = driver.findElement(By.className("user_pt")).getText();
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("【エラー】：獲得済みポイントを取得失敗");
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
	public void output_account() {
		try{
			Output output = new Output();
			output.execute(outputList);
			System.out.println("アカウント出力成功！");
		}catch (Exception e) {
			System.out.println("【エラー】：アカウント出力失敗！");
		}
	}

	/**
	 * sleep処理
	 *
	 * @param long
	 *            millis
	 */
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
