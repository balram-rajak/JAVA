package assembly;

import java.io.FileInputStream;

public class AudioToBinary {

	public static void main(String[] args) {
		
		
		try(FileInputStream fout=new FileInputStream("/Users/rakesh/eclipse-workspace/rough_work/src/resources/videoplayback.mp4")){
			//fout.write(("Last updated "+(new java.util.Date()).toString()).getBytes());
			byte[] bytes=fout.readAllBytes();
			StringBuilder sb1= new StringBuilder();
			for(int i=0; i<32; i++) {
				
				sb1.append(String.format("%02x ", bytes[i]));
				if(i%16==0||i==31) {
					System.out.println("\n");
					System.out.println(sb1.toString());
					sb1.delete(0, sb1.length());
				}
				
			
			
		}
			
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		
	}
}
