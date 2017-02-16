package common.shindan;

import static common.Common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * =====================================================================================================================
 * 共通：WEB診断
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class WebShindan {

	private static final String C_SUBMINT = "submit-btn";
	private static final String C_END = "end-btn";
	private static final String C_BTN = "btn-primary";

	/**
	 * =================================================================================================================
	 * WEB診断処理
	 * =================================================================================================================
	 *
	 * @param WebDriver
	 *            driver
	 * @param String
	 *            url
	 *
	 * @author kimC
	 *
	 */
	public static Boolean execute(WebDriver driver) throws Exception {
		// 「次へ」
		driver.findElement(By.className(C_SUBMINT)).click();
		// 2秒待ち
		Thread.sleep(2000);
		// 「次へ」
		driver.findElement(By.className(C_SUBMINT)).click();
		// 1秒待ち
		Thread.sleep(1000);
		// 「診断質問」
		for (int line = 1; line <= 15; line++) {
			String div_id = "group-" + line;
			String str_xpath = "//div[@id='" + div_id + "']/label[@class='label']";
			int choices_count = driver.findElements(By.xpath(str_xpath)).size();
			if (choices_count > 0) {
				driver.findElements(By.xpath(str_xpath)).get(int_random(choices_count)).click();
				if (line == 15) {
					// 「終了」
					driver.findElement(By.className(C_END)).click();
					break;
				} else {
					// 「次へ」
					driver.findElement(By.className(C_BTN)).click();
				}
			} else {
				break;
			}
		}
		// 「ポイント獲得」
		driver.findElement(By.className(C_END)).click();
		// 2秒待ち
		Thread.sleep(2000);
		// 「アラート」
		driver.switchTo().alert().accept();
		// 「診断処理結果」
		return Boolean.TRUE;
	}

}
