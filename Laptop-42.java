package Ques42;

class Afford{
	
	
	
	public String checkConfiguration(Laptop laptop) throws Exception
	{
		if(laptop.price >70000)
		{
			throw new LaptopException("Price too high");
		}
		String[] detArr = laptop.details.split("/");
		int ram = Integer.parseInt(detArr[0]); 
		int storage = Integer.parseInt(detArr[1]);
		if(ram < 8) {
			throw new LaptopException("Minimum 8 RAM required");
		}
		if(storage < 256) {
			throw new LaptopException("Minimum 256 space required");
		}
		if(detArr[2].equals("HDD")) {
			throw new LaptopException("SSD required");
		}
		
		return "Can be purchased";
	
	}	
	
	public String purchaseLaptop(Laptop laptop) throws Exception{
		
		try {
			
		//String check = checkConfiguration(laptop);
		
		String check = checkConfiguration(laptop);
		if(check.equals("Can be purchased"));
		{
			
			return "Perfect Configuration";
		}
		}
		catch(LaptopException e)
		{
			return "Change Configuration";
		}
		
	catch(Exception e)
	{
		return "Other Exception";
	}
		
	
	}
	
}

class LaptopException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	LaptopException(String msg)
	{
		super(msg);
	}
}

public class Laptop {
	
	int price;
	String details;
	
	public Laptop(String details, int price) {
		this.details = details;
		this.price = price;
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Laptop laptop=new Laptop("8/256/SSD", 58000);
		Afford af=new Afford(); 
		try {
		String s=af.checkConfiguration(laptop);
		String t=af.purchaseLaptop(laptop);
		System.out.println(t.toLowerCase());
		System.out.println(s.toLowerCase());
		//System.out.println(t.toLowerCase());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}


	}

}
