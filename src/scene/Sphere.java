package scene;

public class Sphere extends SceneObject {

	public Sphere(Vector pos) {
		this.pos = pos;
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
