package a.start.of.the.crisp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchingTheBase {
	
	String[] strings = null;
	StringBuilder values = new StringBuilder();
	List<String> output = new ArrayList<String>();
	ConnectionMannager connect = new ConnectionMannager();
	SplittingTheSearch searches = new SplittingTheSearch();
	
	String union = TheQuerys.getUnion();
	String bears = TheQuerys.getBearbase();
	String ikea = TheQuerys.getIkeanames();
	String masters = TheQuerys.getMasters();
	
	
	public String[] queryFromDb(String[] list){
		
		strings = list;
		
		try {
				Connection con = connect.open();
				
				//building the search string and sets the ? marks and the , in the right places. 
				
				if(strings.length <= 10) {	
					values.append(" (");
					for (int i = 1; i <= strings.length;i++) {
						values.append("?");
						
						if (strings.length > i) {
							values.append(",");
							}
					}
					values.append(" )");
				} else {
					System.out.println("To many search queries");
				}
				
				//that then get inserted in a prepared statement that uses UNION ALL to do a great searchset!
				
				PreparedStatement search = con.prepareStatement(bears.replaceAll("\\?", values.toString()) + " " + union + " " +
										   ikea.replaceAll("\\?", values.toString()) + " " + union + " " +
										   masters.replaceAll("\\?", values.toString()));
					
				int test = strings.length;
				
				//adds the search values in the Prepared statement sets words in the ? placeholders
				for (int i = 1; i < (test * 26) + 1; i++) {
					for (int j = 0; j < test;j++) {
					search.setString(i, "%" + strings[j] + "%");
					}
				}
				
				
				ResultSet rs = search.executeQuery();
				
				ResultSetMetaData meta = rs.getMetaData();
				int columns = meta.getColumnCount();
				System.out.println(columns);
				
				if(!rs.next()) {
					System.out.println("No Data");
				} else {
					do {
						for (int i = 1; i <= columns;i++) {
							output.add(rs.getString(i));
							}
					}while (rs.next());
				}
				
				rs.close();
				con.close();
				search.close();
				
				output.removeIf(Objects::isNull);
				
				String newLine = "";
				for (String e : output) {
					newLine += e.concat(" ");
				}
				newLine.replace("\\", "\\\\")
		          .replace("\t", "\\t")
		          .replace("\b", "\\b")
		          .replace("\n", "\\n")
		          .replace("\r", "\\r")
		          .replace("\f", "\\f")
		          .replace("\'", "\\'")
		          .replace("\"", "\\\"");
				
				String[] fixed = newLine.split("\\~");
				System.out.println(fixed.length);
				
//				for(int i = 0; i < fixed.length;i++){
//					System.out.println(fixed[i]);
//				}
				return fixed;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		
		return null;
			
	}
	
	
	
	
	

}
