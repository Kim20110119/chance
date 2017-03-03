package excute;

import excute.excel.Confirm;
import excute.shindan.Chance_Shindan_Confirm;

/**
 * =====================================================================================================================
 * チャンスイット：WEB診断完了件数取得
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_WebShidan_Confirm {

	public static void main(String[] args) {
		// チャンスイット：WEB診断完了件数取得
		Chance_Shindan_Confirm confrim= new Chance_Shindan_Confirm();
		Confirm shindan = new Confirm();
		confrim.execute(shindan.execute());
		System.out.println("【チャンスイット】WEB診断終了。");

	}

}
