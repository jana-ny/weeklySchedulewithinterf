
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

public class AcademicSchedule {
        
    private String course ;
    public String day;
    private final String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    public int taskType ;
    
    private JFrame AcademicF , aw;
    
    private JPanel panel1; //To reference a panel 
    private JPanel panel2; //To reference a panel 
    private JPanel panel3; //To reference a panel
  
    private JLabel LabelSC;// To reference a label
    private JLabel aLabellist;// To reference a label
    
    private JTextField astf;// To reference JTextField
    
    private JButton OkButton; // To reference a button
    private JButton saveButton;// To reference a button
    
    private JRadioButton assignmentradio; // To reference a radio button
    private JRadioButton examradio;// To reference a radio button
    private JRadioButton Projectsradio;// To reference a radio button
    
    
    final int WINDOW_WIDTH1 = 310; // Window width in pixels
    final int WINDOW_HEIGHT1 = 200; // Window height in pixels
    final int WINDOW_WIDTH2 = 750; // Window width in pixels
    final int WINDOW_HEIGHT2 = 280; // Window height in pixels
    
    public JScrollPane scrollPane;// To reference a JScrollPane
    public static JList dayslist;// To reference a JList
   
    private ImageIcon imageIcon;// To reference ImageIcon 
    
 
    /**
     * Constructor 
     * @param course the course name in the AcademicSchedule.
     * @param day the day of the task in the AcademicSchedule.
     * @param taskType the taskType of AcademicSchedule.
     */
    public AcademicSchedule(String course, String day, int taskType) {
        this.course = course;
        this.day = day;
        this.taskType = taskType;
    }
    
    public AcademicSchedule(){
    
            AcademicF = new JFrame();
            
            // Set the Title of this window.
            AcademicF.setTitle("Academic Schedule");
            // Set the size of this window.
            AcademicF.setSize(WINDOW_WIDTH1, WINDOW_HEIGHT1);
            // Specify what happens when the close button is clicked.
            AcademicF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          
            LabelSC = new JLabel("Choose an academic tasktype: ");
            EditComponent.setLabel(LabelSC);
            assignmentradio= new JRadioButton("Assignment");
            
            examradio= new JRadioButton("Examination");
            
            Projectsradio= new JRadioButton("Project");
            
            OkButton= new JButton("OK");
            OkButton.addActionListener(new AcademicSchedule.taskListener());
            EditComponent.setButton(OkButton);
 
            ButtonGroup radioG2 = new ButtonGroup();
            radioG2.add(assignmentradio);
            radioG2.add(examradio);
            radioG2.add(Projectsradio);
            
            EditComponent.setRadio(assignmentradio,examradio,Projectsradio);
                    
            panel1 = new JPanel();
            panel2 = new JPanel(new GridLayout(3,1));
            panel3 = new JPanel();
          
            panel1.add(LabelSC);
            panel2.add(assignmentradio);
            panel2.add(examradio);
            panel2.add(Projectsradio);
            panel3.add(OkButton);
            EditComponent.colorPanel(panel1,panel2,panel3);

            AcademicF.add(panel1,BorderLayout.NORTH);
            AcademicF.add(panel2,BorderLayout.CENTER);
            AcademicF.add(panel3,BorderLayout.SOUTH);
            
            
            AcademicF.setLocationRelativeTo(null);
            AcademicF.setVisible(true);
    
    }
    public void academicWrite(char a){
            
             if(a=='a'){
                 
                aw = new JFrame();

                aw.setTitle("Assignment");
                // Set the size of this window.
                aw.setSize(WINDOW_WIDTH2, WINDOW_HEIGHT2);
                // Specify what happens when the close button is clicked.
                aw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
               
                LabelSC = new JLabel("Write the assignment's course code:");
                EditComponent.setLabel(LabelSC);
                
                imageIcon = new ImageIcon("C:\\Users\\janan\\OneDrive\\Desktop\\UJ\\OOP2\\project\\src\\project\\assign.jpg\\");
                aLabellist = new JLabel(imageIcon);
                astf = new JTextField(10);
                saveButton= new JButton("Save");
                saveButton.addActionListener(new AcademicSchedule.AcademicListener());
                EditComponent.setButton(saveButton);

                panel1 = new JPanel();
                panel2 = new JPanel();
                panel3 = new JPanel();
                
                dayslist = new JList(days);
                dayslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                dayslist.setVisibleRowCount(4);
                scrollPane= new JScrollPane(dayslist);

                panel1.add(LabelSC);
                panel1.add(astf);
                
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
                panel2.add(aLabellist);
                panel2.add(scrollPane);
                
                panel3.add(saveButton);
                
                EditComponent.colorPanel(panel1,panel2,panel3);

                aw.add(panel1,BorderLayout.NORTH);
                aw.add(panel2,BorderLayout.CENTER);
                aw.add(panel3,BorderLayout.SOUTH);


                aw.setLocationRelativeTo(null);
                aw.setVisible(true);
                
             }
             if(a=='e'){
                 
                aw = new JFrame();

                aw.setTitle("Examination");
                
                // Set the size of this window.
                aw.setSize(WINDOW_WIDTH2, WINDOW_HEIGHT2);
                // Specify what happens when the close button is clicked.
                aw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
                LabelSC = new JLabel("Write the exam's course code:");
                EditComponent.setLabel(LabelSC);
                imageIcon = new ImageIcon("C:\\Users\\janan\\OneDrive\\Desktop\\UJ\\OOP2\\project\\src\\project\\exam.jpg\\");
                aLabellist = new JLabel(imageIcon);
                astf = new JTextField(10);
                saveButton= new JButton("Save");
                saveButton.addActionListener(new AcademicSchedule.AcademicListener());
                EditComponent.setButton(saveButton);

                panel1 = new JPanel();
                panel2 = new JPanel();
                panel3 = new JPanel();
                
                dayslist = new JList(days);
                dayslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                dayslist.setVisibleRowCount(4);
                scrollPane= new JScrollPane(dayslist);
                
                panel1.add(LabelSC);
                panel1.add(astf);
                
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
                panel2.add(aLabellist);
                panel2.add(scrollPane);
                
                panel3.add(saveButton);
                EditComponent.colorPanel(panel1,panel2,panel3);

                aw.add(panel1,BorderLayout.NORTH);
                aw.add(panel2,BorderLayout.CENTER);
                aw.add(panel3,BorderLayout.SOUTH);


                aw.setLocationRelativeTo(null);
                aw.setVisible(true);
             
             }
             if(a=='p'){
                 
                aw = new JFrame();

                aw.setTitle("Project");
                // Set the size of this window.
                aw.setSize(WINDOW_WIDTH2, WINDOW_HEIGHT2);
                // Specify what happens when the close button is clicked.
                aw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                LabelSC = new JLabel("Write the project's course code:");
                EditComponent.setLabel(LabelSC);
                imageIcon = new ImageIcon("C:\\Users\\janan\\OneDrive\\Desktop\\UJ\\OOP2\\project\\src\\project\\project.jpg\\");
                aLabellist = new JLabel(imageIcon);
                astf = new JTextField(10);
                saveButton= new JButton("Save");
               
                saveButton.addActionListener(new AcademicSchedule.AcademicListener());
                EditComponent.setButton(saveButton);

                panel1 = new JPanel();
                panel2 = new JPanel();
                panel3 = new JPanel();
                
                dayslist = new JList(days);
                dayslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                dayslist.setVisibleRowCount(4);
                scrollPane= new JScrollPane(dayslist);
                
                panel1.add(LabelSC);
                panel1.add(astf);
                
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
                panel2.add(aLabellist);
                panel2.add(scrollPane);
                
                panel3.add(saveButton);
                EditComponent.colorPanel(panel1,panel2,panel3);

                aw.add(panel1,BorderLayout.NORTH);
                aw.add(panel2,BorderLayout.CENTER);
                aw.add(panel3,BorderLayout.SOUTH);

                aw.setLocationRelativeTo(null);
                aw.setVisible(true);
             
             }
             
            
        }
        //academic schedule window listener
        private  class taskListener implements ActionListener {
            public static int tasktype;

