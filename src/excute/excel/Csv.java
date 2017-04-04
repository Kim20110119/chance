package excute.excel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import excute.bean.AccountBean;

/**
 * =====================================================================================================================
 * 【チャンスイット】CSVからアカウント情報を抽出する(共通処理)
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Csv {

	/** ファイル入出力ストリーム */
	FileInputStream filein;
	/** EXCELワークブック */
	XSSFWorkbook workbook;
	/** EXCELシート */
	XSSFSheet sheet;

	/**
	 * コンストラクタ
	 */
	public Csv() {
	}

	/**
	 * =================================================================================================================
	 * EXCELからアカウント情報を抽出してアカウントBeanに設定する
	 * =================================================================================================================
	 *
	 * @return List<AccountBean> アカウント情報リスト
	 *
	 * @author kimC
	 *
	 */
	public List<AccountBean> execute(String fileName) {
		List<AccountBean> list = new ArrayList<AccountBean>();
		try {
			// ファイルを読み込む
			FileReader fr = new FileReader("csv/" + fileName + ".csv");
			BufferedReader br = new BufferedReader(fr);
			// 読み込んだファイルを１行ずつ処理する
			String line;
			while ((line = br.readLine()) != null) {
				int index = 0;
				// 区切り文字","で分割する
				String[] data = line.split(",", 0);
				// アカウント情報BEAN
				AccountBean bean = new AccountBean();
		        for (String elem : data) {
					switch (index){
						case 0:
							bean.setEmail(elem);
							break;
						case 1:
							bean.setPassword(elem);
							break;
						case 2:
							bean.setUrl(elem);
							break;
					}
					index++;
		        }
		        // アカウント情報リスト
				list.add(bean);
			}
			// 終了処理
			br.close();
		} catch (IOException ex) {
			// 例外発生時処理
			ex.printStackTrace();
		}
		return list;
	}

}
