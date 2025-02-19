
import com.Mysql_Properties;
public class Query implements Operation{

	@Override
	public String update_row() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete_row() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert_row() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String select(String column_names, String table_name, String condition) {
		String s="SELECT "+ column_names+" FROM "+ table_name+" WHERE " +condition;
				
		return s;
	}
	
	public Object get_db() {
		return new Mysql_Properties();
	}

}