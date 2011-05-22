package raytracing;

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
									  new Vector(0.0, 0.0, 1.0));
				int closer = -1;
				double distance = Double.MAX_VALUE;
				
				// search for closer object
				for (int k = 0; k < scene.getNumObjects(); k++) {
					SceneObject object = scene.getObject(k);
					double dist = object.intersects(viewRay);
					if (dist > 0 && dist < distance) {
						distance = dist;
						closer = k;
					}
				}
				
				// if object found, color image
				if (closer != -1) image.writePixel(i, j, scene.getObject(closer).getMaterial().getColor());
			}
		}
	}	
	
	public Image getImage() {
		return image;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
}
