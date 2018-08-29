package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
    exTest();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
//      d.addNode(1, "f");
//      d.addNode(3, "s");
//      d.addNode(7, "t");
//      d.addNode(0, "fo");
//      d.addNode(4, "fi");
//      d.addNode(6, "si");
//      d.addEdge(0, "f", "s", 0, null);
//      d.addEdge(1, "f", "si", 0, null);
//      d.addEdge(2, "s", "t", 0, null);
//      d.addEdge(3, "fo", "fi", 0, null);
//      d.addEdge(4, "fi", "si", 0, null);
//      d.addNode(0, "a");
//      d.addNode(1, "b");
//      d.addNode(2, "c");
//      d.addNode(3, "d");
//      System.out.println("numEdges: "+d.numEdges());
//      System.out.println("numNodes: "+d.numNodes());
//      d.addEdge(0, "a", "b", 0, null);
//      d.addEdge(1, "c", "a", 0, null);
//      d.addEdge(2, "d", "c", 0, null);
//      System.out.println("numEdges: "+d.numEdges());
//      System.out.println("numNodes: "+d.numNodes());
//      d.delNode("a");
//      System.out.println("numEdges: "+d.numEdges());
//      System.out.println("numNodes: "+d.numNodes());
//      d.addEdge(1, "b", "c", 0, null);
//      d.addEdge(2, "a", "d", 0, null);
//      d.addEdge(3,"d","c",0,null);
//      d.addNode(1, "p");
//      d.addNode(4, "a");
//      d.addNode(3, "g");
//      d.addNode(2, "e");
//      d.addEdge(0, "p", "a",0,null);
//      d.addEdge(1, "a", "g",0,null);
//      d.addEdge(2, "g", "e",0,null);
//      d.addEdge(3, "e", "p",0,null);
      d.addNode(0, "1");
      d.addNode(1, "2");
      d.addNode(2, "3");
      d.addNode(3, "4");
      d.addNode(4, "5");
      d.addNode(5, "6");
      d.addNode(6, "7");
      d.addNode(7, "8");
      d.addEdge(0, "1", "3", 0, null);
      d.addEdge(1, "3", "5", 0, null);
      d.addEdge(2, "1", "5", 0, null);
      d.addEdge(3, "6", "8", 0, null);
      d.addEdge(4, "6", "2", 0, null);
      d.addEdge(5, "8", "7", 0, null);
      d.addEdge(6, "7", "4", 0, null);
      d.addEdge(7, "2", "4", 0, null);
 //     d.addEdge(8, "4", "8", 0, null);
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
      printTOPO(d.topoSort());
  
      
    }
    public static void printTOPO(String[] toPrint){
      System.out.print("TOPO Sort: ");
      for (String string : toPrint) {
      System.out.print(string+" ");
    }
      System.out.println();
    }

}