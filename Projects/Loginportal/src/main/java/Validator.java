import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.Logger;
import com.Mysql_Properties;

public class Validator extends LoginPortal {

	private String uname;
	private int flag = 0;
	Operation op = new Query();
	Mysql_Properties o = (Mysql_Properties) op.get_db();
	private HashMap<String, String> m = new HashMap<String, String>();

	private String fetch_data() {

		String result = null;
		try (Connection con = DriverManager.getConnection(o.get_jdbc_mysql_url(), o.get_jdbc_uname(),
				o.get_jdbc_validation())) {
			String Query = op.select("password", "login_details", "username=" + "'" + uname + "'");
			PreparedStatement st = con.prepareStatement(Query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY
					);

			ResultSet rs = st.executeQuery();

				while (rs.next()) {
					result = rs.getString(1);
					return result;
				}
		}

		catch (SQLException e) {
			// Handling code here
			Logger.send_log(e.toString());
			flag = -2;

		}
		return result;
	}

	public int Login(String uname, String pass) {
		set_credentials(uname, pass);
		check(fetch_data()); // in case the resultset is empty return -1

		return flag;
	}

	private void set_credentials(String uname, String pass) {
		m.put(uname, pass);
		this.uname = uname;
	}

	private void check(String value) {

		if (value != null) {
			if (value.equals(m.get(uname)))
				flag = +1;
			else
				flag = 0;
		} else
			flag = -1;
	}

	@Override
	public void Register() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Reset_pass() {
		// TODO Auto-generated method stub

	}
}
