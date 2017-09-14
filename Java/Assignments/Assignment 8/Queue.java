/**
* @author Stefan Schroder
* @version 2016-09-19
*
* Standard queue created for understanding perposes.. nothing special
*/

public class Queue<T>{
	private class Node<T>{
		private T data;
		private Node<T> link;
		
		public Node(){
			this.data = null;
			this.link = null;
			
		}
		
		public Node(T data, Node<T> link){
			this.data = data;
			this.link = link;
			
		}
		
	}//
	
	private Node<T> back;
	private Node<T> front;
	
	public Queue(){
		back = null;
		front = null;
		
	}//
	
	public void enqueue(T addData){
		if(front==null){
			front = new Node<T>(addData,null);
			back = front;
		
		}else{
			Node<T> newNode = new Node<T>(addData, null);
			back.link = newNode;
			back = newNode;
			
		}
		
	}//
	
	public T dequeue(){
		T toSend = null;
		
		if(front!=null){
			toSend = front.data;
			front = front.link;
			
		}
		return toSend;
		
	}//
	
	public int size(){
		Node<T> node = front;
		int counter = 0;
		
		while(node!=null){
			counter++;
			node = node.link;
			
		} 
		return counter;
		
	}//
	
	public boolean isEmpty(){
		return front==null;
		
	}//
	
	public T front(){
		if(front!=null){
			return front.data;
		}
		return null;
		
	}//
	
}