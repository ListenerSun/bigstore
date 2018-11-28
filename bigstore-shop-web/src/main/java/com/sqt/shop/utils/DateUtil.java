package com.sqt.shop.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
	
	private final static SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");

	private final static SimpleDateFormat sdfDay = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private final static SimpleDateFormat sdfDays = new SimpleDateFormat(
	"yyyyMMdd");

	private final static SimpleDateFormat sdfTime = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private final static SimpleDateFormat sdfTimes = new SimpleDateFormat(
	"yyyyMMddHHmmss");
	
	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}
	
	public static String getDate(Date date) {
		return sdfDay.format(date);
	}

	/**
	 * 获取MM格式
	 * 
	 * @return
	 */
	public static String getMonth() {
		return sdfMonth.format(new Date());
	}
	
	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}
	
	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays(){
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}
	
	/**
	 * 获取YYYYMMDDHHmmss格式
	 * 
	 * @return
	 */
	public static String getTimes() {
		return sdfTimes.format(new Date());
	}

	/**
	* @Title: compareDate
	* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	* @param s
	* @param e
	* @return boolean  
	* @throws
	* @author luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() >=fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	public static int getDiffYear(String startTime,String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			long aa=0;
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	  /**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        
            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);
      
        return day;
    }
    
    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);
        
        return dateStr;
    }
    
    
    /**
    * 字符串转换成日期
    * @param str
    * @return date
    */
    public static Date StrToDate(String str) {
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date date = null;
       try {
        date = format.parse(str);
       } catch (ParseException e) {
        e.printStackTrace();
       }
       return date;
    }
    
    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        
        return dateStr;
    }
    
    
	public static String dateToStr(String str){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d =null;
		try {
			d = format.parse(str.replace("Z", " UTC"));
		} catch (ParseException e) {
			e.printStackTrace();
		}//注意是空格+UTC
/*		System.out.println(d);
		System.out.println(f.format(d));*/
		
		return f.format(d);
	}
    

    /** 
     * 两个时间相差距离多少天多少小时多少分多少秒 
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00 
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00 
     * @return String 返回值为：xx天xx小时xx分xx秒 
     */  
    public static String getDistanceTime(String str1, String str2) {  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date one;  
        Date two;  
        long day = 0;  
        long hour = 0;  
        long min = 0;  
        try {  
            one = df.parse(str1);  
            two = df.parse(str2);  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else {  
                diff = time1 - time2;  
            }  
            day = diff / (24 * 60 * 60 * 1000);  
            hour = (diff / (60 * 60 * 1000) - day * 24);  
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } 
        String disTanceTme = "";
        if(day != 0){
        	disTanceTme += day + "天";
        }
        if(hour != 0){
        	disTanceTme += hour + "小时";
        }
        if(min != 0){
        	disTanceTme += min + "分";
        }
        
        return disTanceTme;  
    } 
    
    /***
     * 比较相差多少时间
     * @param startTime
     * @param endTime
     * @param format
     * @param str
     * @return
     * @throws Exception
     */
    public static Long dateDiff(String startTime, String endTime,
            String format, String str) throws Exception {
        // 按照传入的格式生成一个simpledateformate对象     
        SimpleDateFormat sd = new SimpleDateFormat(format);     
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数     
        long nh = 1000 * 60 * 60;// 一小时的毫秒数     
        long nm = 1000 * 60;// 一分钟的毫秒数     
        long ns = 1000;// 一秒钟的毫秒数     
        long diff;     
        long day = 0;     
        long hour = 0;     
        long min = 0;     
        long sec = 0;     
        // 获得两个时间的毫秒时间差异     
        diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime(); 
        if(str.equalsIgnoreCase("d")){
            day = diff / nd;// 计算差多少天     
            return day;
        }
        if(str.equalsIgnoreCase("h")){
            hour = diff % nd / nh + day * 24;// 计算差多少小时     
            return hour;
        }
        if(str.equalsIgnoreCase("m")){
            min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟     
            return min;
        }
        if(str.equalsIgnoreCase("s")){
            sec = diff % nd % nh % nm / ns;// 计算差多少秒    
            return sec;
        }
        return 0l;
    }
	/**
	 * 时间转换成时间戳
	 * @param time
	 * @return
	 */
	public static long dateToTimestamp(String time){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = simpleDateFormat.parse(time);
			long ts = date.getTime() / 1000;
			return ts;
		} catch (ParseException e) {
			return 0;
		}
	}

//   public static void main(String[] ags){
//    	try {
//			System.out.println(dateDiff("2016-10-28 17:42:56","2016-10-28 17:45:56","yyyy-MM-dd HH:mm:ss","m"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	42866.6539467593
//    	Date date = new Date();
//    	System.out.println(date.getTime());
//    	Timestamp ts = new Timestamp(date.getTime());
//   	System.out.println(ts.getTime());
//    	Calendar c = Calendar.getInstance();
//    	System.out.println(c.getTimeInMillis());
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	System.out.println(sdf.format(42866.6539467593));
//    	System.out.println("====");
//	    date = xssfCell.getDateCellValue(); 
//	     sdf.format(date);
		//Date start = new Date();
		//System.out.println(start);
//	}
    
    
}
