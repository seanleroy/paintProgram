package sencore.com.cs.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintWindow extends JFrame {
	
	private JPanel panel;
	private DrawPad drawPad;
	private Container content;

	
	public PaintWindow() {
		panel = new JPanel();
		drawPad = new DrawPad();
		
		panel.setPreferredSize(new Dimension(140, 180));
		
		setSize(1000, 800);
		setTitle("Paint Program");
		
		content = this.getContentPane();
		content.setLayout(new BorderLayout());
		content.add(panel, BorderLayout.WEST);
		content.add(drawPad, BorderLayout.CENTER);
		
		makeColorButton(Color.BLACK);
		makeColorButton(Color.ORANGE);
		makeColorButton(Color.BLUE);
		makeColorButton(Color.GREEN);
		makeColorButton(Color.RED);
		makeColorButton(Color.YELLOW);
		
		JPanel clearPanel = new JPanel(new GridLayout(2, 1));
		clearPanel.setPreferredSize(new Dimension( 105, 50));
		
		JButton clearButton = new JButton("Clear");
		clearButton.setPreferredSize(new Dimension(50, 50));
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.clear();
			}
		});
		clearPanel.add(clearButton);
		panel.add(clearPanel);
		
		JPanel circlePanel = new JPanel(new BorderLayout());
		circlePanel.setPreferredSize(new Dimension(105, 50));
		JButton circle = new JButton("Circle");
		circle.setPreferredSize(new Dimension(50, 50));
		circle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.circle();
			}
			

		});
		clearPanel.add(circle);
		panel.add(circlePanel);
		
	}
	
	/**
	 * Create a new Color button for the program.
	 * @param c the color to create.
	 */
	public void makeColorButton(final Color c) {
		JButton tempButton = new JButton();
		tempButton.setBackground(c);
		tempButton.setPreferredSize(new Dimension(50, 50));
		panel.add(tempButton);
		tempButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawPad.changeColor(c);
			}
		});
	}

}
