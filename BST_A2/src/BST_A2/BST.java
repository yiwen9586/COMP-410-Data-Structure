package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root;}
  
  public boolean insert(String s) {
	  if(s==null)
		  return false;
	  else 
	  {
		  BST_Node newNode = new BST_Node(s);	  
		  if(empty()==true)
		  {
			  root = newNode;
			  root.flag=2;//root 
			  return true;		  
		  }
		  else 
		  {	  
			  if( contains(s)==true)
				  return false;
			  else
				  return root.insertNode(root,s); 
		  }
	  }
  }
  
  public boolean remove(String s){
	  if(s==null)
		  return false;
	  else 
	  {  
		  if(empty()==true)
			  return false;
		  else 
		  {	  
			  if( contains(s)!=true)
				  return false;
			  else if(root.data==s&&root.left==null&&root.right==null)//remove root when the tree only has root
			  {   root=null;		return true;}	  
			  else if(root.data==s&&root.left!=null&&root.right==null)//root has left child
			  {      root=root.left;	return true;}
		      else if(root.data==s&&root.left==null&&root.right!=null)//root has right child
		      {	  root=root.right; return true;}
			  else//remove not root node or root has two childs
				  return root.removeNode(root, s);	
		  }		  
	  }
  }
  
  public String findMin()   
  {
	 if(empty())
		 return null;
	 else
		 return root.findMin(root).data;
  }
  
  public String findMax()   
  {
	 if(empty())
		 return null;
	 else
		 return root.findMax(root).data;
  }
 
  
  public boolean empty()
  {
	  if(root==null)
		  return true;
	  else
		  return false;
  }
  
  public boolean contains(String s)
  {
	  if(s==null)
		  return false;
	  else 
	  {
		  if(empty())
			  return false;
		  else
		  {
			  BST_Node newNode = new BST_Node(s);
			  return root.containsNode(newNode, root);
		  } 
	  }
  }
  
  public int size()
  {
	  if(empty())
		  return 0;
	  else 	  
		  return root.getSize(root);
  }
  
  public int height()
  {
	  if(empty())
		  return -1;
	  else
	      return root.getHeight(root)-1;
  }
  
 
}