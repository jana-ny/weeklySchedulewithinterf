/*                        ******Jana Nabiel Alyamani******
                          ******Dana Salem Alsharqi******
                          ******Sarah Saeed Almalki******
 */

package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.ImageIcon;


public class WeeklyScheduleDemo extends JFrame{
    
    
    private JPanel panel1; //To reference a panel 
    private JPanel panel2; //To reference a panel 
    private JPanel panel3; //To reference a panel
    private JPanel panel4; //To reference a panel
    private JPanel panel5; //To reference a panel
    private JPanel panel6; //To reference a panel
    private JPanel panel7; //To reference a panel
    private JPanel panelF;  //To reference a panel
            
    private JRadioButton Aradio; // To reference a radio button
    private JRadioButton Pradio;// To reference a radio button

    private JLabel LabelSC;// To reference a label
    
    private JButton OkButton; // To reference a button
    private JButton startButton; // To reference a button
    
    
    private JMenuBar menuBar;    // The menu bar
    private JMenuItem exitItem; //to reference a menu item
    private JMenuItem displayItem;//to reference a menu item
    
    
    public JLabel iconLabel,userLabel,WeeklyLable;
    public static JTextField studentid,filename;
    JButton login; // To reference a button
    
    public static JList dayslist;
    
    private JLabel imageLabel;
    private ImageIcon imageIcon;
    
    
        public WeeklyScheduleDemo(){
        
                JFrame LoginF = new JFrame();

                LoginF.setTitle("Login");
                LoginF.setSize(420, 310);
                LoginF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                LoginF.setLayout(new GridLayout(1,2));

                panel1 = new JPanel();
                panel2 = new JPanel();
                panel3 = new JPanel();
                panel4 = new JPanel();
                panel5 = new JPanel();
                panel6 = new JPanel();
                panel7 = new JPanel(new GridLayout(4,1));
                panelF = new JPanel();
                EditComponent.colorPanel(panel1,panel2,panel3);
                EditComponent.colorPanel(panel4,panel5,panel6);
                EditComponent.colorPanel(panel4,panel5,panelF);

                iconLabel=new JLabel();
                ImageIcon logo = new ImageIcon("C:\\Users\\janan\\OneDrive\\Desktop\\UJ\\OOP2\\project\\src\\project\\login.jpg");
                iconLabel.setIcon(logo);

                WeeklyLable=new JLabel("Weekly Schedule");
                userLabel=new JLabel("insert student ID: ");
                EditComponent.setLabel(WeeklyLable);
                EditComponent.setLabel(userLabel);

                studentid=new JTextField(8);
                
                login=new JButton("Login");
                login.addActionListener(new loginListener());
                EditComponent.setButton(login);

                panel1.add(iconLabel);
                panel2.add(WeeklyLable);
                panel3.add(userLabel);
                panel3.add(studentid);

                panel5.add(login);

                panel7.add(panel2);
                panel7.add(panel3);

                panel7.add(panel4);
                panel7.add(panel5);

                LoginF.add(panel1);
                LoginF.add(panel7);

                LoginF.setLocationRelativeTo(null); 
                LoginF.setVisible(true);
             
        }
        
        public void welcomeWindow(){
            
            
            setTitle("Weekly schedule");
            
            // Set the size of this window.
            setSize(500, 630);
           
            // Specify what happens when the close button is clicked.
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            
            LabelSC = new JLabel("Choose a schedule category: " );
            EditComponent.setLabel(LabelSC);
            
            Aradio= new JRadioButton("Academic schedule");
            Pradio= new JRadioButton("Productivity schedule");
            
            OkButton= new JButton("OK");
            startButton = new JButton("Start");
            startButton.addActionListener(new StartListener());
            EditComponent.setButton(OkButton);
            
            ButtonGroup radioG1 = new ButtonGroup();
            radioG1.add(Aradio);
            radioG1.add(Pradio);
            
            menuBar = new JMenuBar();
            JMenu otherMenu = new JMenu("options");
            exitItem = new JMenuItem("Exit");
            exitItem.addActionListener(new ExitListener());
            displayItem = new JMenuItem("Display");
            displayItem.addActionListener(new DisplayListener());
            otherMenu.add(displayItem);
            otherMenu.addSeparator();
            otherMenu.add(exitItem);
            
            imageIcon = new ImageIcon("C:\\Users\\janan\\OneDrive\\Desktop\\UJ\\OOP2\\project\\src\\project\\welcome-text.gif");
            imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);
   
            menuBar.add(otherMenu);
            setJMenuBar(menuBar);
            
            panel1 = new JPanel();
            panel2 = new JPanel();
            panel3 = new JPanel(new GridLayout(4,1));
            panel4 = new JPanel();
            
            panel2.add(imageLabel);
            panel1.add(LabelSC);
            panel3.add(Aradio);
            panel3.add(Pradio);
            panel3.add(panel4);
            panel2.add(imageLabel);
            panel4.add(startButton);
            EditComponent.setButton(startButton);
            EditComponent.colorPanel(panel1,panel2,panel3);
            EditComponent.colorPanel(panel4,null,null);
            EditComponent.setRadio(Aradio,Pradio,null);

            add(panel1,BorderLayout.NORTH);
            add(panel2,BorderLayout.CENTER);
            add(panel3,BorderLayout.SOUTH);
            
            
            setLocationRelativeTo(null);
            setVisible(true);
        }

        public void display(){
        
            // sends the file name to the DisplaySchedule method in the WeeklySchedule class
            
            WeeklySchedule.DisplaySchedule(loginListener.file);
            
        }   
          
//      **************************ACTION LISTENERS******************************  
        
    //the login window listener 
        
        public class loginListener implements ActionListener{

                public static String file,studentIDst;
                public static int studentID;

                @Override
                public void actionPerformed(ActionEvent e)  {

                    studentIDst = studentid.getText();
                    boolean Valid=true;
                    try{
                    // Check if the input is not null and consist of 7 numbers
                    if (studentIDst!= null && studentIDst.length() == 7) {

                        for (int i = 0; i < studentIDst.length(); i++) {
                                char s = studentIDst.charAt(i);
                                if (!Character.isDigit(s)) {
                                    Valid = false;
                                    throw new WeeklyScheduleException("Write your student id in a proper format");
                                     
                                }           
                    }
                    }
                    else{
                         Valid = false;
                         throw new WeeklyScheduleException("Write your student id in a proper format");
                                       
                    }
                    if(Valid){
                        file = studentIDst + ".txt"; 
                         welcomeWindow();
                         
                    }
                    
                    }
                    catch(WeeklyScheduleException ex){
                      JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            }
        
    // weekly schedule window listener
        private  class StartListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Aradio.isSelected())
                       new AcademicSchedule();

                    if(Pradio.isSelected())
                       new ProductiveSchedule();
                    }
        }
 
    //Action Listeners for Menu
        private class ExitListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
        }
        
        
        private class DisplayListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e){
                    display();   
                }
        }
        
        
    public static void main(String[] args)throws IOException {
        
        WeeklyScheduleDemo start = new WeeklyScheduleDemo();
    }     
       
}
 
    
