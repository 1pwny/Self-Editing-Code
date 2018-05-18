import java.io.*;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
    	try {
	    	File f = new File("Iteration1.java");
			Scanner s = new Scanner(new File("Iteration1save.txt"));
			
			if(!f.createNewFile()) {
			    f.delete();
			    f.createNewFile();
			}
		
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f.getName(),true)));
			while(s.hasNext())
			    pw.println(s.nextLine());
			    
			pw.flush();
				
			Process compile = Runtime.getRuntime().exec("javac Iteration1.java");
			
		    compile.waitFor();
		    
		    Iteration1 i1 = new Iteration1();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}