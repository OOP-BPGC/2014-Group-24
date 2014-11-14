
public class Team extends Player
{
	int no_of_players;
	String eventname;
	int seeding;
	String teamname;
	String college_name;
	Player[] list_of_players;
	
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
		this.teamname =  a;
	}
	
	public 	void set_college_name(String a)
	{
		this.college_name =  a;
	}
	
	public 	void set_players(Player[] a)
	{
		int i;
		for(i=0; i<this.no_of_players; i++)
		{
			this.list_of_players[i] = a[i];
		}
	}
	
	public String get_event_name()
	{
		return this.eventname;
	}
	
	public String get_team_name()
	{
		return this.teamname;
	}
	
	public String get_college_name()
	{
		return this.college_name;
	}
	
	public Player[] get_event_name()
	{
		return this.list_of_players;
	}
	
	public void set_seeding(int a)
	{
		this.seeding = a;
	}
	
	public int get_seeding()
	{
		return this.seeding;
	}
}
