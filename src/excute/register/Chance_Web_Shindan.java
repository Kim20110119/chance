package excute.register;

import static common.constant.ChanceConstants.*;
import static common.constant.HtmlConstants.*;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import common.Point;
import common.shindan.WebShindan;

/**
 * =====================================================================================================================
 * 【チャンスイット】：WEB診断
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Chance_Web_Shindan extends Point {
	/** 「診断URL」 */
	String shindan_url  = StringUtils.EMPTY;
	/** 「獲得ポイント」 */
	int point_count = 0;
	/** 「再スタートフラグ」 */
	Boolean restart_flag = Boolean.FALSE;
	/** 「WEB診断開始番号」 */
	int start = 0;
	/** 「WEB診断終了番号」 */
	int end = 200;

	/**
	 * コンストラクタ
	 */
	public Chance_Web_Shindan() {
		// 「WEB診断URL」
		driver.get(PC_WEB_SHINDAN_URL);
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
	public Integer execute(String url) {
		// 「WEB診断URL」
		driver.get(PC_WEB_SHINDAN_URL);
		for (int i = start; i < end; i++) {
			// 0.5秒待ち
			sleep(500);
			// 診断URL
			shindan_url = driver.findElements(By.xpath("//a[@role='button']")).get(i).getAttribute(A_HREF);
			// WEB診断
			driver.get(shindan_url);
			if (!start()) {
				restart();
			}
			// 「WEB診断」
			driver.get(PC_WEB_SHINDAN_URL);
		}
		//
		driver.quit();
		return point_count;
	}

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

}
