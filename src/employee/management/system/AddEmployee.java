package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

// import com.toedter.calendar.JDateChooser;


public class AddEmployee extends JFrame implements ActionListener{
    Random ran=new Random();
    int number =ran.nextInt(999999);

    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempid;
    JDateChooser tdob;

    JComboBox Boxeducation;
    JButton add, back;

    AddEmployee(){

       getContentPane().setBackground(new Color(211, 225, 236));

       JLabel heading= new JLabel("ADD EMPLOYEE DETAILS");
       heading.setBounds(250,30,500,50);
    

       heading.setFont(new Font("serif", Font.BOLD, 30));
       add(heading);

       JLabel name= new JLabel("NAME");
       name.setBounds(50,150,145,30);
       name.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
       add(name);

       tname= new JTextField();
       tname.setBounds(200,150,160,30);
       tname.setBackground(new Color(230, 235, 245));
       add(tname);

       JLabel fname= new JLabel("FATHER'S NAME");
       fname.setBounds(500,150,145,30);
       fname.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
       add(fname);

       tfname= new JTextField();
       tfname.setBounds(655,150,160,30);
       tfname.setBackground(new Color(230, 235, 245));
       add(tfname);

    //    JLabel dob= new JLabel("DATE OF BIRTH");
    //    dob.setBounds(500,150,145,30);
    //    dob.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    //    add(dob);

    //    tdob= new JDateChooser();
    //    tdob.setBounds(200,200,150,30);
    //    tdob.setBackground(new Color(177,252,197));
    //    add(tdob);
 JLabel dob = new JLabel("DATE OF BIRTH");
dob.setBounds(50, 200, 145, 30);
dob.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
add(dob);

tdob = new JDateChooser();
tdob.setBounds(200, 200, 160, 30);
tdob.setBackground(new Color(230, 235, 245));
add(tdob);


    JLabel salary= new JLabel("SALARY");
    salary.setBounds(500,200,145,30);
    salary.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(salary);

    tsalary= new JTextField();
    tsalary.setBounds(655,200,160,30);
    tsalary.setBackground(new Color(230, 235, 245));
    add(tsalary);

    JLabel address= new JLabel("ADDRESS");
    address.setBounds(50,250,145,30);
    address.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(address);

    taddress= new JTextField();
    taddress.setBounds(200,250,160,30);
    taddress.setBackground(new Color(230, 235, 245));
    add(taddress);


    JLabel phone= new JLabel("PHONE");
    phone.setBounds(500,250,145,30);
    phone.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(phone);

    tphone= new JTextField();
    tphone.setBounds(655,250,160,30);
    tphone.setBackground(new Color(230, 235, 245));
    add(tphone);


    JLabel email= new JLabel("EMAIL");
    email.setBounds(50,300,145,30);
    email.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(email);

    temail= new JTextField();
    temail.setBounds(200,300,160,30);
    temail.setBackground(new Color(230, 235, 245));
    add(temail);

    JLabel education= new JLabel("HIGHEST EDUCATION");
    education.setBounds(500,300,145,30);
    education.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(education);

    String items[]= {"BBA","B.TECH","BCA","BSC","B.COM","MBA","MCA","MA","M.TECH","MSC","PHA"};
    Boxeducation=new JComboBox(items);
    Boxeducation.setBackground(new Color(230, 235, 245));
    Boxeducation.setBounds(655, 300, 145, 30);
    add(Boxeducation);

    JLabel aadhar= new JLabel("AADHAR");
    aadhar.setBounds(50,350,145,30);
    aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(aadhar);

    taadhar= new JTextField();
    taadhar.setBounds(200,350,160,30);
    taadhar.setBackground(new Color(230, 235, 245));
    add(taadhar);
    
    JLabel empid= new JLabel("EMPLOYEE ID");
    empid.setBounds(50,400,145,30);
    empid.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(empid);

    tempid= new JLabel(" "+number);
    tempid.setBounds(200,400,145,30);
    // tempid.setBackground(new Color(230, 235, 245));
    tempid.setFont(new Font("SAN_SERIF", Font.BOLD,18));
    add(tempid);

    JLabel designation= new JLabel("DESIGNATION");
    designation.setBounds(500,350,145,30);
    designation.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(designation);

    tdesignation= new JTextField();
    tdesignation.setBounds(655,350,160,30);
    tdesignation.setBackground(new Color(230, 235, 245));
    add(tdesignation);

    add= new JButton("ADD");
    add.setBounds(460,500,150,40);
    add.setBackground(Color.black);
    add.setForeground(Color.WHITE);
    add.addActionListener(this);
    add(add);

    back= new JButton("BACK");
    back.setBounds(250,500,150,40);
    back.setBackground(Color.black);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);


       setSize(900,700);
       setLayout(null);
       setLocation(300,50);
       setVisible(true);
        

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==add){
            String name=tname.getText();
            String fname=tfname.getText();
            String dob=((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=(String)Boxeducation.getSelectedItem();
            String designation=tdesignation.getText();
            String empID=tempid.getText();
            String aadhar=taadhar.getText();

            try {
                Conn c=new Conn();
                String query="insert into employee1 values('"+name+"' ,'"+fname+"', '"+dob+"' ,'"+salary+"', '"+address+"','"+phone+"','"+email+"', '"+education+"' ,'"+designation+"', '"+aadhar+"', '"+empID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_class();
            } 
            
            catch (Exception E) {
                E.printStackTrace();
            }

            

        }
        else{
            setVisible(false);
            new Main_class();
        }

    }
    public static void main(String[] args) {

        new AddEmployee();
        
    }



    
}
