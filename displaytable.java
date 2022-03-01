import java.sql.*;
import java.util.*;
public class displaytable
{
    
     public static void main(String[] args)
    {
       
        displaytable s = new displaytable();
        s.dbms();
    }
 



    void dbms()
    {
      try
      {   
       Class.forName("com.mysql.cj.jdbc.Driver");
       System.out.println("connecting");
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","1Nibinp#");
       System.out.println("Connected");  
       Statement stmt = conn.createStatement();
       String ss = "DROP TABLE student";
       stmt.executeUpdate(ss);
       String sql = "CREATE TABLE student " +
                   "(rollno INTEGER not NULL, " +
                   " name VARCHAR(255), " + 
                   " age INTEGER)"; 

         stmt.executeUpdate(sql);
         System.out.println("Created table in given database...");
         Scanner obj = new Scanner(System.in);
       
       ;
       String query = "INSERT INTO student(rollno, name,age) VALUES "
         + "(1, 'nibin', 25), "
         + "(2, 'akash', 21), "
         + "(3, 'joel', 19), "
         + "(4, 'Archana',21),"
         + "(5, 'Hardik',22)";
         stmt.executeUpdate(query);
        
       ResultSet rs = stmt.executeQuery("select * from student");
          
       
       while(rs.next())
       {
          
            System.out.print("rollno : "+rs.getInt("rollno")+" ");      
            System.out.print("name: "+rs.getString("name")+" ");
            System.out.print("age :"+rs.getString("age")+" ");
            System.out.println("");
            
       }
       
   rs.close();
   stmt.close();
   conn.close();
   }catch(Exception v)
   {
    System.out.println(v);
   }

    }




   
  }
