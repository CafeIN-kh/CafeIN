package kr.cafein.util;

public class StringUtil {

	//HTML 불허, 줄바꿈
	public static String useBrNoHtml(String str) {
		if(str == null) return null;
		
		//null이 아닐경우
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;")
				  .replaceAll("\r\n", "<br>")
				  .replaceAll("\r", "<br>")
				  .replaceAll("\n", "<br>");
	}
	//HTML 불허 
	public static String useNoHtml(String str) {
		if(str == null) return null;
		
		//null이 아닐경우
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;");
	}
}
