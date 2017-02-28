package excute;

import excute.excel.Shindan;
import excute.exchange.Chance_Exchange;

/**
 * =====================================================================================================================
 * チャンスイット：募金
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_Exchange {

	public static void main(String[] args) {
		// チャンスイット：募金
		Chance_Exchange exchange= new Chance_Exchange();
		Shindan shindan = new Shindan();
		exchange.execute(shindan.execute());
		System.out.println("【チャンスイット】募金ポイント終了。");

	}

}
