package excute;

import excute.excel.Csv;
import excute.exchange.Chance_Exchange_Leave;

/**
 * =====================================================================================================================
 * チャンスイット：募金・削除
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_Exchange_Leave_Csv {

	public static void main(String[] args) {
		// チャンスイット：募金・削除
		Chance_Exchange_Leave cel= new Chance_Exchange_Leave();
		Csv csv = new Csv();
		cel.execute(csv.execute("delete_account"));
		System.out.println("【チャンスイット】募金・削除終了。");

	}

}
