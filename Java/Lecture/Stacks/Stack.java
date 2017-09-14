/*
Data item list,
Push	-> Add
Pop 	-> Remove
Peak	-> Look at the item on the top of the stack, aka read ahead

simplest implementation is an Array::
	specific max size n 
	creat stack s with size n
	create instance variable t to indcate top element in array s
		-instantiate as t = -1
	sack operations;
		size(): return t+1
		empty(): check if we have a top element
		peek(): not empty returns s[t]
		push(Object o) if t<N-1
		pop(): if not empty return S[t]

java has its own stack array already.
java.util.Stack<E>;
		
*/
class Stack{
	class Stack1{
		private int maxSize;
		private String[] stackArray;
		private int top;
		
		public Stack1(int s){
			maxSize = s;
			stackArray = new String[maxSize];
			top = -1;
		}
		
		public boolean isFull(){
			return top==maxSize -1;
		}
		
		public boolean isEmpty(){
			return top==-1;
		}
		
		public int size(){
			return top+1;
		}
		
		public void push(String s){
			if(isFull()){
				System.out.println("List is full");
			}else{
				top = top+1;
				stackArray[top] =  s;
			}
		}
		
		public String pop(){
			String s;
			if(isEmpty()){
				s = "List is empty";
			}else{
				s = stackArray[top];
				stackArray[top]=null;
				top-=1;
			}
			return s;
		}
		
		public String peek(){
			return stackArray[top];
		}
		
		public void print(){
			System.out.println("Top of stack:");
			for(String s : stackArray){
				System.out.println(s);
			}
			System.out.println("End of stack.");
		}
	}

	
}