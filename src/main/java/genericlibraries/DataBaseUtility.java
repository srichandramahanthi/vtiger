package genericlibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains reusable methods to perform operations on database
 * @user
 */

public class DataBaseUtility {
      private Connection connection;
      private Statement statement;
      /**
       * this method is used to connect to database
       * @param url
       * @param user
       * @param pwd
     * @throws SQLException 
       */
	public void databaseInitialization(String url,String user,String pwd) throws SQLException

	{
		Driver dbDriver=new Driver();
	try {
		DriverManager.registerDriver(dbDriver);
      } catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		connection=DriverManager.getConnection(url, user,pwd);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		statement=connection.createStatement();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	/**
	 * this method is used to read data from database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException 
	 */
	public List<Object> readFromDatabase(String query,String columnName) throws SQLException
	{
		ResultSet result=statement.executeQuery(query);
		List<Object> list=new ArrayList<Object>();
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		return list;
	}
	/**
	 * this method is used to modify database
	 * @param query
	 * @return
	 */
	public int modifyDatabase(String query)
	{
		int result=0;
		try {
			result=statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * this method is used to close database connection
	 */
	public void closeDatabase()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
