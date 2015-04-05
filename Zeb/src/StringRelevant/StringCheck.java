/**
 * 
 */
package StringRelevant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author benson
 *
 */
public class StringCheck {

	/**
	 * 
	 */
	public StringCheck() {
		// TODO 自动生成的构造函数存根
	}
	/**
	 * check the string whether ipv4 address
	 * @param ip
	 * @return
	 */
	public static boolean IsIpv4(String ip)
	{
		Pattern pattern=Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher matcher=pattern.matcher(ip);
		return matcher.matches();
	}
	
	/**
	 * check the string whether internal ipv4 address
	 * @param ip
	 * @return -1 means the string is not a ipv4 address,0 means ip is a public address
	 * 1 means ip is a Class A internal address
	 * 2 means ip is a Class B internal address
	 * 3 means ip is a Class C internal address
	 */
	public static int IsInternalIpv4(String ip)
	{
		if(!IsIpv4(ip))
		{
			return -1;
		}
		Pattern pattern=Pattern.compile("\\b10\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher matcher=pattern.matcher(ip);
		if(matcher.matches())
		{
			return 1;
		}
		pattern=Pattern.compile("\\b172\\.(1[6-9]|2[0-9]|3[0-1])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		matcher=pattern.matcher(ip);
		if(matcher.matches())
		{
			return 2;
		}
		pattern=Pattern.compile("\\b192\\.168\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		matcher=pattern.matcher(ip);
		if(matcher.matches())
		{
			return 3;
		}
		return 0;
	}
	
	/**
	 * check the string whether email address
	 * @param email
	 * @return
	 */
	public static boolean IsEmail(String email)
	{
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher=pattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * check the string whether datetime string
	 * @param datetime
	 * @return
	 */
	public static boolean IsDatetime(String datetime)
	{
		Pattern pattern = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher matcher=pattern.matcher(datetime);
		return matcher.matches();
	}
	
	/**
	 * check the string whether date string
	 * @param date
	 * @return
	 */
	public static boolean IsDate(String date)
	{
		String datetime=date+" 00:00:00";
		return IsDatetime(datetime);
	}
	
	/**
	 * check the string whether time string
	 * @param time
	 * @return
	 */
	public static boolean IsTime(String time)
	{
		String datetime="1972-01-01 "+time;
		return IsDatetime(datetime);
	}
	
	/**
	 * check the string whether mobile number
	 * @param number
	 * @return
	 */
	public static boolean IsMobileNumber(String number)
	{
		Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher matcher=pattern.matcher(number);
		return matcher.matches();
	}
	
	public static void main(String[] args)
	{
		String datetime="2011-02-28";
		System.out.println(IsDate(datetime));
	}
}
