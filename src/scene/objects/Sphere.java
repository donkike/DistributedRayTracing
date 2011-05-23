package scene.objects;

import scene.Material;
import scene.SceneObject;
import math.Ray;
import math.Vector;

public class Sphere extends SceneObject {
	
	private Vector center;
	private double radius;

	public Sphere(Vector center, double radius, Material material) {
		super(material);
		this.center = center;
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public Vector getCenter() {
		return center;
	}
	
	@Override
	public double intersects(Ray r) {
		Vector d = r.getDirection(), o = r.getOrigin();
		Vector delta = o.substract(center);
		
		double A = d.dot(d);
		double B = 2 * (delta.dot(d));
		double C = delta.dot(delta) - radius*radius;
		
		double disc = B * B - 4 * A * C;
		if (disc < 0) return -1;
		
		double q;
		if (B < 0) 
			q = (-B + Math.sqrt(disc)) / 2;
		else
			q = (-B - Math.sqrt(disc)) / 2;
		
		double t0 = q / A, t1 = C / q;
		return (t0 > 0) ? t0 : (t1 > 0) ? t1 : -1;
	}

	@Override
	public Vector getNormal(Vector v) {
		Vector normal = center.substract(v);
		return normal.normalized();
	}

}
