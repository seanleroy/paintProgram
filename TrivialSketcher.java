package sencore.com.cs.graphics;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrivialSketcher extends JFrame {
	
	public static void main( String[] args ) {
		PaintWindow frame = new PaintWindow();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	// keeps track of the last point to draw the net line from.
	
	
/*	public static void main( String[] args ) {
		JFrame frame = new JFrame( "Simple Sketching Program" );
		DrawPad pad = new DrawPad();
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		
		content.add(pad, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		
		
		content.add(buttonPanel, BorderLayout.WEST);
		buttonPanel.setPreferredSize(new Dimension(140, 100));
		buttonPanel.setMinimumSize(new Dimension(32, 68));
		buttonPanel.setMaximumSize(new Dimension(32, 68));

		
	}

*/
	
}
