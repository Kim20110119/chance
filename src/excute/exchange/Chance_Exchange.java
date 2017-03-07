package excute.exchange;

import static common.constant.ChanceConstants.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import excute.bean.AccountBean;
import excute.excel.Output;

/**
 * =====================================================================================================================
 * 【チャンスイット】：ポイント募金
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Chance_Exchange{
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
	public Chance_Exchange() {
		// Chromeドライバーをプロパティへ設定
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		// 現在日付
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		register_data = sdf.format(nowDate);
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：ポイント募金
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
			// チャンスイット：ログイン画面
			driver.get(PC_LOGIN_URL);
			// チャンスイット：ログインメールアドレス
			driver.findElement(By.name("id")).sendKeys(bean.getEmail());
			// チャンスイット：ログインパスワード
			driver.findElement(By.name("password")).sendKeys(bean.getPassword());
			// 8秒待ち
			sleep(8000);
			// チャンスイット：ログインボタン
			driver.findElement(By.name("search_btn")).click();
			// 0.5秒待ち
			sleep(500);
			// ポイントを募金する
			this.bokin();
			// 獲得済みポイントを取得する
			this.getPoint();
			// WEB診断URLを設定する
			bean.setUrl(this.output_shindan_url);
			// 1.5秒待ち
			sleep(1500);
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
	 * ポイント募金処理
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public Boolean bokin() {
		try{
			// 「募金URL」
			driver.get("http://www.chance.com/bokin/index.jsp");
			// 5秒待ち
			this.sleep(5000);
//			// 募金ポイントを選択する
//			Select element = new Select(driver.findElement(By.name("point_value")));
//			element.selectByValue("300");
			// 「寄付する」
			driver.findElement(By.id("image-btn")).click();
			// 「OK」
			driver.switchTo().alert().accept();
			return Boolean.TRUE;
		}catch (Exception e){
			System.out.println("【エラー】：個人情報登録処理失敗");
			return Boolean.FALSE;
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
