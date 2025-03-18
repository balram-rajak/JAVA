import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Mysql_Properties;

public class Calling_property {
	static int flag=0;
public static void main(String[] args) throws InterruptedException {
	
	Query q=new Query();
	
	Mysql_Properties o=new Mysql_Properties();
	
	String result = null;
	try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_data", "root",
			"furious7")) {
		String uname="balram";
		String Query = q.select("password", "login_details", "username=" + "'" + uname + "'");
		/*PreparedStatement st = con.prepareStatement(Query, ResultSet.TYPE_SCROLL_SENSITIVE,
			      ResultSet.CONCUR_UPDATABLE);*/
		Statement st=con.createStatement();
//st.setString(1,"login_details");
		
		
		ResultSet rs = st.executeQuery("select password from login_details where username='balram';");
		//
		//System.out.println(rs.next());
		
		//rs.absolute(0);
		//bool=rs.next();
      
    	 //rs.absolute(0);
		while (rs.next()) {
			result = rs.getString(1);
			System.out.println(result);
		
		
		/*rs.absolute(0);
		
		while(rs.next()) {
			rs.updateString("password", "balram@000");
			rs.updateRow();
		}*/
	
		System.out.print("////////// \n");
		//update();
		//Thread.sleep(20000);
		
		/*rs.absolute(0);
		while (rs.next()) {
			result = rs.getString(1);
			System.out.println(result);
		}*/
      }
  

	}

	catch (SQLException e) {
		// Handling code here
		flag = -1;

	}

	System.out.println("flag "+flag);

	
}

static void update() {
	Mysql_Properties o=new Mysql_Properties();
	try (Connection con = DriverManager.getConnection(o.get_jdbc_mysql_url(), "balram",
			"balram@0009")) {

		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			      ResultSet.CONCUR_UPDATABLE);

		String Query = "select * from login_details ;";
		ResultSet rs1 = st.executeQuery(Query);
		//System.out.println(rs.next());
		
	
		
		rs1.absolute(0);
		  rs1.absolute(1);rs1.updateString("password", "detroid@21");
		  rs1.updateRow();
		  rs1.absolute(2);rs1.updateString("password", "hema@21");
		  rs1.updateRow();
		 rs1.absolute(3);rs1.updateString("password", "un@21");
		 rs1.updateRow();
		  rs1.absolute(4);rs1.updateString("password", "janya@21");
		  rs1.updateRow();
		System.out.print("////////// ");
		
		
  

      }

	catch (SQLException e) {
		// Handling code here
		flag = -1;

	}
}
}
