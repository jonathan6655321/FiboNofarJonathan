import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
/**
 * FibonacciHeap
 *
 * An implementation of fibonacci heap over non-negative integers.
 */
public class FibonacciHeap
{
	private HeapNode min; // the min of the heap;
	private static int totalLinks; // total links made in the heap
	private static int totalCuts; // total cuts made in the heap
	public MyList roots = new MyList(); // all the roots in the heap TODO change to private
	private int size; //the number of nodes
	private int marks; //the number of marked nodes
	
	
	private static final double GOLDEN_RATIO = 1.61803398875;
   /**
    * public boolean empty()
    *
    * precondition: none
    * 
    * The method returns true if and only if the heap
    * is empty.
    *   
    */
    public boolean empty()
    {
    	if (this.roots.size() == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
		
   /**
    * public HeapNode insert(int key)
    *
    * Creates a node (of type HeapNode) which contains the given key, and inserts it into the heap. 
    */
    public HeapNode insert(int key)
    {
    	HeapNode newInsert = new HeapNode(key); // creates the new node
    	newInsert.setRank(0); // set the rank to 0
    	if (this.empty()) { // if the heap is empty sets the prev and next to be the newNode
    		newInsert.setPrev(newInsert);
    		newInsert.setNext(newInsert);
    	}
    	
    	else { // sets the prev and next to be the last item and the first items in the roots list
    		newInsert.setPrev(this.roots.getTail());
    		newInsert.setNext(this.roots.getHead());
    	}
    	this.size ++;
    	this.roots.addLast(newInsert); // add the root to the roots list
    	
    	
    	this.updateMin(newInsert);
    	
    	
      	return newInsert; //returns the new node
    }
    
    
    
    private void updateMin(HeapNode insertedNode){
    	if (this.min == null) { //updates the min
    		this.min = insertedNode;
    	}
    	else if (this.min.getKey() > insertedNode.getKey()) {
    		this.min = insertedNode;
    	}
    }
    

   /**
    * public void deleteMin()
    *
    * Delete the node containing the minimum key.
    *
    */
    public void deleteMin()
    {
    	
    	MyList minChilds = this.removeMin();
    	this.roots.concate(minChilds);
    	this.consolidate();
    	this.size--;
    	
     	return; 
    }
    
    
    /*
     * removes the minimum element from heap - root list and min pointer. 
     * returns MyList of the min childs with parent set to null.
     */
    private MyList removeMin(){
    	HeapNode min = this.findMin();
    	this.setMin(null);
    	this.roots.delete(min);
    	
    	List <HeapNode> minChildsList = min.childs;
    	MyList minChilds = new MyList();
    	
    	
    	// TODO update markers? ? ? ? 
    	for (HeapNode n: minChildsList){
    		n.parent = null; 
    		minChilds.addLast(n);
    	}
    	return minChilds;
    }
    
    
    /*
     * Consolidates. 
     */
    private void consolidate(){
    	HeapNode[] buckets = this.toBuckets();
    	this.fromBuckets(buckets);
    }
    
    
    private HeapNode[] toBuckets(){
    	// calculates log this.size with base Golden Ratio. 
    	// TODO maybe take a bigger number for safety?
    	int bSize =  (int) (Math.round((Math.log(this.size()))/(Math.log(GOLDEN_RATIO)))) + 1;
//    	int bSize = this.size();
    	HeapNode[] B = new HeapNode[bSize];

    	
    	
    	HeapNode currentNode = this.roots.getHead();
    	HeapNode nextNode = this.roots.getHead();
    	
    	while (nextNode != null){
    		currentNode = nextNode;
    		nextNode = nextNode.getNext();
//    		System.out.println(currentNode.getRank() + " is nodes rank before consolidated\n" + bSize + " is the array size"); 
    		while (B[currentNode.getRank()] != null){
    			currentNode = link(currentNode, B[currentNode.getRank()]);
    			B[currentNode.getRank() - 1] = null;
    		}
    		B[currentNode.getRank()] = currentNode;
//    		System.out.println(Arrays.toString(B));
    		
    	}
    	return B;
    }
    
   
    
    
    private static HeapNode link(HeapNode node1, HeapNode node2){
    	// node1 will be the one with smaller key:
    	if (node1.getKey() > node2.getKey()){
    		HeapNode temp = node1;
    		node1 = node2;
    		node2 = temp;
    	}
    	
//    	TODO do I need the next and prev for nodes in children lists?

    	
    	node1.addChild(node2);
    	node2.setParent(node1);
    	node2.clearNextAndPrev();
    	
    	node1.setRank(node1.getRank() + 1);
    	
    	totalLinks++;
    	
    	return node1;
    	
    }
    
    
    private void fromBuckets(HeapNode[] buckets){
    	MyList newRoots = new MyList();
    	for(HeapNode n: buckets){
    		if (n == null){
    			continue;
    		}
    		n.clearNextAndPrev();
    		newRoots.addLast(n);
    		updateMin(n);
    	}
    	
    	this.roots = newRoots;
    }
    
    
   /**
    * public HeapNode findMin()
    *
    * Return the node of the heap whose key is minimal. 
    *
    */
    public HeapNode findMin()
    {
    	return this.min;
    } 
    
    private void setMin(HeapNode newMin) {
    	this.min = newMin;
    }
    
   /**
    * public void meld (FibonacciHeap heap2)
    *
    * Meld the heap with heap2
    *
    */
    public void meld (FibonacciHeap heap2)
    {
    	  if (this.empty() && !heap2.empty()) { //if my heap is empty and heap2 is not empty
    		  this.min = heap2.min;
    		  this.roots = heap2.roots;
    		  this.marks = heap2.marks;
    		  this.size = heap2.size;
    	  }
    	  else if (!heap2.empty()) { //if my heap is not empty and heap2 is not empty
    		  if (this.min.getKey() > heap2.min.getKey()) {
    			  this.min = heap2.min;
    		  }
    		  this.marks = this.marks + heap2.marks;
    		  this.size = this.size + heap2.size;
    		  this.roots.concate(heap2.roots); // TODO do in O(1) by switching to linked list
    	  }
    	  // if both heaps are empty or if heap2 is empty do nothing!
    }
    

   /**
    * public int size()
    *
    * Return the number of elements in the heap
    *   
    */
    public int size()
    {
    	return this.size;
    }
    	
    /**
    * public int[] countersRep()
    *
    * Return a counters array, where the value of the i-th entry is the number of trees of order i in the heap. 
    * 
    */
   public int[] countersRep() 
    {
	int[] arr = new int[0];
	HeapNode current = this.roots.getHead();
	boolean flag = true;
	while (flag) { // go on all the roots of the heap
		int rank = current.getRank(); //check the rank of the root
		if (rank > arr.length-1) { //if the list is shorter then the rank
			int[] newArr = new int[rank+1]; //copy the array to new longer array
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			arr = newArr;
		}
		arr[rank] +=1; //counter++ to the relevant rank
		if (current != this.roots.getTail()) {
			current = current.getNext();
		}
		else {
			flag = false;
		}
		
		
	}
   return arr;
    }

   /**
    * public void arrayToHeap()
    *
    * Insert the array to the heap. Delete previous elemnts in the heap.
    * 
    */
    public void arrayToHeap(int[] array)
    {
        this.min = null; // we will clear the heap first
    	this.totalLinks = 0;
    	this.totalCuts = 0;
    	this.roots.clear();
    	this.size = 0;
    	this.marks = 0;
    	for (int i:array) { //insert all the items in the array
    		this.insert(i);
    	}
        
    }
	
   /**
    * public void delete(HeapNode x)
    *
    * Deletes the node x from the heap. 
    *
    */
    public void delete(HeapNode x) 
    {    
    	this.decreaseKey(x, Integer.MIN_VALUE);
    	this.decreaseKey(x, -999999999); // TODO change to min value
    	this.deleteMin();
    }

   /**
    * public void decreaseKey(HeapNode x, int delta)
    *
    * The function decreases the key of the node x by delta. The structure of the heap should be updated
    * to reflect this change (for example, the cascading cuts procedure should be applied if needed).
    */
    public void decreaseKey(HeapNode node, int delta)
    {    
    	node.setKey(delta);
    	if (node.getParent() != null) {
    		if (node.getParent().getKey() < node.getKey()) {
    			cascadingCut(node, node.getParent());
    		}
    	}
    }
   /**
    * private void cascadingCut(HeapNode x, HeapNode y) {
    * the function gets HeapNode x (the one who needs to be cut) and node y, his parent.
    * its a recrucian function that cuts recursuianly the items in the tree.
    * first she cuts the node that is invalid, then if the parent node is marked she cuts it also 
    * and continue to the next parent until the root.
    * 
    */
    
    private void cascadingCut(HeapNode node, HeapNode parent) {
    	node.setParent(null);
    	if (node.getMark() == true) {
    		node.setMark(false);
    		this.marks --;
    	}
    	parent.setRank(parent.getRank()-1);
    	if (node.getNext() == node) {
    		parent.deleteChild(node);
    	}
    	else {
    		node.getPrev().setNext(node.getNext());
    		node.getNext().setPrev(node.getPrev());
    		parent.deleteChild(node);
    	}
    	this.roots.addLast(node);
    	if (parent.parent!= null) {
    		if (parent.getMark() == false) {
    			parent.setMark(true);
    			this.marks ++;
    		}
    		else {
    			cascadingCut(parent,parent.getParent());
    		}
    	}
    	
    	
    }
   /**
    * public int potential() 
    *
    * This function returns the current potential of the heap, which is:
    * Potential = #trees + 2*#marked
    * The potential equals to the number of trees in the heap plus twice the number of marked nodes in the heap. 
    */
    public int potential() 
    {    
    	return this.roots.size() + (2 * this.marks);
    }

   /**
    * public static int totalLinks() 
    *
    * This static function returns the total number of link operations made during the run-time of the program.
    * A link operation is the operation which gets as input two trees of the same rank, and generates a tree of 
    * rank bigger by one, by hanging the tree which has larger value in its root on the tree which has smaller value 
    * in its root.
    */
    public static int totalLinks()
    {    
    	return totalLinks;
    }

   /**
    * public static int totalCuts() 
    *
    * This static function returns the total number of cut operations made during the run-time of the program.
    * A cut operation is the operation which diconnects a subtree from its parent (during decreaseKey/delete methods). 
    */
    public static int totalCuts()
    {    
    	return totalCuts;
    }
    /**
     * public class MyList
     * class of linked list the simple linked list for the roots.
     * answers the requirements that we need in this project for the list of roots.
     */
    
    public class MyList {
    	private HeapNode head;
    	private HeapNode tail;
    	private int size;
    	
    	public boolean isEmpty() // check if the list is empty
        {
        	if (this.size == 0) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
    	public void addLast(HeapNode node) { // adds an object at the end of the list
    		if (this.isEmpty()) {
    			this.head = node;
    			this.tail = node;
    			this.size ++;
    		}
    		else {
    			HeapNode tmp = this.tail;
    			this.tail = node;
    			node.setPrev(tmp);
    			tmp.setNext(node);
    			this.size ++;
    		}
    	}
    	public void concate(MyList heap2) { //concate two linked list lists in o(1)
    		this.size = this.size + heap2.size;
    		if (this.tail != null){
    			this.tail.setNext(heap2.head); // TODO there were changes here
//    			this.head.setPrev(heap2.tail);
    			if (heap2.head != null){
    				heap2.head.setPrev(this.tail);    				
    			}
    		} else {
    			this.head = heap2.head;
    		}
    		this.tail = heap2.tail;
    	}
    	public void delete(HeapNode node) { //delete an object from the list
    		
    		if (node.getPrev() != null){
    			node.getPrev().setNext(node.getNext());    			
    		}
    		if (node.getNext() != null){
    			node.getNext().setPrev(node.getPrev());    			
    		}
    		this.size --;
    		if (this.isEmpty()) {
    			this.head = null;
    			this.tail = null;
    		} 
    		if (this.tail == node) {
    			this.tail = node.getPrev();
    		}
    		else if (this.head == node) {
    			this.head = node.getNext();
    		}
    	}
    	public int size() { //returns the size of the list
    		return this.size;
    	}
    	public HeapNode getTail() { //returns the tail of the list
    		return this.tail;
    	}
    	public HeapNode getHead() { // returns the head of the list
    		return this.head;
    	}
    	public void clear() { // clears the list
    		this.head = null;
			this.tail = null;
			this.size = 0;
    	}
    	
    	
    }
    
   

    
   /**
    * public class HeapNode
    * 
    * If you wish to implement classes other than FibonacciHeap
    * (for example HeapNode), do it in this file, not in 
    * another file 
    *  
    */
    public class HeapNode{
    	
    	private int key;
    	private int rank;
    	private boolean mark = false;
    	private LinkedList<HeapNode> childs = new LinkedList<HeapNode>();
    	private HeapNode next;
    	private HeapNode prev;
    	private HeapNode parent;
    	
    	public HeapNode(int key) {
    		this.key = key;
    	}
    	public int getKey() {
    		return this.key;
    	}
    	public int getRank() {
    		return this.rank;
    	}
    	public boolean getMark() {
    		return this.mark;
    	}
    	public List<HeapNode> getChilds() {
    		return this.childs;
    	}
    	public HeapNode getNext() {
    		return this.next;
    	}
    	public HeapNode getPrev() {
    		return this.prev;
    	}
    	public HeapNode getParent() {
    		return this.parent;
    	}
    	
    	public void setKey(int key) {
    		this.key = key;
    	}
    	public void setRank(int rank) {
    		this.rank = rank;
    	}
    	public void setMark(boolean mark) {
    		this.mark = mark;
    	}
    	public void addChild(HeapNode child) {
    		this.childs.addFirst(child);
    	}
    	public void deleteChild(HeapNode child) {
    		this.childs.remove(child);
    	}
    	public void setNext(HeapNode next) {
    		this.next = next;
    	}
    	public void setPrev(HeapNode prev) {
    		this.prev = prev;
    	}
    	public void setParent(HeapNode parent) {
    		this.parent = parent;
    	}
    	
    	public String toString(){
    		return "" +  this.getRank();
    	}
    	
    	private void clearNextAndPrev(){
    		this.next = null;
    		this.prev = null;
    		
    	}

    }
}