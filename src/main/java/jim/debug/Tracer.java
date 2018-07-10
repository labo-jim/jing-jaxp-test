package jim.debug;

import java.io.PrintStream;

public class Tracer {
	
	public static final String TAB = "\t";
	
	public static void trace(String prefix, String message){
		PrintStream p = System.out;
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
		
		if(message != null && !message.isEmpty()){
			p.println(prefix(prefix) + " " + message);
		}
		
		for (StackTraceElement ste : st) {
			p.println(prefix(prefix) + TAB + ste);
		}
	}
	
	public static void trace(String prefix){
		trace(prefix, null);
	}
	
	private static String prefix(String prefix){
		return "[" + yellow(prefix) + "]";
	}
	private static String yellow(String s){
		return "\033[33m" + s + "\033[0m";
	}

}
