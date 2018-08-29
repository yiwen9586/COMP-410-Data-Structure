package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	  Node sentinel; //this will be the entry point to your linked list (the head)
	  
	  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
	    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
	  }
	  
	  public Node findNode(int index) { //use index to find a Node
		  Node tmpElt=new Node(0);
		  tmpElt=sentinel;
		  if(index>=0 && index<size())
		  {
			  for(int i=0;i<=index;i++)		  
				  tmpElt=tmpElt.next; 			  
		      return tmpElt;
		  }
		  else  //index is beyond list size range
			  return null;
	  }
	  
	  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
	  
	  public int size() {  //return the size of the list
		  int size=0;
		  Node tmpElt=new Node(0);
		  tmpElt=sentinel;
		  if(tmpElt.next!=null)
		  {
			  while(tmpElt.next!=sentinel)
			  {
				  tmpElt=tmpElt.next;
				  size=size+1;
			  }
		  }
		  return size;
	  }
	  
	  public boolean insert(double elt, int index) {	 //insert a new element into the list
		  Node newElt=new Node(elt); //new element need to insert
		  Node tmpElt=new Node(0);
		  int size=size();
		  if (index>size||index<0)
			  return false;
		  else if(size==0) {		//the list is empty now and insert the first Node 
			  sentinel.next=sentinel.prev=newElt;
			  newElt.next=newElt.prev=sentinel;
			  return true;
		  }
		  else 
		  {	  
			  if(index==size) //at the location that is one beyond the last element
				  tmpElt=sentinel;//find the place to insert
			  else //at a location where a list element already exists
				  tmpElt=findNode(index);
			  tmpElt.prev.next=newElt;
		      newElt.prev=tmpElt.prev;
		      newElt.next=tmpElt;
		      tmpElt.prev=newElt;
			  return true;
		  }
		  	  
	  }
	  
	  public boolean remove(int index){
		  int size=size();
		  Node tmpElt=new Node(0);
		  if(index>=0 && index<=size-1) {
			  tmpElt=findNode(index);
			  tmpElt.prev.next=tmpElt.next;
			  tmpElt.next.prev=tmpElt.prev;		
			  return true;}
		  else
	    	  	  return false;
	  }
	  
	  public double get(int index) {
		  Node tmpElt=new Node(0);
		  tmpElt=findNode(index);
		  if(tmpElt!=null)
			  return tmpElt.data;
		  else 
			  return Double.NaN;
	  }
	    
	  public boolean isEmpty() {		  
		  if ((sentinel.prev==null && sentinel.next==null)||(sentinel.next==sentinel && sentinel.prev==sentinel))
			  return true;
		  else
			  return false;
	  }
	  
	  public void clear() {
		  sentinel.next=sentinel.prev=null;		  
	  }  
	  
	  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
	    return sentinel;
	  }
	}