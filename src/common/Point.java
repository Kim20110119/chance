package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * ポイントサイト共通処理
 *
 * @author kimC
 *
 */
public class Point {
	// WEBドライバー
	public WebDriver driver;

	/**
	 * システムプロパティにChromeドライバーの設定処理
	 */
	public Point() {
		// Chromeドライバーをプロパティへ設定
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		// Chromeドライバー
		driver = new ChromeDriver();
	}

	/**
	 * クリック処理
	 *
	 * @param By
	 *            locator
	 */
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	/**
	 * クリック処理
	 *
	 * @param By
	 *            locator
	 * @param int
	 *            index
	 *
	 */
	public void clickByIndex(By locator, int index) {
		driver.findElements(locator).get(index).click();
	}

	/**
	 * フォームのサブミット処理
	 *
	 * @param By
	 *            locator
	 */
	public void submit(By locator) {
		driver.findElement(locator).submit();
	}

	/**
	 * テキストフィールドの入力処理
	 *
	 * @param By
	 *            locator
	 * @param String
	 *            text
	 */
	public void sendkeysByStr(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	/**
	 * プルダウンの選択処理
	 *
	 * @param By
	 *            locator
	 * @param String
	 *            label
	 */
	public void selectByText(By locator, String label) {
		Select element = new Select(driver.findElement(locator));
		element.selectByVisibleText(label);
	}

	/**
	 * プルダウンの選択処理
	 *
	 * @param By
	 *            locator
	 * @param int
	 *            index
	 */
	public void selectByIndex(By locator, int index) {
		Select element = new Select(driver.findElement(locator));
		element.selectByIndex(index);
	}

	/**
	 * プルダウンの選択処理
	 *
	 * @param By
	 *            locator
	 * @param String
	 *            value
	 */
	public void selectByValue(By locator, String value) {
		Select element = new Select(driver.findElement(locator));
		element.selectByValue(value);
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

	/**
	 * エレメントサイズ取得処理
	 *
	 * @param By
	 *            locator
	 */
	public int getSize(By locator) {
		return driver.findElements(locator).size();
	}

	/**
	 * xPath取得処理
	 *
	 * @param String
	 *            tag
	 * @param String
	 *            key
	 * @param String
	 *            value
	 * @return String xPath
	 *
	 */
	public String getXpath(String tag, String key, String value) {
		return "//" + tag + "[@" + key + "='" + value + "']";

	}

	/**
	 * ByxPath取得処理
	 *
	 * @param String
	 *            tag
	 * @param String
	 *            key
	 * @param String
	 *            value
	 * @return By xPath
	 *
	 */
	public By getByXpath(String tag, String key, String value) {
		return By.xpath(getXpath(tag, key, value));
	}

	/**
	 * ByxClassName取得処理
	 *
	 * @param String
	 *            className
	 *
	 * @return By className
	 *
	 */
	public By getByClass(String className) {
		return By.className(className);
	}

	/**
	 * ByxTagName取得処理
	 *
	 * @param String
	 *            tag
	 *
	 * @return By tagName
	 *
	 */
	public By getByTag(String tag) {
		return By.tagName(tag);
	}

	/**
	 * ByxId取得処理
	 *
	 * @param String
	 *            id
	 *
	 * @return By id
	 *
	 */
	public By getById(String id) {
		return By.id(id);
	}

	/**
	 * ByxName取得処理
	 *
	 * @param String
	 *            name
	 *
	 * @return By name
	 *
	 */
	public By getByName(String name) {
		return By.name(name);
	}
}
