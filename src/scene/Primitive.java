package scene;

import math.Ray;
import math.Vector;

public interface Primitive {
	
	public double intersects(Ray r);
	public Vector getNormal(Vector v);

}
