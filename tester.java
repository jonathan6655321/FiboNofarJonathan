import java.util.Arrays;

public class tester {
	
	public static void main(String[] args){
		FibonacciHeap myHeap = new FibonacciHeap();
		System.out.println(myHeap.empty());
		System.out.println(myHeap.insert(5).getKey());
		System.out.println(myHeap.insert(7).getKey());
		System.out.println(myHeap.insert(2).getKey());
		System.out.println(myHeap.findMin().getKey());
		myHeap.findMin().setRank(2);
		System.out.println(Arrays.toString(myHeap.countersRep()));
		FibonacciHeap heap2 = new FibonacciHeap();
		System.out.println(heap2.insert(6).getKey());
		System.out.println(heap2.insert(1).getKey());
		System.out.println(heap2.insert(8).getKey());
		System.out.println(heap2.findMin().getKey());
		myHeap.meld(heap2);
		System.out.println(myHeap.findMin().getKey());
		System.out.println(myHeap.size());
		System.out.println(Arrays.toString(heap2.countersRep()));
		int[] arr = {1,2,3,4,5,-1};
		myHeap.arrayToHeap(arr);
		System.out.println(myHeap.findMin().getKey());
		System.out.println(myHeap.size());
		myHeap.decreaseKey(myHeap.findMin(), -2);
		System.out.println(myHeap.findMin().getKey());
		System.out.println(myHeap.potential());
		System.out.println(myHeap.totalCuts());
		System.out.println(myHeap.totalLinks());
		System.out.println(Arrays.toString(myHeap.countersRep()));
	}
}
