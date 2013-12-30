package com.app.utils.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Date Utility Class This is used to convert Strings to Dates and Timestamps
 */
@Component("dateUtil")
@SuppressWarnings("all")
public class DateUtil {
	public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	public final static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public final static SimpleDateFormat simpleDateFormat32 = new SimpleDateFormat(
			"MM/dd/yyyy");

	public final static SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(
			"MM/dd/yyyy HH:mm:ss");

	public final static SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(
			"MMddyyyyHHmmss");
	public final static SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	private final static Log log = LogFactory.getLog(DateUtil.class);

	@SuppressWarnings("unused")
	private final static String defaultDatePattern = null;

	private final static String timePattern = "HH:mm";

	private final static String datePattern = "yyyy-MM-dd HH:mm";

	private final static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

	private final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd");

	/** String date convert to Timestamp */
	public static Timestamp convertStringToTimestamp(String date) {
		String time = date + " 00:00:00";
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}

	/** Timestampconvert to String */
	public static String convertTimestampToString(Timestamp ts) {
		String date = sdf.format(ts);
		return date;
	}

	/**
	 * 获取某个时间最后一天
	 * 
	 * @param sDate1
	 * @return
	 * 
	 * @author 汤建东
	 * @date 2013-1-18 下午3:49:20
	 * 
	 */
	public static int getLastDayOfMonth(Date sDate1) {
		Calendar cDay1 = Calendar.getInstance();
		cDay1.setTime(sDate1);
		int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
		return lastDay;
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);
		if (log.isDebugEnabled()) {
			// log.debug("converting '" + strDate + "' to date with mask '"
			// + aMask + "'");
		}

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	public static String getDateStr(Date theTime) {
		return getDateTime(datePattern, theTime);
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			log.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static boolean isToday(java.sql.Date aDate) {
		final Date now = new Date();
		String nowtime = df.format(now).toString();
		String createtime = df.format(aDate).toString();
		return nowtime.equals(createtime);
	}

	public static Date addDate(Date date, int type, int intervel) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, intervel);
		return calendar.getTime();
	}

	public static int getMinuteMargin(Date beginDate, Date endDate) {
		int minute = 0;
		final int mOfMinute = 1000 * 60;
		final long divtime = (endDate.getTime() - beginDate.getTime());
		final long lminute = divtime % mOfMinute > 0 ? divtime / mOfMinute + 1
				: divtime / mOfMinute;
		minute = Long.valueOf(lminute).intValue();
		return minute;
	}

	public static float dateDiff(Timestamp t1, Timestamp t2, int type) {
		float i = t1.getTime() - t2.getTime();
		float f = 0.0f;// i / (1000 * 60);
		switch (type) {
		case 1:// hour
			f = i / (1000 * 60 * 60);
			break;
		case 2:// min
			f = i / (1000 * 60);
			break;
		case 3:// sec
			f = i / (1000);
			break;
		case 0: // defaut is day
			f = i / (1000 * 60 * 60 * 24);
		}
		String temp = "#,##0.0";
		try {
			return Float.valueOf(new java.text.DecimalFormat(temp).format(f));
		} catch (Exception e) {
			;// System.out.println(e);
		}
		return f;
	}

	public static Timestamp dateAdd(Timestamp t1, Integer i, int type) {
		long interval = i * 1000 * 60 * 60 * 24l;
		Timestamp t = null;
		switch (type) {
		case 1:// hour
			interval = 1000 * 60 * 60 * i;
			t = new Timestamp(t1.getTime() + interval);
			break;
		case 2:// min
			interval = 1000 * 60 * i;
			t = new Timestamp(t1.getTime() + interval);
			break;
		case 3:// sec
			interval = 1000 * i;
			t = new Timestamp(t1.getTime() + interval);
			break;
		case 0: // defaut is day
			t = new Timestamp(t1.getTime() + interval);
			break;
		default:
			t = t1;
		}
		return t;
	}

	/**
	 * 获取月份的开始日期与结束日期 （结束日期为下月的一号）
	 * 
	 * @param date
	 *            日期
	 * @return Date[]
	 */
	public static Date[] getMonthOfYear(Date dateTime) {
		Date[] date = new Date[2];
		try {
			int monthfield, yearReport;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateTime);
			yearReport = calendar.get(Calendar.YEAR);
			monthfield = calendar.get(Calendar.MONTH) + 1;
			Calendar lastDate = Calendar.getInstance();
			lastDate.set(Calendar.YEAR, yearReport);
			lastDate.set(Calendar.MONTH, monthfield - 1);
			lastDate.set(Calendar.DATE, 1);
			int year = lastDate.get(Calendar.YEAR);
			int month = lastDate.get(Calendar.MONTH) + 1;
			int day = lastDate.get(Calendar.DATE);
			String startDate = year + "-" + month + "-" + day;
			date[0] = simpleDateFormat.parse(startDate);
			lastDate.add(Calendar.MONTH, 1);
			lastDate.add(Calendar.DATE, -1);
			year = lastDate.get(Calendar.YEAR);
			month = lastDate.get(Calendar.MONTH) + 1;
			day = lastDate.get(Calendar.DATE);
			startDate = year + "-" + month + "-" + day + " 24" + ":" + "00"
					+ ":" + "00";
			date[1] = simpleDateFormat1.parse(startDate);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		return date;
	}

	/**
	 * 获取日期 年 月 日
	 * 
	 * @param date
	 * @return
	 */
	public static int[] getYearAndMonthAndDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return new int[] { year, month, day };
	}

	/**
	 * 获取两个日期的时间差
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return 相隔天数
	 */
	public static int getTimeDifference(Date beginDate, Date endDate) {
		long DAY = 24L * 60L * 60L * 1000L;
		long day = endDate.getTime() - beginDate.getTime();
		return Long.valueOf(day / DAY).intValue();
	}

	/**
	 * ȡ��ָ����ʽ�ĵ�ǰ���� Symbol Meaning Presentation Example ------ -------
	 * ------------ ------- G era designator (Text) AD y year (Number) 1996 M
	 * month in year (Text & Number) July & 07 d day in month (Number) 10 h hour
	 * in am/pm (1~12) (Number) 12 H hour in day (0~23) (Number) 0 m minute in
	 * hour (Number) 30 s second in minute (Number) 55 S millisecond (Number)
	 * 978 E day in week (Text) Tuesday D day in year (Number) 189 F day of week
	 * in month (Number) 2 (2nd Wed in July) w week in year (Number) 27 W week
	 * in month (Number) 2 a am/pm marker (Text) PM k hour in day (1~24)
	 * (Number) 24 K hour in am/pm (0~11) (Number) 0 z time zone (Text) Pacific
	 * Standard Time ' escape for text (Delimiter) '' single quote (Literal) '
	 * ��:yyyy-MM-dd HH:mm:ss.SSS
	 * 
	 * @param format
	 *            String
	 * @return String
	 */
	public static String getCurDateTime(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date dateCurrentTime = new Date();
		String sCurrentTime = formatter.format(dateCurrentTime);
		return sCurrentTime;
	}

	/**
	 * ����תΪָ���ĸ�ʽ�ַ�
	 * 
	 * @param inputDateTime
	 *            Date
	 * @param format
	 *            String
	 * @return String
	 */
	public static String dateToString(Date inputDateTime, String format) {
		String outDateTime = "0000-00-00 00:00:00";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			outDateTime = formatter.format(inputDateTime);
		} catch (Exception ex) {
		}
		return outDateTime;
	}

	/**
	 * �ַ�ת����
	 * 
	 * @param s
	 *            String
	 * @return Date
	 */
	public static Date StringToDate(String s) {
		Date date = new Date();
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			ParsePosition parseposition = new ParsePosition(0);
			date = simpledateformat.parse(s, parseposition);
		} catch (Exception ex) {
		}
		return date;
	}

	public static Date DateStringToDate(String s) {
		Date date = new Date();
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat(
					"yyyy-MM-dd");
			ParsePosition parseposition = new ParsePosition(0);
			date = simpledateformat.parse(s, parseposition);
		} catch (Exception ex) {
		}
		return date;
	}

	public static Date TimeStringToDate(String s) {
		Date date = new Date();
		try {
			SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm:ss");
			ParsePosition parseposition = new ParsePosition(0);
			date = simpledateformat.parse(s, parseposition);
		} catch (Exception ex) {
		}
		return date;
	}

	public static int getSeason() {
		int ret = 0;
		try {
			int month = Integer.parseInt(getCurDateTime("MM"));
			int day = Integer.parseInt(getCurDateTime("dd"));
			if (month > 1 && month <= 3)
				ret = 4;
			if (month == 3 && day > 19)
				ret = 1;
			if (month > 3 && month <= 6)
				ret = 1;
			if (month == 6 && day > 20)
				ret = 2;
			if (month > 6 && month <= 9)
				ret = 2;
			if (month == 9 && day > 21)
				ret = 3;
			if (month > 9 && month <= 12)
				ret = 3;
			if (month == 12 && day > 20)
				ret = 4;
		} catch (Exception ex) {
		}
		return ret;
	}

	/** 日期格式化 */
	public static String date2String(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 取得前几天的时间
	 * 
	 * @return String
	 * @author YANGJH
	 */
	public static String getBeforeDay(int day) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_WEEK, -day);
		return simpleDateFormat.format(c.getTime());
	}

	/**
	 * 取得前几个月的时间
	 * 
	 * @return String
	 * @author YANGJH
	 */
	public static String getBeforeMonth(int month) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -month);
		return simpleDateFormat.format(c.getTime());
	}

	/**
	 * @author caiqifan
	 * @date 2011-12-1 下午01:48:59
	 * @describe 获取当前日期前N天时间
	 * @return List
	 * @exception
	 * @version 1.0
	 */
	public static List getDateBeforeList(int num) {
		List list = new ArrayList();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int moths = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		for (int k = 1; k <= num; k++) {
			String cudate = getCurrentDate(year, moths, day, k - 1, "-");
			list.add(cudate);
		}
		return list;
	}

	/**
	 * @author caiqifan
	 * @date 2011-12-1 下午01:47:46
	 * @describe 获取当前日期前一天
	 * @return String
	 * @exception
	 * @version 1.0
	 */
	public static String getCurrentDate(int year, int month, int day,
			int beDay, String sign) {
		GregorianCalendar newCal = new GregorianCalendar(year, month, day);
		long milSec = newCal.getTimeInMillis() - beDay * 24 * 3600 * 1000;
		if ("+".equals(sign)) {
			milSec = newCal.getTimeInMillis() + beDay * 24 * 3600 * 1000;
		} else if ("-".equals(sign)) {
			milSec = newCal.getTimeInMillis() - beDay * 24 * 3600 * 1000;
		}
		GregorianCalendar other = new GregorianCalendar();
		other.setTimeInMillis(milSec);
		String newYear = String.valueOf(other.get(GregorianCalendar.YEAR));
		String newMonth = String
				.valueOf(other.get(GregorianCalendar.MONTH) + 1);
		newMonth = newMonth.length() == 1 ? "0" + newMonth : newMonth;
		String newDay = String.valueOf(other
				.get(GregorianCalendar.DAY_OF_MONTH));
		newDay = newDay.length() == 1 ? "0" + newDay : newDay;
		String date = newYear + "-" + newMonth + "-" + newDay;
		return date;
	}

	/**
	 * @author caiqifan
	 * @date 2011-12-1 下午01:47:46
	 * @describe 获取当前日期前后N天
	 * @return String
	 * @exception
	 * @version 1.0
	 */
	public static String getAssignDateNext(String aMask, String nowdate, int day) {
		SimpleDateFormat f = new SimpleDateFormat(aMask);
		GregorianCalendar other = new GregorianCalendar();
		Date date;
		try {
			date = f.parse(nowdate);
			other.setTime(date);
			other.add(other.DAY_OF_YEAR, day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return f.format(other.getTime());
	}

	/**
	 * @author caiqifan
	 * @date 2011-12-1 下午01:48:59
	 * @describe 获取当前日期后N天时间
	 * @return List
	 * @exception
	 * @version 1.0
	 */
	public static List getDateLaterList(String aMask, String nowdate, int day) {
		List list = new ArrayList();
		for (int k = 0; k < day; k++) {
			String cudate = DateUtil.getAssignDateNext(aMask, nowdate, k);
			list.add(cudate);
		}
		return list;
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-12-14 上午11:26:07
	 * @describe 某个时间加N天
	 * @return Date
	 */
	public static Date addDateByStep(Date currentDate, int step) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(currentDate);
		cl.add(Calendar.DATE, step);
		return cl.getTime();
	}

	/**
	 * 
	 * @author caiqf
	 * @date 2012-12-14 上午11:26:07
	 * @describe 某个时间加N天
	 * @return Date
	 */
	public static Date addMinutesByStep(Date currentDate, int step) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(currentDate);
		cl.add(Calendar.MINUTE, step);
		return cl.getTime();
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeekStr(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String str = new SimpleDateFormat("EEEE").format(c.getTime());
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	public static void main(String[] args) throws ParseException {
		int[] n = DateUtil.getYearAndMonthAndDay(new Date());
		System.out.println(n[1]);
	}
}
