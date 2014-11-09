package MockClasses;
import junit.framework.TestCase;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;



public class TestInventory extends TestCase {


private Inventory MckInventory;
public void setUp(){
MckInventory=createNiceMock(Inventory.class);
}
public void TestReturn(String a){
	mockInventory.return("This Is Spree");
}

public String TestBorrow(){
	expect(MckInventory.borrow()).andReturn("This Is Spree");
	replay(MckInventory);
	assertEquals("This Is Spree",MckInventory.borrow());
	verify(MckInventory);
}





}
