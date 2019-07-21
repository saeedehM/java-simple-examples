package concurrency.majoroperations;

public class Demo {

	public static void main(String args[]) {
		Worker R1 = new Worker("Thread-1");
		R1.start();

		Worker R2 = new Worker("Thread-2");
		R2.start();

		try {
			Thread.sleep(1000);
			R1.suspend();
			System.out.println("Suspending First Thread");
			Thread.sleep(1000);
			R1.resume();
			System.out.println("Resuming First Thread");

			R2.suspend();
			System.out.println("Suspending thread Two");
			Thread.sleep(1000);
			R2.resume();
			System.out.println("Resuming thread Two");
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		try {
			System.out.println("Waiting for threads to finish.");
			R1.t.join();
			R2.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		System.out.println("Main thread exiting.");
	}
}