package spree;
import java.util.Scanner;

public class Event extends Team{

	String name_of_sport;
	String[] list_of_teams =new String[50];
	

public void set_sport_name(String name){
	this.name_of_sport = name;
	
}
public void set_list_of_teams(String list[]){
	this.list_of_teams=list;
	
}

public String get_name_of_sport(){
	
	return this.name_of_sport;
}

public String[] get_list_of_teams(){
	
	return this.list_of_teams;
}

		public void set_schedule(int number_of_teams, String list_of_teams[]){

			 
			Scanner in = new Scanner(System.in);
			 System.out.println("The  teams participating are : ");  // shows the teams entered
			 
			 for(int i=0;i<number_of_teams;i++)
			 {
				 System.out.println(list_of_teams[i]);
			 }
			    
			 System.out.println("enter seeds of teams if a team doesnt have a seed then type null and continue: ");
			 
			 String[] seeds = new String[number_of_teams];
			 
			 for(int i=0;i<number_of_teams;i++) // takes seeds for entered teams
			 {
				 System.out.println("seed of team " + list_of_teams[i]);
				 
				 
				 seeds[i] = in.nextLine();
				 
				 while(!seeds[i].equals("1")  && !seeds[i].equals("2") && !seeds[i].equals("3") && 
						 !seeds[i].equals("4") && !seeds[i].equals("null") )		 
				    {							
					 System.out.println("invalid input please re-enter");				 
					 seeds[i] = in.nextLine();
					 }
			 	 
			
			 }
				 
			 
	 System.out.println("The seeded teams are : "); // prints the entered teams which have seeds
			 
			 for(int i=0;i<number_of_teams;i++)
			 {
				 if(seeds[i].equals("null"))
				 {}
				 else if(seeds[i].equals("1") || seeds[i].equals("2") || seeds[i].equals("3") || seeds[i].equals("4") )
				 System.out.println(list_of_teams[i] + " "+ seeds[i]);
				 
				 
			
		}
			 
			 //System.out.println("Enter 1 for knock out type schedule or 2 for pool type schedule");
			 
			 int b = in.nextInt();
			 
			 if(b==1){
				 
				 int k = number_of_teams/4;
				 int j = number_of_teams%4; 
				 int g1=k;
				 int g2=k;
				 int g3=k;
				 int g4=k;
				 
				 if(j==1)              // deciding group size if entered number is not a multiple of 4
					g1= g1+1;
				 
				 if(j==2)
				 {g1=g1+1;
				 g2=g2+1;}
				 
				 if(j==3)
				 {
					 g1=g1+1;
					 g2=g2+1;
					 g3=g3+1;
				 }
					 
				 String[] group_1 = new String[g1];
				 String[] group_2 = new String[g2];
				 String[] group_3 = new String[g3];
				 String[] group_4 = new String[g4];
		
				 
				 for(int i=0;i<number_of_teams;i++)  // assigning seeded teams first to groups
					 {
					 if(seeds[i].equals("1"))
					 {  group_1[0] = list_of_teams[i];
					 list_of_teams[i]="empty";				 				 
					 }
				     if(seeds[i].equals("2"))
				     {   group_2[0] = list_of_teams[i];
				     list_of_teams[i]="empty";}
			     	 if(seeds[i].equals("3"))
			     	 {   group_3[0] = list_of_teams[i];
			     	list_of_teams[i]="empty";}
			    	 if(seeds[i].equals("4"))
			 	        {group_4[0] = list_of_teams[i];
			 	       list_of_teams[i]="empty";}

					 }

				 int p=1,dd=0;           
				 for (int i = 0; i < number_of_teams; i++)   // assigning teams to group 1
				 {    
					if (list_of_teams[i].equals("empty"))
					dd++;
					
										
						else if(p<g1)
							{group_1[p]=list_of_teams[i];
							list_of_teams[i]="empty";
							p++;}
						
					}
				 
				 int q=1;
				 for (int i = 0; i < number_of_teams; i++) { // assigning teams to group 2
					if (list_of_teams[i].equals("empty"))
					dd++;
					
										
						else if(q<g2)
						{  
							{group_2[q]=list_of_teams[i];
							list_of_teams[i]="empty";
							q++;}
							
						}
						
					}
					
				 int x=1;
				 for (int i = 0; i < number_of_teams; i++) {  // assigning teams to group 3
					if (list_of_teams[i].equals("empty"))
					dd++;
					
										
						else if(x<g3)
						{  
							{group_3[x]=list_of_teams[i];
							x++;
							list_of_teams[i]="empty";}
							
						}
						
					}
					
					
				 int z=1;
				 for (int i = 0; i < number_of_teams; i++) {  // assigning teams to group 4
					if (list_of_teams[i].equals("empty"))
					dd++;
					
										
						else if(z<g4)
						{  
							{group_4[z]=list_of_teams[i];
							z++;
							list_of_teams[i]="empty";}
							
						}
						
					}
					
				 for(int i =0;i<g1;i++)   // prints the teams in different groups
						System.out.println("Group 1 : " + group_1[i]);
				 
				 for(int i =0;i<g2;i++)
						System.out.println("Group 2 : " + group_2[i]);
				 
			
				
				for(int i =0;i<g3;i++)
					System.out.println("Group 3 : " + group_3[i]);
				
				for(int i =0;i<g4;i++)
					System.out.println("Group 4 : " + group_4[i]);
				
				
				
				System.out.println("Pool A consists of Group 1 and Group 3");
				System.out.println("Pool B consists of Group 2 and Group 4");
				
				
				System.out.println("\t\tPool A ");   // prints the matches in Pool A which consists of group 1 and group 3
				int time = 800;
				int day=1;
				for(int i=0;i<g1 && time <= 2100;i++)
					{for(int zz=0;zz<g3;zz++,time=time+100){
				{if(time>2100)
					{day++;
					time=800;}
					if(time<1000)				
				System.out.println(group_1[i] + " vs " + group_3[zz] + " at " + "0"+ time + " hours on day " + day);
				else
					System.out.println(group_1[i] + " vs " + group_3[zz] + " at " + time + " hours on day " + day);
				
				}}}
				 
			 
			
			 System.out.println("\t\tPool B ");        // prints the matches in Pool A which consists of group 2 and group 4
				 //time = 800;
				for(int i=0;i<g2 && time <= 2100;i++)
					{for(int zz=0;zz<g4;zz++,time=time+100){
						{if(time>2100)
						{day++;
						time=800;}
				if(time<1000)
				System.out.println(group_2[i] + " vs " + group_4[zz] + " at " + "0"+ time + " hours on day " + day);
				else
					System.out.println(group_2[i] + " vs " + group_4[zz] + " at " + time + " hours on day " + day);
				
				}}}
				 
				System.out.println("\t\tQuarter Finals ");
				if(time<=2100)
				{System.out.println("Quarter-Final 1 : Group 1 winner vs Group 4 runner up at " + time +" hours on day " + day);
				time = time+100;}
				else {day++;
				time=800;}
				if(time<=2100)
				{System.out.println("Quarter-Final 2 Group 1 runner up vs Group 4 winner at " + time +" hours on day " + day);
				time = time+100;}
				else {day++;
				time=800;}
				if(time<=2100)
				{System.out.println("Quarter-Final 3 Group 2 winner vs Group 3 runner up at " + time +" hours on day " + day);
				time = time+100;}
				else {day++;
				time=800;}
				if(time<=2100)
				{System.out.println("Quarter-Final 4 Group 2 runner up vs Group 3 winner at " + time +" hours on day " + day);
				time = time+100;}
				else {day++;
				time=800;}
				
				
				System.out.println("\t\tSemi Finals ");
				if(time<=2100)
				{System.out.println("Semi-Final 1 : Quarter-Final 1 winner vs Quarter-Final 4 winner at " + time +" hours on day " + day);
				time = time+100;}
				else {day++;
				time=800;}
				if(time<=2100)
				{System.out.println("Semi-Final 2 : Quarter-Final 2 winner vs Quarter-Final 3 winner at " + time +" hours on day " + day);
				time = time+100;}
				else {day++;
				time=800;}
				
				
				System.out.println("\t\t Finals ");
				System.out.println("Semi-Final 1 winner vs Semi-Final 2  winner at " + time +" hours on day " + day);
				
			 }


	}






	}
		
		
		

		
		

		
		


	
	
	
	
	
	

