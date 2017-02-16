package common.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * =====================================================================================================================
 * 【チャンスイット】:定数
 * =====================================================================================================================
 *
 * @author kimC
 *
 */
public class ChanceConstants {

	/**
	 * privateコンストラクタでインスタンス生成を抑止
	 */
	private ChanceConstants() {
	}

	/** 【PC】ログインURL */
	public static final String PC_LOGIN_URL = "https://www.chance.com/member/login.srv";
	/** 【PC】CMくじURL */
	public static final String PC_CM_URL = "http://www.chance.com/pjump.srv?id=20625";
	/** 【PC】トイダスURL */
	public static final String PC_TOIDAS_URL = "http://www.chance.com/pjump.srv?id=23719";
	/** 【PC】アンケートURL */
	public static final String PC_ENQUETE_URL = "http://www.chance.com/research/";


	/** 【PC】WEB診断URL */
	public static final String PC_WEB_SHINDAN_URL = "http://shindan-apps.net/chanceit?uid=3435340";
	/** 【PC】モリゲーURL */
	public static final String PC_MRGA_SERVICE_URL = "http://mrga.service-navi.jp/collection";
	/** 【PC】モリモリクイズURL */
	public static final String PC_MRGA_QUIZ_URL = "http://mrga.service-navi.jp/login/redirectqp";

	/** 【SP】:CMくじURL */
	public static final String SP_CM_URL = "http://www.gendama.jp/cl/?id=134510&rt=s&u=6278067";
	/** 【SP】:WEB診断URL */
	public static final String SP_WEB_SHINDAN_URL = "http://www.gendama.jp/sp/more_point";
	/** 【SP】:ポイントの森URL */
	public static final String SP_FOREST_URL = "http://www.gendama.jp/sp/forest";

	/** 【PC】ログインメールアドレス */
	public static final String PC_LOGIN_MAIL = "takashi_19780705@yahoo.co.jp";
	/** 【PC】ログインパスワード */
	public static final String PC_LOGIN_PASSWORD = "LXQZ0705";
	/** 【PC】モリモリ診断URL */
	public static final String PC_ADSURVEY_URL = ".*http://adsurvey.media-ad.jp/.*";
	/** 【PC】モリモリMRGAアンケートURL */
	public static final String PC_MRGA_URL = ".*http://mrga.service-navi.jp/.*";
	/** 【PC】モリモリCOLUMNアンケートURL */
	public static final String PC_COLUMN_URL = ".*http://column-enquete-reado.com/.*";

	/** 【PC】多数決本日終了メッセージ */
	public static final String PC_END_MESSAGE = ".*ポイントがもらえる質問がありません！また明日来てね！.*";
	
	/** 【PC】登録URL */
	public static final String PC_REGISTER_URL = "https://www.chance.com/member/vcampaign.srv?fid=oDsTwLfUyRQ%3D";
	/** 【PC】メールURL */
	public static final String MAIL_URL = "https://m.kuku.lu/index.php";
	/** 【PC】メールID */
	public static final String MAIL_ID = "chance_2017";
	/** 【PC】メールパスワード */
	public static final String MAIL_PASS = "chance_2017";
	
