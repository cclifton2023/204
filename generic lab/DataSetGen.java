public class DataSetGen <G extends Measurable>
{
	private double sum;
	private G maximum;
	private int count;
	
	public DataSetGen()
	{
	    sum = 0;
	    count = 0;
	    maximum = null;
	}
	
	public void add(G x)
	{
	    sum = sum + x.getMeasure();
	    if (count == 0 || maximum.getMeasure() < x.getMeasure())
	    	maximum = x;
	    count++;
	}
	public double getAverage()
	{
	    if (count == 0) 
		return 0;
	    else 
	    	return sum / count;
	}
	public G getMaximum()
	{ 
	    return maximum;
	}
}

