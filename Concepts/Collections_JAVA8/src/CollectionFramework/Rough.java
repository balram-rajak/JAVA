package rough_work;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Rough {
	
	
	public static void main(String[] args) {
		
		
		String reg="Select DISTINCT TOP 600 BATCH_ID from C_OPSI_RELTIO_CLENUP_REMOVAL with (nolock) where DELETE_IND = 'TD' and UPDATED_BY = 'MANUAL_PROC_INACTIVATION'";
		
//		String missingOpsi="7858,275382,2756382,111567858,";
//		String reltioOpsi="7858,275382,6382";
//		
//		StringTokenizer tokenizer=
//				new StringTokenizer(reltioOpsi, ",");
//		
//		while(tokenizer.hasMoreTokens()) {
//			String temp=tokenizer.nextToken();
//			reg=reg.replaceAll("^"+temp.concat(","),
//					"");
////			Pattern pattern=Pattern.compile(","+temp.concat(","));
////			Matcher m=pattern.matcher(","+temp.concat(","));
////			if(m.find()) {
////				reg.replace(","+temp.concat(","),
////						"");
////			}
//			reg=reg.replaceAll(",".concat(temp).concat(","),
//					",");
//			
//		}
//		System.out.println(reg);
//		System.out.println(reg.substring(0,reg.length()-1));
//	    1) at starting/alone 7858,
//		2) at end/between ,7857,
		
		 
		String regex1="[0-9]+ B";
				String regex2="^"+7858+",";
	Pattern pattern1=Pattern.compile(regex1);
	Matcher m1=pattern1.matcher(reg);
	Pattern pattern2=Pattern.compile(regex2);
	Matcher m2=pattern2.matcher(reg);
	
	if(m1.find()) {
		System.out.println(m1.start()+" to "+(m1.end())+" "+reg.substring(m1.start(),m1.end()-1));
		
		Predicate<String> isThereString=t -> t.length()>0;
		
//		System.out.println(m.replaceAll(""));
	}
	
	
	if(m2.find()) {
	System.out.println(m2.start()+"to "+(m2.end())+" "+reg.substring(m2.start(),m2.end()));
	}
	
	if(m1.find()) {
		System.out.println(m1.start()+"to "+(m1.end())+" "+reg.substring(m1.start(),m1.end()));
	}
	
//	if(m2.find()) {
//		System.out.println(m2.start()+"to "+(m2.end())+" "+reg.substring(m2.start(),m2.end()));
//		
//		}
	
	if(m1.find()) {
		System.out.println(m1.start()+"to "+(m1.end())+" "+reg.substring(m1.start(),m1.end()));
	}
	
//	if(m2.find()) {
//		System.out.println(m2.start()+"to "+(m2.end())+" "+reg.substring(m2.start(),m2.end()));
//		
//		}
	
	}
}


