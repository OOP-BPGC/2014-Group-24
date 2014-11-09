package MockClasses;
import junit.framework.TestCase;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;



public class TestPlayer extends TestCase {


private Player MckPlayer;
public void setUp(){
MckPlayer=createNiceMock(Player.class);
}
public void TestSetPriority(int a){
	mockEvent.set_priority(2);
}


public void TestSetRegistration(boolean a){
	mockEvent.set_registration(true);
}


public void TestSetPayment(boolean a){
	mockEvent.set_payment(true);
}


public void TestSetName(String a){
	mockEvent.set_name("OOP");
}


public void TestSetSpreeID(String a){
	mockEvent.set_spreID("OOP123");
}


public void TestSetAccomodation(boolean a){
	mockEvent.set_accomodation(true);
}


public void TestSetCollege(String a){
	mockEvent.set_college("RMS");
}

public boolean TestGetAccomodation(){
	expect(MckPlayer.get_accomodation()).andReturn(true);
	replay(MckPlayer);
	assertEquals(true,MckPlayer.get_accomodation());
	verify(MckPlayer);
}


public String TestGetCollege(){
	expect(MckPlayer.get_college()).andReturn("RMS");
	replay(MckPlayer);
	assertEquals("RMS",MckPlayer.get_college());
	verify(MckPlayer);
}


public String TestGetName(){
	expect(MckPlayer.get_name()).andReturn("OOP");
	replay(MckPlayer);
	assertEquals("OOP",MckPlayer.get_name());
	verify(MckPlayer);
}


public boolean TestGetRegistration(){
	expect(MckPlayer.get_registration()).andReturn(true);
	replay(MckPlayer);
	assertEquals(true,MckPlayer.get_registration());
	verify(MckPlayer);
}


public boolean TestGetPayment(){
	expect(MckPlayer.get_payment()).andReturn(true);
	replay(MckPlayer);
	assertEquals(true,MckPlayer.get_payment());
	verify(MckPlayer);
}


public int TestGetPriority(){
	expect(MckPlayer.get_priority()).andReturn(2);
	replay(MckPlayer);
	assertEquals(2,MckPlayer.get_priority());
	verify(MckPlayer);
}

}
