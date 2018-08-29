package A6_Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class DiGraph implements DiGraph_Interface {

  // in here go all your data and methods for the graph
  // and the topo sort operation
	HashMap<String, Node> NodeMap = new HashMap<String, Node>();  //key:label, value: Node
	HashSet<Long> NodeId = new HashSet<Long>();//store all nodes' id
	HashSet<Long> EdgeId = new HashSet<Long>();//store all edges' id

  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
  }
  
  // rest of your code to implement the various operations
  
  public boolean addNode(long idNum, String label)
  {
	  if(idNum<0 || label==null)
		  return false;
	  else if(NodeMap.containsKey(label)==false && NodeId.contains(idNum)==false)
	  {
		  Node newNode = new Node(idNum,label);
		  NodeMap.put(label, newNode);
		  NodeId.add(idNum);
		  return true;
	  }
	  else
		  return false;
		 		  
  }
  
  public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel)
  {
	  if(idNum<0 || EdgeId.contains(idNum)==true)
		  return false;
	  else if(NodeMap.containsKey(sLabel)==false || NodeMap.containsKey(dLabel)==false)
		  return false;
	  else 
	  {
		  Node sourceNode = NodeMap.get(sLabel);
		  Node destiNode  = NodeMap.get(dLabel);
		  if(sourceNode.Out_Edge.containsKey(dLabel) && destiNode.In_Edge.containsKey(sLabel))
			  return false;
		  else //add edge
		  {
			  Edge newEdge = new Edge(idNum,sLabel,dLabel,weight,eLabel);
			  EdgeId.add(idNum);
			  sourceNode.Out_Edge.put(dLabel, newEdge);
			  destiNode.In_Edge.put(sLabel, newEdge);
			  destiNode.in_degree+=1;
			  return true;
		  }
		 
	  }
  }
  
//  public boolean delNode(String label)
//  {
//	  if(NodeMap.containsKey(label)==false)
//		  return false;
//	  else
//	  {
//		  Node remNode = NodeMap.get(label);
//		  NodeMap.remove(label,remNode);
//		  NodeId.remove(remNode.idNum);
//		  for(Node node:NodeMap.values())
//		  {
//			  if(node.In_Edge.containsKey(label))
//			  {
//				  EdgeId.remove(node.In_Edge.get(label).idNum);
//				  node.In_Edge.remove(label);
//				  node.in_degree-=1;
//			  }
//			  if(node.Out_Edge.containsKey(label))
//			  {
//				  EdgeId.remove(node.Out_Edge.get(label).idNum);
//				  node.Out_Edge.remove(label);	  
//			  }
//	
//		  }
//		  return true;  
//	  }	 
//  }

public boolean delNode(String label)
{
	  if(NodeMap.containsKey(label)==false)
		  return false;
	  else
	  {
		  Node remNode = NodeMap.get(label);
		
		  Iterator<String> InEdge_sL = remNode.In_Edge.keySet().iterator();
		  Iterator<String> OutEdge_dL = remNode.Out_Edge.keySet().iterator();
		  
		  while(InEdge_sL.hasNext())
			  delEdge(InEdge_sL.next(),remNode.Label);
		  while(OutEdge_dL.hasNext()) 			
			  delEdge(remNode.Label,OutEdge_dL.next());
		  
		  NodeMap.remove(label,remNode);
		  NodeId.remove(remNode.idNum);
		  return true;
	  }
}
  
  
  public boolean delEdge(String sLabel, String dLabel)
  {
	  if(NodeMap.containsKey(sLabel)==false || NodeMap.containsKey(dLabel)==false)
		  return false;
	  else 
	  {
		  Node sourceNode = NodeMap.get(sLabel);
		  Node destiNode = NodeMap.get(dLabel);
		  if(sourceNode.Out_Edge.containsKey(dLabel))
		  {
			  Edge remEdge = NodeMap.get(sLabel).Out_Edge.get(dLabel);
			  sourceNode.Out_Edge.remove(dLabel,remEdge);
		      destiNode.In_Edge.remove(sLabel,remEdge);
		      destiNode.in_degree-=1;  
			  EdgeId.remove(remEdge.idNum);
			  return true;
		  }
		  return false;
	  }
  }
  
  public long numNodes()
  {
    return NodeId.size();
  }
  
  public long numEdges()
  {
    return EdgeId.size();
  }

