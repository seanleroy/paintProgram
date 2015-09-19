package sencore.com.cs.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;

public class DrawPad extends JComponent {
	
	private Image image;
	private Graphics2D graphics2D;
	private DrawPad drawPad;
	private ColorButton button;
	
	private int currentX, currentY, oldX, oldY;
	private int width = 50, height = 50;
	
	public DrawPad() {
		setDoubleBuffered(false);
		
		addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		
		addMouseMotionListener( new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				graphics2D.setStroke(new BasicStroke(4));
				graphics2D.drawLine(oldX, oldY, currentX, currentY);
				repaint();
				
				 oldX = currentX;
				 oldY = currentY;
			}
		});
	}
	
	public void layout() {
		
	}
	
	/**
	 * Create the image to paint on.
	 */
	public void paintComponent(Graphics g) {
		if ( image == null ) {
			// createImage, creates an on-screen drawable image to be used for
			// double buffering.
			image = createImage(getSize().width, getSize().height);
			// creates a graphics context for drawing to an off-screen image
			graphics2D = (Graphics2D) image.getGraphics();
			// sets the value of a single preference for the rendering algorithms
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			clear();
		}
		
		g.drawImage(image,  0,  0,  null);
	}
	
	/**
	 * Clear the screen for a blank pad to draw on.
	 */
	public void clear() {
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0,  0,  getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		// repaints the component
		repaint();
	}
	
	public void circle() {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				oldX = e.getX();
				oldY = e.getY();
				
			}
			
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				
			}
			
			public void mouseReleased(MouseEvent e) {
			
				width += currentX;
				height += currentY;
				graphics2D.setStroke(new BasicStroke(4));
				graphics2D.drawOval(oldX - 7, oldY - 7, width, height);
				repaint();
				
				
			}
		});
		

	}
	
	public void changeColor(final Color theColor) {
		graphics2D.setPaint(theColor);
		repaint();
		
	}
	
	class ColorButton {
		
			
	}

}
