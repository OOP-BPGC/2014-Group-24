package spree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player{
	String gender;
	boolean contingent;
	int priority;
	String name;
	String spreeID;
	String college;
	boolean registration,payment,accomodation;
	
	public void set_priority(String g, boolean c)
	/**
	 * Sets the priority for the candidates applying for accomodation on campus. Female candidates
	 * travelling alone are given top priority (#1), teams comprising of only women are given #2,
	 * male contestants without a contingent are given priority #3 and all others ae given the 
	 * least priority (#4). 
	 * @param String gender, boolean contingent
	 * @author Group_24
	 * @return void
	 */
	{
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
	/**
	 * Returns the priority number of the player. 
	 * @param none
	 * @author Group_24
	 * @return int priority_number
	 */
	{
		return priority;	
	}
	
	public void set_name(String a)
	/**
	 * Sets the name of the player. 
	 * @param String name_player
	 * @author Group_24
	 * @return void
	 */
	{
		this.name=a;
		
	}
	public void set_spreeID(String a)
	/**
	 * Sets the SPREE ID of the player. 
	 * @param String name_contestant
	 * @author Group_24
	 * @return void
	 */
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
	/**
	 * Sets the college name of the player. 
	 * @param String name_college
	 * @author Group_24
	 * @return void
	 */
	
	{
		this.college =a;
		
	}
	public void set_accomodation()		
	/**
	 * Essentially prints a message to the console if the accomodation status is returned as 
	 * a success. Additional functionalities include writing the data to an external database
	 * as well entering the payment details. 
	 * @param none
	 * @author Group_24
	 * @return void
	 */
	{
		if(this.get_priority()==1)
		{
			this.set_payment();
				if (this.get_payment()==true)
				{
					System.out.println("Payment Successful");
					//Update database : update_database_check_payment
					//Update database : update_database_set_accomodation
				}
				else
				{
					System.out.println("Problem Encountered");
					//Return an error
				}
				
		}
		else if(this.get_priority()==2)
		{
			this.set_payment();
				if (this.get_payment()==true)
				{
					System.out.println("Payment Successful");
					//Update database : update_database_check_payment
					//Update database : update_database_set_accomodation
				}
				else
				{
					System.out.println("Problem Encountered");
					//Return an error
				}
		}
		else if(this.get_priority()==3)
		{
			this.set_payment();
				if (this.get_payment()==true)
				{
					System.out.println("Payment Successful");
					//Update database : update_database_check_payment
					//Update database : update_database_set_accomodation
				}
				else
				{
					System.out.println("Problem Encountered");
					//Return an error
				}
		}
		else 
		{
			this.set_payment();
				if (this.get_payment()==true)
				{
					System.out.println("Payment Successful");
					//Update database : update_database_check_payment
					//Update database : update_database_set_accomodation
				}
				else
				{
					System.out.println("Problem Encountered");
					//Return an error
				}
		}
		
	}
	
	public void set_registration()
	/**
	* Registers the contestant for the competition
	* @param none
	* @author Group_24
	* @return void
	*/
	{
		//Update database : update_database_set_registration
	}
	public void set_payment()
	/**
	* Deals with the payment of a contestant for the competition
	* @param none
	* @author Group_24
	* @return void
	*/
	{
		//Update database : update_database_set_payment
	}
	public String get_name()
	/**
	 * Returns the name of the player. 
	 * @param none
	 * @author Group_24
	 * @return String name
	 */
	{
		return this.name;
	}
	public String get_college()
	/**
	 * Returns the college of the player. 
	 * @param none
	 * @author Group_24
	 * @return String college_name
	 */
	{
		return this.college;
	}
	public String get_spreeID()
	/**
	 * Returns the SPREE ID of the player. 
	 * @param none
	 * @author Group_24
	 * @return String SPREE_ID
	 */
	{
		return this.spreeID;
	}
	public boolean get_payment()
	/**
	 * Returns the payment status of the player. 
	 * @param none
	 * @author Group_24
	 * @return boolean payment_status
	 */
	{
		return this.payment;
				
	}
	public boolean get_registration()
	/**
	 * Returns the registration status of the player. 
	 * @param none
	 * @author Group_24
	 * @return boolean registration_status
	 */
	{
		return this.registration;
				
	}
	public boolean get_accomodation()
	/**
	 * Returns the accomodation status of the player. 
	 * @param none
	 * @author Group_24
	 * @return boolean accomodation_status
	 */
	{
		return this.accomodation;
				
	}

}
