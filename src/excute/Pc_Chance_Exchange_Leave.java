package excute;

import excute.excel.Shindan;
import excute.exchange.Chance_Exchange_Leave;

/**
 * =====================================================================================================================
 * チャンスイット：募金・削除
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_Exchange_Leave {

	public static void main(String[] args) {
		// チャンスイット：募金・削除
		Chance_Exchange_Leave cel= new Chance_Exchange_Leave();
		Shindan shindan = new Shindan();
		cel.execute(shindan.execute());
		System.out.println("【チャンスイット】募金・削除終了。");

	}

}
