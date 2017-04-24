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
	/** 出力アカウント用Index */
	Integer index;
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
	public void execute(List<AccountBean> pList , Integer i){
		try{
			// 商品リスト
			this.list = pList;
			this.index = i;
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
		// Excel2007以降形式のファイルの素を作成
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
		b1.setCellValue("パスワード");
		Cell c1 = row.createCell(2);  // 「C1」
		c1.setCellValue("ニックネーム");
		Cell d1 = row.createCell(3);  // 「D1」
		d1.setCellValue("年");
		Cell e1 = row.createCell(4);  // 「E1」
		e1.setCellValue("月");
		Cell f1 = row.createCell(5);  // 「F1」
		f1.setCellValue("日");
		Cell g1 = row.createCell(6);  // 「G1」
		g1.setCellValue("性別");
		Cell h1 = row.createCell(7);  // 「H1」
		h1.setCellValue("WEB診断URL");
		Cell i1 = row.createCell(8);  // 「I1」
		i1.setCellValue("開始");
		Cell j1 = row.createCell(9);  // 「J1」
		j1.setCellValue("終了");
		// セルのスタイル
		CellStyle style =  workbook.createCellStyle();
		// フォント
		Font font = workbook.createFont();
		font.setColor(IndexedColors.ROSE.getIndex());
		// セルにセット！！
		style.setFont(font);
		a1.setCellStyle(style);
		b1.setCellStyle(style);
		c1.setCellStyle(style);
		d1.setCellStyle(style);
		e1.setCellStyle(style);
		f1.setCellStyle(style);
		g1.setCellStyle(style);
		h1.setCellStyle(style);
		i1.setCellStyle(style);
		j1.setCellStyle(style);
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
				b_index.setCellValue(bean.getPassword());  // パスワード
				// 「C_Index」
				Cell c_index = row_index.createCell(2);
				c_index.setCellValue(bean.getNickname());  // ニックネーム
				// 「D_Index」
				Cell d_index = row_index.createCell(3);
				d_index.setCellValue(bean.getYear());      // 年
				// 「E_Index」
				Cell e_index = row_index.createCell(4);
				e_index.setCellValue(bean.getMonth());     // 月
				// 「F_Index」
				Cell f_index = row_index.createCell(5);
				f_index.setCellValue(bean.getDay());       // 日
				// 「G_Index」
				Cell g_index = row_index.createCell(6);
				g_index.setCellValue(bean.getSex());       // 性別
				// 「H_Index」
				Cell h_index = row_index.createCell(7);
				h_index.setCellValue(bean.getUrl());       // WEB診断URL
				// 「I_Index」
				Cell i_index = row_index.createCell(8);
				i_index.setCellValue(bean.getStart());     // 開始
				// 「J_Index」
				Cell j_index = row_index.createCell(9);
				j_index.setCellValue(bean.getEnd());       // 終了
				index++;
			}
		}
		// ファイル入出力ストリーム
		FileOutputStream out = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String strDate = simpleDateFormat.format(new Date(System.currentTimeMillis()));
			String fileName = "OUTPUT_" + strDate + "_" + this.index.toString() + ".xlsx";
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
