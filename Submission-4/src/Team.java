package spree;

import java.sql.*;
import java.util.Scanner;
import spree.Player;

public class Team 
{
	int no_of_players;
	String eventname;
	int seeding;
	String team_name;
	String college_name;
        public Team()
        {
            this.no_of_players=0;
            this.eventname=null;
            this.seeding=0;
            this.team_name=null;
            this.college_name=null;
        }
	public void set_Team(Player player)
        {
            System.out.println("Are you part of a team?");
            String team;
            Scanner sc=new Scanner(System.in);
            team=sc.nextLine();
            if(team.equals("YES"))
            {
                System.out.println("Enter the event you're participating in:");
                this.set_event_name(sc.nextLine());
                System.out.println("Enter your team name");
                this.set_team_name(sc.nextLine());
                System.out.println("Enter the nuber of players in your team: ");
                this.set_no_of_players(sc.nextInt());
                this.set_college_name(player.get_college());
                //BY DEFAULT, SEEDING IS ZERO FOR ALL
                this.seeding=0;
                //Seeding is decided according to the manager 
                //Open the connection and enter these values 
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
                query = " insert into TEAM (NO_OF_PLAYERS,EVENT, SEEDING, TEAM_NAME, COLLEGE_NAME, PLAYER_NAME)" + " values (?, ?, ?, ?, ?, ?)";
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt     (1, this.get_no_of_players());
                preparedStmt.setString  (2, this.get_event_name());
                preparedStmt.setInt     (3, this.get_seeding());
                preparedStmt.setString  (4, this.get_team_name());
                preparedStmt.setString  (5, this.get_college_name());
                preparedStmt.setString  (6, player.get_name());
                preparedStmt.execute();
                String check;
                System.out.println("Enter more players? ");                
                check=sc.nextLine();
                while(check.equals("YES"))
                {
                   if(check.equals("YES"))
                        {
                        System.out.println("Enter the player name: ");
                        String player_name=sc.nextLine();
                        preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setInt     (1, this.get_no_of_players());
                        preparedStmt.setString  (2, this.get_event_name());
                        preparedStmt.setInt     (3, this.get_seeding());
                        preparedStmt.setString  (4, this.get_team_name());
                        preparedStmt.setString  (5, this.get_college_name());
                        preparedStmt.setString  (6, player_name);
                        // execute the preparedstatement
                        preparedStmt.execute();
                        }
                    System.out.println("Enter more players? ");                
                    check=sc.nextLine();
                }
                conn.close();
        }
            catch (Exception e)
            {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }
            
            
        }
	
	public void set_no_of_players(int a)
	{
		this.no_of_players = a;
		
	}
	
	public 	void set_event_name(String a)
	{
		this.eventname =  a;
	}
	
	public 	void set_team_name(String a)
	{
		this.team_name = a;
                
	}
	
	public 	void set_college_name(String a)
	{
		this.college_name = a;
	}
	
	public String get_event_name()
	{
		return this.eventname;
	}
	
	public String get_team_name()
	{
		return this.team_name;
	}
	
	public String get_college_name()
	{
		return this.college_name;
	}
	
	public void set_seeding(int a)
	{
		this.seeding = a;
	}
	
	public int get_seeding()
	{
		return this.seeding;
	}
        
        public int get_no_of_players()
	{
		return this.no_of_players;
	}
}
