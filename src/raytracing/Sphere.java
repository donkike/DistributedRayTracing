package raytracing;

public class Sphere extends SceneObject implements Primitive {

	public Sphere(Vector pos) {
		this.pos = pos;
	}
	
	@Override
	public boolean intersect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getNormal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
