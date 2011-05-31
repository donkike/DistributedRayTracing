package math;

import java.io.Serializable;


public class Ray implements Serializable {
	
	private Vector origin;
	private Vector direction;
	
	public Ray(Vector origin, Vector direction) {
		this.origin = origin;
		this.direction = direction;
	}
	
	public Vector getPoint(double t){
		return origin.add(direction.multiply(t));
	}
	
	public Vector getOrigin() {
		return origin;
	}
	
	public Vector getDirection() {
		return direction;
	}

}
