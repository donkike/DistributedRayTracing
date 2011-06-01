package scene;

import java.io.Serializable;

import image.Color;

@SuppressWarnings("serial")
public class Material implements Serializable {
	
	private Color color;
	private double reflection;
	private double diffuse;
	private double refraction;
	private double specular;
	
	public Material(Color color, double diffuse, double specular, double reflection, double refraction) {
		this.color = color;
		this.reflection = reflection;
		this.diffuse = diffuse;
		this.refraction = refraction;
		this.specular = specular;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setSpecular(double specular) {
		this.specular = specular;
	}
	
	public double getSpecular() {
		return specular;
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
		return "Material(Color(R:" + color.getRed() + ",G:" + color.getGreen() + ",B:" + color.getBlue() + "))" +
				"\n  Refraction:" + refraction + "; Reflection:" + reflection + "; Diffuse:" + diffuse;
	}
}
