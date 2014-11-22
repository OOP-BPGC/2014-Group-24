package inv;
import java.util.*;


public class Inventory {
	
	Map<String, Integer> theMap = new HashMap<String, Integer>();
	Map<String, ArrayList<String>> borrower = new HashMap<String, ArrayList<String>>();
	
	public Inventory(){
	
		ArrayList<String> al = new ArrayList<String>();
		al.add(null);
		

	theMap.put("BasketBall", 100);
	theMap.put("Football", 90);
	theMap.put("Water", 92);
	theMap.put("Tennisball", 98);
	
	
	borrower.put("BasketBall", al);
	borrower.put("Football", al);
	borrower.put("Water", al);
	borrower.put("Tennisball", al);
	}

	/**
	 * storing the id number and borrowing the equipment from the inventory
	 * @param String id, String s, int i
	 * @return boolean k
	 */
public boolean borrows (String id, String s, int i){
	boolean k = false;
	int size;
	
	ArrayList<String> al = new ArrayList<String>();
	
	if(theMap.containsKey(s)){
		
		al.addAll(borrower.get(s));
		size = al.isEmpty()?0:al.size();
		
		if (size + i <= theMap.get(s)){
			for (int j=0; j<i; j++)
				al.add(id);
		borrower.remove(s);
		borrower.put(s, al);
		k=true;
		}
		
		
	}
	
	

	
	return k;
	
}

/**
 * removing the id number and returning the equipment from the inventory
 * @param String id, String s, int i
 * @return String k
 */
public String returns(String id, String s, int i){
	
	String k = "error";
	
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al1 = new ArrayList<String>();
	al.addAll(borrower.get(s));
	al1.addAll(borrower.get(s));
	int p=0;
	while (al1.contains(id)){
		al1.remove(id);
	p++;
	}
		if(al.contains(id)&&i<=p){
		for (int j=0; j<i; j++)
				al.remove(id);
		borrower.remove(s);
		borrower.put(s, al);
		k= "removed";
		}return k;
}

public void addEquipment(String s, int i){
	
	ArrayList<String> al = new ArrayList<String>();
	al.add(null);
	theMap.put(s, i);
	borrower.put(s, al);
	
}
}
