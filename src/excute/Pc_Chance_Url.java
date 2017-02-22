package excute;

import excute.excel.Register;
import excute.register.Chance_Url;

/**
 * =====================================================================================================================
 * チャンスイット：新規登録し、WEB診断URLを取得する
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_Url {

	public static void main(String[] args) {
		// チャンスイット：新規登録し、WEB診断URLを取得
		Chance_Url chance_url= new Chance_Url();
		Register register = new Register();
		chance_url.execute(register.execute());
		System.out.println("【チャンスイット】新規登録し、WEB診断URLを取得処理完了しました。");

	}

}
