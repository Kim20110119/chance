package excute.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import excute.bean.AccountBean;

/**
 * =====================================================================================================================
 * 出力用アカウントBean
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class Output {

	/** ファイル入出力ストリーム */
	FileInputStream filein;
	/** EXCELワークブック */
	XSSFWorkbook workbook;
	/** EXCELシート */
	XSSFSheet sheet;
	/** 出力アカウント用Bean */
	List<AccountBean> list;

	/**
	 * コンストラクタ
	 */
	public Output() {
	}

	/**
	 * =================================================================================================================
	 * アカウント情報を抽出してEXCELファイルで出力する
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public void execute(List<AccountBean> pList){
		try{
			// 商品リスト
			this.list = pList;
			// 出力EXCELを作成する
			this.create();
		}catch (Exception e){
			System.out.println("EXCEl出力失敗！");
		}

	}

	/**
	 * =================================================================================================================
	 * アカウント情報を抽出してEXCELファイルで出力する
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public void create() throws IOException {
		// Excel2007以降の「.xlsx」形式のファイルの素を作成
		workbook = new XSSFWorkbook();
		// シートを「サンプル」という名前で作成
		Sheet sheet = workbook.createSheet("アカウント");
		// 商品項目セルを作成する
		// 行
		Row row = sheet.createRow(0);
		// 列
		Cell a1 = row.createCell(0);  // 「A1」
		a1.setCellValue("メールアドレス");
		Cell b1 = row.createCell(1);  // 「B1」
		b1.setCellValue("WEB診断URL");
		Cell c1 = row.createCell(2);  // 「C1」
		c1.setCellValue("登録日付");
		Cell d1 = row.createCell(3);  // 「D1」
		d1.setCellValue("ポイント");
		// セルのスタイル
		CellStyle style =  workbook.createCellStyle();
		// フォント
		Font font = workbook.createFont();
		font.setColor(IndexedColors.ROSE.getIndex());
		// セルにセット！！
		style.setFont(font);
		a1.setCellStyle(style);
		b1.setCellStyle(style);
		int index = 1;
		if(list != null){
			for(AccountBean bean : list){
		    	// 商品項目セルを作成する
				Row row_index = sheet.createRow(index);
				// 「A_Index」
				Cell a_index = row_index.createCell(0);
				a_index.setCellValue(bean.getEmail());     // メールアドレス
				// 「B_Index」
				Cell b_index = row_index.createCell(1);
				b_index.setCellValue(bean.getUrl());       // WEB診断URL
				// 「C_Index」
				Cell c_index = row_index.createCell(2);
				c_index.setCellValue(bean.getData());      // 登録日付
				// 「D_Index」
				Cell d_index = row_index.createCell(3);
				d_index.setCellValue(bean.getPoint());     // ポイント
			}
		}
		// ファイル入出力ストリーム
		FileOutputStream out = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'OUTPUT'_yyyyMMdd_HHmmss'.xlsx'");
			String fileName = simpleDateFormat.format(new Date(System.currentTimeMillis()));
			// 出力先のファイルを指定
			out = new FileOutputStream("excel/" + fileName);
			// 上記で作成したブックを出力先に書き込み
			workbook.write(out);
	    } catch (FileNotFoundException e) {
	    	System.out.println(e.getStackTrace());
	    } finally {
			// 最後はちゃんと閉じておきます
			out.close();
			workbook.close();
	    }
	}

}
