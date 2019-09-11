import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
public class Tree extends JPanel {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		
		f.setVisible(true);
		f.setSize(750, 750);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tree t = new Tree();
		f.add(t);
	}
	
	Branch b;
	JSlider slider;
	JSlider slider1;
	JSlider slider2;
	public Tree() {
		// The base branch will always be at a 90 degree angle to the x axis
		
		this.setLayout(new BorderLayout());
		b = new Branch(375, 0, Math.PI / 2, 10, 100, 10.0);

		slider = new JSlider(JSlider.VERTICAL, 10, 200, 100);
		slider1 = new JSlider(JSlider.VERTICAL, 50, 200, 100);
		slider2 = new JSlider(1, 15, 10);
		
		this.setBackground(Color.BLACK);

		this.add(slider, BorderLayout.EAST);
		this.add(slider1, BorderLayout.WEST);
		this.add(slider2, BorderLayout.SOUTH);
		this.makeNewListeners(this);
		
	}
	/**
	Separate function because 1:1 relationship between ChangeListener and JSlider
	*/
	public void makeNewListeners(Tree t) {
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double val = ((double) slider.getValue()) / 10.0;
				b.setdTheta(val);
				t.repaint();
			}
		});

		slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				b.setLength(slider1.getValue());
				t.repaint();
			}
		});

		
		slider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				b.setDepth(slider2.getValue());
				t.repaint();
			}
		});
	}
	/**
	public void stateChanged(ChangeEvent e) {
		double val = ((double) slider.getValue()) / 10.0;
		b.setdTheta(val);
		this.repaint();
	}*/

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		b.draw(g);
	}

}