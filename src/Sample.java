import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
public class Sample {
	public static void main(String[] args) throws Exception{
		    //createCredentials();
	        selectRoom();
		}	
	public static  void selectRoom(){
		Connection con=null;
		try {
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMPLOY","Jgadishk","Sriram@33");
		String sql="INSERT INTO MANAGEMENT(ID,PASSWORD,TYPEOFROOM,Roomcost,CHECKINDATE,NUMBEROFDAYS,CHECKOUTDATE,TOTALCOST)VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement mystmt = con.prepareStatement(sql);
		Scanner sc =new Scanner(System.in);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("******** WELCOME FOR BOOKING PROCESS   ********");
		System.out.println("                       PLEASE VERIFY YOUR ID:                                 ");
		System.out.print("Enter  Your ID: ");
		String id=sc.next();
		System.out.print("Enter  Your PASSWORD: ");
		String passWord=sc.next();
     	System.out.println("---------------------------------------------------------------------------------------------------------------------");
     	System.out.println(" ######$$$$$$$$$$$$$$$              WElCOME FOR ROOM SELECTION                   $$$$$$$$$$$$$$$$$####################");
     	System.out.println("\n                           press 1 for NormalRomm    perday-1000     \n                (Facilities:FAN, TELEVISION ");
     	System.out.println("\n                           press 2 for Deluxe        perday-1500      \n                (Facilities:AirConditionar,TELEVISION , HotWater) ");
     	System.out.println("\n                           press 3 for SuperDelxue   perday-2000      \n                (Facilities:AirConditionar, TELEVISION , HotWater )");
     	System.out.println("\n                           press 4 for ExcutiveRoom  perday-2500     \n                 (Facilities:AirConditionar, TELEVISION , HotWater)\n" );
		System.out.print("Choose your option:");
		int roomCost=0;
		String  typeOfRoom  ="";
		char  choice;
		do
		{
		 choice=sc.next().charAt(0);
		       switch(choice) {
		               case '1':
			                 System.out.println( "your selected NormalRoom\n");
			                 typeOfRoom  = "NormalRoom";
			                 roomCost=1000;	
			                 choice='n';
			                 break;
		               case '2':
			                 System.out.println( "your selected Deluxe\n");
			                 typeOfRoom  ="Deluxe";
			                 roomCost=1500;
			                 choice='n';
			                 break;
		               case '3':
			                 System.out.println("your selected SuperDelxue\n");
			                 typeOfRoom ="SuperDelxue";
			                 roomCost=2000;
			                 choice='n';
			                 break;
		               case '4':
			                  System.out.println("your selected ExcutiveRooms\n");
			                  typeOfRoom  ="ExcutiveRooms";
			                  roomCost=2500;
			                  choice='n';
			                  break;
		               default:
			                   System.out.println ("Choose  Valid option :");
		               }//switch
		       
		}
		while( choice !='n');
		//LocalDateTime checkindate= LocalDateTime.now();
		//System.out.println("checkindate"+checkindate);
		System.out.print("Choose NUMBEROFDAYS You Want:\n");
		int  numberOfDays =sc.nextInt();
		//LocalDateTime checkoutDate =checkindate .plusDays(numberOfDays);
		//System.out.println("CheckoutDay"+checkoutDate);
		int cos=sc.nextInt(); 
		int totalCost  =numberOfDays *roomCost;
		System.out.println("Total Cost: "+totalCost+"\n");
		mystmt.setString(1, id );
		mystmt.setString(2, passWord );
		mystmt.setString(3,typeOfRoom);
		mystmt.setInt(4, roomCost);
		//mystmt.set(5,checkindate );
		mystmt.setInt(6, numberOfDays );
		//mystmt.setString(7, checkoutDate );
		mystmt.setInt(8, totalCost );
		
		System.out.println("all data is loaded\n");
		mystmt.executeUpdate();
     	System.out.println("-------------------------------------------------------------------------------------------------------------------------");

		}//TryEnd
		catch(Exception e) {System.out.println("Error");}
		finally {
			try {
			if(con!=null) {con.close();}
			else {System.out.println("Connection failed");}}
			catch(Exception e){System.out.println("Errorr");}
			
		}//finally
	}}