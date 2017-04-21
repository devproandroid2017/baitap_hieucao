package baitap_hieucao;

public class MyNumberSecondWay extends Thread{
	private static long total = 0;
	
	public static final Object obj = new Object();
	
	private static int numberOfObj = 0;
	private static int numberOfProcessing = 0;
	private long min = 0;
	private long max = 0;
	public MyNumberSecondWay(long min, long max) {
		this.min = min;
		this.max = max;
		numberOfObj ++;
		numberOfProcessing++;
	}
	public void run(){
		//tinh tong
		long sum = 0;
		for(long i = min; i <= max; i++){
			sum += i;
		}
		total = total + sum;
		numberOfProcessing --;
		if(numberOfProcessing == 0){
			synchronized (obj) {
				obj.notify();	
			}
		}
	}
	public static long getTotal(){
		try {
			synchronized (obj) {
				obj.wait();	
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public static void main(String[] args) {
		//nhap min max
		long min = 0;
		long max = 1000000000;
		long result = 0;
		int nthread = 8;
		//phan chia min max thanh 4 phan gia tri
		long xmin = min;
		long xmax = min;
		for(int i = 1; i <= nthread; i++){
			xmin = xmax + 1;
			xmax = i * max / nthread;
			MyNumberSecondWay thr1 = new MyNumberSecondWay(xmin, xmax);
			thr1.start();
		}
//		long num1 = max / 4;
//		long num2 = 2 * max / 4;
//		long num3 = 3 * max / 4;
//		long num4 = 4 * max / 4;
		//khoi tao 4 thread
//		MyNumberSecondWay thr1 = new MyNumberSecondWay(min, num1);
//		MyNumberSecondWay thr2 = new MyNumberSecondWay(num1 + 1, num2);
//		MyNumberSecondWay thr3 = new MyNumberSecondWay(num2 + 1, num3);
//		MyNumberSecondWay thr4 = new MyNumberSecondWay(num3 + 1, num4);
//		//start 4 thread
//		thr1.start();
//		thr2.start();
//		thr3.start();
//		thr4.start();
		//in ket qua ra man hinh
		result = MyNumberSecondWay.getTotal();
		System.out.println("sum "+ min + " to " + max + ":" + result);
	}

}
