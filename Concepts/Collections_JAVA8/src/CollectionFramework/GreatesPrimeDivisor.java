package rough_work;

public class GreatesPrimeDivisor {

	static boolean isPrime(int div) {
		if(!(div<=3)) {
			for(int i=2; i<=div/2;i++) {
				if(div%i==0) return false;
			}
		}
		else return true;
		return true;
		
	}
	
public static void main(String[] args) {
		
		int input=123;
		
		for(int i=input/2;i>=2;i--) {
			if(input%i==0 && isPrime(i)) {
				System.out.println(i);
				break;
			}
			else if(i==2) System.out.println(-1);
		}
}
}
