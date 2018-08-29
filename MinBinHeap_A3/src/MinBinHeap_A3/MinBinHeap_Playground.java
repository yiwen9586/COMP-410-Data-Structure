package MinBinHeap_A3;

public class MinBinHeap_Playground {
  public static void main(String[] args){   
    //Add more tests as methods and call them here!!
    TestBuild();
  }
  
  public static void TestBuild(){ 
    // constructs a new minbinheap, constructs an array of EntryPair, 
    // passes it into build function. Then print collection and heap.
    MinBinHeap mbh= new MinBinHeap();
    EntryPair[] collection= new EntryPair[5];
    collection[0]=new EntryPair("i",3);
    collection[1]=new EntryPair("b",2);
    collection[2]=new EntryPair("c",1);
    collection[3]=new EntryPair("d",0);
    collection[4]=new EntryPair("e",46);
//    collection[5]=new EntryPair("f",5);
//    collection[6]=new EntryPair("g",6);
//    collection[7]=new EntryPair("h",17);
//    collection[0]=new EntryPair("a",5);
//    collection[1]=new EntryPair("b",4);
//    collection[2]=new EntryPair("c",3);
//    collection[3]=new EntryPair("d",2);
//    collection[4]=new EntryPair("e",1);
   // collection[5]=new EntryPair("f",3);
//    collection[6]=new EntryPair("g",9);
//    collection[7]=new EntryPair("h",31);
//    collection[8]=new EntryPair("i",18);
//    collection[9]=new EntryPair("j",21);
//    collection[10]=new EntryPair("k",12);
//    collection[11]=new EntryPair("l",13);
 
//    mbh.insert(collection[0]);
//    mbh.insert(collection[1]);
//    mbh.insert(collection[2]);
//    mbh.insert(collection[3]);
//    mbh.insert(collection[4]);
//    mbh.insert(collection[5]);
//    mbh.insert(collection[6]);
//    mbh.insert(collection[7]);
//    mbh.insert(collection[8]);
//    mbh.insert(collection[9]);
//    mbh.insert(collection[10]);
//    mbh.insert(collection[11]);

   
    mbh.build(collection);
    System.out.println(mbh.size());
  mbh.delMin();
  System.out.println(mbh.size());
    printHeap(mbh.getHeap(), mbh.size());
    mbh.delMin();
    System.out.println(mbh.size());
    printHeap(mbh.getHeap(), mbh.size());
  //  mbh.delMin();
    mbh.insert(new EntryPair("l",4));
    System.out.println(mbh.size());
    printHeap(mbh.getHeap(), mbh.size());
    mbh.delMin();
    System.out.println(mbh.size());
    printHeap(mbh.getHeap(), mbh.size());
    System.out.println( mbh.getMin().value+ mbh.getMin().priority);
    mbh.delMin();
    System.out.println(mbh.size());
    printHeap(mbh.getHeap(), mbh.size());
    mbh.delMin();
    System.out.println(mbh.size());
    printHeap(mbh.getHeap(), mbh.size());
    mbh.delMin();
    System.out.println(mbh.size());
    printHeap(mbh.getHeap(), mbh.size());
  //  printHeapCollection(collection);
   
  }
  
  public static void printHeapCollection(EntryPair[] e) { 
    //this will print the entirety of an array of entry pairs you will pass 
    //to your build function.
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=0;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
}
