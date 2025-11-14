package innerClasses.ClassInsideInterface;

import innerClasses.ClassInsideInterface.EmailService.DefaultImplementation;
import innerClasses.ClassInsideInterface.EmailService.EmailDetails;

public class ClassinsideInterface {

	public static void main(String[] args) {
		
		//Case -I
		EmailService e=i -> {
			System.out.printf("From: %s \n",i.getFromList());
			System.out.printf("To: %s \n",i.getToList());
			System.out.printf("Subject: %s \n",i.getSubject());
			System.out.printf("Body:\n	%s \n",i.getBody());

		};
		
	e.sendEmails(new EmailDetails("@wit.com", "balram@wit.com"
			, "alert please respond", "urgent"));
	
	//Case -II
	DefaultImplementation def=new DefaultImplementation();
	def.sendEmails(new EmailDetails("@xyz.com", "balramRajak@xyz.com"
			, "What is the status", "Project"));
	
	}
	
}


interface EmailService{
	
	//case -II
	class DefaultImplementation implements EmailService{

		@Override
		public void sendEmails(EmailDetails e) {
			System.out.println("default implementation "
					+ "for EmailService interface");
			System.out.println("Email Body: \n	  "+e.getBody());
			
		}
		
	}
	
	//case - I
	public void sendEmails(EmailDetails e);
	
	public class EmailDetails {

		public String getToList() {
			return toList;
		}
		public void setToList(String toList) {
			this.toList = toList;
		}
		public String getFromList() {
			return fromList;
		}
		public void setFromList(String fromList) {
			this.fromList = fromList;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public EmailDetails(String toList, String fromList, String body, String subject) {
			super();
			this.toList = toList;
			this.fromList = fromList;
			this.body = body;
			this.subject = subject;
		}
		String toList;
		String fromList;
		String body;
		String subject;
	}
}