package excute;

import excute.excel.Register;
import excute.register.Chance_Register;

/**
 * =====================================================================================================================
 * チャンスイット：登録
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Chance_Register {

	public static void main(String[] args) {
		// チャンスイット：WEB診断
		Chance_Register chance_register= new Chance_Register();
		Register register = new Register();
		chance_register.execute(register.execute());
		System.out.println("【チャンスイット】新規登録&WEB診断終了。");

	}

}
