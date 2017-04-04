package excute.exchange;

import static common.Common.*;
import static common.constant.ChanceConstants.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import excute.bean.AccountBean;

/**
 * =====================================================================================================================
 * 【チャンスイット】：ポイント退会
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Proxy_Chance_Exchange_Leave{
	/** 「WEBドライバー」 */
	WebDriver driver;
	/** 「獲得ポイント」 */
	int point_count = 0;
	/** 「アカウントBean」 */
	AccountBean bean = new AccountBean();

	/**
	 * コンストラクタ
	 */
	public Proxy_Chance_Exchange_Leave() {
		// Chromeドライバーをプロパティへ設定
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--proxy-server=http://210.140.43.144:8888");
		option.addArguments("--proxy-bypass-list=localhost");
		// Chromeドライバー
		driver = new ChromeDriver(option);
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
				System.out.println("################################");
				System.out.println(bean.getEmail()+"処理開始");
				if(this.login()){
					// 0.5秒待ち
					sleep(500);
					// ポイントを募金する
					this.bokin();
					// 退会する
					this.leave();
				}
			}catch(Exception e){
			}
		}
		// ブラウザを終了する
		driver.quit();
		return point_count;
	}

	/**
	 * =================================================================================================================
	 * ログイン処理
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public Boolean login() {
		try{
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
			// 現在のURLを取得する
			String url = driver.getCurrentUrl();
			// ログイン後URLかを判断する
			if(url.equals("http://www.chance.com/")){
				return Boolean.TRUE;
			}else{
				System.out.println("【エラー】：" + bean.getEmail()+"ログイン処理失敗");
				return Boolean.FALSE;
			}
		}catch (Exception e){
			System.out.println("【エラー】：" + bean.getEmail()+"ログイン処理失敗");
			return Boolean.FALSE;
		}

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
			// 募金ポイントを選択する
			Select element = new Select(driver.findElement(By.name("point_value")));
			element.selectByValue("5000");
			// 「寄付する」
			driver.findElement(By.id("image-btn")).click();
			// 「OK」
			driver.switchTo().alert().accept();
			return Boolean.TRUE;
		}catch (Exception e){
			System.out.println("【エラー】：" + bean.getEmail()+"ポイント募金処理失敗");
			return Boolean.FALSE;
		}

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
			// 2秒待ち
			this.sleep(2000);
			// 退会原因
			driver.findElement(By.id(Integer.toString(int_random(5)+1))).click();
			// 退会原因
			driver.findElement(By.id(Integer.toString(int_random(5)+1))).click();
			// 「退会する」
			driver.findElement(By.id("btn-nav")).findElement(By.tagName("a")).click();
			// 1秒待ち
			this.sleep(1000);
			// 「パスワード」
			driver.findElement(By.name("password")).sendKeys(bean.getPassword());
			// 「退会する」
			driver.findElement(By.id("btn-nav")).findElement(By.tagName("a")).click();
			System.out.println(bean.getEmail()+"退会処理成功");
			return Boolean.TRUE;
		}catch (Exception e){
			System.out.println("【エラー】：" + bean.getEmail()+"退会処理失敗");
			return Boolean.FALSE;
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
