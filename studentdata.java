import java.sql.*;
import java.util.*;
public class studentdata 
{
    
     public static void main(String[] args)
    {
       
        studentdata s = new studentdata();
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
       String ss = "DROP TABLE students";
       stmt.executeUpdate(ss);
       String sql = "CREATE TABLE students " +
                   "(rollno INTEGER not NULL, " +
                   " name VARCHAR(255), " + 
                   " cgpa INTEGER)"; 

         stmt.executeUpdate(sql);
         System.out.println("Created table in given database...");
         Scanner obj = new Scanner(System.in);
       
        System.out.println("how many students");
        int n = obj.nextInt();
        String query = "INSERT INTO students ("
                        + " rollno,"
                        + "name,"
                        + "cgpa ) VALUES ("
                        + "?, ?, ?)";
 
         for(int i=0;i<n;i++)
         {
             PreparedStatement st = conn.prepareStatement(query);
             
             System.out.println("enter the roll of "+(i+1)+" student");
             int r = obj.nextInt();
      
             System.out.println("enter the name of "+(i+1)+" student");
             String name = obj.next();
             
             
             System.out.println("enter the cgpa of "+(i+1)+" student");
             float f = obj.nextFloat();
             
             st.setInt(1,r);
             st.setString(2,name);
             st.setFloat(3,f);
             st.executeUpdate();
             st.close();
          }
        
       ResultSet rs = stmt.executeQuery("select * from students where cgpa >=7");
          
       
       while(rs.next())
       {
          
            System.out.print("rollno : "+rs.getInt("rollno")+" ");      
            System.out.print("name: "+rs.getString("name")+" ");
            System.out.print("cgpa :"+rs.getString("cgpa")+" ");
            System.out.print("");
            
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
