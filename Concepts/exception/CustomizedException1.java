package exception;

public class CustomizedException1 {

	public static void main(String[] args) {
		
		if(Integer.parseInt(args[0])<18)
			throw new TooOldException("Your marriage age is over");
	else if(Integer.parseInt(args[0])>60)
		throw new TooYoungException("Please wait for some more time");
	else
		System.out.println("Registered successfully");
	
}
}

class TooOldException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TooOldException(String msg) {
		super(msg);
	}
}

class TooYoungException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TooYoungException(String msg) {
		super(msg);
	}
}
