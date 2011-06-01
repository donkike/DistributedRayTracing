package math;

import java.io.Serializable;


@SuppressWarnings("serial")
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

	public double getT(Vector v){
		double t = (v.getComponents()[0] - origin.getComponents()[0])/direction.getComponents()[0];
		if(Math.abs(t - (v.getComponents()[1] - origin.getComponents()[1]/direction.getComponents()[1])) <= 0.0001
				&& Math.abs(t - (v.getComponents()[2] - origin.getComponents()[2]/direction.getComponents()[2])) <= 0.0001){
			return t;
		}
		return -1;
	}
}
