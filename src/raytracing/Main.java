package raytracing;

import scene.Scene;
import math.*;
import scene.*;
import scene.objects.Sphere;

import image.Color;

public class Main {
	
	public static void main(String[] args) {
		
		Scene scene = new Scene(600, 400);
		Sphere light = new Sphere(new Vector(200.0, 200.0, 200.0), 200.0,
									new Material(Color.createColor(java.awt.Color.YELLOW), 0.0, 0.0));
		scene.addLight(light);
		scene.addObject(new Sphere(new Vector(200.0, 200.0, 100.0), 100.0,
								   new Material(Color.createColor(Color.ORANGE), 0.6, 0.8)));		
		RayTracer rt = new RayTracer(scene);
		long begin = System.currentTimeMillis();
		rt.execute();
		long end = System.currentTimeMillis();
		rt.getImage().save("basic.jpg", "jpeg");
		System.out.println("Execution time: "+ (end - begin) +" ms");		
	}

}
