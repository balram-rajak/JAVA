/**
 * Client-side operations interface for the login portal.
 * Defines the contract for user-facing operations.
 * 
 * @author Balram Rajak
 */
public interface Client_side_op extends Portal{

	/**
	 * Registers a new user in the system.
	 */
	public void Register();
	
	/**
	 * Authenticates and logs in a user.
	 * 
	 * @return Employee_Login object for validated user
	 */
	public Object Login();
	
	/**
	 * Resets the user's password.
	 */
	public void Reset_pass();
	
}
