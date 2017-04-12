package excute.shindan;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import excute.bean.AccountBean;
import excute.excel.Output;

/**
 * =====================================================================================================================
 * チャンスイット：WEB診断
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Chance_Shindan_Confirm{
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
	int end = 40;
	/** 「アカウントBean」 */
	AccountBean bean = new AccountBean();
	/** 「出力アカウントリスト」 */
	List<AccountBean> outputList = new ArrayList<AccountBean>();

	/**
	 * コンストラクタ
	 */
	public Chance_Shindan_Confirm() {
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
		// Chrome画像表示の設定
		this.setImage();
		for (int account_index = 0; account_index < list.size(); account_index++) {
			// アカウントBean
			bean = list.get(account_index);
			// 「WEB診断URL」
			driver.get(bean.getUrl());
			int size = driver.findElements(By.xpath("//img[@src='/images/icons/sumi.png']")).size();
			bean.setPoint(Integer.toString(size));
			// 出力アカウント情報を設定する
			outputList.add(bean);
		}
		// アカウント情報出力する
		this.output_account();
		// ブラウザドライバーを終了する
		driver.quit();
		return point_count;

	}

	/**
	 * =================================================================================================================
	 * Chromeの設定：すべての画像を表示しない
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public void setImage() {
		try{
			driver.get("chrome://settings-frame/content");
			driver.findElements(By.name("images")).get(1).click();
			driver.findElement(By.id("content-settings-overlay-confirm")).click();
		}catch (Exception e){

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
			System.out.println("アカウント・WEB診断URL出力成功！");
		}catch (Exception e) {
			System.out.println("【エラー】：アカウント・WEB診断URL出力失敗！");
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
