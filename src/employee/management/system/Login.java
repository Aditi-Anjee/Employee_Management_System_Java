package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
// import java.sql.Statement;


public class Login extends JFrame implements ActionListener{
    JTextField tusername;
    JTextField tpassword;
    JButton login,back;


    
    Login(){

        JLabel username= new JLabel("Username"); //text frame visibility
        username.setBounds(40,20,100,30);
        add(username);

        tusername= new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);


        JLabel password= new JLabel("Password"); //text frame visibility
        password.setBounds(40,70,100,30);
        add(password);

        tpassword= new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);


        login= new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        
        back= new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        
        //  Decorative Image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.png"));
        Image i22 = i11.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(340, 07, 400, 300);
        add(imgg);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 700, 400);
        add(img);


        setLayout(null);
        setSize(700, 400);
        setLocation(450,200);
        setVisible(true);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            try {

                String username=tusername.getText();
                String password=tpassword.getText();
                
                Conn conn =new Conn();

                String query="select * from login where username='"+username+"'and password='"+password+"'";

                ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username and passsword");
                }


            } catch (Exception E) {

                E.printStackTrace();
            }

        }
        else if (e.getSource()==back) {
            System.exit(90);
            
        }
    }

    

    public static void main(String[] args) {

        new Login();
        
    }

    
    
}


