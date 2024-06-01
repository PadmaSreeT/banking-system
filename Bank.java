package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Bank {

	public static void main(String[] args) throws IOException,SQLException {
		// TODO Auto-generated method stub
		System.out.println("ATM MACHINE:");
		int n=0;
		int c=0;
		int hi=0;
		int pp=0;
		int xx=0;
		int a=0;
		int enterpin;
		String depositt;
		int deposit=0;
		String phonenumber= "";
		String withdraww;
		int withdraw=0;
		String check;
		String transferr;
		int transfer=0;
		int balance1=0;
		String phonenumber2="";
		String name="";
		int age=0;
		String gender="";
		int reentered=0;
		int balance=0;
		int balance14=0;
		int deposit14=0;
		int balance13=0;
		System.out.println("DO YOU WANT TO DO ANY TRANSACTION??????");
		System.out.println("press enter or type 'no'");
		InputStreamReader a1 = new InputStreamReader(System.in);
	    BufferedReader b1=new BufferedReader(a1); 
	    String answer=b1.readLine();
	    if(answer.equals("no"))
	    {
	    	System.out.println("THANKYOU FOR VISITING");
	    }
	    else if (!answer.equals("no"))
	    { 
	    try
        {
		   Class.forName("com.mysql.cj.jdbc.Driver");
   	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb","root","313233");
   	   Statement st=con.createStatement();
   	   String query="create table if not exists bankdetails(s_no int auto_increment unique,phonenumber varchar(10),pin int(4),name varchar(20),age int,gender varchar(10),deposit int,withdraw int,balance int,transferedamount int,transferedto varchar(20),receivedfrom varchar(20),receviedamount int,primary key(phonenumber))";
		   st.executeUpdate(query);
		   String query440="create table if not exists transactionhistory(s_no int auto_increment unique,dateoftransaction date, phonenumber varchar(10),deposited int,withdraw int,receivedfrom varchar(10),receivedamount int,transferedamount int,transferedto varchar(10))";
		   st.executeLargeUpdate(query440);
		for (int i=1;i>n;i++)
		{
			if (xx==0)
			{
				System.out.println("1.CREATE ACCOUNT:");
				System.out.println("2.LOGIN ACCOUNT:");
				System.out.println("3.EXIT:");
		System.out.println("Enter Your Choice:");
		InputStreamReader a2=new InputStreamReader(System.in);
		BufferedReader b2=new BufferedReader(a2);
		 a=Integer.parseInt(b2.readLine());
		 if(a==1)
		{
	    	System.out.println("Enter Your Phone Number for creating account:");
			InputStreamReader a3 = new InputStreamReader(System.in);
			BufferedReader b3=new BufferedReader(a3); 
		    phonenumber=b3.readLine();
			System.out.println("Create Pin:");
			System.out.println("pin consists of 4 characters");
			InputStreamReader a4=new InputStreamReader(System.in);			
			BufferedReader b4=new BufferedReader(a4);
			c=Integer.parseInt(b4.readLine());
			System.out.println("re-enter Pin:");
			System.out.println("pin consists of 4 characters");
			InputStreamReader a20=new InputStreamReader(System.in);			
			BufferedReader b20=new BufferedReader(a20);
			reentered=Integer.parseInt(b20.readLine());
			System.out.println("Enter Your name:");
			InputStreamReader a17= new InputStreamReader(System.in);
			BufferedReader b17=new BufferedReader(a17); 
		    name=b17.readLine();
		    System.out.println("age:");
			InputStreamReader a18 = new InputStreamReader(System.in);
			BufferedReader b18=new BufferedReader(a18); 
		    age=Integer.parseInt(b18.readLine());
		    System.out.println("gender:");
			InputStreamReader a19 = new InputStreamReader(System.in);
			BufferedReader b19=new BufferedReader(a19); 
		    gender=b19.readLine();
			int length=phonenumber.length();
			int length1=String.valueOf(c).length();
			if (length==10 && length1==4 && c==reentered)
			{
				System.out.println("ACCOUNT CREATED SUCCESSFULLY");
				String query1="insert into bankdetails(phonenumber,pin,name,age,gender) values(?,?,?,?,?)";
				   PreparedStatement pt=con.prepareStatement(query1);
				   pt.setString(1,phonenumber);
				   pt.setInt(2,c);
				   pt.setString(3,name);
				   pt.setInt(4,age);
				   pt.setString(5,gender);
				   int rowsaffecteed=pt.executeUpdate();
				   if(rowsaffecteed>0) 
				   {
					   System.out.println("inserted!!!!!");
					  xx=1;	   
					  pp=1;
			}else
			{
				System.out.println("not inserted!!!!!");
				xx=0;
				pp=0;
			}
		}
			else
			{
				System.out.println("wrong details!!!!");
				xx=0;
				pp=0;
			}
		}
		 else if(a==2)
        	   {
        		   System.out.println("then enter your phonenumber for logging into your account:");
        		   InputStreamReader a6=new InputStreamReader(System.in);
            	   BufferedReader b6=new BufferedReader(a6);
            	    phonenumber=b6.readLine();
        		   System.out.println("enter pin");
        		   InputStreamReader a7=new InputStreamReader(System.in);
            	   BufferedReader b7=new BufferedReader(a7);
            	   enterpin=Integer.parseInt(b7.readLine());
            		   String query2="(SELECT * from bankdetails where phonenumber=? AND pin=?)"; 
            		   PreparedStatement bb=con.prepareStatement(query2);
					  bb.setString(1,phonenumber);
					   bb.setInt(2,enterpin);
					   ResultSet bbb=bb.executeQuery();
					   if (bbb.next())
					   {
						   System.out.println("you have logged in!!!!!");
						   pp=1;
						   xx=1;
        	           }
					 else
    		   {
    			   System.out.println("WRONG pin or phonenumber!!!!");
    			   xx=0;
    			   pp=0;
    			   System.out.println("TRY AGAIN!!!!!");
    		   }
        	   }
		 
        	   }
		}
        boolean exit = false;
				while(!exit)
				{
					if(pp==1)
					{
					System.out.println("Enter Your Choicee:");
					System.out.println("1.DEPOSIT:");
					System.out.println("2.WITHDRAW:");
					System.out.println("3.CHECK BALANCE:");
					System.out.println("4.TRANFER:");
					System.out.println("5.TRANSACTION HISTORY:");
					System.out.println("6.EXIT:");
					InputStreamReader a5=new InputStreamReader(System.in);
					BufferedReader b5=new BufferedReader(a5);
				    hi=Integer.parseInt(b5.readLine());
				 if(hi==1)
				{
					System.out.println("DEPOSIT:");
					System.out.println("if you want to deposit press enter or type 'no':");
					InputStreamReader a8 = new InputStreamReader(System.in);
				    BufferedReader b8=new BufferedReader(a8); 
				     depositt=b8.readLine();
					if(!depositt.equals("no"))
					{
						System.out.println("how much amount you want to deposit:");
						InputStreamReader a10=new InputStreamReader(System.in);
						BufferedReader b10=new BufferedReader(a10);
						 deposit=Integer.parseInt(b10.readLine());
						 String query56="SELECT * from bankdetails where phonenumber=?"; 
			      		   PreparedStatement oo=con.prepareStatement(query56);
							   oo.setString(1,phonenumber);
							    ResultSet ooo=oo.executeQuery();
							   if (ooo.next())
							  {   
								   Object oooo=ooo.getObject("balance");
								   Object oooooo=ooo.getObject("deposit");
								   if(ooo.wasNull())
								   {
									   if(oooo==null && oooooo==null) {
								    String query100="update bankdetails set deposit=?,balance=? where phonenumber=?";
										 PreparedStatement zz=con.prepareStatement(query100);
										 zz.setInt(1,deposit);
										 zz.setInt(2,deposit);
									     zz.setString(3,phonenumber);
										 int zzz=zz.executeUpdate();
									       if(zzz>0) {
											   System.out.println("AMOUNT WAS DEPOSITED!!!!");
											   LocalDate today2=LocalDate.now();
											   int numeric2=0;
											   String ssss="-";
											   String query565="insert into transactionhistory(dateoftransaction,deposited,withdraw,receivedfrom,receivedamount,transferedto,transferedamount,phonenumber) values(?,?,?,?,?,?,?,?)";
											   PreparedStatement paz=con.prepareStatement(query565);
											Date sqldate2=Date.valueOf(today2);
											paz.setDate(1,sqldate2);
											   paz.setInt(2,deposit);
											   paz.setInt(3,numeric2);
											   paz.setString(4,ssss);
											   paz.setInt(5,numeric2);
											   paz.setString(6,ssss);
											   paz.setInt(7,numeric2);
											   paz.setString(8,phonenumber);
											   int r2=paz.executeUpdate();
											   if(r2>0) 
											   {
												   System.out.println("transactionsuccessful!!!!!");
											   }
											   else {
												   System.out.println("transaction not succeed!!!!!");
											   }
											   pp=1;
											   
										   }
									       if(zzz==0) {
											   System.out.println("NOT DEPOSITED!!!!");
											   pp=1;
										   }
							   } 
								   } 
							   else {
								   balance14=(Integer)oooo;
								   deposit14=(Integer)oooooo;
					    int deposit11=deposit14+deposit;
						 balance=balance14+deposit;
						 String query3="update bankdetails set deposit=?,balance=? where phonenumber=?";
						 PreparedStatement cc=con.prepareStatement(query3);
						 cc.setInt(1,deposit11);
						 cc.setInt(2,balance);
					     cc.setString(3,phonenumber);
						 int ccc=cc.executeUpdate();
					       if(ccc>0) {
							   System.out.println("AMOUNT WAS DEPOSITED!!!!");
							   LocalDate today1=LocalDate.now();
							   int numeric1=0;
							   String sss="-";
							   String query447="insert into transactionhistory(dateoftransaction,deposited,withdraw,receivedfrom,receivedamount,transferedto,transferedamount,phonenumber) values(?,?,?,?,?,?,?,?)";
							   PreparedStatement paqq=con.prepareStatement(query447);
							Date sqldate1=Date.valueOf(today1);
							   paqq.setDate(1,sqldate1);
							   paqq.setInt(2,deposit);
							   paqq.setInt(3,numeric1);
							   paqq.setString(4,sss);
							   paqq.setInt(5,numeric1);
							   paqq.setString(6,sss);
							   paqq.setInt(7,numeric1);
							   paqq.setString(8,phonenumber);
							   int r3=paqq.executeUpdate();
							   if(r3>0) 
							   {
								   System.out.println("transactionsuccessful!!!!!");
							   }
							   else {
								   System.out.println("transaction not succeed!!!!!");
							   }
							   pp=1;
						   }
					       if(ccc==0) {
							   System.out.println("NOT DEPOSITED!!!!");
							   pp=1;
						   }
					}
					}
				}
					else if(depositt.equals("no"))
					{
						System.out.println("NOT DEPOSITED");
						pp=1;
					}
					}
				 else if(hi==2) {
					 System.out.println("WITHDRAW:");
						System.out.println("if you want to withdraw press enter or type 'no':");
						InputStreamReader a99 = new InputStreamReader(System.in);
					    BufferedReader b99=new BufferedReader(a99); 
					     withdraww=b99.readLine();
					     if(!withdraww.equals("no"))
							{
								System.out.println("how much amount you want to withdraw:");
								InputStreamReader a87=new InputStreamReader(System.in);
								BufferedReader b87=new BufferedReader(a87);
								 withdraw=Integer.parseInt(b87.readLine());
								 String query56="SELECT * from bankdetails where phonenumber=?"; 
					      		   PreparedStatement zy=con.prepareStatement(query56);
									   zy.setString(1,phonenumber);
									    ResultSet zyx=zy.executeQuery();
									   if (zyx.next())
									  {   
										   Object zyxw=zyx.getObject("balance");
										   Object zyxwv=zyx.getObject("withdraw");
										   int balance32=(Integer)zyxw;
										   if(zyx.wasNull())
										   {
											   if(zyxw==null) {
												   System.out.println("NO BALANCE");
													pp=1; 
											   }
										   
											   else if(zyxwv==null && zyxw!=null) {
												   if(balance32>=withdraw) {
												    	int balance60=balance32-withdraw;
												    	 String query87="update bankdetails set withdraw=?,balance=? where phonenumber=?";
														 PreparedStatement ab=con.prepareStatement(query87);
														 ab.setInt(1,withdraw);
														 ab.setInt(2,balance60);
													     ab.setString(3,phonenumber);
														 int abc=ab.executeUpdate();
													       if(abc>0) {
															   System.out.println("AMOUNT WAS WITHDRAWED!!!!");
															   LocalDate today3=LocalDate.now();
															   int numeric3=0;
															   String sss1="-";
															   String query4474="insert into transactionhistory(dateoftransaction,deposited,withdraw,receivedfrom,receivedamount,transferedto,transferedamount,phonenumber) values(?,?,?,?,?,?,?,?)";
															   PreparedStatement qq=con.prepareStatement(query4474);
															Date sqldate3=Date.valueOf(today3);
															   qq.setDate(1,sqldate3);
															   qq.setInt(2,numeric3);
															   qq.setInt(3,withdraw);
															   qq.setString(4,sss1);
															   qq.setInt(5,numeric3);
															   qq.setString(6,sss1);
															   qq.setInt(7,numeric3);
															   qq.setString(8,phonenumber);
															   int r4=qq.executeUpdate();
															   if(r4>0) 
															   {
																   System.out.println("transactionsuccessful!!!!!");
															   }
															   else {
																   System.out.println("transaction not succeed!!!!!");
															   }
															   pp=1;
														   }
													       if(abc==0) {
															   System.out.println("NOT  WITHDRAWED!!!!");
															   pp=1;
														   }
												   }else {
													   System.out.println("NOT SUFFICIENT BALANCE!!!!");
													   pp=1;
													   }
												   }
										   }
												    else if(zyxwv!=null && zyxw!=null) {
												    	if(balance32>=withdraw) {
													    	int withdraw333=(Integer)zyxwv;
												    	int balance532=balance32-withdraw;
												    	int withdraw1000=withdraw333+withdraw;
												    	String query65="update bankdetails set withdraw=?,balance=? where phonenumber=?";
														 PreparedStatement pa=con.prepareStatement(query65);
														 pa.setInt(1,withdraw1000);
														 pa.setInt(2,balance532);
													     pa.setString(3,phonenumber);
														 int pad=pa.executeUpdate();
													       if(pad>0) {
															   System.out.println("AMOUNT WAS WITHDRAWED!!!!");
															   LocalDate today4=LocalDate.now();
															   int numeric4=0;
															   String sss12="-";
															   String query449="insert into transactionhistory(dateoftransaction,deposited,withdraw,receivedfrom,receivedamount,transferedto,transferedamount,phonenumber) values(?,?,?,?,?,?,?,?)";
															   PreparedStatement qqsq=con.prepareStatement(query449);
															Date sqldate4=Date.valueOf(today4);
															   qqsq.setDate(1,sqldate4);
															   qqsq.setInt(2,numeric4);
															   qqsq.setInt(3,withdraw);
															   qqsq.setString(4,sss12);
															   qqsq.setInt(5,numeric4);
															   qqsq.setString(6,sss12);
															   qqsq.setInt(7,numeric4);
															   qqsq.setString(8,phonenumber);
															   int r5=qqsq.executeUpdate();
															   if(r5>0) 
															   {
																   System.out.println("transactionsuccessful!!!!!");
															   }
															   else {
																   System.out.println("transaction not succeed!!!!!");
															   }
															   pp=1;
														   }
													       if(pad==0) {
															   System.out.println("NOT WITHDRAWED!!!!");
															   pp=1;
														   }
												    }else {
														   System.out.println("NOT SUFFICIENT BALANCE!!!!");
														   pp=1;
														   }
												    } 
										     
									  }
									   
				 }else if(withdraww.equals("no")) { 
					 System.out.println("NOT WITHDRAWED");
						pp=1;
				 }
				 }
				 
				 else if( hi==3)
				{
					System.out.println("CHECK BALANCE:");
					System.out.println("if you want to checkbalance press enter or type 'no':");
					InputStreamReader a12 = new InputStreamReader(System.in);
				    BufferedReader b12=new BufferedReader(a12); 
				     check=b12.readLine();
				     String query32="SELECT balance from bankdetails where phonenumber=?"; 
	      		   PreparedStatement ff=con.prepareStatement(query32);
					   ff.setString(1,phonenumber);
					   ResultSet fff=ff.executeQuery();
					   if (fff.next())
					   { 
							   Object balanceooObj=fff.getObject("balance");
							   balance13=(Integer)balanceooObj;
				     if(!check.equals("no"))
					{
						System.out.println("CHECK BALANCE:"+balance13);
						pp=1;
					}
					   }
					else if(check.equals("no"))
					{
						System.out.println("INVALID!!!");
						pp=1;
					}
				} 
				 else if(hi==4)
				 {
					 System.out.println("TRANSFER:");
						System.out.println("if you want to transfer press enter or type 'no':");
						InputStreamReader a13 = new InputStreamReader(System.in);
					    BufferedReader b13=new BufferedReader(a13); 
					     transferr=b13.readLine();
					     if(!transferr.equals("no"))
							{
					    	 System.out.println("enter phonenumber of receiver:");
								InputStreamReader a15=new InputStreamReader(System.in);
								BufferedReader b15=new BufferedReader(a15);
								 phonenumber2=b15.readLine();
								 String query5="(SELECT * from bankdetails where phonenumber=?)"; 
		                		   PreparedStatement gg=con.prepareStatement(query5);
								   gg.setString(1,phonenumber2);
								   ResultSet ggg=gg.executeQuery();
								   if (ggg.next())
								   { 
									   String query8="(SELECT balance from bankdetails where phonenumber=?)"; 
			                		   PreparedStatement hh=con.prepareStatement(query8);
									   hh.setString(1,phonenumber);
									   ResultSet hhh=hh.executeQuery();
									   if(hhh.next())
									   {
										   Object balanceObj=hhh.getObject("balance");
										   int balance11=(Integer)balanceObj;
									   System.out.println("how much amount you want to transfer:");
										InputStreamReader a52=new InputStreamReader(System.in);
										BufferedReader b52=new BufferedReader(a52);
										 transfer=Integer.parseInt(b52.readLine());
										 if(transfer<=balance11)
										 {
											balance=balance11-transfer;
											 String query6="update bankdetails set transferedamount=?,transferedto=?,balance=? where phonenumber=?";
											 PreparedStatement ii=con.prepareStatement(query6);
											 ii.setInt(1,transfer);
											 ii.setString(2,phonenumber2);
											 ii.setInt(3,balance);
											 ii.setString(4,phonenumber);
											 int iii=ii.executeUpdate();
											 if(iii>0) {
												   System.out.println("AMOUNT WAS TRANSFERED!!!!");
												   LocalDate today5=LocalDate.now();
												   int numeric5=0;
												   String sss123="-";
												   String query44744="insert into transactionhistory(dateoftransaction,deposited,withdraw,receivedfrom,receivedamount,transferedto,transferedamount,phonenumber) values(?,?,?,?,?,?,?,?)";
												   PreparedStatement qq23=con.prepareStatement(query44744);
												Date sqldate5=Date.valueOf(today5);
												   qq23.setDate(1,sqldate5);
												   qq23.setInt(2,numeric5);
												   qq23.setInt(3,numeric5);
												   qq23.setString(4,sss123);
												   qq23.setInt(5,numeric5);
												   qq23.setString(6,phonenumber2);
												   qq23.setInt(7,transfer);
												   qq23.setString(8,phonenumber);
												   int r6=qq23.executeUpdate();
												   if(r6>0) 
												   {
													   System.out.println("transactionsuccessful!!!!!");
												   }
												   else {
													   System.out.println("transaction not succeed!!!!!");
												   }
												   pp=1;
											   }
										       else if(iii==0) {
												   System.out.println("NOT TRANSFERED!!!!");
												   pp=1;
											   }
											 String query9="(SELECT balance from bankdetails where phonenumber=?)"; 
					                		   PreparedStatement jj=con.prepareStatement(query9);
											   jj.setString(1,phonenumber2);
											   ResultSet jjj=jj.executeQuery();
											   if(jjj.next())
											   {
												   Object balanceoObj=jjj.getObject("balance");
												   int balance12=(Integer)balanceoObj;
											 balance1=balance12+transfer;
											 String query7="update bankdetails set receviedamount=?,receivedfrom=? ,balance=? where phonenumber=?";
											 PreparedStatement kk=con.prepareStatement(query7);
											 kk.setInt(1,transfer);
											 kk.setString(2,phonenumber);
											 kk.setInt(3,balance1);
											 kk.setString(4,phonenumber2);
											 int kkk=kk.executeUpdate();
											 if(kkk>0) {
												   System.out.println("AMOUNT WAS RECEIVED!!!!");
												   LocalDate today6=LocalDate.now();
												   int numeric6=0;
												   String sss1234="-";
												   String query447441="insert into transactionhistory(dateoftransaction,deposited,withdraw,receivedfrom,receivedamount,transferedto,transferedamount,phonenumber) values(?,?,?,?,?,?,?,?)";
												   PreparedStatement qq2323=con.prepareStatement(query447441);
												Date sqldate6=Date.valueOf(today6);
												   qq2323.setDate(1,sqldate6);
												   qq2323.setInt(2,numeric6);
												   qq2323.setInt(3,numeric6);
												   qq2323.setString(4,phonenumber);
												   qq2323.setInt(5,transfer);
												   qq2323.setString(6,sss1234);
												   qq2323.setInt(7,numeric6);
												   qq2323.setString(8,phonenumber);
												   int r7=qq2323.executeUpdate();
												   if(r7>0) 
												   {
													   System.out.println("transactionsuccessful!!!!!");
												   }
												   else {
													   System.out.println("transaction not succeed!!!!!");
												   }
												   pp=1;
											   }
										       else if(kkk==0) {
												   System.out.println("NOT RECEIVED!!!!");
												   pp=1;
											   }
										 }
										 }
										 else if(transfer>balance)
										 {
											 System.out.println("NOT SUFFICIENT BALANCE TO TRANSFER!!!!");
											   pp=1;
										 }
										 
								   }
								   }
								   else
								   {
									   System.out.println("WRONG pin or phonenumber!!!!");
									   System.out.println("TRY AGAIN!!!!!");
									   pp=1;
								   }
				 }
					     else if(transferr.equals("no"))
							{
								System.out.println("INVALID!!!");
								pp=1;
							}
				}else if (hi==5){
					System.out.println("TRANSACTION HISTORY:");
					System.out.println("if you want to see transactionhistory press enter or type 'no':");
					InputStreamReader a9981 = new InputStreamReader(System.in);
				    BufferedReader b9981=new BufferedReader(a9981); 
				    String transactionhistoryy=b9981.readLine();
				    String query323133="SELECT s_no,dateoftransaction,deposited,withdraw,receivedfrom,receivedamount,transferedto,transferedamount from transactionhistory where phonenumber=?"; 
		      		   PreparedStatement ffgh=con.prepareStatement(query323133);
						   ffgh.setString(1,phonenumber);
						   ResultSet ffghhh=ffgh.executeQuery();
						   if(!transactionhistoryy.equals("no"))
							{
							   System.out.println("dateoftransaction"+"          "+"deposit"+"       "+"withdraw"+"       "+"receivedfrom"+"         "+"receivedamount"+"      "+"transferedamount"+"      "+"transferedto");
						   while (ffghhh.next())
						   { 
								   Date datee=(Date)ffghhh.getObject("dateoftransaction");
								   Object balanceooObj1234=ffghhh.getObject("deposited");
								   int depositt1=(Integer)balanceooObj1234;
								   Object balanceooObj12345=ffghhh.getObject("withdraw");
								   int withdrawww=(Integer)balanceooObj12345;
								   Object balanceooObj123456=ffghhh.getObject("receivedfrom");
								  String re1 =(String)balanceooObj123456;
								   Object balanceooObj1234567=ffghhh.getObject("receivedamount");
								   int re2=(Integer)balanceooObj1234567;
								   Object balanceooObj12345678=ffghhh.getObject("transferedamount");
									  int re12 =(int)balanceooObj12345678;
									   Object balanceooObj123456789=ffghhh.getObject("transferedto");
									   String re23=(String)balanceooObj123456789;
				    	 System.out.println(datee+"                 "+depositt1+"               "+withdrawww+"             "+re1+"                    "+re2+"                    "+re12+"                 "+re23);
						}   
						   }
				     else if(transactionhistoryy.equals("no"))
				     {
				    	 System.out.println("THANKYOU!!!!");
				    	 pp=1;
				}
				}
				
				else if(a==3 || hi==6)
				
				{
					System.out.println("THANKYOU!!!!");
		           pp=0;
		           xx=1;
				    }
		   }
				}
	    }catch(Exception e1)
        {
    	    System.out.println(e1);
     } 
	}
	}  
}

	


