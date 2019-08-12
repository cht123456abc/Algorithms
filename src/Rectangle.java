import java.awt.Color;

public class Rectangle implements Comparable<Rectangle>{
	private double value;
	private double x;
	private double y;
	private double halfWidth;
	private double halfHeight;
	private Color c;

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getHalfWidth() {
		return halfWidth;
	}
	public void setHalfWidth(double halfWidth) {
		this.halfWidth = halfWidth;
	}
	public double getHalfHeight() {
		return halfHeight;
	}
	public void setHalfHeight(double halfHeight) {
		this.halfHeight = halfHeight;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	
	public int compareTo(Rectangle anotherRectangle) {
		return (this.getValue() < anotherRectangle.getValue()) ? -1 : ((this.getValue() == anotherRectangle.getValue()) ? 0 : 1);
	}
	
}
