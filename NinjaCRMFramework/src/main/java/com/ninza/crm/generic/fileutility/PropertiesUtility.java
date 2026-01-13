package com.ninza.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {
   public String getDataFromPropertiesFile(String Key) throws Throwable  {
	   FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
       Properties p = new Properties();
       p.load(fis);
       String data = p.getProperty(Key);
       return data;
   }
}
