package excute;

import excute.excel.Shindan;
import excute.shindan.Chance_Shindan;

/**
 * =====================================================================================================================
 * チャンスイット：WEB診断
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_WebShidan {

	public static void main(String[] args) {
		// チャンスイット：WEB診断
		Chance_Shindan chance_shindan= new Chance_Shindan();
		Shindan shindan = new Shindan();
		chance_shindan.execute(shindan.execute());
		System.out.println("【チャンスイット】WEB診断終了。");

	}

}
