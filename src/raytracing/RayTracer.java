package raytracing;


import image.Color;
import image.Image;
import scene.*;
import math.*;

public class RayTracer {
	
	private Scene scene;
	private Image image;
	
	public RayTracer(Scene scene) {
		this.scene = scene;
		image = new Image(scene.getWidth(), scene.getHeight());
	}
	
	public void execute() {
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				
				// cast ray
				Ray viewRay = new Ray(new Vector((double)i, (double)j, -1000.0), 
									  new Vector(0.0, 0.0, 1.0).normalized());
				
				image.writePixel(i, j, intersectObject(viewRay));
			}
		}
	}	
	
	public Color intersectObject(Ray r){
		double distance = Double.MAX_VALUE;
		Color color = Color.createColor(Color.BLACK);
		
		// search for closer object
		for (int k = 0; k < scene.getNumObjects(); k++) {
			SceneObject object = scene.getObject(k);
			double dist = object.intersects(r);
			if (dist > 0 && dist < distance) {
				distance = dist;
				color = findColor(object, distance, r);
			}
		}
		
		return color;
	}
	
	public Color findColor(SceneObject o, double d, Ray r){
		Color color, reflectColor, refractColor;
		color = reflectColor = refractColor = o.getMaterial().getColor();
		Vector intersection = r.getDirection().multiply(d);
		double c1 = - o.getNormal(intersection).dot(r.getDirection());
		if (o.getMaterial().getReflection() > 0){
			Vector reflectDirection = r.getDirection().add(o.getNormal(intersection).multiply(2*c1));
			reflectColor = intersectObject(new Ray(intersection, reflectDirection));
			reflectColor = reflectColor.multiply((float)o.getMaterial().getReflection());
		}
		if(o.getMaterial().getDiffuse() > 0){
			double n = o.getMaterial().getDiffuse();
			double c2 = Math.sqrt(1- Math.pow(n, 2) * (1 - Math.pow(c1, 2)));
			Vector refractDirection = r.getDirection().multiply(n).add(o.getNormal(intersection).multiply(n*c1-c2));
			refractColor = intersectObject(new Ray(intersection, refractDirection));
			refractColor = refractColor.multiply((float)o.getMaterial().getReflection());
		}
		//Combinar los colores
		Color[] colors = {color, reflectColor, refractColor};
		return Color.combine(colors);
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
}
