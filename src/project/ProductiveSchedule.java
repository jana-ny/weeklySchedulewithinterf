
/*                        ******Jana Nabiel Alyamani******
                          ******Dana Salem Alsharqi******
                          ******Sarah Saeed Almalki******
 */
package project;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class ProductiveSchedule {
       
    private String eventName;    
    public String day;
    private final String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private int eventType ;
    
    public JFrame pw,ProductiveF;
    
    private JPanel panel1; //To reference a panel 
    private JPanel panel2; //To reference a panel 
    private JPanel panel3; //To reference a panel

    private JLabel LabelSC;// To reference a label
    private JLabel aLabellist;// To reference a label
    
    private JButton OkButton; // To reference a button
    private JButton saveButton;// To reference a button
       
    public static JTextField studentid,filename,protf;// To reference a TextField 
    
    final int WINDOW_WIDTH1 = 310; // Window width in pixels
    final int WINDOW_HEIGHT1 = 200; // Window height in pixels
    final int WINDOW_WIDTH2 = 750; // Window width in pixels
    final int WINDOW_HEIGHT2 = 280; // Window height in pixels
    
    private JRadioButton seminarradio; // To reference a radio button
    private JRadioButton workshopradio;// To reference a radio button 
     
    public static JList dayslist; // To reference JList
    public JScrollPane scrollPane;// To reference JScrollPane
    
    private ImageIcon imageIcon;// To referenceImageIcon
    
    
    /**
     * Constructor 
     * @param eventName the eventName in the ProductiveSchedule.
     * @param day the day of the event in the ProductiveSchedule. 
     * @param eventType the eventType of the ProductiveSchedule.
     */
    public ProductiveSchedule(String eventName, String day, int eventType) {
        this.eventName = eventName;
        this.day = day;
        this.eventType = eventType;
    }
    
    /**
     * Constructor 
     */
    public ProductiveSchedule(){
            
            
            ProductiveF = new JFrame();

            ProductiveF.setTitle("Productive Schedule");
            // Set the size of this window.
            ProductiveF.setSize(WINDOW_WIDTH1, WINDOW_HEIGHT1);
            // Specify what happens when the close button is clicked.
            ProductiveF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            
            LabelSC = new JLabel("Choose a productive activity: ");

            EditComponent.setLabel(LabelSC);
            
            seminarradio= new JRadioButton("Seminar");
            workshopradio= new JRadioButton("Workshop");
            
            OkButton= new JButton("OK");
            OkButton.addActionListener(new ProductiveSchedule.activityListener());
            EditComponent.setButton(OkButton);
            

            ButtonGroup radioG2 = new ButtonGroup();
            radioG2.add(seminarradio);
            radioG2.add(workshopradio);
            
            EditComponent.setRadio(seminarradio, workshopradio,null);
            
            panel1 = new JPanel();
            panel2 = new JPanel(new GridLayout(2,1));
            panel3 = new JPanel();

            panel1.add(LabelSC);
            panel2.add(seminarradio);
            panel2.add(workshopradio);
            panel3.add(OkButton);
            EditComponent.colorPanel(panel1,panel2,panel3);

            ProductiveF.add(panel1,BorderLayout.NORTH);
            ProductiveF.add(panel2,BorderLayout.CENTER);
            ProductiveF.add(panel3,BorderLayout.SOUTH);
            
            ProductiveF.setLocationRelativeTo(null);
            ProductiveF.setVisible(true);
        }
    
    public void productiveWrite(char a){
            
            if(a=='s'){
                 
                pw = new JFrame();
                pw.setTitle("Seminar");
                
                // Set the size of this window.
                pw.setSize(700, 280);
                // Specify what happens when the close button is clicked.
                pw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
                imageIcon = new ImageIcon("C:\\Users\\janan\\OneDrive\\Desktop\\UJ\\OOP2\\project\\src\\project\\sem.jpg");
                LabelSC = new JLabel("Write the Seminar's name:");
                EditComponent.setLabel(LabelSC);
                
                aLabellist = new JLabel(imageIcon);
                protf = new JTextField(15);
                saveButton= new JButton("Save");
                saveButton.addActionListener(new ProductiveSchedule.ProductiveListener());
                EditComponent.setButton(saveButton);

                panel1 = new JPanel();
                panel2 = new JPanel();
                panel3 = new JPanel();
                
                dayslist = new JList(days);
                dayslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                dayslist.setVisibleRowCount(4);
                scrollPane= new JScrollPane(dayslist);
                
                panel1.add(LabelSC);
                panel1.add(protf);
                
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
                panel2.add(aLabellist);
                panel2.add(scrollPane);
                EditComponent.colorPanel(panel1,panel2,panel3);
                panel3.add(saveButton);

                pw.add(panel1,BorderLayout.NORTH);
                pw.add(panel2,BorderLayout.CENTER);
                pw.add(panel3,BorderLayout.SOUTH);


                pw.setLocationRelativeTo(null);
                pw.setVisible(true);
                

             }
             if(a=='w'){
                 
                pw = new JFrame();

                pw.setTitle("Workshop");
                // Set the size of this window.
                pw.setSize(WINDOW_WIDTH2, WINDOW_HEIGHT2);
                
                // Specify what happens when the close button is clicked.
                pw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
               
                LabelSC = new JLabel("Write the Workshop's title:");
                EditComponent.setLabel(LabelSC);
                imageIcon = new ImageIcon("C:\\Users\\janan\\OneDrive\\Desktop\\UJ\\OOP2\\project\\src\\project\\workshop.jpg");
                aLabellist = new JLabel(imageIcon);
                protf = new JTextField(15);
                saveButton= new JButton("save");
                saveButton.addActionListener(new ProductiveSchedule.ProductiveListener());
                EditComponent.setButton(saveButton);

                panel1 = new JPanel();
                panel2 = new JPanel();
                panel3 = new JPanel();
                
                
                dayslist = new JList(days);
                dayslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                dayslist.setVisibleRowCount(4);
                scrollPane= new JScrollPane(dayslist);
                
                
                panel1.add(LabelSC);
                panel1.add(protf);
                
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
                panel2.add(aLabellist);
                panel2.add(scrollPane);
               

                panel3.add(saveButton);
                EditComponent.colorPanel(panel1,panel2,panel3);
               
                pw.add(panel1,BorderLayout.NORTH);
                pw.add(panel2,BorderLayout.CENTER);
                pw.add(panel3,BorderLayout.SOUTH);


                pw.setLocationRelativeTo(null);
                pw.setVisible(true);
             
             }
            
        }
    private  class activityListener implements ActionListener {
            public static int activitytype;

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
             if(seminarradio.isSelected()){
                
                activitytype=1;
                productiveWrite('s');
             }
             if(workshopradio.isSelected()){
                
                activitytype=2;
                productiveWrite('w');
             }
            }
        }
        
        public  class ProductiveListener implements ActionListener {
            
             public static String selected,written;
             String file= WeeklyScheduleDemo.loginListener.file;
             ProductiveSchedule psched;
             WeeklySchedule wtsp;
             int eventt= activityListener.activitytype;
             
             
             @Override
        public void actionPerformed(ActionEvent e) {
            
              selected = (String)dayslist.getSelectedValue();
              written= protf.getText();
              
                if (written == null || selected == null){
                      try{

                           throw new WeeklyScheduleException("please fill all the components");
                      }
                      catch(WeeklyScheduleException ex){
                              JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                }
                else {
                      try {
                          psched = new ProductiveSchedule( written, selected , eventt);
                          wtsp= new WeeklySchedule(psched);
                          wtsp.setFileName(file);
                          wtsp.writeToScheduleP(psched);
                          ProductiveF.dispose();
                          pw.dispose();
                          JOptionPane.showMessageDialog(null, "Your task has been saved successfully", "Saved", JOptionPane.INFORMATION_MESSAGE);
                          
                      }
                      catch (IOException a) {
                          JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
                      }
                   }
        }
                  
        } 
        
    /**
     * 
     * @return The value in the eventName field. 
     */
    public String getEventName() {
        return eventName;
    }
    /**
     * 
     * @return The value in the day field.
     */
    public String getDay() {
        return day;
    }
    /**
     * 
     * @return The value in the EventType field.
     */
    public int getEventType() {
        return eventType;
    }

    
}