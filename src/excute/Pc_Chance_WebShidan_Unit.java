package excute;

import excute.excel.Unit_Shindan;
import excute.shindan.Chance_Unit_Shindan;

/**
 * =====================================================================================================================
 * チャンスイット：WEB診断単体
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_WebShidan_Unit {

	public static void main(String[] args) {
		// チャンスイット：WEB診断単体
		Chance_Unit_Shindan chance_unit_shindan= new Chance_Unit_Shindan();
		Unit_Shindan shindan = new Unit_Shindan();
		chance_unit_shindan.execute(shindan.execute(args[0]));
		System.out.println("【チャンスイット】WEB診断終了。");
	}

}