	/**
	 * =====================================================================================================================
	 * メール一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getMailList() {
		List<String> list=new ArrayList<String>();
		list.add("kubeyaryo@cream.pink");
		list.add("porinu@f5.si");
		list.add("sope151@f5.si");
		list.add("byofo159@fuwamofu.com");
		list.add("nuteya@ruru.be");
		list.add("herepaso@ruru.be");
		list.add("pebuzimyo@ruru.be");
		list.add("kodogeya@cream.pink");
		list.add("mepomiwa@macr2.com");
		list.add("gyazakato@ahk.jp");
		list.add("yafatata@svk.jp");
		list.add("sado348@f5.si");
		list.add("yama95@f5.si");
		list.add("nyose231@ichigo.me");
		list.add("netokuya@merry.pink");
		list.add("ke768@cream.pink");
		list.add("bazo158@ichigo.me");
		list.add("momapya8@merry.pink");
		list.add("pidobu@neko2.net");
		list.add("puzi738@ruru.be");
		list.add("fipu4@cream.pink");
		list.add("kapo49@merry.pink");
		list.add("fabefasa@fuwamofu.com");
		list.add("kyupoga@cream.pink");
		list.add("tokepyoso@ichigo.me");
		list.add("demyumu497@ichigo.me");
		list.add("pyaponyo382@svk.jp");
		list.add("kupofe@f5.si");
		list.add("birinagi@ahk.jp");
		list.add("gafe562@cream.pink");
		list.add("dezeka522@svk.jp");
		list.add("pu789@ichigo.me");
		list.add("henugimu@neko2.net");
		list.add("byakyugo@macr2.com");
		list.add("nyunuhu@ichigo.me");
		list.add("gasugya750@fuwamofu.com");
		list.add("fosuhosi@fuwamofu.com");
		list.add("nugunebi@neko2.net");
		list.add("danepe@fuwamofu.com");
		list.add("zukipa@neko2.net");
		list.add("nenyuta@macr2.com");
		list.add("yare277@ruru.be");
		list.add("hayo995@f5.si");
		list.add("ryokyupo@ichigo.me");
		list.add("tadosiwa@svk.jp");
		list.add("pibya167@cream.pink");
		list.add("ryotomuku@f5.si");
		list.add("monumyomyo@svk.jp");
		list.add("byo127@ichigo.me");
		list.add("byanyo330@f5.si");
		list.add("zimyobo@cream.pink");
		list.add("wanibya803@macr2.com");
		list.add("ruzaba@ahk.jp");
		list.add("henomyora@macr2.com");
		list.add("myobya162@macr2.com");
		list.add("yupokakya@f5.si");
		list.add("betokyu749@neko2.net");
		list.add("hifokaryu@svk.jp");
		list.add("potomyo@merry.pink");
		list.add("mehi697@cream.pink");
		list.add("nayuyu203@ahk.jp");
		list.add("byobepa@ichigo.me");
		list.add("gazode@macr2.com");
		list.add("yori241@f5.si");
		list.add("fonemo755@merry.pink");
		list.add("hipasede@neko2.net");
		list.add("ryu342@cream.pink");
		list.add("noforo@ichigo.me");
		list.add("ganegupyo@ichigo.me");
		list.add("nakapora@merry.pink");
		list.add("seda733@fuwamofu.com");
		list.add("sisazi@ichigo.me");
		list.add("yapyopu@macr2.com");
		list.add("kyagyogi@ruru.be");
		list.add("sukumo@neko2.net");
		list.add("gohite@f5.si");
		list.add("buzorekya@ahk.jp");
		list.add("dosufi@f5.si");
		list.add("rozokyo@macr2.com");
		list.add("roha625@merry.pink");
		list.add("supu634@ichigo.me");
		list.add("naryo370@svk.jp");
		list.add("nyaryuso@ahk.jp");
		list.add("gifo768@f5.si");
		list.add("buzo696@ahk.jp");
		list.add("nyonyu845@ahk.jp");

		return list;
	}
	
	/**
	 * =====================================================================================================================
	 * メール一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getPassList() {
		List<String> list=new ArrayList<String>();
		list.add("31aPe1SRRb");
		list.add("3O8Tl61f1b");
		list.add("3jgscVrlLb");
		list.add("3Cf33HO8Yb");
		list.add("3vfuvcNe8b");
		list.add("33A8DxkA8b");
		list.add("3fSaZ70Hbb");
		list.add("3CMgU7uiWb");
		list.add("3DHJk5cd0b");
		list.add("3A98LbPDob");
		list.add("3JRBvDvS6b");
		list.add("3MA07MKFwb");
		list.add("3QgRnY6neb");
		list.add("33Eg2s1SEb");
		list.add("3eNivnwAZb");
		list.add("3z4hn3D1Gb");
		list.add("3Fw3cajx8b");
		list.add("3UO6rPcXrb");
		list.add("3AU9glsudb");
		list.add("3cbuVybD3b");
		list.add("3PGl6yga4b");
		list.add("3fNb4BKPtb");
		list.add("3eyRDhEBUb");
		list.add("3my6lae4eb");
		list.add("30C8y61jgb");
		list.add("3cWYlcVynb");
		list.add("3iWeL1836b");
		list.add("3hw54004xb");
		list.add("3ofbT46Hxb");
		list.add("3Q4CXYEOSb");
		list.add("3BPZCHP9Eb");
		list.add("37pihq0pob");
		list.add("31aP41SRRb");
		list.add("3OxTl61f1b");
		list.add("3jgsiVrlLb");
		list.add("3Cf33HO8Yb");
		list.add("3vfuviNexb");
		list.add("33AxDxkA8b");
		list.add("3fSaZ70Hbb");
		list.add("3CMgU7u4Wb");
		list.add("3DHJk5cd0b");
		list.add("3A98LbPDob");
		list.add("3JRBvDvS6b");
		list.add("3lxza6CHzb");
		list.add("3F6RjrzvKb");
		list.add("3J798bAF7b");
		list.add("3gd4yP74Lb");
		list.add("3IeRxrco1b");
		list.add("3WaiVTProb");
		list.add("3ZNa4cBmvb");
		list.add("3wgWDm8K6b");
		list.add("3sV6ULx4hb");
		list.add("36O4qnbx3b");
		list.add("3XgbSlL84b");
		list.add("3QhtcLGmDb");
		list.add("3KjUXZJFAb");
		list.add("3ztfcDd3Ob");
		list.add("35V0VBA1Bb");
		list.add("3jhfNOrWFb");
		list.add("3NxUSzQ71b");
		list.add("3yHLszX6Xb");
		list.add("3BCNxLfcib");
		list.add("3u6By6CXTb");
		list.add("3S7wTX3VQb");
		list.add("3dlhvJvVob");
		list.add("38X8F19exb");
		list.add("3eVqPHz2sb");
		list.add("32zpxGr6Jb");
		list.add("34Mhbql4Zb");
		list.add("3WJP0lcyzb");
		list.add("3HXej4KrAb");
		list.add("33DGLEnHBb");
		list.add("3SOeMvKEtb");
		list.add("3nuX4Em67b");
		list.add("3ncW44jP2b");
		list.add("3yD4fw4HPb");
		list.add("3O19K3wSub");
		list.add("3SOVEEahtb");
		list.add("3xxeSVBuvb");
		list.add("3qSbXKl4Mb");
		list.add("3WFfdxG0Gb");
		list.add("3NDzkfv5Ub");
		list.add("3X4NiiyFmb");
		list.add("3CEZt0T9Hb");
		list.add("3GTezpj9eb");
		list.add("3YLRt58Blb");


		return list;
	}
	
	/**
	 * =====================================================================================================================
	 * ニックネーム一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getNickNameList() {
		List<String> list=new ArrayList<String>();		
		list.add("Mami_Kawana");
		list.add("tsugio650");
		list.add("takafumi20250");
		list.add("masaru4335");
		list.add("miyutakahashi");
		list.add("jsspksrhxbqxishuuji307");
		list.add("jun21994");
		list.add("nobuo0350");
		list.add("yasuyuki4972");
		list.add("ayumi1397");
		list.add("mitsuo484");
		list.add("yoshio0001");
		list.add("rymufoagwpqyoshiaki18936");
		list.add("imaejima");
		list.add("tetsuo907");
		list.add("shouji4019");
		list.add("chikarataniuchi");
		list.add("bozfckfsyomotoko74986");
		list.add("toshio406");
		list.add("hiroko3374");
		list.add("chiakitakamura");
		list.add("kazunori48643");
		list.add("Shino_Umeki");
		list.add("olidwtarzzpghayasuyoshi599");
		list.add("satomi3307");
		list.add("ryuuichi75357");
		list.add("teiichishimabukuro");
		list.add("nkihara");
		list.add("yuika79332");
		list.add("tomoko5091");
		list.add("ezlnweouulyiemariko340");
		list.add("yuki9839");
		list.add("Morio_Kita");
		list.add("mitsuo72929");
		list.add("hptn=sgjddkenji751");
		list.add("mrtwuumeqsv-yuuto045");
		list.add("ikosugi");
		list.add("fukutarou09872");
		list.add("takashi9000");
		list.add("tarou11763");
		list.add("toshimitsu629");
		list.add("kazuyoshi_nemoto");
		list.add("takuya_takaoka");
		list.add("tamio_kaji");
		list.add("tadayoshi_sakashita");
		list.add("mitsuaki692");
		list.add("makonara");
		list.add("akio7464");
		list.add("qjpcmclxtnhmxvsshiori45063");
		list.add("nennbolmuneo43254");
		list.add("ippeiokayama");
		list.add("yuukooobayashi");
		list.add("katsumi81953");
		list.add("honokaishihara");
		list.add("teiichi9485");
		list.add("akikonagasaka");
		list.add("takeshi_terada");
		list.add("ihosaka");
		list.add("masahiko8256");
		list.add("mari_ogino");
		list.add("kouhei4868");
		list.add("oinomata");
		list.add("kazuko70999");
		list.add("yasuko5101");
		list.add("tsuyoshi01673");
		list.add("harumi49548");
		list.add("Sawa_Ikeuchi");
		list.add("Yoshio_Kouya");
		list.add("tetsurou_yokokawa");
		list.add("shouzou_saegusa");
		list.add("ryuuhei639");
		list.add("masako9884");
		list.add("gzzqcjbtnmkayo31402");
		list.add("shingen_nishida");
		list.add("ryuusuke387");
		list.add("katsuyoshi08342");
		list.add("masatoshinakamura");
		list.add("akeomjisao5018");
		list.add("fymmobga-yyoshirou5185");
		list.add("hitoshi_kitano");
		list.add("yasuhikohiruta");
		list.add("Kyouko_Itakura");
		list.add("Naoko_Harada");
		list.add("akawada");
		list.add("hiroko_akutsu");
		list.add("yoshio818");

		return list;
	}
	
	/**
	 * =====================================================================================================================
	 * 年一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getYearList() {
		List<String> list=new ArrayList<String>();
		list.add("1979");
		list.add("1983");
		list.add("1970");
		list.add("1975");
		list.add("1986");
		list.add("1984");
		list.add("1967");
		list.add("1969");
		list.add("1975");
		list.add("1986");
		list.add("1975");
		list.add("1992");
		list.add("1976");
		list.add("1993");
		list.add("1959");
		list.add("1983");
		list.add("1984");
		list.add("1992");
		list.add("1983");
		list.add("1986");
		list.add("1970");
		list.add("1958");
		list.add("1970");
		list.add("1990");
		list.add("1985");
		list.add("1970");
		list.add("1976");
		list.add("1965");
		list.add("1967");
		list.add("1982");
		list.add("1969");
		list.add("1991");
		list.add("1988");
		list.add("1993");
		list.add("1957");
		list.add("1971");
		list.add("1975");
		list.add("1977");
		list.add("1987");
		list.add("1971");
		list.add("1968");
		list.add("1994");
		list.add("1977");
		list.add("1981");
		list.add("1958");
		list.add("1988");
		list.add("1976");
		list.add("1993");
		list.add("1997");
		list.add("1974");
		list.add("1971");
		list.add("1988");
		list.add("1969");
		list.add("1974");
		list.add("1957");
		list.add("1960");
		list.add("1975");
		list.add("1977");
		list.add("1964");
		list.add("1962");
		list.add("1993");
		list.add("1980");
		list.add("1964");
		list.add("1995");
		list.add("1961");
		list.add("1995");
		list.add("1981");
		list.add("1993");
		list.add("1962");
		list.add("1959");
		list.add("1985");
		list.add("1961");
		list.add("1971");
		list.add("1981");
		list.add("1990");
		list.add("1972");
		list.add("1983");
		list.add("1975");
		list.add("1983");
		list.add("1959");
		list.add("1991");
		list.add("1967");
		list.add("1967");
		list.add("1964");
		list.add("1992");
		list.add("1979");

		return list;
	}
	
	/**
	 * =====================================================================================================================
	 * 月一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getMonthList() {
		List<String> list=new ArrayList<String>();
		list.add("8");
		list.add("8");
		list.add("12");
		list.add("11");
		list.add("11");
		list.add("6");
		list.add("4");
		list.add("7");
		list.add("12");
		list.add("3");
		list.add("10");
		list.add("12");
		list.add("8");
		list.add("8");
		list.add("7");
		list.add("6");
		list.add("7");
		list.add("5");
		list.add("10");
		list.add("3");
		list.add("5");
		list.add("9");
		list.add("5");
		list.add("4");
		list.add("9");
		list.add("11");
		list.add("8");
		list.add("1");
		list.add("8");
		list.add("1");
		list.add("9");
		list.add("3");
		list.add("6");
		list.add("6");
		list.add("7");
		list.add("12");
		list.add("4");
		list.add("2");
		list.add("2");
		list.add("2");
		list.add("6");
		list.add("9");
		list.add("8");
		list.add("6");
		list.add("12");
		list.add("8");
		list.add("2");
		list.add("7");
		list.add("1");
		list.add("1");
		list.add("12");
		list.add("11");
		list.add("12");
		list.add("7");
		list.add("6");
		list.add("2");
		list.add("3");
		list.add("11");
		list.add("4");
		list.add("6");
		list.add("2");
		list.add("10");
		list.add("6");
		list.add("6");
		list.add("6");
		list.add("4");
		list.add("5");
		list.add("11");
		list.add("5");
		list.add("7");
		list.add("4");
		list.add("12");
		list.add("12");
		list.add("7");
		list.add("4");
		list.add("3");
		list.add("8");
		list.add("8");
		list.add("10");
		list.add("12");
		list.add("2");
		list.add("1");
		list.add("4");
		list.add("10");
		list.add("11");
		list.add("12");

		return list;
	}
	
	/**
	 * =====================================================================================================================
	 * 日一覧を取得する
	 * =====================================================================================================================
	 *
	 * @author kimC
	 *
	 */
	public static List<String> getDayList() {
		List<String> list=new ArrayList<String>();
		list.add("24");
		list.add("19");
		list.add("11");
		list.add("27");
		list.add("9");
		list.add("15");
		list.add("18");
		list.add("20");
		list.add("23");
		list.add("19");
		list.add("25");
		list.add("21");
		list.add("17");
		list.add("30");
		list.add("10");
		list.add("17");
		list.add("16");
		list.add("28");
		list.add("31");
		list.add("7");
		list.add("22");
		list.add("17");
		list.add("18");
		list.add("8");
		list.add("19");
		list.add("1");
		list.add("9");
		list.add("4");
		list.add("1");
		list.add("4");
		list.add("23");
		list.add("7");
		list.add("3");
		list.add("29");
		list.add("10");
		list.add("9");
		list.add("22");
		list.add("9");
		list.add("22");
		list.add("26");
		list.add("4");
		list.add("19");
		list.add("7");
		list.add("30");
		list.add("14");
		list.add("11");
		list.add("3");
		list.add("22");
		list.add("10");
		list.add("16");
		list.add("9");
		list.add("2");
		list.add("13");
		list.add("20");
		list.add("30");
		list.add("24");
		list.add("10");
		list.add("16");
		list.add("5");
		list.add("29");
		list.add("10");
		list.add("8");
		list.add("8");
		list.add("22");
		list.add("24");
		list.add("29");
		list.add("26");
		list.add("21");
		list.add("8");
		list.add("27");
		list.add("18");
		list.add("17");
		list.add("1");
		list.add("20");
		list.add("29");
		list.add("28");
		list.add("15");
		list.add("12");
		list.add("1");
		list.add("15");
		list.add("15");
		list.add("10");
		list.add("30");
		list.add("14");
		list.add("18");
		list.add("1");

		return list;
	}
	

}
