package concurrency.majoroperations;

public class Worker implements Runnable {

	public Thread t;
	private String threadName;
	boolean suspended = false;

	Worker(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);

		try {

			for (int i = 10; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				Thread.sleep(300);

				synchronized (this) {

					while (suspended) {
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			
			
			System.out.println("Thread " + threadName + " interrupted.");
		}
		
		
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);

		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	void suspend() {
		suspended = true;
	}

	synchronized void resume() {
		suspended = false;
		notify();
	}

}
