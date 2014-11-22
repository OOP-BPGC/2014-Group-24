import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class EventManager {
	
	String Event;
	String Name;
	String ID;
	String LoginStatus;

	public EventManager(String event, String name, String ID){
		this.Event = event;
		this.ID = ID;
		this.Name = name;
	}
	
	public String Login(String username, String password) throws IOException{
		String k = "Login Failed";
		String[] Username = new String[100];
		String[] Password = new String[100];
		int i=0;
		String sCurrentLine;
		
		BufferedReader br = new BufferedReader(new FileReader("E:\\workspace\\event manager\\bin\\login.txt"));
		
		while ((sCurrentLine = br.readLine()) != null) {


            String[] information = sCurrentLine.split(",");
            Username[i] = information[0];
            Password[i] = information[1];
            i++;
            
		}
		
		for(int j=0; j<i; j++){
			if(username.equals(Username[i]) && password.equals(Password[i])){
				k="logged in";
				break;
			}
		}
		this.LoginStatus =k;
		return k;
		
	}
	
	private void deletePlayer(String name)
        {
	if (this.LoginStatus.equals("Logged in"))
            {
                try
                {
                    // create a mysql database connection
                    String myDriver = "org.gjt.mm.mysql.Driver";
                    String myUrl = "jdbc:mysql://localhost:3306/test";
                    String password = "/\\ySQL";
                    Class.forName(myDriver);
                    Connection conn = DriverManager.getConnection(myUrl, "root", password);
                    //CREATE DATABASE QUERRY HERE. DELETE THE ROW HAVING THE TEAM NAME THAT IS INPUT IN THE ARGUEMENTS OF THE METHOD
                    // the mysql insert statement
                    String query = "use SPREE";
                    PreparedStatement initialStmt = conn.prepareStatement(query);
                    initialStmt.execute();
                    query = "DELETE FROM TEAM WHERE TEAM NAME = ?;";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString   (1, name);
                    preparedStmt.execute();
                    conn.close();
                }
                catch(Exception e)
                {
                    System.out.println("ERROR");
                }
                
        }
        else
	{
		System.out.println("You are not Logged in");
	}
		
	}
}
