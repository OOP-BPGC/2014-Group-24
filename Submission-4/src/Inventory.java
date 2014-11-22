package spree;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;


public class Inventory 
{
	Map<String, Integer> theMap = new HashMap<String, Integer>();
	Map<String, ArrayList<String>> borrower = new HashMap<String, ArrayList<String>>();
	
	public Inventory()
            {
                ArrayList<String> al = new ArrayList<String>();
		al.add(null);
                theMap.put("BasketBall", 100);
                theMap.put("Football", 90);
                theMap.put("Water", 92);
                theMap.put("Tennisball", 98);
                borrower.put("BasketBall", al);
                borrower.put("Football", al);
                borrower.put("Water", al);
                borrower.put("TennisBall", al);
            }

	
        public boolean borrows(String id, int BASKETBALLS, int FOOTBALLS, int WATER, int TENNIS_BALLS)
        /**
	 * Storing the ID number and the equipment from the party borrowing the equipment
	 * @param String ID Gets the ID of the person borrowing the equipment
         * @param String s
         * @param int i
	 * @return boolean k
	 */    
                
        {
            boolean borrowed = false;
            int size;
            ArrayList<String> al = new ArrayList<String>();
            String[] names = {"BASKETBALLS","FOOTBALLS","WATER","TENNIS_BALLS"};
            String equipment_name;
            int[] quantity_borrowed={BASKETBALLS,FOOTBALLS,WATER,TENNIS_BALLS};
            for(int i=0;i<4;i++)
            {
                equipment_name=names[i];
                if(theMap.containsKey(equipment_name))
                    {
                        al.addAll(borrower.get(equipment_name));
                        size = al.isEmpty()?0:al.size();
                        if (size + quantity_borrowed[i] <= theMap.get(equipment_name))
                            {
                            for (int j=0; j<quantity_borrowed[i]; j++)
                                al.add(id);
                            borrower.remove(equipment_name);
                            borrower.put(equipment_name, al);
                            borrowed=true;
                            }
                    }
            }
            try
            {
                // create a mysql database connection
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/test";
                String password = "/\\ySQL";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "root", password);
                // the mysql insert statement
                String query = "use SPREE;";
                PreparedStatement initialStmt = conn.prepareStatement(query);
                initialStmt.execute();
                query="insert into Inventory VALUES (?,?,?,?,?);";
                PreparedStatement executeStmt = conn.prepareStatement(query);
                executeStmt.setInt      (1, BASKETBALLS);
                executeStmt.setInt      (2, FOOTBALLS);
                executeStmt.setInt      (3, WATER);
                executeStmt.setInt      (4, TENNIS_BALLS);
                executeStmt.setString   (5, id);
                executeStmt.execute();
                conn.close();
            }
            catch (Exception e)
            {
                System.out.println("System failure");
                e.printStackTrace();
                //conn.close();
            }
            return borrowed;
        }

        /**
         * Removing the ID number and returning the equipment from the inventory
         * @param String ID 
         * @param String equipment_name
         * @param int quantity_borrowed
         * @return String k
         */
        public String returns(String ID, String equipment_name, int quantity_borrowed)
        {
            String k = "ERROR";
            ArrayList<String> al = new ArrayList<String>();
            ArrayList<String> al1 = new ArrayList<String>();
            al.addAll(borrower.get(equipment_name));
            al1.addAll(borrower.get(equipment_name));
            int p=0;
            while (al1.contains(ID))
                {
                al1.remove(ID);
                p++;
                }
            if(al.contains(ID) && quantity_borrowed<=p)
                {
		for (int j=0; j<quantity_borrowed; j++)
                    al.remove(ID);
		borrower.remove(equipment_name);
		borrower.put(equipment_name, al);
		k="Your Equipment has been removed, please wait...";
		}
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
                    query="UPDATE Inventory SET BASKETBALLS=?, FOOTBALLS=?, WATER=?, TENNIS_BALLS=? WHERE SPREEID=?;";
                    PreparedStatement executeStmt = conn.prepareStatement(query);
                    executeStmt.setInt      (1, 0);
                    executeStmt.setInt      (2, 0);
                    executeStmt.setInt      (3, 0);
                    executeStmt.setInt      (4, 0);
                    executeStmt.setString   (5, ID);
                    executeStmt.execute();
                    conn.close();
            }
            catch (Exception e)
            {
                System.out.println("System failure; run for your life. ");
                e.printStackTrace();
                //conn.close();
            }
        return k;
        }

        public void addEquipment(String equipment_name, int quantity_borrowed)
            {
            ArrayList<String> al = new ArrayList<String>();
            al.add(null);
            theMap.put(equipment_name, quantity_borrowed);
            borrower.put(equipment_name, al);
            }
}
