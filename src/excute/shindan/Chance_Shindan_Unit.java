package excute.shindan;

import static common.constant.HtmlConstants.*;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.shindan.WebShindan;

/**
 * =====================================================================================================================
 * チャンスイット：WEB診断
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Chance_Shindan_Unit{
	/** 「WEBドライバー」 */
	WebDriver driver;
	/** 「診断URL」 */
	String shindan_url  = StringUtils.EMPTY;

	/**
	 * コンストラクタ
	 */
	public Chance_Shindan_Unit() {
		// Chromeドライバーをプロパティへ設定
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
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
	public Integer execute(String url, String start, String end) {
		for (int i = Integer.parseInt(start); i < Integer.parseInt(end); i++) {
			// 「WEB診断」
			driver.get(url);
			// 0.5秒待ち
			sleep(500);
			// 診断URL
			shindan_url = driver.findElements(By.xpath("//a[@role='button']")).get(i).getAttribute(A_HREF);
			// WEB診断
			driver.get(shindan_url);
			if (!start()) {
				restart();
			}
		}
		//
		driver.quit();
		return 0;
	}

	public Boolean start() {
		try {
			WebShindan.execute(driver);
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("【エラー】：WEB診断失敗");
			return Boolean.FALSE;
		}

	}

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
