package projectWeek05;

public class ProjectWeek05 {

	/*Created a Logger interface with two methods which is "log" and "error"
	 * along with three classes called "AstriskLogger", "SpacedLogger" and "App"
	 */
		public interface Logger {
			void log(String message);
			void error(String message);
			
		}
		/*LOG wraps the input string with three asterisks on each side
		 * ERROR prints the input string inside a box of asterisks,
		 * prefixed with "ERROR:". 
		 */
		public static class AsteriskLogger implements Logger{
			@Override
			public void log(String message) {
				System.out.println("***" + message + "***");
			}
			@Override
			public void error(String message) {
				String errorMessage = "***Error: " + message + "***";
				String border = "*".repeat(errorMessage.length());
				System.out.println(border);
				System.out.println(errorMessage);
				System.out.println(border);
			}
		}
		
		/*LOG adds a space between each character of the input string
		 * ERROR does the same as LOG, but prefixes the output with "ERROR:".
		 */
		public static class SpacedLogger implements Logger{
			@Override
			public void log(String message) {
				System.out.println(spacedString(message));
			}
			
			@Override 
			public void error(String message) {
				System.out.println("ERROR: " + spacedString(message));
			}
			private String spacedString(String message) {
				StringBuilder spacedMessage = new StringBuilder();
				for(char ch : message.toCharArray()) {
					spacedMessage.append(ch).append(" ");
				}
				return spacedMessage.toString().trim(); //this will remove the trailing space
			}
		}
		/*The App class contains the main methods to test the loggers and instantiates the AsteriskLogger
		 * and SpacedLogger 
		 */
		public static class App{
			public static void main(String[] args) {
				//Instantiate instances of the logger classes
				Logger asteriskLogger = new AsteriskLogger();
				Logger spacedLogger = new SpacedLogger();
				
				//This will test the log method on AsteriskLogger
				asteriskLogger.log("Hello");
				
				//This will test the error method on AsteriskLogger
				asteriskLogger.error("Hello");
				
				//This will test the log method on SpacedLogger
				spacedLogger.log("Hello");
				
				//This will test the error method on SpacedLogger
				spacedLogger.error("Hello");
			}
		}
	}


