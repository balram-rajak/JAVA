
public interface Operation {

	String update_row();
	
	String delete_row();
	
	String insert_row();
	
	String select(String table_name,String column_names,String condition);
	
	public Object get_db();

	
}
