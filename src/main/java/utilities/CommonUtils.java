package utilities;

import java.util.Date;

public class CommonUtils {

	public static final int IMPLICIT_WAIT_TIMEOUT=25;
	public static final int PAGE_LOAD_TIMEOUT=25;
	
	public static String getEmailwithTimestamp() {
		return "akashthkare"+new Date().toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
