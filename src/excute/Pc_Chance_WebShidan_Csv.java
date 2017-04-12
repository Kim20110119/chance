package excute;

import excute.excel.Csv;
import excute.shindan.Chance_Unit_Shindan;

/**
 * =====================================================================================================================
 * チャンスイット：CSVファイルによりWEB診断
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_WebShidan_Csv {

	public static void main(String[] args) {
		// チャンスイット：WEB診断単体
		Chance_Unit_Shindan chance_unit_shindan= new Chance_Unit_Shindan(args[0]);
		Csv csv = new Csv();
		chance_unit_shindan.execute(csv.execute("web_url"));
		System.out.println("【チャンスイット】CSVファイルによりWEB診断終了。");
	}

}
