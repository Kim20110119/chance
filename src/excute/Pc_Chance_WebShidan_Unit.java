package excute;

import excute.shindan.Chance_Shindan_Unit;

/**
 * =====================================================================================================================
 * チャンスイット：WEB診断
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_WebShidan_Unit {

	public static void main(String[] args) {
		// チャンスイット：WEB診断
		Chance_Shindan_Unit chance_shindan= new Chance_Shindan_Unit();
		chance_shindan.execute(args[0],args[1],args[2]);
		System.out.println("【チャンスイット】WEB診断終了。");

	}

}
