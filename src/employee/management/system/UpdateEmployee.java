package employee.management.system;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateEmployee extends JFrame implements ActionListener{

    JTextField teducation, tfname, taddress, tphone, temail, tsalary, tdesignation;
    JLabel tempid;
    JButton update,back;
    String number;

    public UpdateEmployee(String number)  {

        this.number=number;

        
       getContentPane().setBackground(new Color(211, 225, 236));

       JLabel heading= new JLabel("ADD EMPLOYEE DETAILS");
       heading.setBounds(250,30,500,50);
    

       heading.setFont(new Font("serif", Font.BOLD, 30));
       add(heading);

       JLabel name= new JLabel("NAME");
       name.setBounds(50,150,145,30);
       name.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
       add(name);

       JLabel tname= new JLabel();
       tname.setBounds(200,150,170,30);
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

JLabel dob = new JLabel("DATE OF BIRTH");
dob.setBounds(50, 200, 145, 30);
dob.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
add(dob);

JLabel tdob=new JLabel();
tdob.setBounds(200,200,145,30);
tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
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
    
    teducation= new JTextField();
    teducation.setBounds(655,300,160,30);
    teducation.setBackground(new Color(230, 235, 245));
    add(teducation);
    

    JLabel aadhar= new JLabel("AADHAR");
    aadhar.setBounds(50,350,145,30);
    aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(aadhar);

    JLabel taadhar= new JLabel();
    taadhar.setBounds(200,350,160,30);
    taadhar.setBackground(new Color(230, 235, 245));
    add(taadhar);
    
    JLabel empid= new JLabel("EMPLOYEE ID");
    empid.setBounds(50,400,145,30);
    empid.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
    add(empid);

    tempid= new JLabel();
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


    try {
        Conn c=new Conn();
        String query="select* from employee1 where empID='"+number+"'";
        ResultSet resultSet= c.statement.executeQuery(query);//data ko nikalna hai
        while(resultSet.next()){
            tname.setText(resultSet.getString("name"));
            tfname.setText(resultSet.getString("fname"));
            tdob.setText(resultSet.getString("dob"));
            taddress.setText(resultSet.getString("address"));
            tsalary.setText(resultSet.getString("salary"));
            tphone.setText(resultSet.getString("phone"));
            temail.setText(resultSet.getString("email"));
            teducation.setText(resultSet.getString("education"));
            taadhar.setText(resultSet.getString("aadhar"));
            tempid.setText(resultSet.getString("empID"));
            tdesignation.setText(resultSet.getString("designation"));



        }
        
    } catch (Exception E) {
        E.printStackTrace();
    }

    update= new JButton("UPDATE");
    update.setBounds(460,500,150,40);
    update.setBackground(Color.black);
    update.setForeground(Color.WHITE);
    update.addActionListener(this);
    add(update);

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
        if (e.getSource()==update) {
            String fname=tfname.getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String education=teducation.getText();
            String designation=tdesignation.getText();
            String email=temail.getText();
            
            try {
                Conn c=new Conn();
                // String query="Update employee set fname='"+fname+"', salary ='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"', designation='"+designation+"' where empID ='"+number+"'";
                String query = "UPDATE employee1 SET fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empID = '"+number+"'";
                c.statement.executeUpdate(query);//to run query
                JOptionPane.showMessageDialog(null,"Details updated successfully");
                setVisible(false);
                new Main_class();
  
            } catch (Exception E) {
                E.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new ViewEmployee();
        }


    }
    
    public static void main(String[] args) {
       new UpdateEmployee("");
        
    }
    
}
