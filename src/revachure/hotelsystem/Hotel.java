package revachure.hotelsystem;
import java.sql.*;
import java.util.Scanner;
public class Hotel {
	public static void main(String[] args) throws Exception{
		    //createCredentials();
	        selectRoom();
		}	
	public static  void selectRoom(){
		Connection con=null;
		try {
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employ","Jagadishk","Sriram@33");
		String sql="INSERT INTO hotel2 (ID,PASSWARD,TYPEOFROOM,ROOMCOST,NUMBEROFDAYS,TOTALCOST)VALUES(?,?,?,?,?,?)";
		Scanner sc =new Scanner(System.in);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("******** WELCOME FOR BOOKING PROCESS  ********");
		System.out.print("Enter  Your ID: ");
		String id=sc.next();
		System.out.print("Enter  Your PASSWORD: ");
		String passWord=sc.next();
     	System.out.println("---------------------------------------------------------------------------------------------------------------------");
     	System.out.println(" ``````````````WElCOME TO JKHOTEL```````````" );
     	System.out.println("\n                           press 1 for NormalRomm    perday-1000     \n                (Facilities: TELEVISION ");
     	System.out.println("\n                           press 2 for Deluxe        perday-2000      \n                (Facilities:AirConditionar,TELEVISION ) ");
     	System.out.println("\n                           press 3 for SuperDelxue   perday-3000      \n                (Facilities:AirConditionar, TELEVISION , HotWater )");
     	System.out.println("\n                           press 4 for ExcutiveRoom  perday-3500     \n                 (Facilities:AirConditionar, TELEVISION , HotWater,BATHTUB)\n" );
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
			                 roomCost=2000;
			                 choice='n';
			                 break;
		               case '3':
			                 System.out.println("your selected SuperDelxue\n");
			                 typeOfRoom ="SuperDelxue";
			                 roomCost=3000;
			                 choice='n';
			                 break;
		               case '4':
			                  System.out.println("your selected ExcutiveRooms\n");
			                  typeOfRoom  ="ExcutiveRooms";
			                  roomCost=3500;
			                  choice='n';
			                  break;
		               default:
			                   System.out.println ("Choose  Valid option :");
		               }//switch
		       
		}
		while( choice !='n');
		System.out.print("Choose NUMBEROFDAYS You Want:");
		int  numberOfDays =sc.nextInt();
		int totalCost  =numberOfDays *roomCost;
		PreparedStatement mystmt = con.prepareStatement(sql);
		System.out.println("Total Cost: "+totalCost+"\n");
		mystmt.setString(1,id);
		mystmt.setString(2,passWord);
		mystmt.setString(3,typeOfRoom);
		mystmt.setInt(4,roomCost);
		mystmt.setInt(5,numberOfDays);
		mystmt.setInt(6,totalCost);
		
		mystmt.executeUpdate();
		sc.close();
		System.out.println("Your Booking is Done! ");
     	System.out.println("-------------------------------------------------------------------------------------------------------------------------");

		}//TryEnd
		catch(Exception e) {}
		finally {
			try {
			if(con!=null) {con.close();}
			else {System.out.println("Connection failed");}}
			catch(Exception e){System.out.println("Errorr");}
			
		}//finally
	}
}