package scene.objects;

import math.Ray;
import math.Vector;
import scene.Material;
import scene.SceneObject;

public class Plane extends SceneObject {
	
	private Vector normal;
	private double distance;

	public Plane(Vector normal, double distance, Material material) {
		super(material);
		this.normal = normal;
		this.distance = distance;
	}
	
	public double getDistance() {
		return distance;
	}

	@Override
	public double intersects(Ray r) {
		Vector d = r.getDirection(), o = r.getOrigin();
		double denom = d.dot(normal);
		if (denom > -0.0001 && denom < 0.0001) return -1;
		double t = (-distance - o.dot(normal)) / denom;
		return (t > 0) ? t : -1;
	}

	@Override
	public Vector getNormal(Vector v) {
		return normal;
	}

}
