package test.structs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAQS {

	public static Lock lock = new ReentrantLock();
	

	/*
	 * ÖĞ¶ÏËø²âÊÔ
	 * ÂÖÑ¯Ëø²âÊÔ
	 * 
	 */
	
	
	public static void main(String[] args) {

		new Thread() {

			public void run() {
				
				try {
					lock.lockInterruptibly();

					System.out.println("lock has already");
					for (int i = 0; i < 1000000; i++) {
						if (i % 100000 == 0)
							System.out.println("this is " + i + " times");

					}
				} catch (InterruptedException e) {
					System.out.println("t1 has interrupt");
				} finally {
					lock.unlock();
					System.out.println("lock has released");
				}

				
			}

		}.start();

		new Thread() {

			public void run() {

				System.out.println("t2 is running");
				try {
					// if (lock.tryLock(4, TimeUnit.SECONDS)) {
					// System.out.println("t2 has get lock");
					// }
					lock.tryLock();
					System.out.println("t2 has get lock");
					

				} finally {
				//	lock.unlock();
					System.out.println("t2 finish");
				}
				

			}

		}.start();

		new Thread() {

			public void run() {
				System.out.println("t3 is running");
				try {
					lock.lock();
					System.out.println("t3 has get lock");
					
				} finally {
					lock.unlock();
					System.out.println("t3 finish");
				}

			}

		}.start();

	}

}
