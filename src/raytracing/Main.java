package raytracing;

import scene.Scene;
import math.*;
import scene.*;
import scene.objects.Plane;
import scene.objects.Sphere;

import image.Color;

public class Main {
	
	public static void main(String[] args) {
		
		Scene scene = new Scene(600, 400);
		scene.addObject(new Sphere(new Vector(200.0, 200.0, 100.0), 100.0,
								   new Material(Color.createColor(Color.ORANGE), 0.6, 0.8)));
		scene.addObject(new Plane(new Vector(0.0, 0.0, -1.0), 200.0, 
								  new Material(Color.createColor(Color.CYAN), 0.0, 0.0)));
		
		RayTracer rt = new RayTracer(scene);
		rt.execute();
		rt.getImage().save("basic.jpg", "jpeg");
		
	}

}
