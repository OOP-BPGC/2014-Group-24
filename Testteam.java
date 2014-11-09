package MockClasses;
import junit.framework.TestCase;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;



public class TestTeam extends TestCase {


private Team MckTeam;
public void setUp(){
MckTeam=createNiceMock(Team.class);
}
public void TestSetNoOfPlayers(int a){
	mockEvent.set_no_of_players(2);
}

public void TestSetEventName(String a){
	mockEvent.set_event_name("RMS");
}

public void TestSetTeamName(String a){
	mockEvent.set_team_name("RMS");
}

public void TestSetCollegeName(String a){
	mockEvent.set_college_name("RMS");
}

public void TestSetPlayers(array a){
	mockEvent.set_players({"RMS","BITS","IIT"});
}


public void TestSetSeedng(int a){
	mockEvent.set_seeding(2);
}


public String TestGetEventName(){
	expect(MckTeam.get_event_name()).andReturn("RMS");
	replay(MckTeam);
	assertEquals("RMS",MckTeam.get_event_name());
	verify(MckTeam);
}

public String TestGetCollegeName(){
	expect(MckTeam.get_college_name()).andReturn("RMS");
	replay(MckTeam);
	assertEquals("RMS",MckTeam.get_college_name());
	verify(MckTeam);
}


public String TestGetTeamName(){
	expect(MckTeam.get_team_name()).andReturn("RMS");
	replay(MckTeam);
	assertEquals("RMS",MckTeam.get_team_name());
	verify(MckTeam);
}


public int TestGetNoOfPlayers(){
	expect(MckTeam.get_no_of_players()).andReturn(2);
	replay(MckTeam);
	assertEquals(2,MckTeam.get_no_of_players());
	verify(MckTeam);
}

public int TestGetSeeding(){
	expect(MckTeam.get_seeding()).andReturn(2);
	replay(MckTeam);
	assertEquals(2,MckTeam.get_seeding());
	verify(MckTeam);
}

public array TestPlayers(){
	expect(MckTeam.get_players()).andReturn({"RMS","BITS","IIT"});
	replay(MckTeam);
	assertEquals({"RMS","BITS","IIT"},MckTeam.get_players());
	verify(MckTeam);
}


}
