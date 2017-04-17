package excute.excel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import excute.bean.AccountBean;

/**
 * =====================================================================================================================
 * 【チャンスイット】EXCELからアカウント情報を抽出する(共通処理)
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Register_Excel {

	/** ファイル入出力ストリーム */
	FileInputStream filein;
	/** EXCELワークブック */
	XSSFWorkbook workbook;
	/** EXCELシート */
	XSSFSheet sheet;

	/**
	 * コンストラクタ
	 */
	public Register_Excel() {
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
			filein = new FileInputStream("excel/" + fileName + ".xlsx");
			workbook = new XSSFWorkbook(filein);
			// 「データ」シート
			sheet = workbook.getSheet("アカウント");
			Iterator<Row> rows = sheet.rowIterator();
			int index = 0;
			while(rows.hasNext()) {
				Row row = rows.next();
				if(index > 0){
					AccountBean bean = new AccountBean();
					// メールアドレス
					Cell cell_0 = row.getCell(0);
					bean.setEmail(this.getCellValue(cell_0));
					// パスワード
					Cell cell_1 = row.getCell(1);
					bean.setPassword(this.getCellValue(cell_1));
					// WEB診断URL
					Cell cell_2 = row.getCell(2);
					String url = this.getCellValue(cell_2);
					if(url.matches(".*http://syouhisya-kinyu.com/chanceit.*")){
						bean.setUrl(url);
					}else{
						continue;
					}
					// アカウント情報リスト
					list.add(bean);
				}
				index++;
			}
			workbook.close();
			filein.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("処理が失敗しました");
		}
		return list;
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
	public String getCellValue(Cell cell) {
		if(cell != null){
			if(cell.getCellTypeEnum() == CellType.NUMERIC){
				int int_value = (int)cell.getNumericCellValue();
				return String.valueOf(int_value);
			}else{
				return cell.getStringCellValue();
			}
		}else{
			return StringUtils.EMPTY;
		}

	}

}
