import java.awt.Graphics;
import java.awt.Point;

public class Branch {
	int x;
	int y;
	double angle;
	int depth;
	double length;
	double dTheta;

	/** - x and y are the points of origin
	    - If depth 0, reached end of tree. The depth will tell information about
	      how long to make the branch
      	- Angle is the angle of the current branch
      	- dTheta is used to increase/decrease the angle the children branch off into
      	- length is the length of the line drawn
    */
	public Branch(int x, int y, double angle, int depth, double length, double dTheta) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.depth = depth;
		this.length = length;
		this.dTheta = dTheta;
	}

	public void setdTheta(double val) {
		this.dTheta = val;
	}

	public void setLength(double val) {
		this.length = val;
	}

	public void setDepth(int val) {
		this.depth = val;
	}

	// Returns the end point of the line based on the angle and length
	public Point getNewPoint() {
		int newX = (int) ((Math.cos(angle) * length) + x);
		int newY = (int) ((Math.sin(angle) * length) + y);
		return new Point(newX, newY);
	}

	// Draws this branch and then draw all others
	public void draw(Graphics g) {
		Point p = this.getNewPoint();
		g.drawLine(x, y, p.x, p.y);

		if (depth != 0) {
			Branch left = new Branch(p.x, p.y, angle - (Math.PI) / dTheta, depth-1, length * 0.67, dTheta);
			Branch right = new Branch(p.x, p.y, angle + (Math.PI) / dTheta, depth-1, length * 0.67, dTheta);
			left.draw(g);
			right.draw(g);
		}

	}


}