package excute.shindan;

import static common.constant.HtmlConstants.*;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import common.shindan.WebShindan;
import excute.bean.AccountBean;

/**
 * =====================================================================================================================
 * チャンスイット：WEB診断
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Chance_Unit_Shindan{
	/** 「WEBドライバー」 */
	WebDriver driver;
	/** 「診断URL」 */
	String shindan_url  = StringUtils.EMPTY;
	/** 「獲得ポイント」 */
	int point_count = 0;
	/** 「再スタートフラグ」 */
	Boolean restart_flag = Boolean.FALSE;
	/** 「WEB診断開始番号」 */
	int start = 0;
	/** 「WEB診断終了番号」 */
	int end = 33;
	/** 「アカウントBean」 */
	AccountBean bean = new AccountBean();

	/**
	 * コンストラクタ
	 */
	public Chance_Unit_Shindan() {
		// Chromeドライバーをプロパティへ設定
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：WEB診断メイン処理
	 * =================================================================================================================
	 *
	 * @return int point_couont 獲得済みポイント
	 *
	 * @author kimC
	 *
	 */
	public Integer execute(List<AccountBean> list) {
		// Chromeドライバー
		driver = new ChromeDriver();
		// 10秒待ち
		sleep(10000);
		for (int account_index = 0; account_index < list.size(); account_index++) {
			// アカウントBean
			bean = list.get(account_index);
			// 開始Index
			if(StringUtils.isNotEmpty(bean.getStart())){
				start = Integer.valueOf(bean.getStart());
			}
			// 終了Index
			if(StringUtils.isNotEmpty(bean.getEnd())){
				end = Integer.valueOf(bean.getEnd());
			}
			// 「WEB診断URL」
			this.setUrl(bean.getUrl());
			for (int i = start; i < end; i++) {
				try {
					// 0.5秒待ち
					sleep(500);
					// 診断URL
					shindan_url = driver.findElements(By.xpath("//a[@role='button']")).get(i).getAttribute(A_HREF);
					// WEB診断
					this.setUrl(shindan_url);
					if (!start()) {
						restart();
					}
				} catch (Exception e) {
					try {
						// 「WEB診断」
						this.setUrl(bean.getUrl());
						// 0.5秒待ち
						sleep(500);
						// 診断URL
						shindan_url = driver.findElements(By.xpath("//a[@role='button']")).get(i).getAttribute(A_HREF);
						// WEB診断
						driver.get(shindan_url);
						if (!start()) {
							restart();
						}
					} catch (Exception r_e) {
						System.out.println("【エラー】：WEB診断URLを取得する処理失敗");
					}
				}
				// 「WEB診断」
				this.setUrl(bean.getUrl());
			}
			// ブラウザドライバーを終了する
			driver.quit();
			}
		return point_count;

	}

	/**
	 * =================================================================================================================
	 * チャンスイット：WEB診断スタート
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public Boolean start() {
		try {
			WebShindan.execute(driver);
			point_count += 10;
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
	 * @author kimC
	 *
	 */
	public void restart() {
		try {
			// WEB診断
			driver.get(shindan_url);
			WebShindan.execute(driver);
			point_count += 10;
		} catch (Exception e) {
			System.out.println("【エラー】：WEB診断再スタート失敗");
		}
	}

	/**
	 * =================================================================================================================
	 * チャンスイット：URL遷移
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public void setUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			try {
				driver.get(url);
			} catch (Exception n_e) {
			}
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
