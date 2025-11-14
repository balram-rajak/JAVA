package com;

import java.io.FileOutputStream;

public class Logger {

	public static void send_log(String log) {
		try(FileOutputStream fout=new FileOutputStream("/Users/rakesh/eclipse-workspace/Loginportal/log.txt")){
			fout.write(("Last updated "+(new java.util.Date()).toString()).getBytes());
			fout.write("\n".getBytes());
			fout.write(log.getBytes());
		}
		catch(Exception e) {
			
		}
		
	}
}
