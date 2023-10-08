package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties readConfigFile() {
		
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
