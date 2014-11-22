package spree;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Player
{
	String gender;
	boolean contingent;
	int priority;
	String name;
	static String spreeID;
        String password;                            
	String college;
	boolean registration,payment,accomodation;
	
        public Player()
        {
            System.out.println("Enter your name");
            Scanner sc= new Scanner(System.in);
            String parameter=sc.nextLine();
            this.set_name(parameter);
            System.out.println("Enter your gender");
            parameter=sc.nextLine();
            this.set_gender(parameter);
            System.out.println("Are you with a contingent? Answer YES or NO");
            parameter=sc.nextLine();
            if (parameter=="YES")
                {
                this.set_contingent(true);
                }
            else
            {
                this.set_contingent(false);
            }
            System.out.println("Enter your SPREEID: ");
            parameter=sc.nextLine();
            boolean valid_id=false;
            while(valid_id==false)
                valid_id=this.set_spreeID(parameter);
            System.out.println("Your SPREE ID is: " + this.get_spreeID() + ". Preserve it carefully as it will be used to handle all transactions.");
            System.out.println("In case of misuse of the SPREEID, the campus will not be held responsible.");
            System.out.println("Enter your password ");
            parameter=sc.nextLine();
            this.set_password(parameter);
            System.out.println("Enter your College");
            parameter=sc.nextLine();
            this.set_college(parameter);
            this.set_registration(true);
            this.set_priority(this.get_gender(), this.get_contingent());
            this.set_accomodation();
            try
            {
                // create a mysql database connection
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/test";
                String password = "/\\ySQL";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", password);
                // the mysql insert statement
                String query = "use SPREE";
                PreparedStatement initialStmt = conn.prepareStatement(query);
                initialStmt.execute();
                query = " insert into Player (GENDER, CONTINGENT, PRIORITY, NAME, SPREEID, PASSWORD, COLLEGE, REGISTRATION, PAYMENT,ACCOMODATION)" + " values (?,?,?, ?, ?, ?, ?, ?, ?, ?)";
 
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString   (1, this.get_gender());
                preparedStmt.setBoolean  (2, this.get_contingent());
                preparedStmt.setInt      (3, this.get_priority());
                preparedStmt.setString   (4, this.get_name());
                preparedStmt.setString   (5, this.get_spreeID());
                preparedStmt.setString   (6, this.get_password());
                preparedStmt.setString   (7, this.get_college());
                preparedStmt.setBoolean  (8, true);
                preparedStmt.setBoolean  (9, this.get_payment());
                preparedStmt.setBoolean  (10, false);
 
                // execute the preparedstatement
                preparedStmt.execute();
                conn.close();
        }
            catch (Exception e)
            {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        
        }
	public void set_priority(String g, boolean c)
	/**
	 * Sets the priority for the candidates applying for accommodation on campus. Female candidates
	 * traveling alone are given top priority (#1), teams comprising of only women are given #2,
	 * male contestants without a contingent are given priority #3 and all others as given the 
	 * least priority (#4). 
	 * @param String gender, boolean contingent
	 * @author Group_24
	 * @return void
	 */
	{
		if(g.equals("female")&& !c)
		{
			priority = 1;
			
		}
		if(g.equals("female")&& c)
		{
			priority = 2;
			
		}
		if(g.equals("male")&& c)
		{
			priority = 3;
			
		}
		if(g.equals("male")&& !c)
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
	public boolean set_spreeID(String a)
	/**
	 * Sets the SPREE ID of the player. 
	 * @param String name_contestant
	 * @author Group_24
	 * @return Boolean validation
	 */
	{
	try
        {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/test";
            String password = "/\\ySQL";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", password);
            // the mysql insert statement
            String query = "use SPREE";
            PreparedStatement initialStmt = conn.prepareStatement(query);
            initialStmt.execute();
            query="Select SPREEID from Player;";
            PreparedStatement executeStmt = conn.prepareStatement(query);
            executeStmt.execute();
            ResultSet rs = executeStmt.getResultSet();
            int flag=0;
            try 
            {
                while(rs.next())
                {
                    String spree_ID=rs.getString(1);
                    if (spree_ID.equals(a))
                    {
                        System.out.println("ID exists already, try another.");
                        flag=1;
                        break;
                    }
                }
                if (flag==0)
                {
                    this.spreeID=a;
                }
               
            }
            finally
            {
                rs.close();
                
            }
            conn.close();
        if (flag==1)
            return false;
        else if(flag==0)
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Error recieved");
            return false;
        }
    return false;
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
        public void set_gender(String a)
	/**
	 * Sets the gender of the player. 
	 * @param String gender
	 * @author Group_24
	 * @return void
	 */
	
	{
		this.gender =a;
		
	}
        public void set_contingent(Boolean a)
	/**
	 * Sets the contingent of the player. 
	 * @param boolean Contingent
	 * @author Group_24
	 * @return void
	 */
	
	{
		this.contingent=a;
		
	}
        
         public void set_password(String a)
	/**
	 * Sets the password of the player. 
	 * @param String password
	 * @author Group_24
	 * @return void
	 */
	
	{
		this.password=a;
		
	}
	public void set_accomodation()		
	/**
	 * Essentially prints a message to the console if the accommodation status is returned as 
	 * a success. Additional functionalities include writing the data to an external database
	 * as well entering the payment details. 
	 * @param none
	 * @author Group_24
	 * @return void
	 */
	{
            String SPREEID=this.get_spreeID();
            int priority=this.get_priority();
            switch(priority)
            {
                    case 1 :    this.set_payment();
                                if (this.get_payment()==true)
                                {
                                try
                                    {
                                    // create a mysql database connection
                                    String myDriver = "org.gjt.mm.mysql.Driver";
                                    String myUrl = "jdbc:mysql://localhost:3306/test";
                                    String password = "/\\ySQL";
                                    Class.forName(myDriver);
                                    Connection conn = DriverManager.getConnection(myUrl, "root", password);
                                    // the mysql insert statement
                                    String query = "use SPREE";
                                    PreparedStatement initialStmt = conn.prepareStatement(query);
                                    initialStmt.execute();
                                    query = "update Player set ACCOMODATION = 1 WHERE SPREEID = ?";
                                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                                    preparedStmt.setString(1, SPREEID);
                                    //execute the PreparedStatement
                                    preparedStmt.execute();
                                    conn.close();
                                    System.out.println("Your payment is successful and accomodation has been granted to you on campus");
                                    }
                                catch (Exception e)
                                    {
                                    System.err.println("Got an exception!");
                                    System.err.println(e.getMessage());
                                    }
                                 }
                                else
                                {
                                    System.out.println("Nope, sorry");
                                }   
                                break;
                    case 2 :    this.set_payment();
                                if (this.get_payment()==true)
                                {
                                System.out.println("Enter your SPREEID: ");
                                try
                                    {
                                    // create a mysql database connection
                                    String myDriver = "org.gjt.mm.mysql.Driver";
                                    String myUrl = "jdbc:mysql://localhost:3306/test";
                                    String password = "/\\ySQL";
                                    Class.forName(myDriver);
                                    Connection conn = DriverManager.getConnection(myUrl, "root", password);
                                    // the mysql insert statement
                                    String query = "use SPREE";
                                    PreparedStatement initialStmt = conn.prepareStatement(query);
                                    initialStmt.execute();
                                    query = "update Player set ACCOMODATION = 1 WHERE SPREEID = ?";
                                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                                    preparedStmt.setString(1, SPREEID);
                                    //execute the PreparedStatement
                                    preparedStmt.execute();
                                    conn.close();
                                    System.out.println("Your payment is successful and accomodation has been granted to you on campus");
                                    }
                                catch (Exception e)
                                    {
                                    System.err.println("Got an exception!");
                                    System.err.println(e.getMessage());
                                    }
                                 }
                                else
                                {
                                    System.out.println("Nope, sorry");
                                }   
                                break;
                case 3 :    this.set_payment();
                                if (this.get_payment()==true)
                                {
                                System.out.println("Enter your SPREEID: ");
                                try
                                    {
                                    // create a mysql database connection
                                    String myDriver = "org.gjt.mm.mysql.Driver";
                                    String myUrl = "jdbc:mysql://localhost:3306/test";
                                    String password = "/\\ySQL";
                                    Class.forName(myDriver);
                                    Connection conn = DriverManager.getConnection(myUrl, "root", password);
                                    // the mysql insert statement
                                    String query = "use SPREE";
                                    PreparedStatement initialStmt = conn.prepareStatement(query);
                                    initialStmt.execute();
                                    query = "update Player set ACCOMODATION = 1 WHERE SPREEID = ?";
                                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                                    preparedStmt.setString(1, SPREEID);
                                    //execute the PreparedStatement
                                    preparedStmt.execute();
                                    conn.close();
                                    System.out.println("Your payment is successful and accomodation has been granted to you on campus");
                                    }
                                catch (Exception e)
                                    {
                                    System.err.println("Got an exception!");
                                    System.err.println(e.getMessage());
                                    }
                                 }
                                else
                                {
                                    System.out.println("Nope, sorry");
                                }   
                                break;
                    case 4 :    this.set_payment();
                                if (this.get_payment()==true)
                                {
                                System.out.println("Enter your SPREEID: ");
                                try
                                    {
                                    // create a mysql database connection
                                    String myDriver = "org.gjt.mm.mysql.Driver";
                                    String myUrl = "jdbc:mysql://localhost:3306/test";
                                    String password = "/\\ySQL";
                                    Class.forName(myDriver);
                                    Connection conn = DriverManager.getConnection(myUrl, "root", password);
                                    // the mysql insert statement
                                    String query = "use SPREE";
                                    PreparedStatement initialStmt = conn.prepareStatement(query);
                                    initialStmt.execute();
                                    query = "update Player set ACCOMODATION = 1 WHERE SPREEID = ?";
                                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                                    preparedStmt.setString(1, SPREEID);
                                    //execute the PreparedStatement
                                    preparedStmt.execute();
                                    conn.close();
                                    System.out.println("Your payment is successful and accomodation has been granted to you on campus");
                                    }
                                catch (Exception e)
                                    {
                                    System.err.println("Got an exception!");
                                    System.err.println(e.getMessage());
                                    }
                                 }
                                else
                                {
                                    System.out.println("Nope, sorry");
                                }   
                                break;
                    default:    System.out.println("Sorry");
                                break;
            }
        }

	public void set_registration(Boolean a)
	/**
	* Registers the contestant for the competition
	* @param none
	* @author Group_24
	* @return void
	*/
	{
		this.registration=a;
	}
	public void set_payment()
	/**
	* Deals with the payment of a contestant for the competition. Asks the user if payment is to be done immediately,
        * or at the gate. Payment online is done through a secure server(redirection is not included in the function 
        * definition). Payment_Status of the candidate is then updated.
	* @param none
	* @author Group_24
	* @return void
	*/
	{
            String payment_reply, SPREEID;
            System.out.println("Would you like to pay now?");
            Scanner sc=new Scanner(System.in);
            payment_reply=sc.nextLine();
            if (payment_reply.equals("YES"))
            {
                System.out.println("Redirecting to secure server...");
                //function to check payment status
                SPREEID=this.get_spreeID();
                try
                {
                    // create a mysql database connection
                    String myDriver = "org.gjt.mm.mysql.Driver";
                    String myUrl = "jdbc:mysql://localhost:3306/test";
                    String password = "/\\ySQL";
                    Class.forName(myDriver);
                    Connection conn = DriverManager.getConnection(myUrl, "root", password);
                    // the mysql insert statement
                    String query = "use SPREE";
                    PreparedStatement initialStmt = conn.prepareStatement(query);
                    initialStmt.execute();
                    System.out.println("Enter you pasword: ");
                    String pass_ID=sc.nextLine();
                    query = "update Player set PAYMENT = 1 WHERE SPREEID = ? AND PASSWORD = ? ;";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, SPREEID);
                    preparedStmt.setString(2, pass_ID);
                    //execute the PreparedStatement
                    preparedStmt.execute();
                    this.payment=true;
                    conn.close();
                }
                catch (Exception e)
                {
                    System.err.println("Got an exception!");
                    System.err.println(e.getMessage());
                }
            }
            else
                {
                System.out.println("YOU WILL HAVE TO MAKE YOUR PAYMENT AT THE GATE");
                this.payment=false;
                }
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
        
        
	public String get_password()
	/**
	 * Returns the password of the player. 
	 * @param none
	 * @author Group_24
	 * @return String password
	 */
	{
		return this.password;
	}
        
        public Boolean get_contingent()
	/**
	 * Returns the contingent status of the player. 
	 * @param none
	 * @author Group_24
	 * @return Boolean CONTINGENT_STATUS
	 */
	{
		return this.contingent;
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
        
        public String get_college()
	/**
	 * Returns the college of the player. 
	 * @param none
	 * @author Group_24
	 * @return String SPREE_ID
	 */
	{
		return this.college;
	}
        
        public String get_gender()
	/**
	 * Returns the gender of the player. 
	 * @param none
	 * @author Group_24
	 * @return String Gender
	 */
	{
		return this.gender;
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
	 * Returns the accommodation status of the player. 
	 * @param none
	 * @author Group_24
	 * @return boolean accommodation_status
	 */
	{
		return this.accomodation;
				
	}

}
