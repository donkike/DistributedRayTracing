package scene;

import java.awt.Color;

public class Material {
	
	private Color color;
	private double reflection;
	private double diffuse;
	
	public Material(Color color, double reflection, double diffuse) {
		this.color = color;
		this.reflection = reflection;
		this.diffuse = diffuse;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public double getReflection() {
		return reflection;
	}
	
	public void setReflection(double reflection) {
		this.reflection = reflection;
	}
	
	public double getDiffuse() {
		return diffuse;
	}
	
	public void setDiffuse(double diffuse) {
		this.diffuse = diffuse;
	}

}
