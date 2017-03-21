package excute.exchange;

import static common.Common.*;
import static common.constant.ChanceConstants.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import excute.bean.AccountBean;
import excute.excel.Output;

/**
 * =====================================================================================================================
 * 【チャンスイット】：ポイント退会
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Proxy_Chance_Leave{
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
	public Proxy_Chance_Leave() {
		// Chromeドライバーをプロパティへ設定
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--proxy-server=http://203.140.78.67:8080");
		option.addArguments("--proxy-bypass-list=localhost");
		// Chromeドライバー
		driver = new ChromeDriver(option);
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
			try{
				// アカウントBean
				bean = list.get(i);
				// チャンスイット：ログイン画面
				driver.get(PC_LOGIN_URL);
				// チャンスイット：ログインメールアドレス
				driver.findElement(By.name("id")).sendKeys(bean.getEmail());
				// チャンスイット：ログインパスワード
				driver.findElement(By.name("password")).sendKeys(bean.getPassword());
				// 1秒待ち
				sleep(1000);
				// チャンスイット：ログインボタン
				driver.findElement(By.name("search_btn")).click();
				// 0.5秒待ち
				sleep(500);
				// ポイントを募金する
				this.leave();
				// WEB診断URLを設定する
				bean.setUrl(this.output_shindan_url);
				// 出力アカウント情報を設定する
				outputList.add(bean);
			}catch(Exception e){
			}
		}
		// ブラウザを終了する
		driver.quit();
		// アカウント情報出力する
		this.output_account();
		return point_count;
	}

	/**
	 * =================================================================================================================
	 * ポイント退会処理
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public Boolean leave() {
		try{
			// 「退会URL」
			driver.get("https://www.chance.com/member/leave.srv");
			// 5秒待ち
			this.sleep(5000);
			// 退会原因
			driver.findElement(By.id(Integer.toString(int_random(7)))).click();
			// 退会原因
			driver.findElement(By.id(Integer.toString(int_random(7)))).click();
			// 「退会する」
			driver.findElement(By.id("btn-nav")).findElement(By.tagName("a")).click();
			// 「パスワード」
			driver.findElement(By.name("password")).sendKeys(bean.getPassword());
			// 「退会する」
			driver.findElement(By.id("btn-nav")).findElement(By.tagName("a")).click();
			return Boolean.TRUE;
		}catch (Exception e){
			System.out.println("【エラー】：個人情報登録処理失敗");
			return Boolean.FALSE;
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
