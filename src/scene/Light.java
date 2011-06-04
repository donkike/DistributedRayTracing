package scene;

import java.io.Serializable;

import image.Color;
import math.Vector;

public class Light implements Serializable {
	
	public static final int GLOBAL = 1;
	public static final int DIRECTIONAL = 2;
	public static final int SPOTLIGHT = 3;
	
	private Vector pos;
	private int type;
	private Color ambient, specular, diffuse;
	
	public Light(Vector pos, Color ambient, Color diffuse, Color specular, int type){
		this.setPos(pos);
		this.setAmbient(ambient);
		this.setDiffuse(diffuse);
		this.setSpecular(specular);
		this.setType(type);
	}

	public void setPos(Vector pos) {
		this.pos = pos;
	}

	public Vector getPos() {
		return pos;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setDiffuse(Color diffuse) {
		this.diffuse = diffuse;
	}

	public Color getDiffuse() {
		return diffuse;
	}

	public void setSpecular(Color specular) {
		this.specular = specular;
	}

	public Color getSpecular() {
		return specular;
	}

	public void setAmbient(Color ambient) {
		this.ambient = ambient;
	}

	public Color getAmbient() {
		return ambient;
	}
	

}
