package scene.objects;

import scene.Material;
import scene.SceneObject;
import math.Ray;
import math.Vector;

@SuppressWarnings("serial")
public class Cylinder extends SceneObject {
	
	private double radius;
	private Vector a, b, dir;
	
	public Cylinder(double radius, Vector a, Vector b, Material material){
		super(material, (a.add(b)).multiply(0.5));
		this.radius = radius;
		this.a = a;
		this.b = b;
		this.dir = (a.substract(b)).normalized();
	}

	@Override
	public Vector getNormal(Vector v) {
		double d1 = -(dir.dot(a));
		if(Math.abs(dir.dot(v)+d1) <= 0.0001){
			return dir;
		}
		double d2 = -((dir.multiply(-1)).dot(b));
		if(Math.abs((dir.multiply(-1)).dot(v)+d2) <= 0.0001){
			return dir.multiply(-1);
		}
		Vector perpendicular = (v.substract(b)).cross(dir);
		return (dir.cross(perpendicular)).normalized();
		
//		Vector n = (new Vector(v.getComponents()[0]-pos.getComponents()[0], 0, 
//				v.getComponents()[2]-pos.getComponents()[2]).normalized()).normalized();
//		
//		return n;
	}

	@Override
	public double intersects(Ray r) {
		double dotP1 = dir.dot(r.getDirection());
		if (dotP1 < 0){
			double d1 = - (dir.dot(a));
			double t1 = - (d1 + dir.dot(r.getOrigin())) / dotP1;
			Vector p1 = r.getPoint(t1);
			
			if ((p1.substract(a)).magnitudeSquared() <= (radius*radius)){
				return t1;
			}
		}
		
		double dotP2 = (dir.multiply(-1)).dot(r.getDirection());
		if (dotP2 < 0){
			double d2 = - ((dir.multiply(-1)).dot(b));
			double t2 = - (d2 + (dir.multiply(-1)).dot(r.getOrigin())) / dotP2;
			Vector p2 = r.getPoint(t2);
			
			if ((p2.substract(b)).magnitudeSquared() <= (radius*radius)){
				return t2;
			}
		}
		
		Vector AB = b.substract(a);
		Vector AO = r.getOrigin().substract(a);
		Vector AOxAB = AO.cross(AB);
		Vector VxAB = r.getDirection().cross(AB);
		double ab2 = AB.dot(AB);
		double A = VxAB.dot(VxAB);
		double B = 2 * (VxAB.dot(AOxAB));
		double C = (AOxAB.dot(AOxAB)) - (radius*radius*ab2);
		
		double disc = B*B-4*A*C;
		
		if (disc < 0) return -1;
		
		double t1 = (-B + Math.sqrt(disc))/(2*A);
		double t2 = (-B - Math.sqrt(disc))/(2*A);
		
		double t = (t1 < t2) ? t1 : t2;
		
		if(t >= 0){
			Vector point = r.getPoint(t);
			double dotA = (point.substract(a)).dot(dir);
			double dotB = (point.substract(b)).dot((dir.multiply(-1)));
			if(dotA > 0 || dotB > 0) t = -1;
		}
		
		return t;
	}

	public double getRadius() {
		return radius;
	}

	public Vector getDir() {
		return dir;
	}

	public Vector getB() {
		return b;
	}

	public Vector getA() {
		return a;
	}

}
