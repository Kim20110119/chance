package common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * @author お客様
 *
 */
public class Common {
	/**
	 * 整数乱数を生成する処理.<BR>
	 *
	 * @param int
	 *            x 乱数の限界値
	 * @return int y [0]～[x-1]の値
	 *
	 */
	public static int int_random(int x) {
		// Randomクラスのインスタンス化
		Random rnd = new Random();
		return rnd.nextInt(x);
	}

	/**
	 * 文字列のマッチ判断する処理.<BR>
	 *
	 * @param String
	 *            str1 文字列
	 * @param String
	 *            str1 比較する文字列
	 * @return matche_flag
	 *
	 */
	public static boolean str_matche(String str1, String str2) {
		if (str1.matches(".*" + str2 + ".*")) {
			// マッチする
			return Boolean.TRUE;
		} else {
			// マッチしない
			return Boolean.FALSE;
		}
	}

	/**
	 * =================================================================================================================
	 * 文字列を数字に変換する
	 * =================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static Integer getIndex(String value) {
		Integer i = 0;
		if(StringUtils.isNoneEmpty(value)){
			i = Integer.parseInt(value);
		}
		return i;
	}

	/**
	 * =================================================================================================================
	 * 誕生日年から年齢を計算する（文字列年齢）
	 * =================================================================================================================
	 *
	 * @param String year 年
	 * @return String age 年齢
	 * @author kimC
	 *
	 */
	public static String getStrAge(String strYear) {
		Integer age = 30;
		if(StringUtils.isNoneEmpty(strYear)){
			Calendar calendar = Calendar.getInstance();
		    int year = calendar.get(Calendar.YEAR);
		    age = year - Integer.valueOf(strYear);
		}
		return age.toString();
	}

	/**
	 * =================================================================================================================
	 * 年齢帯を取得する
	 * =================================================================================================================
	 *
	 * @param String year 年
	 * @return Integer ageGroup 年齢帯
	 *
	 * @author kimC
	 *
	 */
	public static Integer getAgeGroup(String year) {
		Integer age = getintAge(year);
		Integer ageGroup = 2;
		try{
			if(age <= 20){
				ageGroup = 0;
			}else if(age > 20 && age <= 30){
				ageGroup = 1;
			}else if(age > 30 && age <= 40){
				ageGroup = 2;
			}else if(age > 40 && age <= 50){
				ageGroup = 3;
			}else if(age > 50 && age <= 60){
				ageGroup = 4;
			}else{
				ageGroup = 5;
			}
		}catch (Exception e){
		}
		return ageGroup;
	}

	/**
	 * =================================================================================================================
	 * 誕生日年から年齢を計算する（整数年齢）
	 * =================================================================================================================
	 *
	 * @param String year 年
	 * @return Integer age 年齢
	 * @author kimC
	 *
	 */
	public static Integer getintAge(String strYear) {
		Integer age = 30;
		if(StringUtils.isNoneEmpty(strYear)){
			Calendar calendar = Calendar.getInstance();
		    int year = calendar.get(Calendar.YEAR);
		    age = year - Integer.valueOf(strYear);
		}
		return age;
	}

	/**
	 * 終了メッセージを取得する処理.<BR>
	 *
	 * @param String
	 *            site サイト名
	 * @param String
	 *            item 項目
	 * @param int
	 *            point ポイント
	 *
	 * @return String end_message 終了メッセージ
	 *
	 */
	public static String get_end_message(String site, String item, int point) {
		return "【" + site + "】：" + item + "終了。獲得ずみポイント：" + point;
	}

