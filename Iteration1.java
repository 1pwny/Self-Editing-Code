import java.io.*;
import java.util.*;

public class Iteration1 extends thread {
	public static int n = 1; //don't edit anything before this line;
	private static int one, two, three, four, five, six, seven, eight, nine, ten;
	Thread prev;
	
	public Iteration1() {
		start();
	}
	
	public Iteration1(thread t) {
		testprint("Iterated to 1");
		this.start();
	}
	
	public void run() {
		testprint("ran iteration 1");
		Iteration2 i = new Iteration2(this);
		try {
			Files.delete("Iteration1.java");
			Files.delete("Iteration1.class");
		} catch (Exception e) {}
		terminate();
	}
	
	public String getCode() {
	    Scanner s = new Scanner(System.in);
	    
	    System.out.println("Input code:");
        String st = "", temp;
        Scanner sc = new Scanner(System.in);
        while(!(temp = sc.nextLine()).equals("done"))
            st += "\n\t" + temp;
            
        testprint("got input");
        return st;
	}
	
	public void initNums() {
		one = 0;
		one++;
		two = one + one;
		three = two + one;
		four = three + one;
		five = four + one;
		six = five + one;
		seven = six + one;
		eight = seven + one;
		nine = eight + one;
		ten = nine + one;
	}
	
	public void start() {
		testprint("started iteration 1");
		initNums();
		
		try {
			//next iteration
			File f = new File("Iteration2.java");
			Scanner s = new Scanner(new File("Iteration1.java"));
		
			if(!f.createNewFile()) {
		    	f.delete();
		    	f.createNewFile();
			}
		
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f.getName(),true)));
		
			int ln = one;
		
			while(s.hasNext()) {
		    	if(ln == ten*ten +nine*two) {
		        	pw.println(getCode());
		    	}
				pw.println(s.nextLine().replaceAll(n+one+"",n+two+"").replaceAll("1","2"));
				ln++;
			}
			
			pw.flush();
			
			Process compile = Runtime.getRuntime().exec("javac Iteration2.java");
	        compile.waitFor();
	        
	        
	        //create barebones next-next iteration so that the next iteration compiles
	        f = new File("Iteration" + (n+two) + ".java");
	        s = new Scanner(new File("iterbase"));
	        if(!f.createNewFile()) {
		    	f.delete();
		    	f.createNewFile();
			}
			
			pw = new PrintWriter(new BufferedWriter(new FileWriter(f.getName(),true)));
			
			while(s.hasNext())
				pw.println(s.nextLine().replaceAll("0",(n+two)+""));
				
			pw.flush();
			
			compile = Runtime.getRuntime().exec("javac Iteration" + (n+two) +".java");
	        compile.waitFor();
		} catch (Exception e) {
			System.out.println("Something messed up during Iteration 1");
		}
		
		this.run();
	}
	
	public static void main(String[] args) {
		for(int n = 4; n < 4; n++) {
			try {
				(new File("Iteration"+n+".java")).delete();
				(new File("Iteration"+n+".class")).delete();
			} catch (Exception e) {
				
			}
		}
		
		Iteration1 i = new Iteration1();
	}
	
	public static void testprint(String s) {
		System.out.println(s);
	}
	
}