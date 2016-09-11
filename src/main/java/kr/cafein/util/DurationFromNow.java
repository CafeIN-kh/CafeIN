package kr.cafein.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DurationFromNow {
	/**
	 * ������� "yyyyMMddHHmmss" ������ ��¥ ���� ���̺�
	 * @param date1
	 * @return String
	 */
	public static String getTimeDiffLabel(String date1) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			return getTimeDiffLabel(sdf.parse(date1), new Date());
		} catch (ParseException e) {
			return "-";
		}
	}

	/**
	 * ������� Date ������ ��¥ ���� ���̺�
	 * @param d1
	 * @return String
	 */
	public static String getTimeDiffLabel(Date d1) {
		return getTimeDiffLabel(d1, new Date());
	}

	/**
	 * "yyyyMMddHHmmss" ������ ��¥ ���� ���̺�
	 * @param date1
	 * @param date2
	 * @return String
	 */
	public static String getTimeDiffLabel(String date1, String date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd- HH:mm:ss");
		try {
			return getTimeDiffLabel(sdf.parse(date1), sdf.parse(date2));
		} catch (ParseException e) {
			return "-";
		}
	}

	/**
	 * java.util.Date ������ ��¥ ���� ���̺�
	 * @param d1
	 * @param d2
	 * @return String
	 */
	public static String getTimeDiffLabel(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		int sec = (int)(diff / 1000);
		if (sec < 5) return "5�ʹ̸�";
		if (sec < 60) return sec + "�� ��";

		int min = (int)(sec / 60);
		if (min < 60) return min + "�� ��";

		int hour = (int)(min / 60);
		if (hour < 24) return hour + "�ð� ��";

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = (Calendar) c1.clone();
		c1.setTime(d1);
		c2.setTime(d2);

		int day = c2.get(Calendar.DATE) - c1.get(Calendar.DATE);
		if (day <= 0) {
			day = hour / 24;
		}

		if (hour/24 < 30) {
			if (day == 1) return "����";
			if (day == 2) return "2����";
			return day + "����";
		}

		int month = hour / 24 / 30;
		if (month == 1) return "�� ����";
		if (month == 2) return "�� ����";
		if (month < 12) return month + "����";

		int year = month / 12;
		if (year == 1) return "�۳�";
		return year + "����";

	}
}