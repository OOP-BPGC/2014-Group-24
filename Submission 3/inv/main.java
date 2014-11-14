package inv;
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Inventory i = new Inventory();
	
		
		System.out.println(i.borrows("a","BasketBall",2));
		
		System.out.println(i.borrows("a","Football",2));
		
		System.out.println(i.returns("a","Football",1));
		System.out.println(i.returns("a","Football",2));
		System.out.println(i.returns("a","Football",1));
		
		
		System.out.println(i.borrows("a","Basketasdasd",2));
		
		i.addEquipment("Basketasdasd", 5);
		
		System.out.println(i.borrows("a","Basketasdasd",2));

	}

}
