package q3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.Font;

/**
 * <p>StopWatchPanel.java is a base class which constructs 
 * the Stop watch panel. The class creates the label for the 
 * timer and the buttons for start, stop and reset. The class 
 * utilizes a private class for each button as a listener. The
 * class adds each panel and each button to the original Stop
 * watch panel to achieve it's visible interface.   
 * </p>
 *
 * @author Steven Ma
 * @version 1.0
 */
public class StopWatchPanel extends JPanel {
    /**
     * <p>Constant for the main panel size in X-axis.</p>
     */
    private static final int DISPLAYX = 300;
    /**
     * <p>Constant for the main panel size in Y-axis.</p>
     */
    private static final int DISPLAYY1 = 80;
    /**
     * <p>Constant for the secondary panel in the Y-axis.</p>
     */
    private static final int DISPLAYY2 = 40;
    /**
     * <p>Constant for font size for timer.</p>
     */
    private static final int FTSIZE = 25;
    /**
     * <p>Constant for increasing timer label.</p>
     */
    private static final double INCRE = 0.1;
    /**
     * <p>Constant for the delay for the timer object.</p>
     */
    private static final int DELAY = 100;
    /**
     * <p>Declaration of of type timer object.</p>
     */
    private Timer timer;
    /**
     * <p>Declaration of JLabel object for labelTimer.</p>
     */
    private JLabel labelTimer;
    /**
     * <p>Declaration of JLabel object for start.</p>
     */
    private JButton start;
    /**
     * <p>Declaration of JLabel object for labelstart.</p>
     */
    private JLabel labelStart;
    /**
     * <p>Declaration of JLabel object for stop.</p>
     */
    private JButton stop;
    /**
     * <p>Declaration of JLabel object for labelStop.</p>
     */
    private JLabel labelStop;
    /**
     * <p>Declaration of JLabel object for reset.</p>
     */
    private JButton reset;
    /**
     * <p>Declaration of JLabel object for labelReset.</p>
     */
    private JLabel labelReset;
    /**
     * <p>Declaration of double primitive type.</p>
     */
    private double time;
    /**
     * <p>Declaration of Number format type called fmt.</p>
     */
    private NumberFormat fmt = new DecimalFormat("0.0");
    /**
     * <p>Method for creating the Stop watch panel.  Also creates 
     * the sub-panel inside for the timer and adds the start, stop and 
     * reset buttons.</p>
     */
    public StopWatchPanel() {
        setPreferredSize(new Dimension(DISPLAYX, DISPLAYY1));
        setBackground(Color.green);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(DISPLAYX, DISPLAYY2));
        panel.setBackground(Color.red);
        add(panel);

        timer = new Timer(DELAY, new TimerListener());
        labelTimer = new JLabel(fmt.format(time));
        labelTimer.setFont(new Font("Serif", 1, FTSIZE));
        panel.add(labelTimer);

        start = new JButton("Start");
        start.addActionListener(new StartButtonListener());

        labelStart = new JLabel();
        add(start);
        add(labelStart);

        stop = new JButton("Stop");
        stop.addActionListener(new StopButtonListener());
        labelStop = new JLabel();
        add(stop);
        add(labelStop);

        reset = new JButton("Reset");
        reset.addActionListener(new ResetButtonListener());
        labelReset = new JLabel();
        add(reset);
        add(labelReset);
    }
    /**
     * <p>StartButtonListner is a private listener class which implements the 
     * interface ActionListner.  It contains a method which listens
     * for an action event that is associated with the Start button.</p>
     *
     * @author Steven Ma
     * @version 1.0
     */
    private class StartButtonListener implements ActionListener {
        /**
         * <p>Method for starting timer object.</p>
         * @param event ActionEvent formal parameter inputed.
         */
        public void actionPerformed(ActionEvent event) {
            timer.start();
        }
    }
    /**
     * <p>StartButtonListner is a private listener class which implements the 
     * interface ActionListner.  It contains a method which listens
     * for an action event that is associated with the Stop button.</p>
     *
     * @author Steven Ma
     * @version 1.0
     */
    private class StopButtonListener implements ActionListener {
        /**
         * <p>Method for stopping timer object.</p>
         * @param event ActionEvent formal parameter inputed.
         */
        public void actionPerformed(ActionEvent event) {
            timer.stop();
        }
    }
    /**
     * <p>StartButtonListner is a private listener class which implements the 
     * interface ActionListner.  It contains a method which listens
     * for an action event that is associated with the Reset button.</p>
     *
     * @author Steven Ma
     * @version 1.0
     */
    private class ResetButtonListener implements ActionListener {
        /**
         * <p>Method for reseting timer label.</p>
         * @param event ActionEvent formal parameter inputed.
         */
        public void actionPerformed(ActionEvent event) {

            time = 0.0;
            labelTimer.setText(fmt.format(time));
        }
    }
    /**
     * <p>StartButtonListner is a private listener class which implements the 
     * interface ActionListner.  It contains a method which listens
     * for an action event that is associated with the Timer object.</p>
     *
     * @author Steven Ma
     * @version 1.0
     */
    private class TimerListener implements ActionListener {
        /**
         * <p>Method for increasing the timer label from timer object.</p>
         * @param event ActionEvent formal parameter inputed.
         */
        public void actionPerformed(ActionEvent event) {
            time = time + INCRE;
            labelTimer.setText(fmt.format(time));
        }
    }
}