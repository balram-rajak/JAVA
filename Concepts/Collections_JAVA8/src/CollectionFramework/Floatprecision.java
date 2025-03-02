package rough_work;

import java.util.Scanner;

public class Floatprecision {

	private Precision precision;
	private float value;
	
	void setFloatPrecison(){
		
		Scanner sc1=new Scanner(System.in);
		
		value=(sc1.nextFloat()/sc1.nextFloat());
		sc1.close();
	}
	
	public Floatprecision(Precision precision) {
		super();
		this.precision = precision;
	}
	
	public Floatprecision() {
		
	}
	
	
	float floatprecision() {
		
		value=precision.getvalue();
		int n1=(int)(value*10000);
		
		if(n1%10==0 || n1%10<=5) {
			value=(float)(n1-(n1%10))/10000;
			
		}
		else {
			value=(float)((n1-(n1%10))+10)/10000;
			
		}
		
		return value;
	}
	
	
float floatprecision(float value) {
		
		int n1=(int)(value*10000);
		
		if(n1%10==0 || n1%10<=5) {
			value=(float)(n1-(n1%10))/10000;
			
		}
		else {
			value=(float)((n1-(n1%10))+10)/10000;
			
		}
		System.out.println(value);
		
		return value;
	}
}



interface Precision {
	
	float getvalue();
}
