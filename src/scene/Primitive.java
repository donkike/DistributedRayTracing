package scene;

public interface Primitive {
	
	public double intersect(Ray r);
	public Vector getNormal(Vector v);

}
