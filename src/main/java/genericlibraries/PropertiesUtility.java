package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains reusable methods to perform operation on properties file
 * @author user
 *
 */

public class PropertiesUtility {
	/**
	 * This method is used to read data from properties
	 * @param filepath
	 * @param key
	 * @return
	 */
	private Properties property;
	public void propertiesInitialization(String filepath)
	{
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream(filepath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		property=new Properties();
		try
		{
			property.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public String readFromProperties(String key)
	{
			
			return property.getProperty(key);
	}

}
