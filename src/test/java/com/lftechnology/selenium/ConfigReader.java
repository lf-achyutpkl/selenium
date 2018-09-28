package com.lftechnology.selenium;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigReader {
	private final Logger logger = Logger.getLogger(ConfigReader.class.getName());

	private Properties prop = null;
	private final String filename = "app.properties";
	
	private static Map<String, String> properties = new HashMap<String, String>();
	private static ConfigReader configReader = new ConfigReader();
	
	private ConfigReader() {
		init();
	}
	
	/**
	 * Return map of properties
	 * @return Map<String, String> Map of all properties
	 */
	public static Map<String, String> getProperties() {
		return ConfigReader.properties;
	}
	
	/**
	 * Return specific value of key.
	 * @author Achyut Pokhrel
	 * @param key {@link String}
	 * @return {@link String} Value for the given key, if not found returns empty string i.e. ""
	 */
	public static String getProperty(String key) {
		return properties.getOrDefault(key, "");
	}
	
	private void init() {
		prop = new Properties();
		
		try(InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(filename)){
	        
    		
    		if(input==null){
    	        logger.log(Level.SEVERE, "File not found: " + filename);
    		    return;
    		}

    		prop.load(input);
    		
    		Enumeration<?> e = prop.propertyNames();
    		while (e.hasMoreElements()) {
    			String key = (String) e.nextElement();
    			String value = prop.getProperty(key);
    			properties.put(key, value);
    		}
    	} catch (Exception ex) {
    		ex.printStackTrace();
        }
	}
	

}