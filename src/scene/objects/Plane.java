package scene.objects;

import math.Ray;
import math.Vector;
import scene.Material;
import scene.SceneObject;

@SuppressWarnings("serial")
public class Plane extends SceneObject {
	
	private Vector min,max;
	private double a,b,c,d;
	private boolean infinite;

	public Plane(Vector min, Vector max, Vector other, Material material, boolean inf) {
		super(material, (min.add(max)).multiply(1/2));
		this.max = max;
		this.min = min;
		infinite = inf;
		
		Vector u = min.substract(other);
		Vector v = max.substract(other);
		Vector n = v.cross(u).normalized();
		
		a = n.getComponents()[0]; 
		b = n.getComponents()[1]; 
		c = n.getComponents()[2];
		d = - (a*min.getComponents()[0] + b*min.getComponents()[1] + c*min.getComponents()[2]);
	}

	@Override
	public double intersects(Ray r) {
		Vector n = new Vector(a,b,c);
		double dot = n.dot(r.getDirection());
		if(dot >= 0) return -1;
		double t = -(d + n.dot(r.getOrigin()))/dot;
		Vector p = r.getPoint(t);
		if(infinite || (p.geq(min) && p.leq(max))) return t;
		return -1;
	}

	@Override
	public Vector getNormal(Vector v) {
		return new Vector(a,b,c).normalized();
	}

	public void setMax(Vector max) {
		this.max = max;
	}

	public Vector getMax() {
		return max;
	}

	public void setMin(Vector min) {
		this.min = min;
	}

	public Vector getMin() {
		return min;
	}

	public void setInfinite(boolean infinite) {
		this.infinite = infinite;
	}

	public boolean isInfinite() {
		return infinite;
	}

}
