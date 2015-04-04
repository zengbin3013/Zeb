/**
 * 
 */
package BashShell;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Zeb
 * create by 2015-04-0 01:04:00
 * for execute windows command
 */
public class WindowCmdShell {

	/**
	 * 
	 */
	public WindowCmdShell() {
		// TODO 自动生成的构造函数存根
	}
	
	/**
	 * @param cmdstring the command string
	 * @return the result string
	 * @throws Exception
	 */
	public static String ExecuteWindowsCmd(String cmdstring) throws Exception
	{
		Process proc;
		StringBuilder result=new StringBuilder();
		try {
			proc=Runtime.getRuntime().exec(cmdstring);
			InputStream ins=proc.getInputStream();
			InputStreamReader insr=new InputStreamReader(ins);
			BufferedReader bufr=new BufferedReader(insr);
			String line;
			boolean isstart=false;
			while ((line=bufr.readLine())!=null) {
				if (isstart) {
					result=result.append("\r\n"+line);
				}else {
					result=result.append(line);
					isstart=true;
				}
				
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return result.toString();
	}
	
	public static void main(String[] args) throws Exception
	{
		String s=ExecuteWindowsCmd("cmd /c ping www.qq.com");
		System.out.println(s);
	}

}
