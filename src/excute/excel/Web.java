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
public class Web {

	/** ファイル入出力ストリーム */
	FileInputStream filein;
	/** EXCELワークブック */
	XSSFWorkbook workbook;
	/** EXCELシート */
	XSSFSheet sheet;

	/**
	 * コンストラクタ
	 */
	public Web() {
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
					if(StringUtils.isEmpty(this.getCellValue(cell_0))){
						continue;
					}
					bean.setEmail(this.getCellValue(cell_0));
					// パスワード
					Cell cell_1 = row.getCell(1);
					bean.setPassword(this.getCellValue(cell_1));
					// ニックネーム
					Cell cell_2 = row.getCell(2);
					bean.setNickname(this.getCellValue(cell_2));
					// 年
					Cell cell_3 = row.getCell(3);
					bean.setYear(this.getCellValue(cell_3));
					// 月
					Cell cell_4 = row.getCell(4);
					bean.setMonth(this.getCellValue(cell_4));
					// 日
					Cell cell_5 = row.getCell(5);
					bean.setDay(this.getCellValue(cell_5));
					// 性別
					Cell cell_6 = row.getCell(6);
					bean.setSex(this.getCellValue(cell_6));
					// WEB診断URL
					Cell cell_7 = row.getCell(7);
					String url = this.getCellValue(cell_7);
					if(url.matches(".*http://syouhisya-kinyu.com/chanceit.*")){
						bean.setUrl(url);
					}else{
						continue;
					}
					// 開始
					Cell cell_8 = row.getCell(8);
					bean.setStart(this.getCellValue(cell_8));
					// 終了
					Cell cell_9 = row.getCell(9);
					bean.setEnd(this.getCellValue(cell_9));
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
