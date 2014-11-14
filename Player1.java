import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player1{
	String gender;
	boolean contingent;
	int priority;
	String name;
	String spreeID;
	String college;
	boolean registration,payment,accomodation;
	
	public void set_priority(String g, boolean c){
		if(g.equals("F")&& !c)
		{
			priority = 1;
			
		}
		if(g.equals("F")&& c)
		{
			priority = 2;
			
		}
		if(g.equals("M")&& c)
		{
			priority = 3;
			
		}
		if(g.equals("M")&& !c)
		{
			priority = 4;
			
		}
		
	}
	public int get_priority()
	{
			return priority;	
	}
	
	public void set_name(String a)
	{
		this.name=a;
		
	}
	public void set_spreeID(String a)
	{
		
		Pattern p= Pattern.compile("A-Z{3}0-9{3}");
		Matcher m = p.matcher(a);
		boolean foundmatch = m.find();
		if(foundmatch)
		{  
			this.spreeID=a;
		}
		else
		{
			System.out.println("Invalid spree ID. Set the valid spreeID");
			
		}
		
	}
	public void set_college(String a)
	{
		this.college =a;
		
	}
	public void set_accomodation()
	{
		if(priority==1)
		{
			
		}
		else if (priority==2)
		{
			
		}
	}
	public void set_registration()
	{
		
	}
	public void set_payment()
	{
		
	}
	public String get_name()
	{
		return this.name;
	}
	public String get_college()
	{
		return this.college;
	}
	public String get_spreeID()
	{
		return this.spreeID;
	}
	public boolean get_payment()
	{
		return this.payment;
				
	}
	public boolean get_registration()
	{
		return this.registration;
				
	}
	public boolean get_accomodation()
	{
		return this.accomodation;
				
	}



public static void main(String[] args)
{
	
	Player1 one = new Player1();
	one.set_name("ABC");
	System.out.println(one.get_name());
	one.set_college("XYZ");
	System.out.println(one.get_college());
	one.set_spreeID("kndsn");
	System.out.println(one.get_spreeID());
	
	
	
}
}
