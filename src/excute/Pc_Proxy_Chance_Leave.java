package excute;

import excute.excel.Shindan;
import excute.exchange.Proxy_Chance_Leave;

/**
 * =====================================================================================================================
 * チャンスイット：退会
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Proxy_Chance_Leave {

	public static void main(String[] args) {
		// チャンスイット：退会
		Proxy_Chance_Leave leave= new Proxy_Chance_Leave();
		Shindan shindan = new Shindan();
		leave.execute(shindan.execute());
		System.out.println("【チャンスイット】退会ポイント終了。");
	}

}
