package spree;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
	static int i=0;
	static int j=0;
	static int q=0;
    public boolean checkIDexists(String username, String pass)
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
            query="Select PASSWORD from Player where SPREEID=?";
            PreparedStatement executeStmt = conn.prepareStatement(query);
            executeStmt.setString   (1, username);
            executeStmt.execute();
            ResultSet rs = executeStmt.getResultSet();
            try 
            {
                while(rs.next())
                {
                    String password_ID=rs.getString(1);
                    if (pass.equals(password_ID))
                    {
                        System.out.println("Login successful");
                        return true;
                    }
                    else 
                    {
                        System.out.println("Login failed");
                        return false;
                    }
                }
            }
            finally
            {
                rs.close();
                
            }
            conn.close();
        
        }
        catch (Exception e)
        {
            
            System.out.println("Error received");
            return false;
        }
    return false;
    }
    
    public static void main(String[] args) throws IOException
    {
    	Main main_object = new Main();
    	
        Player[] parray = new Player[i];
        Team[] tarray = new Team[j];
        Event[] E = new Event[q];
        
        System.out.println("Welcome to Spree Registration");
        
        System.out.println("Enter 1 if you want to register yourself for SPREE");
        System.out.println("Enter 2 if you want to book your accommodation at bits goa");
        System.out.println("Enter 3 if you want to book your accommodation at bits goa");
        System.out.println("Enter 4 if you want to register your team (you need to enter your details before you do this)");
        System.out.println("Enter 5 to exit");
        
        
       Scanner in = new Scanner(System.in);
       int reply;
       
       reply = in.nextInt();
       while(reply !=5){
       if(reply == 1)
       {	String name;
       String details;
    	   System.out.println("Enter your name");
    	   name = in.nextLine();
    	   parray[i].set_name(name);
    	   String gender;
    	   System.out.println("Enter your gender, write either male or female");
    	   gender=in.nextLine();
    	   while(!gender.equals("male") || !gender.equals("female")){
    		   System.out.println("Please enter the gender properly");
    		   gender=in.nextLine();}
    		   
    	   parray[i].set_gender(gender);   
    	   
    	   String contingent;
    	   boolean k;
    	   System.out.println("Are you with a contingent?");
    	   contingent=in.nextLine();
    	   while(!contingent.equals("yes") || !contingent.equals("no")){
    		   System.out.println("Please enter your choice properly");
    		   
    		   contingent=in.nextLine();}
    	   if(contingent.equals("yes")){
    		   parray[i].set_contingent(true);
    		   k=true;}
    	   else  {parray[i].set_contingent(false);
    	   k=false;}
    	   
    	   
    	   System.out.println("Enter your college name");
    	   details=in.nextLine();    	   
    	   parray[i].set_college(details);

    	   parray[i].set_priority(gender,k);   	   
    	   parray[i].set_spreeID(name);  
    	   System.out.println("your SPREEID is " + parray[i].get_spreeID());
    	   
    	 // i++;
    	   
    	   
       }
       
       if(reply==2){
    	   parray[i].set_accomodation();
    	if(parray[i].get_accomodation())
    		 System.out.println("Based on your team and college your accomodation has been confirmed find out your room numbers at the gate");
    	else 	System.out.println("Sorry, accommodation is full in campus");
    	
    		i++;
       }
       
    if(reply==3)
    {
    	System.out.println("Enter the event you are managing");
    	String event = in.nextLine();
    	System.out.println("Enter your name");
    	String name2 = in.nextLine();
    	 EventManager em = new EventManager(event,name2);
    	 
    	 System.out.println("Enter your username");
    	 String username = in.nextLine();
    	 
    	 System.out.println("Enter your password");
    	 String password = in.nextLine();
    em.Login(username,password);
    
    System.out.println("to cancel a team's registration, enter the team's name or type null if you dont want to cancel");
    String answer = in.nextLine();
    if(!answer.equals("null"))
    em.deleteTeam(answer);
     
    System.out.println("to see the schedule of an event, enter the event's name");
    answer = in.nextLine();
  
    	  
    	if(reply == 4){
    		
    		tarray[j].set_Team(parray[i]); 
    		  int m=j;       
    		    String[] tnames = new String[m];
    		    for(int k =0;k<=j;k++){
    		    	tnames[k]=tarray[j].get_team_name();
    		    	
    		    }
    		    
    		    E[q].set_list_of_teams(tnames);//
    		
    		E[q].set_sport_name(tarray[j].get_event_name()) ;  
    		q++;
    		j++;
    		
    		
    	}
    	   
       
       
        
       }   
    }
    }}
