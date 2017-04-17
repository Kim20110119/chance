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
public class Shindan_Url {

	/**
	 * =================================================================================================================
	 * EXCELからWEB診断URL情報を抽出してアカウントBeanに設定する
	 * =================================================================================================================
	 *
	 * @param String file ファイル名
	 * @return List<AccountBean> アカウント情報リスト
	 *
	 * @author kimC
	 *
	 */
	public List<AccountBean> execute(String file) {
		List<AccountBean> list = new ArrayList<AccountBean>();
		try{
			if(StringUtils.isNoneEmpty(file)){
				Register_Excel url = new Register_Excel();
				list = url.execute(file);
			}else{
				System.out.println("【エラー】：EXCELファイルを指定してください");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("【エラー】：アカウント情報を抽出処理が失敗しました");
		}
		return list;
	}

}
