package Ques43;

class BombBlast extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BombBlast(String msg) {
		super(msg);
	}
	
}

public class WalkingBoy {
	
	int stepSize;
	int blockSize;
	
	WalkingBoy(int stepSize, int blockSize)
	{
		this.blockSize = blockSize;
		this.stepSize = stepSize;
	}
	

	public String targetHit(String platform) throws Exception{
		
		int len = platform.length();
		// int i=0;
		 String[] block = new String[10] ;
		 String[] step = new String[10];
		 int j=0;
		 int m=0;
		 int temp = len %blockSize;
		 int quotient = len - temp; 
		
		 for(int i=0;i<quotient;i=i+blockSize)
		 {
			block[j] = platform.substring(i,i+blockSize);
			
			j=j+1;
		 }
		 block[j]= platform.substring(quotient, len); 
		// System.out.println("j="+j);
		 /*
		 for(int k=0; k<=j;k++)
		{
		System.out.println(block[k]);
		}
		*/
		
		
		 
		 for (m =0 ; m<j;m++)
		 {
			 step[m] = block[m].substring(0,stepSize);
			 
		 }
		 int k = m;
		 step[k] = block[k].substring(0,block[k].length());
		 /*
		 for (m =0 ; m<=k;m++)
		 {
			
			 System.out.println(step[m]);
		 }
		 */
		 for( m=0; m<=j ;m++)
			{
			
			if(block[m].contains("x")) {
				throw new BombBlast("You hit the target");
			}
			
			}
		 return "win";
		 
			
		
	}
	
	public static void main(String[] args) throws Exception {
		WalkingBoy boy = new WalkingBoy(2,3);
		try {
		System.out.println("BombBlast :"+boy.targetHit("1212121x212"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
