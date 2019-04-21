import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DemoDateplusseven {

	public static void main(String[] args) {
		 
		
		/*
		 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 * LocalDateTime now = LocalDateTime.now(); //
		 * System.out.println(dtf.format(now));
		 * System.out.println(java.time.LocalDate.now());
		 */   
		 Calendar now = Calendar.getInstance();
		    System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1) + "-"
		        + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));

		    // add days to current date using Calendar.add method
		    now.add(Calendar.DATE, 10);

		    System.out.println("date after six month : " + (now.get(Calendar.MONTH) ) + "-"
		        + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));
		    
		    
		   

	}

}