	/**
	 * =====================================================================================================================
	 * 都道府県一覧を取得する
	 * =====================================================================================================================
	 *
	 * @return List<String> prefList 都道府県
	 * @author kimC
	 *
	 */
	public static List<String> getPrefList() {
		List<String> list=new ArrayList<String>();
		list.add("北海道");
		list.add("青森県");
		list.add("岩手県");
		list.add("宮城県");
		list.add("秋田県");
		list.add("山形県");
		list.add("福島県");
		list.add("茨城県");
		list.add("栃木県");
		list.add("群馬県");
		list.add("埼玉県");
		list.add("千葉県");
		list.add("東京都");
		list.add("神奈川県");
		list.add("新潟県");
		list.add("富山県");
		list.add("石川県");
		list.add("福井県");
		list.add("山梨県");
		list.add("長野県");
		list.add("岐阜県");
		list.add("静岡県");
		list.add("愛知県");
		list.add("三重県");
		list.add("滋賀県");
		list.add("京都府");
		list.add("大阪府");
		list.add("兵庫県");
		list.add("奈良県");
		list.add("和歌山県");
		list.add("鳥取県");
		list.add("島根県");
		list.add("岡山県");
		list.add("広島県");
		list.add("山口県");
		list.add("徳島県");
		list.add("香川県");
		list.add("愛媛県");
		list.add("高知県");
		list.add("福岡県");
		list.add("佐賀県");
		list.add("長崎県");
		list.add("熊本県");
		list.add("大分県");
		list.add("宮崎県");
		list.add("鹿児島県");
		list.add("沖縄県");
		return list;
	}


