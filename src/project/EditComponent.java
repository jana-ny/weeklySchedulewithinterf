/*                        ******Jana Nabiel Alyamani******
                          ******Dana Salem Alsharqi******
                          ******Sarah Saeed Almalki******
 */
package project;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class EditComponent {
    
    
    // gold, (252,237, 108)
    public static Color gold= new Color(252,237, 108);
    //navy (4,30,52)
    public static Color navy= new Color(4,30,52);
    //whiteSmoke (245, 245, 245)
    public static Color whiteSmoke=new Color(245, 245, 245);
    /**
        * The colorPanel method sets a frame with 3 panels background color,
        * 
        * @param p1 the first Panel 
        * @param p2 the second Panel 
        * @param p3 the third Panel 
        */
        public static void colorPanel(JPanel p1, JPanel p2,JPanel p3)
        {
            try{
                p1.setBackground(navy);
                p2.setBackground(navy);
                p3.setBackground(navy);
            }
            catch(NullPointerException e){
                p1.setBackground(navy);
            }
        }
        
        /**
        * The setButton method sets a buttons background, foreground color,and 
        * sets the button font, and border
        * 
        * @param b1 the button
        */
        public static void setButton(JButton b1)
        {
        b1.setBackground(whiteSmoke);
        b1.setForeground(navy);
        b1.setFont(new Font("serif", Font.BOLD, 17));
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        }
        /**
        * The setLabel method sets a labels foreground color and font
        * 
        * @param L1 the label
        */
        public static void setLabel(JLabel L1)
        {
        
        L1.setForeground(gold.darker());
        L1.setFont(new Font("serif", Font.BOLD, 19));
        
        }
        
        /**
        * The setRadio method sets 3 radio buttons background, foreground color,
        * and font
        * 
        * @param r1 the first radio button 
        * @param r2 the second radio button
        * @param r3 the third radio button
        */
        public static void setRadio(JRadioButton r1,JRadioButton r2,JRadioButton r3)
        {
        
                try{
                    r1.setBackground(navy);
                    r2.setBackground(navy);
                    r3.setBackground(navy);
                    r1.setForeground(gold.darker());
                    r2.setForeground(gold.darker());
                    r3.setForeground(gold.darker());
                    r1.setFont(new Font("serif", Font.BOLD, 17));
                    r2.setFont(new Font("serif", Font.BOLD, 17));
                    r3.setFont(new Font("serif", Font.BOLD, 17));
                }
                catch(NullPointerException e){
                    r1.setBackground(navy);
                    r2.setBackground(navy);
                    r1.setForeground(gold.darker());
                    r2.setForeground(gold.darker());
                    r1.setFont(new Font("serif", Font.BOLD, 17));
                    r2.setFont(new Font("serif", Font.BOLD, 17));
                }
        }
    
}