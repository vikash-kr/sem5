
package loginform;

 
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.sql.*;

 
public class LoginForm extends JFrame {
 JLabel l1, l2, l3;
 JTextField tf1;
 JButton btn1;
 JPasswordField p1;
 LoginForm() {
  JFrame frame = new JFrame("Login Form");
  l1 = new JLabel("Login Form");
  l1.setForeground(Color.blue);
  l1.setFont(new Font("Serif", Font.BOLD, 20));
 
  l2 = new JLabel("Username");
  l3 = new JLabel("Password");
  tf1 = new JTextField();
  p1 = new JPasswordField();
  btn1 = new JButton("Login");
 
  l1.setBounds(100, 30, 400, 30);
  l2.setBounds(80, 70, 200, 30);
  l3.setBounds(80, 110, 200, 30);
  tf1.setBounds(300, 70, 200, 30);
  p1.setBounds(300, 110, 200, 30);
  btn1.setBounds(150, 160, 100, 30);
 
  frame.add(l1);
  frame.add(l2);
  frame.add(tf1);
  frame.add(l3);
  frame.add(p1);
  frame.add(btn1);
 

 
 
 btn1.addActionListener((ActionEvent ae) -> {
     String uname = tf1.getText();
     String pass = p1.getText();
      String DB_username ="";
      String DB_password = "";
     try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/user","root","vikash123");  
        //here sonoo is database name, root is username and password  
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from login");  
        
        while(rs.next()) {
          System.out.println(DB_username+"  "+DB_password);
        //System.out.println(rs.getString(1)+"  "+rs.getString(2));
        DB_username = rs.getString(1);
        DB_password = rs.getString(2);
        }
        
        
     
        
     //if(uname.equals("vikash") && pass.equals("vik123"))
     if(uname.equals(DB_username) && pass.equals(DB_password))
     {
         Welcome wel = new Welcome();
         wel.setVisible(true);
         JLabel label = new JLabel("Welcome:"+uname);
         wel.getContentPane().add(label);
     }
     else
     {
         //      JOptionPane.showMessageDialog(this,"Incorrect login or password",
         //      "Error",JOptionPane.ERROR_MESSAGE);
         Welcome wel = new Welcome();
         wel.setVisible(true);
         JLabel label = new JLabel("Wrong user name of password");
         wel.getContentPane().add(label);
     }
     
     
     con.close();
    }
     catch(Exception e){
         System.out.println(e);
     }
  });
   frame.setSize(1000, 600);
  frame.setLayout(null);
  frame.setVisible(true);
 }
 public static void main(String[] args) {
  new LoginForm();
 }
}
