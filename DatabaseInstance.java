import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class DatabaseInstance {
	private static Connection instance = null;
	private DatabaseInstance(){}
	
	public static Connection getInstance(){
		if(instance == null){
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "msrit");
			}catch(Exception e){
				System.out.print("Error connecting to database: ");
				System.out.println(e.getMessage());
			}
			
		}
		return instance;
	}

}
