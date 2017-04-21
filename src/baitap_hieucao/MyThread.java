package baitap_hieucao;

public class MyThread extends Thread{
	
	private static Object obj = new Object();
	
	private final int MIN = 1;
	private final int MAX = 1000000000;

	public void run(){
		System.out.println("");
//		synchronized (obj) {
			printData();
//		}
	}
	public void printData(){
		for(int i = 1; i < 100; i++){
			System.out.print(i + "-");
		}
	}
	public static void main(String[] args) {
		MyThread thr1 = new MyThread();
		MyThread thr2 = new MyThread();
		MyThread thr3 = new MyThread();
		
		thr1.start();
		thr2.start();
		thr3.start();
		
	}

}
