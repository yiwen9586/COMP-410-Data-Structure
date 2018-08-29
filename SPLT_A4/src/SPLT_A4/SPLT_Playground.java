package SPLT_A4;

public class SPLT_Playground {
  public static void main(String[] args){
    genTest();
  }
  
  public static void genTest(){
    SPLT tree= new SPLT();
    tree.insert("a");
    tree.insert("f");
    tree.insert("e");
    tree.insert("g");
    tree.insert("d");
    tree.insert("c");
    tree.insert("b");
//    tree.insert("d");
//    tree.insert("i");
//    tree.insert("b");
//    tree.insert("g");
//    tree.insert("f");
//    tree.insert("e");
//    tree.insert("h");
//    tree.insert("c");
//    tree.insert("j");
//    tree.insert("a");
//    tree.remove("e");
//    tree.remove("h");
//    tree.remove("a");
//    tree.remove("j");
    

//    tree.remove("a");
//    tree.remove("d");
//    tree.remove("c");
 //   tree.remove("e");
   
  //  tree.remove("a");
//    tree.insert("f");
//    tree.insert("a");
//    tree.insert("c");
//    tree.insert("e");
//    tree.insert("g");
//    tree.insert("h");
//    tree.insert("i");
 //   System.out.println("size is "+tree.size());    
  //  printLevelOrder(tree);
  //  tree.splay(tree.root.findNode(tree.root, "f"));
    System.out.println("root is:"+tree.root);
    System.out.println("size is "+tree.size());
    printLevelOrder(tree);
    printInOrder(tree.root);
    

  }

    static void printLevelOrder(SPLT tree){ 
    //will print your current tree in Level-Order...Requires a correct height method
    //https://en.wikipedia.org/wiki/Tree_traversal
      int h=tree.getRoot().getHeight(tree.getRoot());
      for(int i=0;i<=h;i++){
        System.out.print("Level "+i+":");
        printGivenLevel(tree.getRoot(), i);
        System.out.println();
      }
      
    }
    static void printGivenLevel(BST_Node root,int level){
      if(root==null)return;
      if(level==0)System.out.print(root.data+" ");
      else if(level>0){
        printGivenLevel(root.left,level-1);
        printGivenLevel(root.right,level-1);
      }
    }
   static void printInOrder(BST_Node root){
      if(root!=null){
      printInOrder(root.getLeft());
      System.out.print(root.getData()+" ");
      printInOrder(root.getRight());
      }
  }
  
}