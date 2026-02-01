package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesReader {
	
	FileInputStream fis;
	Properties properties;
	
	public PropertiesReader(String filePath) throws IOException {
		 this.fis = new FileInputStream(filePath);
		 this.properties = new Properties(); 
		 this.properties.load(fis);
	}
	
	/**
	 * @description this method is used for get value of the key.
	 * @param  key   <code>String</code>
	 * @return value <code>String</code>
	 */
	public String getValueOfKey(String key) {
		return this.properties.getProperty(key);
	}
}
