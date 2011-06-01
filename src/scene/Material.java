package scene;

import java.io.Serializable;

import image.Color;

public class Material implements Serializable {
	
	private Color color;
	private double reflection;
	private double diffuse;
	private double refraction;
	
	public Material(Color color, double reflection, double diffuse, double refraction) {
		this.color = color;
		this.reflection = reflection;
		this.diffuse = diffuse;
		this.refraction = refraction;
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

	public double getRefraction() {
		return refraction;
	}
	
	public void setRefraction(double refraction) {
		this.refraction = refraction;
	}
	
	public String toString() {
		return "Material(" + color.toString() + ")" +
				"\n  Refraction:" + refraction + "; Reflection:" + reflection + "; Diffuse:" + diffuse;
	}
}
