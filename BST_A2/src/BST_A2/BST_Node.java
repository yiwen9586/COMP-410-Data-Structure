package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  BST_Node parent;
  int flag;//indicate whether a left child(1) or a right child(0) or a root(2)
  

  
  BST_Node(String data){ this.data=data; this.flag=3;}

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }
  public BST_Node getParent(){ return parent; }
  public int getFlag(){ return flag; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public boolean containsNode(BST_Node newNode,BST_Node orgNode)
  {
	  if(orgNode==null)
		  return false;
	  else
	  {
		  int res = newNode.data.compareTo(orgNode.data);
		  if(res==0)
			  return true;
		  else if(res>0)//bigger, go right
			  return containsNode(newNode,orgNode.right);
		  else//smaller, go left 
			  return containsNode(newNode,orgNode.left); 
	  }
  }
  
  public BST_Node findNode(BST_Node root,String s)
  {
	  if(root==null)
		  return null;
	  else
	  {
		  int res = s.compareTo(root.data);
		  if(res==0)
			  return root;
		  else if(res>0)//bigger, go right
			  return findNode(root.right,s);
		  else//smaller, go left 
			  return findNode(root.left,s); 
	  }
  }
  
  
  public boolean insertNode(BST_Node root,String s)
  { 
	  int res = s.compareTo(root.data);
	  BST_Node newNode = new BST_Node(s);
	  if(res<0)
	  {
		  if(root.left!=null)
			  return insertNode(root.left,s);
		  else 
		  {
			  root.left=newNode;	
			  newNode.parent=root;
			  newNode.flag=1;//left child
			  return true;
		  }
	  }
	  else
	  {
		  if(root.right!=null)
			  return insertNode(root.right,s);
		  else 
		  {
			  root.right=newNode;	
			  newNode.parent=root;
			  newNode.flag=0;//right child
			  return true;
		  }
	  }	  
  
  }
  
  public boolean removeNode(BST_Node root,String s)
  {
	  BST_Node remNode = new BST_Node(null);
	  BST_Node minNode = new BST_Node(null);
	  remNode = findNode(root,s);
	  if(remNode.left==null&&remNode.right==null)//leaf
	  {
		  if(remNode.flag==1)//is a left child
			  remNode.parent.left=null;
		  else if(remNode.flag==0)//is a right child
			  remNode.parent.right=null;
		  return true;
	  }
	  if(remNode.left!=null&&remNode.right!=null)//has two child
	  {
		  minNode=findMin(remNode.right);
		  if(remNode.flag==1)
			  remNode.parent.left.data=minNode.data;
		  else if(remNode.flag==0)		  
			  remNode.parent.right.data=minNode.data;
		  else//remove root
			  remNode.data=minNode.data;
	      
		  //remove minNode
		  if(minNode.flag==1)//is a left child
		  {
			  if(minNode.right!=null)
			  {	  
				  minNode.right.flag=1;
				  minNode.parent.left=minNode.right;
				  minNode.right.parent=minNode.parent;
			  }
			  else
				  minNode.parent.left=null;	
		  }
		  else
		  {
			  if(minNode.right!=null)
			  {
				  minNode.parent.right=minNode.right;
				  minNode.right.parent=minNode.parent;
			  }
			  else
				  minNode.parent.right=null;
		  }
		  
		  return true;		  
	  }
	  else//has one child
	  {
		  if(remNode.flag==1)//is a left child
		  {
			  if(remNode.left!=null)//has left child
			  {
				  remNode.parent.left=remNode.left;
			  	  remNode.left.parent=remNode.parent;
			  }
			  else//has right child
			  {
				  remNode.right.flag=1;
				  remNode.parent.left=remNode.right;
			      remNode.right.parent=remNode.parent;
			  }
		  }
		  else if(remNode.flag==0)//is a right child
		  {
			  if(remNode.left!=null)//has left child
			  {
				  remNode.left.flag=0;
				  remNode.parent.right=remNode.left;
			      remNode.left.parent=remNode.parent;
			  }
			  else//has right child
			  {
				  remNode.parent.right=remNode.right;
				  remNode.right.parent=remNode.parent;
			  }
		  } 	  
		  return true; 
	  }
	 
  }
  
  public BST_Node findMin(BST_Node min)
  {
	  while(min.left!=null)
		  min = min.left;  
	  return min; 
  }
  
  public BST_Node findMax(BST_Node max)
  {  
	  while(max.right!=null)
		  max = max.right;
	  return max; 
  }
  

  public int getSize(BST_Node node)
  {
	  if(node!=null)
		  return getSize(node.left)+getSize(node.right)+1;
	  else
		  return 0;
  }
  
  public int Max(int x,int y)
  {
	  if (x>y)
		  return x;
	  else
		  return y;
  }
  
  public int getHeight(BST_Node node)
  {
	  if (node!=null) {
		  int left_h = getHeight(node.left);
		  int right_h = getHeight(node.right);
		  return Max(left_h,right_h)+1;
	  }	    
	  else
		  return 0;
  }
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}
