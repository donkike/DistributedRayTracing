package raytracing;

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

}
