package excute.sample;

import excute.excel.Output;
import excute.excel.Register;

/**
 * =====================================================================================================================
 * チャンスイット：サンプル
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Pc_Sample {

	public static void main(String[] args) {
		// チャンスイット：WEB診断
		Output chance_register= new Output();
		Register register = new Register();
		chance_register.execute(register.execute());
		System.out.println("【チャンスイット】新規登録&WEB診断終了。");

	}

}
