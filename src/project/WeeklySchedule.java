

/*                        ******Jana Nabiel Alyamani******
                          ******Dana Salem Alsharqi******
                          ******Sarah Saeed Almalki******
 */
package project;

import java.awt.BorderLayout;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;



public class WeeklySchedule extends JFrame {
    
    
            /*The fileName attribute holds the file name.*/ 
            public static String fileName;
            public AcademicSchedule aSched;//aggregation
            public ProductiveSchedule pSched;//aggregation

                /**
                 * Constructor 
                 * @param aSched 
                 */
                public WeeklySchedule(AcademicSchedule aSched) {
                    this.aSched = aSched;
                }
                
                /**
                 * Constructor
                 * @param pSched 
                 */
                public WeeklySchedule(ProductiveSchedule pSched) {
                    this.pSched = pSched;
                }
                
                /**
                 * Constructor
                 * @param fileName the fileName of WeeklySchedule.
                 */
                public WeeklySchedule(String fileName) {
                    this.fileName = fileName;
                }

                /**
                * The setFileName method stores a value in the 
                * fileName field.
                * @param fileName 
                */
                public void setFileName(String fileName) {
                    this.fileName = fileName;
                }
                
                
                /**
                 * The getFileName method returns a WeeklySchedule
                 * object's fileName.
                 * @return The value in the fileName field.
                 */
                public String getFileName() {
                    return fileName;
                }
                

                /**
                * This method is used to display the contents of a file in a window.
                * If the user did not fill the schedule(which leads to an empty file), 
                * a JOptionPane window is displayed to the user informing the user to fill the schedule.
                * @param fileName a string that holds the file name
                */
                public static void DisplaySchedule(String fileName) 
                {
                     final int WINDOW_WIDTH1 = 310; // Window width in pixels
                     final int WINDOW_HEIGHT1 = 200; // Window height in pixels
                      String filepath= new File(fileName +"").getAbsolutePath();
                      filepath = filepath.replace("\\", "\\\\");

                        try {

                            
                           File file=new File(filepath);
                           Scanner read = new Scanner(file);
                           
                           // used StringBuilder class to help with saving all the files content
                           StringBuilder content = new StringBuilder();

                            while (read.hasNextLine()) {
                                content.append(read.nextLine()).append("\n");
                            }
                            read.close();

                            JFrame DisplayF = new JFrame();
                            DisplayF.setTitle("Weekly Schedule");
                            // Set the size of this window.
                            DisplayF.setSize(WINDOW_WIDTH1, WINDOW_HEIGHT1);
                            // Specify what happens when the close button is clicked.
                            DisplayF.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                            DisplayF.setLayout(new BorderLayout());

                            JTextArea textArea = new JTextArea(7,30);
                            textArea.setText(content.toString());
                            textArea.setEditable(false);


                            JLabel scheduleLabel = new JLabel("This Weeks Schedule:");
                            EditComponent.setLabel(scheduleLabel);

                            JScrollPane scrolBarA = new JScrollPane(textArea);
                            scrolBarA.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                            scrolBarA.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                            JPanel panel1 = new JPanel();
                            JPanel panel2 = new JPanel();

                            panel1.add(scheduleLabel);
                            panel2.add(scrolBarA);
                            EditComponent.colorPanel(panel1,panel2,null);

                            DisplayF.add(panel1,BorderLayout.NORTH);
                            DisplayF.add(panel2,BorderLayout.CENTER);

                            DisplayF.setLocationRelativeTo(null);
                            DisplayF.setVisible(true);
                            }
                     
                        catch (FileNotFoundException e) {
                            JOptionPane.showMessageDialog(null, "You have to fill your schedule first", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }

                }



                /**
                * This method is used to write an academic schedule object to a file.
                * The contents of the academic schedule object are appended to the file.
                * @param aSched the academic schedule object to be written to the file
                * @throws IOException if an input or output exception occurs
                */
                
                public void writeToScheduleA(AcademicSchedule aSched)throws IOException
                {

                    FileWriter fwFileSchedule= new FileWriter(getFileName(),true);
                    PrintWriter pwFileSchedule =new PrintWriter(fwFileSchedule);
                    String[] TypeS = {"Assignment","Examination","Project"};
                    int tempType= aSched.getTaskType();
                    pwFileSchedule.println("  you have " +" '"+ aSched.getCourse() +"' "+ TypeS[--tempType]+" on "+aSched.getDay());
                    pwFileSchedule.println("  ---------------------------------------------");

                    pwFileSchedule.close();
                }
                /**
                * This method is used to write a productive schedule object to a file.
                * The contents of the productive schedule object are appended to the file.
                * @param pSched the productive schedule object to be written to the file
                * @throws IOException if an input or output exception occurs
                */
                public void writeToScheduleP(ProductiveSchedule pSched)throws IOException

                {

                    FileWriter fwFileSchedule= new FileWriter(getFileName(),true);
                    PrintWriter pwFileSchedule =new PrintWriter(fwFileSchedule);
                    String[] TypeS= {"Seminar","Workshop"};
                    int tempType=pSched.getEventType();
                    pwFileSchedule.println("  you have " +" '"+ pSched.getEventName() +"' " + TypeS[--tempType]+" on "+pSched.getDay());
                    pwFileSchedule.println("  ---------------------------------------------");

                    pwFileSchedule.close();
                }

}
