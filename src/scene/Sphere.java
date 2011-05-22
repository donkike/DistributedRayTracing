package scene;

public class Sphere extends SceneObject {
	
	private double radius;

	public Sphere(Vector pos, double radius) {
		this.pos = pos;
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	@Override
	public int intersect() {
		return 0;
	}

	@Override
	public double getNormal() {
		return 0;
	}

}
