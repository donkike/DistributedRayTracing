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
