package MockClasses;
import junit.framework.TestCase;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;


public class TestEvent extends TestCase {
	private Event mockEvent;
	public void setUp() throws Exception {
		mockEvent = createNiceMock(Event.class);
		}
public void TestSchedule(){
	try{
		mockEvent.schedule(null,null);
	fail("Exception should have occured");
	}
	catch(Exception e){
		
	}
	mockEvent.schedule(2,{2,5,5});
	}


public void TestSetSportName(String a){
	mockEvent.set_sport_name("Cricket");
}

public void TestSetListOfTeams(array a){
	mockEvent.set_list_of_teams({"RMS","BITS","IIT"});
}

public String TestGetNameOfSport(){
	expect(mockEvent.get_name_of_sport()).andReturn("Cricket");
	replay(mockEvent);
	assertEquals("Cricket",mockEvent.get_name_of_sport());
	verify(mockEvent);
}
public array TestGetListOfTeams(){
	expect(mockEvent.get_list_of_teams()).andReturn({"RMS","BITS","IIT"});
	replay(mockEvent);
	assertEquals({"RMS","BITS","IIT"},mockEvent.get_list_of_teams());
	verify(mockEvent);
}


}