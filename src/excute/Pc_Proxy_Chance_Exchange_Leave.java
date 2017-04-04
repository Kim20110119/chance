package excute;

import excute.excel.Shindan;
import excute.exchange.Proxy_Chance_Exchange_Leave;

/**
 * =====================================================================================================================
 * チャンスイット：プロキシサーバー募金・退会
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Proxy_Chance_Exchange_Leave {

	public static void main(String[] args) {
		// チャンスイット：プロキシサーバー募金・退会
		Proxy_Chance_Exchange_Leave leave= new Proxy_Chance_Exchange_Leave(args[0], args[1]);
		Shindan shindan = new Shindan();
		leave.execute(shindan.execute());
		System.out.println("【チャンスイット】プロキシサーバー募金・退会終了。");
	}

}