//  public String[] topoSort()
//  {
//	  int size = NodeId.size();
//	  String[] topoSort = new String[size];
//	  int i = 0;
//	  int k = 0;
//	  while(NodeMap.isEmpty()!=true)
//	  {	 
//		  for(Node node:NodeMap.values())
//		  {
//			  if(node.in_degree==0)
//			  {
//				  topoSort[i]=node.Label;
//				  delNode(node.Label);
//				  i++;
//				  break;
//			  }			 
//		  }  
//		  if(topoSort[k]==null)
//			  return null;
//		  k++;
//	  }
//		  return topoSort;	
//  }
  
   public String[] topoSort()
   {
	   Queue<Node> Zero_In_Node=new LinkedList<Node>();
	   if(NodeMap.isEmpty())
		   return null;

	   ArrayList<String> topoString = new ArrayList<String>();
	   for(Node node:NodeMap.values())
	   {
		   if(node.in_degree==0 )
			   Zero_In_Node.add(node);
	   }
	  
	   while(Zero_In_Node.isEmpty()==false)
	   {
		   Node deqNode = Zero_In_Node.poll();		   
		   topoString.add(deqNode.Label);
		   Iterator<Edge> OutEdge = deqNode.Out_Edge.values().iterator();
			while(OutEdge.hasNext()) 
			{			
				Node destiNode = NodeMap.get(OutEdge.next().destiL);
				destiNode.in_degree-=1;
				if(destiNode.in_degree ==0 ) {
					Zero_In_Node.add(destiNode);
				}
			}	   
	   }
	
	   if(NodeMap.size()==topoString.size())
		   return topoString.toArray( new String[topoString.size()]);
	   else
		   return null; 
   }
  
   public ShortestPathInfo[] shortestPath(String label)
   {
	   int size = NodeId.size();
	   ShortestPathInfo[] sp = new ShortestPathInfo[size];
	   MinBinHeap PQ= new MinBinHeap();
	   EntryPair sNode = new EntryPair(label,0);
	   PQ.insert(sNode);
	   sp[0]= new ShortestPathInfo(label,0);
	   int i = 0;
	   while(PQ.size()!=0)
	   {
		   Node currNode = NodeMap.get(PQ.getMin().value);
		   long currDist = PQ.getMin().priority;
		   //System.out.println("currNode:"+currNode.Label+"   dist:"+currDist);	   
		   PQ.delMin();
		   if(currNode.flag==1)//known
			   continue;
		   else
		   {
			   sp[i]= new ShortestPathInfo(currNode.Label,currDist);
			   //System.out.println("currNode:"+currNode.Label+"   dist:"+currDist);	  
			   currNode.flag=1;
		   }
		   Iterator<Edge> adjNode = currNode.Out_Edge.values().iterator();//adjacent nodes
		   while(adjNode.hasNext())
		   {
			   Node aNode = NodeMap.get(adjNode.next().destiL);
			   if(aNode.flag==0)//unknown Node
			   {
				   long newDist = currDist+currNode.Out_Edge.get(aNode.Label).weight;
				   if(aNode.dist==0 || aNode.dist>newDist)
				   {
					   aNode.dist = newDist;
					   EntryPair a = new EntryPair(aNode.Label,aNode.dist);
					   PQ.insert(a);
				   }
				 
			   }
		   }	
		   i++;
	   }
	   
	   if(i<size)//set unreachable nodes' dist to -1
	   {
		   for(Node node:NodeMap.values())
		   {
			   if(node.flag==0)//unknown(unreachable)
			   {
				   node.dist=-1;
				   sp[i] = new ShortestPathInfo(node.Label,node.dist);
				   //System.out.println("currNode:"+node.Label+"   dist:"+node.dist);	 
				   i++;
			   }
			   
		   }
	   }	  
	  
	   return sp;
   }
}