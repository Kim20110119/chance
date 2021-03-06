package common.shindan;

import static common.Common.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	private static final String C_END = "end-btn";

	/**
	 * =================================================================================================================
	 * WEB診断処理
	 * =================================================================================================================
	 *
	 * @param WebDriver driver
	 *
	 * @author kimC
	 *
	 */
	public static Boolean execute(WebDriver driver){
		try {
			/** JavaScript */
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			// 0.5秒待ち
			Thread.sleep(500);
			// 「診断質問」
			executor.executeScript("$('#group-2').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-3').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-4').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-5').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-6').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-7').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-8').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-9').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-10').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-11').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-12').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-13').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-14').toggleClass('dia-invisible');");
			executor.executeScript("$('#group-15').toggleClass('dia-invisible');");
			for (int line = 1; line <= 15; line++) {
				String value = driver.findElements(By.name("q"+line)).get(int_random(4)).getAttribute("value");
				executor.executeScript("$('input[name=q"+ line +"]').val(['"+value+"']);");
				if (line == 15) {
					// 「終了」
					executor.executeScript("$('#current').val('15');");
					executor.executeScript("$('#form').submit();");
					break;
				}
			}
			// 「診断処理結果」
			return getPoint(driver);
		} catch (Exception e) {
			// 「診断処理結果」
			return Boolean.FALSE;
		}
	}

	/**
	 * =================================================================================================================
	 * ポイント獲得処理
	 * =================================================================================================================
	 *
	 * @param WebDriver driver
	 *
	 * @author kimC
	 *
	 */
	public static Boolean getPoint(WebDriver driver){
		try {
			// 2秒待ち
			Thread.sleep(1000);
			// 「ポイント獲得」
			driver.findElement(By.className(C_END)).click();
			// 1秒待ち
			Thread.sleep(500);
			// 「アラート」
			driver.switchTo().alert().accept();
			// 「診断処理結果」
			return Boolean.TRUE;
		} catch (Exception e) {
			// 「診断処理結果」
			return Boolean.FALSE;
		}
	}
}
