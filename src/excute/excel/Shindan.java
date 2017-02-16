package excute.excel;

import java.util.ArrayList;
import java.util.List;

import excute.bean.AccountBean;

/**
 * =====================================================================================================================
 * 【チャンスイット】EXCELからWEB診断URLリストを抽出する
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Shindan {

	/** EXCELファイル名 */
	public static final String FILE_NAME = "WEB診断URL";

	/**
	 * コンストラクタ
	 */
	public Shindan() {
	}

	/**
	 * =================================================================================================================
	 * EXCELからWEB診断URL情報を抽出してアカウントBeanに設定する
	 * =================================================================================================================
	 *
	 * @return List<AccountBean> アカウント情報リスト
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
