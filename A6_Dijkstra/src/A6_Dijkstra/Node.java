package A6_Dijkstra;

import java.util.HashMap;

public class Node
{
	long idNum;
	String Label;
	HashMap<String, Edge> In_Edge;//string:sourcelabel
	HashMap<String, Edge> Out_Edge;//string:destilabel
	int in_degree;
	long dist;//min dist from start node
	int flag;//indicate whether the node is known or not
	
  
  
  public Node(long idNum, String label)
  {
    this.idNum = idNum;
    this.Label = label;
    this.In_Edge = new HashMap();
    this.Out_Edge = new HashMap();
    this.in_degree = 0;
    this.flag=0;
  }
  
  public String getLabel()
  {
    return this.Label;
  }
  
  public long getID()
  {
    return this.idNum;
  }
  
  public String toString()
  {
	  return "Node: id: "+this.idNum+"  lable:"+this.Label;
  }
}
