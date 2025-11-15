/**
 * Employee login handler class.
 * Provides access to the validator for employee authentication.
 * 
 * @author Balram Rajak
 */
public final class Employee_Login {

	/**
	 * Returns a new Validator instance for credential verification.
	 * 
	 * @return Validator object for authentication
	 */
	public Validator get_validator() {
		return new Validator();
	}

}