        @Override
        public void actionPerformed(ActionEvent e) {
            
             if (assignmentradio.isSelected()){
                tasktype=1;
                academicWrite('a');
             }
             if(examradio.isSelected()){
                
                tasktype=2;
                academicWrite('e');
             }
             if(Projectsradio.isSelected()){
                
                tasktype=3;
                academicWrite('p');
             }
            }
        }
        
        private  class AcademicListener implements ActionListener {
            
             String selected,written;
             String file= WeeklyScheduleDemo.loginListener.file;
             AcademicSchedule asched;
             WeeklySchedule wtsa;
             int taskt= taskListener.tasktype;
             
             @Override
        public void actionPerformed(ActionEvent e) {
            
              selected = (String) dayslist.getSelectedValue();
              written= astf.getText();
              
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
                      asched = new AcademicSchedule( written, selected , taskt);
                      wtsa= new WeeklySchedule(asched);
                      wtsa.setFileName(file);
                      wtsa.writeToScheduleA(asched);
                      AcademicF.dispose();
                      aw.dispose();
                      JOptionPane.showMessageDialog(null, "Your task has been saved successfully", "Saved", JOptionPane.INFORMATION_MESSAGE);
                      
                  }
                  catch(IOException a){
                      JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
                  }
                 }
                 
            }
        }

    /**
     * The getCourse method returns a AcademicSchedule
     * object's course.
     * @return The value in the course field.
     */
    public String getCourse() {
        return course;
    }
    /**
     * The getDay method returns a AcademicSchedule
     * object's day.
     * @return The value in the day field.
     */
    public String getDay() {
        return day;
    }
    /**
     * The getTaskType method returns a AcademicSchedule
     * object's TaskType.
     * @return The value in the TaskType field.
     */
    public int getTaskType() {
        return taskType;
    }
 
    
} 