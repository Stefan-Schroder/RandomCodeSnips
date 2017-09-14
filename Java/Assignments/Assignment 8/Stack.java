/**
* @author Stefan Schroder
* @version 2016-09-19
*
* I created my own stack in linked list format.
* for the perpose of giveing some extra functionality, such as the polar method.
* and the output list.
* everthing else is standard
*/

public class Stack <T>{
	
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
	
	private Node<T> top;
	
	public Stack(){
		top = null;
		
	}//
	
	public void push(T data){
		top = new Node<T>(data,top);
		
	}//
	
	public T pop(){
		T toReturn;
		if(top==null){
			toReturn = null;
			
		}else{
			toReturn = top.data;
			top = top.link;
			
		}
		return toReturn;
		
	}//
	
	public T peek(){
		return top.data;
		
	}//
	
	public Node<T> find(T toFind){
		Node<T> node = top;
		
		while(node.link!=null){
			if(node.data.equals(toFind)){
				return node;
				
			}
			
			node = node.link;
		
		}
		return null;
		
	}//
	
	public int size(){
		int counter = 0;
		Node<T> node = top;
		
		while(node!=null){
			counter++;
		
		}
		return counter;
		
	}//
	
	public boolean contains(T toFind){
		return find(toFind)!=null;
		
	}//
	
	public T findData(T toFind){
		return find(toFind).data;
		
	}//
	
	/**
	* This was ultered to give me the functionality to print out the remaining data in a way i wanted
	*/
	public void outputList(){
		Node<T> node = top;
		
		while(node!=null){
			System.out.println("error at end: opening bracket '"+node.data+"' remains unclosed.");
			node = node.link;
			
		}
		
	}//
	
	public boolean isEmpty(){
		return top==null;
		
	}//
	
	/**
	* The polar method was created to serve as a check for the item passed in and the item that is at the top of the list
	* to have opopsite bracket symbols.
	*/
	public boolean polar(char toCheck){
		switch(toCheck){
			case ')':
				return top.data.equals('(');
				
			case '}':
				return top.data.equals('{');
			
			case ']':
				return top.data.equals('[');
				
			case '>':
				return top.data.equals('<');
		}
		return false;
	
	}//
	
}