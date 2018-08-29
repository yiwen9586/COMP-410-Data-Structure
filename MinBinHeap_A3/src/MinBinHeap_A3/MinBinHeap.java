package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }

@Override
public void insert(EntryPair entry) {
	// TODO Auto-generated method stub
	int hole=size+1;
	while(hole>1)
	{
		if(array[hole/2].priority<entry.priority)
		{
			array[hole]=entry;
			break;
		}
		else 
		{
			array[hole]=array[hole/2];
			hole=hole/2;
		}
	}
	array[hole]=entry;
	size++;
}

@Override
public void delMin() {
	// TODO Auto-generated method stub
	int hole=1;
	int m = 0;
	int s = size;
	if(s>0)//operate if size > 0
	{
	EntryPair temp = new EntryPair(null,0);
	temp=array[s];  //Save out last element
    array[s]=null;
    size--;
	while(hole<s)
	{
		if(array[2*hole]==null&&array[2*hole+1]==null)//has no child
		{
			array[hole]=temp;
			break;
		}
		
		else if(array[2*hole]!=null&&array[2*hole+1]==null)//has one child, means it has left child only
		{	
			if(array[2*hole].priority<temp.priority)
			{
				array[hole]=array[2*hole];
			    array[2*hole]=temp;
			    break;
			}
			else
			{
				array[hole]=temp;
				break;
			}
			
		}//end one child
				
		else //has two child
		{
			if (array[2*hole].priority<array[2*hole+1].priority)
				m=2*hole;
			else
				m=2*hole+1;
			if(array[m].priority<temp.priority)
			{
				array[hole]=array[m];
				hole=m;
			}
			else
			{
				array[hole]=temp;
				break;
			}
		}//end two child
	}
	
	}//end if size > 0	
}

@Override
public EntryPair getMin() {
	// TODO Auto-generated method stub
	if(size()==0)
		return null;
	else
		return array[1];
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}

public void sortArray(int hole)
{
	if(array[2*hole]!=null&&array[2*hole+1]==null)//has one child, means it has left child only
	{
		if(array[2*hole].priority<array[hole].priority)//need swap
			swap(2*hole,hole);
	}
	else//has two child
	{
		if(array[2*hole].priority<array[2*hole+1].priority)
		{
			if(array[2*hole].priority<array[hole].priority)
				swap(2*hole,hole);
		}		
		else
		{
			if(array[2*hole+1].priority<array[hole].priority)
			    swap(2*hole+1,hole);
		}
	}
}

public void swap(int hole1, int hole2)
{
	EntryPair temp = new EntryPair(null,0);
	temp=array[hole1];
	array[hole1]=array[hole2];
	array[hole2]=temp;
}

@Override
public void build(EntryPair[] entries) {
	// TODO Auto-generated method stub
	    int s = entries.length;
		for(int i=0;i<s;i++)
			array[i+1]=entries[i];
		size=s;
		int hole=s/2;//parent of the last array item
		
		//check up
		while(hole>=1)
		{
			sortArray(hole);
			hole=hole-1;
		}
		
		//now hole=0
		hole=2;
		//check down
		while(hole<=s/2)
		{
		    sortArray(hole);		
			hole=hole+1;
		}		
		
}
}
