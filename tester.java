//package myfibo;

import java.util.Arrays;
import java.util.Random;

public class tester {
	
	public static void main(String[] args){
//		FibonacciHeap myHeap = new FibonacciHeap();
//		System.out.println(myHeap.empty());
//		System.out.println(myHeap.insert(5).getKey());
//		System.out.println(myHeap.insert(7).getKey());
//		System.out.println(myHeap.insert(2).getKey());
//		System.out.println(myHeap.findMin().getKey());
//		myHeap.findMin().setRank(2);
//		System.out.println(Arrays.toString(myHeap.countersRep()));
//		FibonacciHeap heap2 = new FibonacciHeap();
//		System.out.println(heap2.insert(6).getKey());
//		System.out.println(heap2.insert(1).getKey());
//		System.out.println(heap2.insert(8).getKey());
//		System.out.println(heap2.findMin().getKey());
//		myHeap.meld(heap2);
//		System.out.println(myHeap.findMin().getKey());
//		System.out.println(myHeap.size());
//		System.out.println(Arrays.toString(heap2.countersRep()));
//		int[] arr = {1,2,3,4,5,-1};
//		myHeap.arrayToHeap(arr);
//		System.out.println(myHeap.findMin().getKey());
//		System.out.println(myHeap.size());
//		myHeap.decreaseKey(myHeap.findMin(), -2);
//		System.out.println(myHeap.findMin().getKey());
//		System.out.println(myHeap.potential());
//		System.out.println(myHeap.totalCuts());
//		System.out.println(myHeap.totalLinks());
//		System.out.println(Arrays.toString(myHeap.countersRep()));
//		myHeap.deleteMin();
//		System.out.println(Arrays.toString(myHeap.countersRep()));
//		System.out.println(myHeap.insert(-1).getKey());
//		System.out.println(Arrays.toString(myHeap.countersRep()));
//		System.out.println(myHeap.insert(-2).getKey());
//		System.out.println(myHeap.insert(5).getKey());
//		myHeap.deleteMin();
//		System.out.println(Arrays.toString(myHeap.countersRep()));
//		myHeap.delete(myHeap.findMin());
//		System.out.println(Arrays.toString(myHeap.countersRep()));
//		FibonacciHeap.HeapNode myNode = myHeap.insert(1000);
//		myHeap.deleteMin();
//		System.out.println(Arrays.toString(myHeap.countersRep()));
//		myHeap.decreaseKey(myNode,-1);
//		System.out.println(myHeap.size());
//		System.out.println(Arrays.toString(myHeap.countersRep()));
//		myHeap.deleteMin();
//		System.out.println(Arrays.toString(myHeap.countersRep()));
//		System.out.println(myHeap.size());
		//mesures need to add run time function
		
		
		/*
		 * nofars tests: 
		 */
		
		FibonacciHeap heap1000 = new FibonacciHeap();
		for (int i =1000 ; i>0;i--) {
			heap1000.insert(i);
		}
		System.out.println("Insertation1000:\ntotalLinks = "+heap1000.totalLinks()+"\ntotalCuts = "+heap1000.totalCuts()+"\nPotential = "+heap1000.potential());
		for (int l = 0; l<1000/2;l++) {
			heap1000.deleteMin();
		}
		System.out.println("Deletion1000/2\ntotalLinks = "+heap1000.totalLinks()+"\ntotalCuts = "+heap1000.totalCuts()+"\nPotential = "+heap1000.potential());
		
		FibonacciHeap heap2000 = new FibonacciHeap();
		for (int i =2000 ; i>0;i--) {
			heap2000.insert(i);
		}
		System.out.println("Insertation2000:\ntotalLinks = "+heap2000.totalLinks()+"\ntotalCuts = "+heap2000.totalCuts()+"\nPotential = "+heap2000.potential());
		for (int l = 0; l<2000/2;l++) {
			heap2000.deleteMin();
		}
		System.out.println("Deletion2000/2\ntotalLinks = "+heap2000.totalLinks()+"\ntotalCuts = "+heap2000.totalCuts()+"\nPotential = "+heap2000.potential());
		
		FibonacciHeap heap3000 = new FibonacciHeap();
		for (int i =3000 ; i>0;i--) {
			heap3000.insert(i);
		}
		System.out.println("Insertation3000:\ntotalLinks = "+heap3000.totalLinks()+"\ntotalCuts = "+heap3000.totalCuts()+"\nPotential = "+heap3000.potential());
		for (int l = 0; l<3000/2;l++) {
			heap3000.deleteMin();
		}
		System.out.println("Deletion3000/2\ntotalLinks = "+heap3000.totalLinks()+"\ntotalCuts = "+heap3000.totalCuts()+"\nPotential = "+heap3000.potential());
		

		/*
		 * sequence 1:
		 */
		
//		System.out.println("Sequence 1:");
//		System.out.println("Sequence 2:");
//		System.out.println("m, Run-Time (in miliseconds), totalLinks, totalCuts, Potential");
//		int numIterations = 3;
//		int m;
//		long startTime;
//		long endTime;
//		int[] insertThese;
//		
//		for (int i=1; i < numIterations + 1; i++){
//			
//			FibonacciHeap heap = new FibonacciHeap();
//			
//			m = i*1000;
//			insertThese = new int[m];
//			for (int j =1 ; j < m+1; j++ ){
//				insertThese[j-1] = j;
//			}
//			
//			startTime = System.nanoTime();
//			
//			heap.arrayToHeap(insertThese);
//			
//			
//			// comment this out for sequence 1
//			for (int k = 0; k < m/2; k++){
//				heap.deleteMin();
//				
//				if (heap.findMin().getKey() != k+2){
//					System.out.println("error in min:" + heap.findMin().getKey());
//				}
//			}
//			
//			endTime = System.nanoTime();
// 
//			long duration = (endTime - startTime)/1000000; // time in milliseconds
//			
//			
//			System.out.println(m + "," +  duration+ "," + FibonacciHeap.totalLinks()
//			+ "," +FibonacciHeap.totalCuts()+ "," + heap.potential());
//		}

//			FibonacciHeap heap = new FibonacciHeap();
//			for(int i = 1; i<66; i++){
//				heap.insert(i);
//			}
//			heap.deleteMin();
//			view(heap);
//			heap.delete(heap.roots.getTail().getChilds().get(0).getChilds().get(2));
//			view(heap);
//			heap.delete(heap.roots.getTail().getChilds().getFirst().getChilds().getFirst().getChilds().get(3));
//			view(heap);
//			heap.delete(heap.roots.getTail().getChilds().getFirst().getChilds().getFirst().getChilds().getFirst().getChilds().get(2));
//			view(heap);
//			heap.delete(heap.roots.getTail().getChilds().getFirst().getChilds().getFirst().getChilds().getFirst().getChilds().getFirst().getChilds().get(1));
//			view(heap);
//			heap.delete(heap.roots.getTail().getChilds().getFirst().getChilds().getFirst().getChilds().getFirst().getChilds().getFirst().getChilds().getFirst());
//			view(heap);
//			System.out.println(heap.size());
//			System.out.println(heap.totalCuts());
//			System.out.println("------ first insert then delete ------");
//			System.out.println("*** Starting Medida for m = " + 3000 + " ***");
//			long start_time = System.nanoTime();
//			for (int i = 3000; i > 0; i--){
//				heap.insert(i);
//			}
//			for (int i = 0; i < 3000 / 2; i++){
//				System.out.println(heap.findMin().key);
//				heap.deleteMin();
//			}
//			long end_time = System.nanoTime();
//			double difference = (end_time - start_time) / 1e6;
//			System.out.println("Time: " + difference);
//			System.out.println("Total Links: " + FibonacciHeap.totalLinks());
//			System.out.println("Total Cuts: " + FibonacciHeap.totalCuts());
//			System.out.println("Potential: " + heap.potential());
//			view(heap);
//			System.out.println(heap.findMin().getKey());
//			
//		
//		
//		
//	}
//	public static void medida_insert(int size)
//	{
//		System.out.println("------ only insert ------");
//		System.out.println("*** Starting Medida for m = " + size + " ***");
//		FibonacciHeap heap = new FibonacciHeap();
//		long start_time = System.nanoTime();
//		for (int i = size; i > 0; i--){
//			heap.insert(i);
//		}
//		long end_time = System.nanoTime();
//		double difference = (end_time - start_time) / 1e6;
//		System.out.println("Time: " + difference);
//		System.out.println("Total Links: " + FibonacciHeap.totalLinks());
//		System.out.println("Total Cuts: " + FibonacciHeap.totalCuts());
//		System.out.println("Potential: " + heap.potential());
//		
//		// measure time
////		double[] timings = new double[10000];
////		for (int i = 0; i < timings.length; i++){
////			heap = new FibonacciHeap_lianm_guyshalev();
////			long start_time = System.nanoTime();
////			heap.arrayToHeap(arr);
////			long end_time = System.nanoTime();
////			double difference = (end_time - start_time);
////			timings[i] = difference;
////		}
////		System.out.println(Arrays.toString(timings));
////		System.out.println("Time: " + average(timings)/1e6);
//	}
//	
//	public static void medida_insert_delete(int size)
//	{
//		System.out.println("------ first insert then delete ------");
//		System.out.println("*** Starting Medida for m = " + size + " ***");
//		FibonacciHeap heap = new FibonacciHeap();
//		long start_time = System.nanoTime();
//		for (int i = size; i > 0; i--){
//			heap.insert(i);
//		}
//		for (int i = 0; i < size / 2; i++){
//			heap.deleteMin();
//		}
//		long end_time = System.nanoTime();
//		double difference = (end_time - start_time) / 1e6;
//		System.out.println("Time: " + difference);
//		System.out.println("Total Links: " + FibonacciHeap.totalLinks());
//		System.out.println("Total Cuts: " + FibonacciHeap.totalCuts());
//		System.out.println("Potential: " + heap.potential());
//	}
//	
//	public static double average(double[] numbers){
//		int sum = 0;
//        for(int i = 0; i < numbers.length ; i++)
//                sum += numbers[i];
//        double average = sum / numbers.length;
//        return average;
//	}
//	
//	public static void deleteAll(FibonacciHeap heap, int amount){
//		int[]arr = randomIntArr(amount);
//		for(int i:arr){
//			heap.insert(i);
//		}
//		heap.deleteMin();
//		for(int i = 0; i<amount-2; i++){
//			if(heap.roots.size()==1){
//				heap.delete(heap.findMin().getChilds().getFirst());
//			}
//			else{
//				heap.delete(heap.findMin().getNext());
//			}
//			
//		}
//	}
//	
//	public static int[] randomIntArr (int size){
//		Random rnd = new Random();
//		int[] res = new int[size];
//		int cnt = 0;
//		while(cnt < size){
//			int val = rnd.nextInt(100000);
//			boolean contains = false;
//			for(int j = 0; j<cnt;j++){
//				if (val == 0 || res[j] == val){
//					contains = true;
//					break;
//				}
//			}
//			if(contains){
//				continue;
//				}
//			else{
//				res[cnt] = val;
//				cnt++;
//			}
//		}
//		return res;
//	}
//	
//	public static void view (FibonacciHeap heap){
//		String res = "";
//		int[] arr = heap.countersRep();
//		for(int i:arr){
//			res+="["+i+"]";
//		}
//		System.out.println(res);
	}
	
}
