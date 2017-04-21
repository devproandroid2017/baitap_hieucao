package baitap_hieucao;

public class MyNumberFirstWay {

	public static void main(String[] args) {
	
		int min = 0;
		int max = 1000000000;
		long result = 0;
		for(int i = min; i <= max; i++){
			result += i;
		}
		System.out.println("sum "+ min + " to " + max + ":" + result);

	}

}
