package kr.cafein.util;

public class PagingUtil_adminFranchise {
	private int startCount;	 // �� ���������� ������ �Խñ��� ���� ��ȣ
	private int endCount;	 // �� ���������� ������ �Խñ��� �� ��ȣ
	private StringBuffer pagingHtml;// ������ ǥ�� ���ڿ�
/*	private int franchise_num;*/

	/**
	 * currentPage : ����������
	 * totalCount : ��ü �Խù� ��
	 * rowCount : �� ��������  �Խù��� ��
	 * pageCount : �� ȭ�鿡 ������ ������ ��
	 * pageUrl : ȣ�� ������ url
	 * addKey : �ΰ����� key ���� ���� null ó�� (&num=23�������� ������ ��)
	 * */

	
	/* ========================   */

	public PagingUtil_adminFranchise(String keyword, int currentPage, int totalCount, int rowCount,
			int pageCount, int franchise_num,String pageUrl) {
		this(keyword,currentPage,totalCount,rowCount,pageCount,pageUrl,null,franchise_num);
	}

	public PagingUtil_adminFranchise(String keyword, int currentPage, int totalCount, int rowCount,
			int pageCount,String pageUrl,String addKey,int franchise_num) {
		

if(addKey == null) addKey = ""; //�ΰ�Ű�� null �϶� ""ó��
		
		// ��ü ������ ��
		int totalPage = (int) Math.ceil((double) totalCount / rowCount);
		if (totalPage == 0) {
			totalPage = 1;
		}
		// ���� �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		// ���� �������� ó���� ������ ���� ��ȣ ��������.
		startCount = (currentPage - 1) * rowCount + 1;
		endCount = currentPage * rowCount;
		// ���� �������� ������ ������ �� ���ϱ�.
		int startPage = (int) ((currentPage - 1) / pageCount) * pageCount + 1;
		int endPage = startPage + pageCount - 1;
		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		// ���� block ������
		pagingHtml = new StringBuffer();
		if (currentPage > pageCount) {
			if(keyword==null){//�˻� �̻���
				pagingHtml.append("<a href="+pageUrl+"?franchise_num="+franchise_num+"&pageNum="+ (startPage - 1) + addKey +">");
			}else{
				pagingHtml.append("<a href="+pageUrl+"?franchise_num="+franchise_num+"&keyword="+keyword+"&pageNum="+ (startPage - 1) + addKey +">");
			}
			pagingHtml.append("����");
			pagingHtml.append("</a>");
		}
		pagingHtml.append("&nbsp;|&nbsp;");
		//������ ��ȣ.���� �������� ���������� �����ϰ� ��ũ�� ����.
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("&nbsp;<b> <font color='red'>");
				pagingHtml.append(i);
				pagingHtml.append("</font></b>");
			} else {
				if(keyword==null){//�˻� �̻���
					pagingHtml.append("&nbsp;<a href='"+pageUrl+"?franchise_num="+franchise_num+"&pageNum=");
				}else{
					pagingHtml.append("&nbsp;<a href='"+pageUrl+"?franchise_num="+franchise_num+"&keyword="+keyword+"&pageNum=");
				}
				pagingHtml.append(i);
				pagingHtml.append(addKey+"'>");
				pagingHtml.append(i);
				pagingHtml.append("</a>");
			}
			pagingHtml.append("&nbsp;");
		}
		pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");
		// ���� block ������
		if (totalPage - startPage >= pageCount) {
			if(keyword==null){//�˻� �̻���
				pagingHtml.append("<a href="+pageUrl+"?franchise_num="+franchise_num+"&pageNum="+ (endPage + 1) + addKey +">");
			}else{
				pagingHtml.append("<a href="+pageUrl+"?franchise_num="+franchise_num+"&keyword="+keyword+"&pageNum="+ (endPage + 1) + addKey +">");
			}
			pagingHtml.append("����");
			pagingHtml.append("</a>");
		}
	}
	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}
	public int getStartCount() {
		return startCount;
	}
	public int getEndCount() {
		return endCount;
	}


}
