package scene;

public interface Primitive {
	
	public double intersects(Ray r);
	public Vector getNormal(Vector v);

}
