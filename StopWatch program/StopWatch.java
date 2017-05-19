package q3;

import javax.swing.JFrame;

/**
 * <p>StopWatch.java is a driver class which uses the StopWatchPanel class
 * to create a panel inside the Jpanel created.  The class also uses the 
 * JFrame methods to set the frame to the appropriate size of the panel.  
 * Lastly, the StopWatch class prints out whether it has successfully run 
 * through all of it's arguments. </p>
 *
 * @author Steven Ma
 * @version 1.0
 */
public class StopWatch {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Stop Watch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new StopWatchPanel());
        frame.pack(); // puts window to proper size
        frame.setVisible(true);
        System.out.println("Question three was called and ran sucessfully.");
    }

};
