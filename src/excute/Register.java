package excute;

import excute.excel.Excel;
import excute.register.Chance;

/**
 * =====================================================================================================================
 * チャンスイット：新規登録し、WEB診断URLを取得する
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Register {

	public static void main(String[] args) {
		// チャンスイット：新規登録し、WEB診断URLを取得
		Chance chance= new Chance(args[0], args[1], args[2]);
		Excel excel = new Excel();
		chance.execute(excel.execute("register_01"));
		System.out.println("【チャンスイット】新規登録し、WEB診断URLを取得処理完了しました。");

	}

}