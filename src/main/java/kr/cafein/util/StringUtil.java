package kr.cafein.util;

public class StringUtil {

	//HTML ����, �ٹٲ�
	public static String useBrNoHtml(String str) {
		if(str == null) return null;
		
		//null�� �ƴҰ��
		//\r\n���� �����Ǿ����� ��� <br>�� ��ü
		//�ٲ� ������ �� \r�� ������ �ٽ� <br>�� ��ü
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;")
				  .replaceAll("\r\n", "<br>")
				  .replaceAll("\r", "<br>")
				  .replaceAll("\n", "<br>");
	}
	//HTML ���� 
	public static String useNoHtml(String str) {
		if(str == null) return null;
		
		//null�� �ƴҰ��
		return str.replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;");
	}
}
