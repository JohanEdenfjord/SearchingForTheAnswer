package a.start.of.the.crisp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMannager {
	
	public Connection open() {
		Connection connect=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is Loaded!");
		} catch (ClassNotFoundException e) {
			// TODO make a proper System out println
			e.printStackTrace();
		}
		
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/info_search?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm",
						"root", "");
			if(connect != null) {
				System.out.println("it works! Connectionmanagern!");
			}else {
				System.out.println("noooooo CM didnt work, asswipe");
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			return connect;
		
		
	}

}
