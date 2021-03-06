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
	/** 「診断一覧URL」 */
	String shindan_list_url  = StringUtils.EMPTY;
	/** 「ユーザーパス」 */
	String user_path  = StringUtils.EMPTY;
	/** 「再スタートフラグ」 */
	Boolean restart_flag = Boolean.FALSE;
	/** 「WEB診断開始番号」 */
	int start = 0;
	/** 「WEB診断終了番号」 */
	int end = 33;
	/** 「アカウントBean」 */
	AccountBean bean = new AccountBean();
	/** 「WEB診断Index」 */
	int index = 0;

	/**
	 * コンストラクタ
	 * @param String path パス
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
		for (int account_index = 0; account_index < list.size(); account_index++) {
			try{
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
				// Chromeドライバーオプション
				try{
					driver = new ChromeDriver();
				}catch(Exception s_e){
					try{
						driver = new ChromeDriver();
					}catch(Exception r_s_e){
						continue;
					}
				}
				// Chromeの画像表示設定
				this.setImage();
				// 「WEB診断URL」を取得する
				this.shindan_list_url = bean.getUrl();
				// WEB診断一覧へ遷移する
				this.setUrl(this.shindan_list_url);
				// WEB診断開始
				for (int i = start; i < end; i++) {
					this.index = i;
					try {
						// 0.5秒待ち
						sleep(500);
						// 診断URL
						String url = driver.findElements(By.xpath("//a[@role='button']")).get(i).getAttribute(A_HREF);
						this.shindan_url = url.replace("start?&", "step?=undefined&");
						// WEB診断
						this.setUrl(this.shindan_url);
						if (!start()) {
							restart();
						}
					} catch (Exception e) {
					}
					// 「WEB診断一覧」
					this.setUrl(this.shindan_list_url);
				}
				try {
					// ブラウザドライバーを終了する
					driver.quit();
				}catch(Exception q_e){
				}
			}catch(Exception m_e){
				try {
					// ブラウザドライバーを終了する
					driver.quit();
				}catch(Exception q_e){
				}
				continue;
			}
		}
		return 0;

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
	 * チャンスイット：WEB診断スタート
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public Boolean start() {
		return WebShindan.execute(driver);
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
			for(int i = 0; i < 5; i++){
				// WEB診断一覧画面
				this.setUrl(this.shindan_list_url);
				// 診断URL
				String url = driver.findElements(By.xpath("//a[@role='button']")).get(index).getAttribute(A_HREF);
				this.shindan_url = url.replace("start?&", "step?=undefined&");
				// WEB診断
				this.setUrl(this.shindan_url);
				if(this.start()){
					break;
				}
			}
		} catch (Exception e) {
			// WEB診断一覧画面
			this.setUrl(this.shindan_list_url);
			try {
				// 1秒待ち
				sleep(1000);
				// 診断URL
				String url = driver.findElements(By.xpath("//a[@role='button']")).get(index).getAttribute(A_HREF);
				this.shindan_url = url.replace("start?&", "step?=undefined&");
				// WEB診断
				this.setUrl(this.shindan_url);
				if(WebShindan.execute(driver)){
				}else{
					System.out.println("【エラー】：WEB診断再スタート失敗");
				}
			} catch (Exception r_e) {
				System.out.println("【エラー】：WEB診断再スタート失敗");
				// WEB診断一覧画面
				this.setUrl(this.shindan_list_url);
			}
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
