package excute.excel;

import java.util.ArrayList;
import java.util.List;

import excute.bean.AccountBean;

/**
 * =====================================================================================================================
 * 【チャンスイット】EXCELから登録用アカウント情報を抽出する
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Register {

	/** EXCELファイル名 */
	public static final String FILE_NAME = "登録用アカウント";

	/**
	 * コンストラクタ
	 */
	public Register() {
	}

	/**
	 * =================================================================================================================
	 * EXCELから登録用アカウント情報を抽出してアカウントBeanに設定する
	 * =================================================================================================================
	 *
	 * @return List<AccountBean> アカウントｓ情報リスト
	 *
	 * @author kimC
	 *
	 */
	public List<AccountBean> execute() {
		List<AccountBean> list = new ArrayList<AccountBean>();
		try{
			Excel excel = new Excel();
			list = excel.execute(FILE_NAME);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("アカウント情報を抽出処理が失敗しました");
		}
		return list;
	}

}
