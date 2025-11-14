package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Basic1 extends JFrame{

	private static final long serialVersionUID = 1L;

	
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		
		
		
	}
	
	static void createAndShowGUI(){
		JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] JButton Scores! [=]");
        
        Gui gui=new Gui();
        
        frame.setContentPane(gui.createContext());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 190);
        frame.setVisible(true);
        
	}
}



class Gui implements ActionListener{
	
	JButton send = new JButton("send");

	JButton delete;

	JButton cancel;
	
	 int redScoreAmount = 0;
	    int blueScoreAmount = 0;

	    JPanel titlePanel, scorePanel, buttonPanel;
	    JLabel redLabel, blueLabel, redScore, blueScore;
	    JButton redButton, blueButton, resetButton;
	
	 JPanel createContext() {
		 JPanel totalGUI = new JPanel();
	        totalGUI.setLayout(null);

	        titlePanel = new JPanel();
	        titlePanel.setLayout(null);
	        titlePanel.setLocation(10, 0);
	        titlePanel.setSize(250, 30);
	        totalGUI.add(titlePanel);
		
		buttonPanel = new JPanel();
	        buttonPanel.setLayout(null);
	        buttonPanel.setLocation(10, 80);
	        buttonPanel.setSize(260, 70);
	        totalGUI.add(buttonPanel);
		
	       // buttonPanel.add(send);
	        
	        redButton = new JButton("Red Score!");
	        redButton.setLocation(0, 0);
	        redButton.setSize(120, 30);
	        redButton.addActionListener(this);
	        buttonPanel.add(redButton);
	        
	        send = new JButton("send");
	        send.setLocation(130, 0);
	        send.setSize(120, 30);
	        send.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					totalGUI.setBackground(new Color(700) );
				}
			}
					);
	        buttonPanel.add(send);
		
		
		totalGUI.setOpaque(true);
		return totalGUI;
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == redButton)
        {
            redScoreAmount = redScoreAmount + 1;
            redScore.setText(""+redScoreAmount);
        }
        else if(e.getSource() == blueButton)
        {
            blueScoreAmount = blueScoreAmount + 1;
            blueScore.setText(""+blueScoreAmount);
        }
        else if(e.getSource() == resetButton)
        {
            redScoreAmount = 0;
            blueScoreAmount = 0;
            redScore.setText(""+redScoreAmount);
            blueScore.setText(""+blueScoreAmount);
        }
    }
}
