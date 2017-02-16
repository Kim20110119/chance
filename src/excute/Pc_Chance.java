package excute;

import static common.constant.ChanceConstants.*;

import org.openqa.selenium.By;

import common.Point;

/**
 * チャンスイット：共通処理
 *
 * @author kimC
 *
 */
public class Pc_Chance extends Point {

	public Pc_Chance() {
		// チャンスイット：ログイン画面
		driver.get(PC_LOGIN_URL);
		// チャンスイット：ログインメールアドレス
		driver.findElement(By.name("id")).sendKeys(PC_LOGIN_MAIL);
		// チャンスイット：ログインパスワード
		driver.findElement(By.name("password")).sendKeys(PC_LOGIN_PASSWORD);
		// 8秒待ち
		sleep(8000);
		// チャンスイット：ログインボタン
		driver.findElement(By.name("search_btn")).click();
	}

}
