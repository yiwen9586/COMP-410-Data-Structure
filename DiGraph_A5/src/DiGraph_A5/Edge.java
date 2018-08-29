package DiGraph_A5;

public class Edge {
	  String sourceL;
	  String destiL;
	  String Elabel;
	  long idNum;
	  long weight;
	  
	  public Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel)
	  {
		this.idNum=idNum;
	    this.sourceL = sLabel;
	    this.destiL = dLabel;
	    this.weight = weight;
	    this.Elabel = eLabel;
	  }
	  
	  public String getSourceL()
	  {
	    return this.sourceL;
	  }
	  
	  public void setSourceL(String sourceL)
	  {
	    this.sourceL = sourceL;
	  }
	  
	  public String getDestL()
	  {
	    return this.destiL;
	  }
	  
	  public void setDestL(String destiL)
	  {
	    this.destiL = destiL;
	  }
	  
	  public String getELabel()
	  {
	    return this.Elabel;
	  }
	  
	  public void setELabel(String elabel)
	  {
	    this.Elabel = elabel;
	  }
	  
	  public long getEId()
	  {
	    return this.idNum;
	  }
	  
	  public void setEId(long idNum)
	  {
	    this.idNum = idNum;
	  }
	  
	  public long getWeight()
	  {
	    return this.weight;
	  }
	  
	  public void setWeight(long weight)
	  {
	    this.weight = weight;
	  }
	
}
