package excute.excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import excute.bean.AccountBean;

/**
 * =====================================================================================================================
 * 【チャンスイット】EXCELからWEB診断URLリストを抽出する
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Unit_Shindan {

	/** EXCELファイル名 */
	public static final String FILE_NAME = "WEB診断URL_全部";

	/**
	 * コンストラクタ
	 */
	public Unit_Shindan() {
	}

	/**
	 * =================================================================================================================
	 * EXCELからWEB診断URL情報を抽出してアカウントBeanに設定する
	 * =================================================================================================================
	 *
	 * @param String pFile ファイル名
	 * @return List<AccountBean> アカウント情報リスト
	 *
	 * @author kimC
	 *
	 */
	public List<AccountBean> execute(String pFile) {
		List<AccountBean> list = new ArrayList<AccountBean>();
		try{
			String file = FILE_NAME;
			if(StringUtils.isNoneEmpty(pFile)){
				file = pFile;
			}
			Web web = new Web();
			list = web.execute(file);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("アカウント情報を抽出処理が失敗しました");
		}
		return list;
	}

}
