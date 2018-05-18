import java.io.*;

public class thread implements Runnable {
    public void run() {
		
	}
	
	public void terminate() {
		try {
			while(true)
				Thread.sleep(3600000); //sleep for an hour, basically permanent stasis
		} catch (Exception e) {
			System.out.println("Caught error");
		}
	}
	
	public void wait(int m) {
		try {
			Thread.sleep(m);
		} catch (Exception e) {
			
		}
	}
}