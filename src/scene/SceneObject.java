package scene;

import java.io.Serializable;

import math.Vector;

public abstract class SceneObject implements Primitive, Serializable {
	
	protected String name;
	protected Vector pos;
	protected Material material;
	protected boolean light;
	
	public SceneObject(Material material, Vector pos) {
		this.material = material;
		this.pos = pos;
		light = false;
	}
	
	public Vector getPos(){
		return pos;
	}
	
	public void setPos(Vector pos){
		this.pos = pos;
	}
	
	public boolean isLight() {
		return light;
	}
	
	public void setLight(boolean light) {
		this.light = light;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Object: " + this.getClass().getName() + " at " + pos.toString() + "\n" + material.toString();
	}

}
