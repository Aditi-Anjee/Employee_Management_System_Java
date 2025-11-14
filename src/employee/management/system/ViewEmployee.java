package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;



public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;

    Choice choiceEMP;
    JButton Searchbtn,print, update, back;

    public ViewEmployee() {

        getContentPane().setBackground(new Color(180, 200, 245));
        JLabel search=new JLabel("SEARCH BY EMPLOYEE ID");
        search.setBounds(20,20,200,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(250,20,200,20);
        add(choiceEMP);

        try {

            Conn c=new Conn();
            ResultSet resultSet =c.statement.executeQuery("select*from employee1");
            while(resultSet.next()){
                choiceEMP.add(resultSet.getString("empID"));

            }
            

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        table=new JTable();
        try {
            Conn c=new Conn();
            ResultSet resultSet =c.statement.executeQuery("select*from employee1");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
            

            
        } catch (Exception e)
        
        {
            e.printStackTrace();

        }

        JScrollPane jp= new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);
        
        Searchbtn = new JButton("SEARCH");
        Searchbtn.setBounds(20, 70, 100, 20);
        Searchbtn.addActionListener(this);
        add(Searchbtn);

        print = new JButton("PRINT");
        print.setBounds(140, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("UPDATE");
        update.setBounds(240, 70, 100, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(360, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Searchbtn){
            String query="select*from employee1 where empID='"+choiceEMP.getSelectedItem()+"'";
            try {
                Conn c=new Conn();
                ResultSet resultSet=c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
  
            } catch (Exception E) {

                E.printStackTrace();
            }
            
        }
        else if(e.getSource()==print){
            try {
                table.print();
                
            } catch (Exception E) {
                E.printStackTrace();
            }

            }

        else if(e.getSource()==update){

            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
        }
        else{
            setVisible(false);
            new Main_class();
        }
        
    }

    

    public static void main(String[] args) {
        new ViewEmployee();


    }

    


    
}
