package scene;

public class Vector {
	
	public double x, y, z;
	
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double length() {
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	public void normalize() {
		double length = length();
		x /= length;
		y /= length;
		z /= length;
	}
	
	public Vector normalized() {
		double length = length();
		return new Vector(x / length, y / length, z / length);
	}
	
	public Vector add(Vector v) {
		return new Vector(x + v.x, y + v.y, z + v.z);
	}
	
	public Vector substract(Vector v) {
		return new Vector(x - v.x, y - v.y, z - v.z);
	}
	
	public double dot(Vector v) {
		return x * v.x + y * v.y + z * v.z;
	}
	
	public Vector cross(Vector v) {
		double newX = (y * v.z) - (z * v.y);
		double newY = (x * v.z) - (z * v.x);
		double newZ = (x * v.y) - (y * v.x);
		return new Vector(newX, -newY, newZ);
	}

}
