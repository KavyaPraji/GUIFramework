package com.sinoka.erp.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./cofigCommondata/CommondataErp.properties");
		Properties ps=new Properties();
		ps.load(fis);
		
		String data=ps.getProperty(key);
	
		
		return data;
	}

}
