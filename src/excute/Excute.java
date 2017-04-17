package excute;

import excute.excel.Shindan_Url;
import excute.shindan.Web_Shindan;

/**
 * =====================================================================================================================
 * チャンスイット：WEB診断単体
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Excute {

	public static void main(String[] args) {
		// チャンスイット：WEB診断単体
		Web_Shindan shindan= new Web_Shindan();
		Shindan_Url shindan_url = new Shindan_Url();
		shindan.execute(shindan_url.execute(args[0]));
		System.out.println("【チャンスイット】WEB診断終了。");
	}

}