	/**
	 * =====================================================================================================================
	 * Proxyサーバー一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getProxyList() {
		List<String> list=new ArrayList<String>();
		list.add("106.186.22.65:8888");
		list.add("219.127.253.43:80");
		list.add("219.166.7.50:80");
		list.add("43.229.204.102:8080");
		list.add("43.230.163.186:8080");
		list.add("43.231.23.101:8080");
		list.add("43.252.138.156:3128");
		list.add("121.94.173.145:80");
		list.add("160.202.40.203:8080");
		list.add("160.202.41.51:8080");
		list.add("160.202.42.10:8080");
		list.add("160.202.42.114:8080");
		list.add("160.202.42.122:8080");
		list.add("160.202.42.66:8080");
		list.add("160.202.42.74:8080");
		list.add("124.155.112.85:80");
		list.add("124.32.141.184:3128");
		list.add("151.80.135.147:3128");
		list.add("182.253.123.52:8080");
		list.add("118.98.122.226:8080");
		list.add("49.1.244.139:3128");
		list.add("203.153.20.5:3128");
		list.add("89.38.150.186:6742");
		list.add("123.30.238.16:3128");
		list.add("78.108.108.9:8080");
		list.add("94.177.242.218:3128");
		list.add("66.175.83.156:8080");
		list.add("221.141.2.52:8080");
		list.add("190.214.48.125:8080");
		list.add("91.121.195.198:31288");
		list.add("92.47.195.250:3128");
		list.add("200.167.191.227:9090");
		list.add("193.246.106.105:80");
		list.add("176.31.96.198:3128");
		list.add("115.166.118.83:8080");
		list.add("86.105.51.239:3128");
		list.add("88.199.164.137:8080");
		list.add("183.131.151.208:80");
		list.add("144.217.40.115:80");
		list.add("180.250.46.227:8080");
		list.add("220.248.229.45:3128");
		list.add("95.161.228.186:8080");
		list.add("94.177.224.103:3128");
		list.add("182.53.247.142:8080");
		list.add("178.63.157.84:1080");
		list.add("200.52.75.41:80");
		list.add("86.105.51.150:4646");
		list.add("118.101.37.209:8080");
		list.add("118.97.32.226:8080");
		list.add("213.221.56.213:3128");
		list.add("80.88.90.149:80");
		list.add("95.173.179.84:3128");
		list.add("176.31.113.42:8118");
		list.add("125.31.19.27:80");
		list.add("185.15.109.47:8080");
		list.add("154.16.127.52:8080");
		list.add("200.85.37.254:80");
		list.add("114.6.135.179:8080");
		list.add("197.237.218.89:8080");
		list.add("46.101.23.197:8118");
		list.add("200.68.27.100:3128");
		list.add("190.202.5.58:8080");
		list.add("149.56.41.35:80");
		list.add("188.113.138.238:3128");
		list.add("125.209.67.74:80");
		list.add("41.207.49.136:8080");
		list.add("103.4.250.18:9090");
		list.add("115.166.118.83:8080");
		list.add("163.47.147.34:8080");
		list.add("177.125.61.33:8080");
		list.add("83.220.168.131:80");
		list.add("81.201.58.106:8080");
		list.add("89.40.118.31:3128");
		list.add("58.59.141.187:3128");
		list.add("122.155.3.143:3128");
		list.add("149.56.123.105:3128");
		list.add("47.48.167.78:8080");
		list.add("207.188.73.155:80");
		list.add("163.121.188.2:8080");
		list.add("190.88.36.197:80");
		list.add("93.174.55.82:80");
		list.add("186.219.106.4:8080");
		list.add("124.120.28.179:3128");
		list.add("1.179.146.153:8080");
		list.add("182.253.202.122:8080");
		list.add("136.243.82.159:8118");
		list.add("154.16.127.52:80");
		list.add("187.17.19.143:8080");
		list.add("139.59.183.176:8118");
		list.add("197.220.193.137:443");
		list.add("182.253.197.60:80");
		list.add("125.162.140.49:3128");
		list.add("122.154.100.164:8080");
		list.add("177.87.10.162:8080");
		list.add("202.47.236.252:80");
		list.add("180.178.45.186:3128");
		list.add("77.174.83.147:80");
		list.add("95.78.251.33:3128");
		list.add("89.40.127.83:3128");
		list.add("124.133.230.254:80");
		list.add("41.59.67.58:8080");
		list.add("113.253.13.205:80");


		return list;
	}

	/**
	 * =====================================================================================================================
	 * i2i用Proxyサーバー一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getI2iProxyList() {
		List<String> list=new ArrayList<String>();
		list.add("160.202.42.98:8080");
		list.add("180.12.154.77:8080");
		list.add("219.127.253.43:80");
		list.add("160.202.42.43:8080");
		list.add("43.226.15.164:8080");
		list.add("54.249.6.200:3128");
		list.add("163.44.155.183:1080");
		list.add("153.122.48.186:4444");
		list.add("219.166.7.50:80");
		list.add("163.47.145.30:8080");
		list.add("163.53.187.98:8080");
		return list;
	}

	/**
	 * =====================================================================================================================
	 * WEB診断番号一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getPointmailAppIdList() {
		List<String> list=new ArrayList<String>();
		list.add("https://pointmall.prcm.jp/item/redirect/5084");
		list.add("https://pointmall.prcm.jp/item/redirect/5301");
		list.add("https://pointmall.prcm.jp/item/redirect/5302");
		list.add("https://pointmall.prcm.jp/item/redirect/5303");
		list.add("https://pointmall.prcm.jp/item/redirect/5304");
		list.add("https://pointmall.prcm.jp/item/redirect/5305");
		list.add("https://pointmall.prcm.jp/item/redirect/5306");
		list.add("https://pointmall.prcm.jp/item/redirect/5307");
		list.add("https://pointmall.prcm.jp/item/redirect/4845");
		list.add("https://pointmall.prcm.jp/item/redirect/5267");
		list.add("https://pointmall.prcm.jp/item/redirect/4774");
		list.add("https://pointmall.prcm.jp/item/redirect/5264");
		list.add("https://pointmall.prcm.jp/item/redirect/5268");
		list.add("https://pointmall.prcm.jp/item/redirect/5257");
		list.add("https://pointmall.prcm.jp/item/redirect/5248");
		list.add("https://pointmall.prcm.jp/item/redirect/5040");
		list.add("https://pointmall.prcm.jp/item/redirect/4659");
		list.add("https://pointmall.prcm.jp/item/redirect/5249");
		list.add("https://pointmall.prcm.jp/item/redirect/5240");
		list.add("https://pointmall.prcm.jp/item/redirect/5222");
		list.add("https://pointmall.prcm.jp/item/redirect/5223");
		list.add("https://pointmall.prcm.jp/item/redirect/5224");
		list.add("https://pointmall.prcm.jp/item/redirect/5225");
		list.add("https://pointmall.prcm.jp/item/redirect/5226");
		list.add("https://pointmall.prcm.jp/item/redirect/5227");
		list.add("https://pointmall.prcm.jp/item/redirect/5228");
		list.add("https://pointmall.prcm.jp/item/redirect/5229");
		list.add("https://pointmall.prcm.jp/item/redirect/5230");
		list.add("https://pointmall.prcm.jp/item/redirect/5231");
		list.add("https://pointmall.prcm.jp/item/redirect/5199");
		list.add("https://pointmall.prcm.jp/item/redirect/5200");
		list.add("https://pointmall.prcm.jp/item/redirect/5201");
		list.add("https://pointmall.prcm.jp/item/redirect/5202");
		list.add("https://pointmall.prcm.jp/item/redirect/5203");
		list.add("https://pointmall.prcm.jp/item/redirect/5204");
		list.add("https://pointmall.prcm.jp/item/redirect/5205");
		list.add("https://pointmall.prcm.jp/item/redirect/5206");
		list.add("https://pointmall.prcm.jp/item/redirect/5207");
		list.add("https://pointmall.prcm.jp/item/redirect/5208");
		list.add("https://pointmall.prcm.jp/item/redirect/5184");
		list.add("https://pointmall.prcm.jp/item/redirect/5185");
		list.add("https://pointmall.prcm.jp/item/redirect/5186");
		list.add("https://pointmall.prcm.jp/item/redirect/5187");
		list.add("https://pointmall.prcm.jp/item/redirect/5188");
		list.add("https://pointmall.prcm.jp/item/redirect/5189");
		list.add("https://pointmall.prcm.jp/item/redirect/5190");
		list.add("https://pointmall.prcm.jp/item/redirect/5191");
		list.add("https://pointmall.prcm.jp/item/redirect/5192");
		list.add("https://pointmall.prcm.jp/item/redirect/5193");
		list.add("https://pointmall.prcm.jp/item/redirect/5047");
		list.add("https://pointmall.prcm.jp/item/redirect/4522");
		list.add("https://pointmall.prcm.jp/item/redirect/5284");
		list.add("https://pointmall.prcm.jp/item/redirect/5009");
		list.add("https://pointmall.prcm.jp/item/redirect/5097");
		list.add("https://pointmall.prcm.jp/item/redirect/5098");
		list.add("https://pointmall.prcm.jp/item/redirect/5099");
		list.add("https://pointmall.prcm.jp/item/redirect/5100");
		list.add("https://pointmall.prcm.jp/item/redirect/5101");
		list.add("https://pointmall.prcm.jp/item/redirect/5102");
		list.add("https://pointmall.prcm.jp/item/redirect/5103");
		list.add("https://pointmall.prcm.jp/item/redirect/5104");
		list.add("https://pointmall.prcm.jp/item/redirect/5105");
		list.add("https://pointmall.prcm.jp/item/redirect/5106");
		list.add("https://pointmall.prcm.jp/item/redirect/5083");
		list.add("https://pointmall.prcm.jp/item/redirect/5067");
		list.add("https://pointmall.prcm.jp/item/redirect/5043");
		list.add("https://pointmall.prcm.jp/item/redirect/5031");
		list.add("https://pointmall.prcm.jp/item/redirect/5049");
		list.add("https://pointmall.prcm.jp/item/redirect/5028");
		list.add("https://pointmall.prcm.jp/item/redirect/5029");
		list.add("https://pointmall.prcm.jp/item/redirect/5030");
		list.add("https://pointmall.prcm.jp/item/redirect/5032");
		list.add("https://pointmall.prcm.jp/item/redirect/5033");
		list.add("https://pointmall.prcm.jp/item/redirect/5034");
		list.add("https://pointmall.prcm.jp/item/redirect/5035");
		list.add("https://pointmall.prcm.jp/item/redirect/5036");
		list.add("https://pointmall.prcm.jp/item/redirect/5037");
		list.add("https://pointmall.prcm.jp/item/redirect/4989");
		list.add("https://pointmall.prcm.jp/item/redirect/4974");
		list.add("https://pointmall.prcm.jp/item/redirect/4975");
		list.add("https://pointmall.prcm.jp/item/redirect/4976");
		list.add("https://pointmall.prcm.jp/item/redirect/4977");
		list.add("https://pointmall.prcm.jp/item/redirect/4978");
		list.add("https://pointmall.prcm.jp/item/redirect/4979");
		list.add("https://pointmall.prcm.jp/item/redirect/4980");
		list.add("https://pointmall.prcm.jp/item/redirect/4981");
		list.add("https://pointmall.prcm.jp/item/redirect/4982");
		list.add("https://pointmall.prcm.jp/item/redirect/4983");
		list.add("https://pointmall.prcm.jp/item/redirect/4959");
		list.add("https://pointmall.prcm.jp/item/redirect/4960");
		list.add("https://pointmall.prcm.jp/item/redirect/4961");
		list.add("https://pointmall.prcm.jp/item/redirect/330");
		list.add("https://pointmall.prcm.jp/item/redirect/4527");
		list.add("https://pointmall.prcm.jp/item/redirect/3083");
		list.add("https://pointmall.prcm.jp/item/redirect/4934");
		list.add("https://pointmall.prcm.jp/item/redirect/4935");
		list.add("https://pointmall.prcm.jp/item/redirect/4931");
		list.add("https://pointmall.prcm.jp/item/redirect/4932");
		list.add("https://pointmall.prcm.jp/item/redirect/4933");
		list.add("https://pointmall.prcm.jp/item/redirect/4936");
		list.add("https://pointmall.prcm.jp/item/redirect/4937");
		list.add("https://pointmall.prcm.jp/item/redirect/4938");
		list.add("https://pointmall.prcm.jp/item/redirect/4939");
		list.add("https://pointmall.prcm.jp/item/redirect/4940");
		list.add("https://pointmall.prcm.jp/item/redirect/5132");
		list.add("https://pointmall.prcm.jp/item/redirect/4875");
		list.add("https://pointmall.prcm.jp/item/redirect/4878");
		list.add("https://pointmall.prcm.jp/item/redirect/4883");
		list.add("https://pointmall.prcm.jp/item/redirect/4881");
		list.add("https://pointmall.prcm.jp/item/redirect/4882");
		list.add("https://pointmall.prcm.jp/item/redirect/4876");
		list.add("https://pointmall.prcm.jp/item/redirect/4877");
		list.add("https://pointmall.prcm.jp/item/redirect/4879");
		list.add("https://pointmall.prcm.jp/item/redirect/4880");
		list.add("https://pointmall.prcm.jp/item/redirect/4795");
		list.add("https://pointmall.prcm.jp/item/redirect/4789");
		list.add("https://pointmall.prcm.jp/item/redirect/4772");
		list.add("https://pointmall.prcm.jp/item/redirect/4840");
		list.add("https://pointmall.prcm.jp/item/redirect/318");
		list.add("https://pointmall.prcm.jp/item/redirect/4653");
		list.add("https://pointmall.prcm.jp/item/redirect/4664");
		list.add("https://pointmall.prcm.jp/item/redirect/4666");
		list.add("https://pointmall.prcm.jp/item/redirect/4668");
		list.add("https://pointmall.prcm.jp/item/redirect/4667");
		list.add("https://pointmall.prcm.jp/item/redirect/4665");
		list.add("https://pointmall.prcm.jp/item/redirect/4660");
		list.add("https://pointmall.prcm.jp/item/redirect/4654");
		list.add("https://pointmall.prcm.jp/item/redirect/4775");
		list.add("https://pointmall.prcm.jp/item/redirect/4519");
		list.add("https://pointmall.prcm.jp/item/redirect/4521");
		list.add("https://pointmall.prcm.jp/item/redirect/4517");
		list.add("https://pointmall.prcm.jp/item/redirect/4516");
		list.add("https://pointmall.prcm.jp/item/redirect/4515");
		list.add("https://pointmall.prcm.jp/item/redirect/4512");
		list.add("https://pointmall.prcm.jp/item/redirect/1036");
		list.add("https://pointmall.prcm.jp/item/redirect/338");
		list.add("https://pointmall.prcm.jp/item/redirect/328");
		list.add("https://pointmall.prcm.jp/item/redirect/327");
		list.add("https://pointmall.prcm.jp/item/redirect/326");
		list.add("https://pointmall.prcm.jp/item/redirect/325");
		list.add("https://pointmall.prcm.jp/item/redirect/323");
		list.add("https://pointmall.prcm.jp/item/redirect/322");
		list.add("https://pointmall.prcm.jp/item/redirect/320");
		list.add("https://pointmall.prcm.jp/item/redirect/319");
		list.add("https://pointmall.prcm.jp/item/redirect/304");
		list.add("https://pointmall.prcm.jp/item/redirect/305");
		list.add("https://pointmall.prcm.jp/item/redirect/331");
		list.add("https://pointmall.prcm.jp/item/redirect/306");
		list.add("https://pointmall.prcm.jp/item/redirect/307");
		list.add("https://pointmall.prcm.jp/item/redirect/308");
		list.add("https://pointmall.prcm.jp/item/redirect/332");
		list.add("https://pointmall.prcm.jp/item/redirect/311");
		list.add("https://pointmall.prcm.jp/item/redirect/312");
		list.add("https://pointmall.prcm.jp/item/redirect/313");
		list.add("https://pointmall.prcm.jp/item/redirect/737");
		list.add("https://pointmall.prcm.jp/item/redirect/4447");
		list.add("https://pointmall.prcm.jp/item/redirect/1044");
		list.add("https://pointmall.prcm.jp/item/redirect/249");
		list.add("https://pointmall.prcm.jp/item/redirect/251");
		list.add("https://pointmall.prcm.jp/item/redirect/252");
		list.add("https://pointmall.prcm.jp/item/redirect/255");
		list.add("https://pointmall.prcm.jp/item/redirect/285");
		list.add("https://pointmall.prcm.jp/item/redirect/256");
		list.add("https://pointmall.prcm.jp/item/redirect/259");
		list.add("https://pointmall.prcm.jp/item/redirect/260");
		list.add("https://pointmall.prcm.jp/item/redirect/264");
		list.add("https://pointmall.prcm.jp/item/redirect/1045");
		list.add("https://pointmall.prcm.jp/item/redirect/265");
		list.add("https://pointmall.prcm.jp/item/redirect/373");
		list.add("https://pointmall.prcm.jp/item/redirect/4561");
		list.add("https://pointmall.prcm.jp/item/redirect/4962");
		list.add("https://pointmall.prcm.jp/item/redirect/4963");
		list.add("https://pointmall.prcm.jp/item/redirect/272");
		return list;
	}

	/**
	 * =====================================================================================================================
	 * WEB診断番号一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getNumberList() {
		List<String> list=new ArrayList<String>();
		list.add("273703");
		list.add("276063");
		list.add("276065");
		list.add("276066");
		list.add("276071");
		list.add("276072");
		list.add("276075");
		list.add("276076");
		list.add("276077");
		list.add("276080");
		list.add("280898");
		list.add("280899");
		list.add("280900");
		list.add("280901");
		list.add("280902");
		list.add("280903");
		list.add("280904");
		list.add("285625");
		list.add("285626");
		list.add("285627");
		list.add("285628");
		list.add("285629");
		list.add("285630");
		list.add("285631");
		list.add("285632");
		list.add("285633");
		list.add("285634");
		list.add("291033");
		list.add("291034");
		list.add("291035");
		list.add("291037");
		list.add("291039");
		list.add("291041");
		list.add("291042");
		list.add("297075");
		list.add("297076");
		list.add("297077");
		list.add("297078");
		list.add("297080");
		list.add("297083");
		list.add("297084");
		list.add("297085");
		list.add("297087");
		list.add("297662");
		list.add("297663");
		list.add("297664");
		list.add("297665");
		list.add("297666");
		list.add("297667");
		list.add("297668");
		list.add("297670");
		list.add("297674");
		list.add("297698");
		list.add("298904");
		list.add("298905");
		list.add("298907");
		list.add("298908");
		list.add("298909");
		list.add("298910");
		list.add("298911");
		list.add("298912");
		list.add("298913");
		list.add("299254");
		list.add("299255");
		list.add("299258");
		list.add("299259");
		list.add("299261");
		list.add("299263");
		list.add("299264");
		list.add("299265");
		list.add("299266");
		list.add("299303");
		list.add("304869");
		list.add("304962");
		list.add("305225");
		list.add("305226");
		list.add("305229");
		list.add("305230");
		list.add("305231");
		list.add("305232");
		list.add("305233");
		list.add("305234");
		list.add("305235");
		list.add("309068");
		list.add("309069");
		list.add("309070");
		list.add("309072");
		list.add("309079");
		list.add("309080");
		list.add("309081");
		list.add("309082");
		list.add("309083");
		list.add("309085");
		list.add("311055");
		list.add("311056");
		list.add("311057");
		list.add("311060");
		list.add("311061");
		list.add("311062");
		list.add("311158");
		list.add("311159");
		list.add("311160");
		list.add("311161");
		list.add("312991");
		list.add("312992");
		list.add("312993");
		list.add("312994");
		list.add("312995");
		list.add("312996");
		list.add("312997");
		list.add("312998");
		list.add("313000");
		list.add("313001");
		list.add("314584");
		list.add("314585");
		list.add("314586");
		list.add("314588");
		list.add("314589");
		list.add("314590");
		list.add("314591");
		list.add("314592");
		list.add("314593");
		list.add("314594");
		list.add("318840");
		list.add("318841");
		list.add("318842");
		list.add("318844");
		list.add("318845");
		list.add("318846");
		list.add("318847");
		list.add("318848");
		list.add("318849");
		list.add("318850");
		list.add("320403");
		list.add("320404");
		list.add("320405");
		list.add("320407");
		list.add("320408");
		list.add("320409");
		list.add("320410");
		list.add("320411");
		list.add("320412");
		list.add("320414");
		list.add("322628");
		list.add("322629");
		list.add("322630");
		list.add("322631");
		list.add("322632");
		list.add("322633");
		list.add("322634");
		list.add("322637");
		list.add("322638");
		list.add("322639");
		list.add("324521");
		list.add("324522");
		list.add("324523");
		list.add("324524");
		list.add("324526");
		list.add("324527");
		list.add("324530");
		list.add("324531");
		list.add("324532");
		list.add("324533");
		list.add("325790");
		list.add("325791");
		list.add("325794");
		list.add("325795");
		list.add("325796");
		list.add("325797");
		list.add("325799");
		list.add("325800");
		list.add("325801");
		list.add("325810");
		list.add("327697");
		list.add("327698");
		list.add("327699");
		list.add("327700");
		list.add("327701");
		list.add("327702");
		list.add("327703");
		list.add("327706");
		list.add("327707");
		list.add("327708");
		list.add("329586");
		list.add("329587");
		list.add("329588");
		list.add("329589");
		list.add("329591");
		list.add("329592");
		list.add("329593");
		list.add("329594");
		list.add("329595");
		list.add("329596");
		list.add("330387");
		list.add("330388");
		list.add("330389");
		list.add("330390");
		list.add("330391");
		list.add("330392");
		list.add("330393");
		list.add("330394");
		list.add("330395");
		list.add("330396");
		list.add("332203");
		list.add("332204");
		list.add("332205");
		list.add("332206");
		list.add("332207");
		list.add("332208");
		list.add("332209");
		list.add("332211");
		list.add("332212");
		list.add("332213");
		list.add("336118");
		list.add("336119");
		list.add("336120");
		list.add("336121");
		list.add("336124");
		list.add("336125");
		list.add("336126");

		return list;
	}

}
