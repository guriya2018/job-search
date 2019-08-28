package com.automation.framework.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader {
	
private static Properties config = null;
	
	public static void loadTestProperties() {
		try {
			config = new Properties();
			if (config.isEmpty()) {
				File file = new File(System.getProperty("test-suite-dev.properties"));
				config.load(new FileInputStream(file));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String propName) {
		if(!config.isEmpty() && config.containsKey(propName.toUpperCase())) {
		   return config.getProperty(propName.toUpperCase());
		}	
		return null;
	}

}
