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
									new Material(Color.createColor(Color.YELLOW), 0.0, 0.0, 0.0));
		scene.addLight(light);
		Sphere light2 = new Sphere(new Vector(400.0, 300.0, 400.0), 10.0,
									new Material(Color.createColor(Color.YELLOW), 0.0, 0.0, 0.0));
		scene.addLight(light2);
		scene.addObject(new Sphere(new Vector(300.0, 200.0, 100.0), 100.0,
								   new Material(Color.createColor(Color.ORANGE), 0.6, 0.47, 1.52)));
		scene.addObject(new Sphere(new Vector(200.0, 100.0, 200.0), 50.0,
								   new Material(Color.createColor(Color.CYAN), 0.4, 0.6, 1.33)));
		scene.addObject(new Sphere(new Vector(400.0, 100.0, 50.0), 70.0,
								   new Material(Color.createColor(Color.RED), 0.3, 0.54, 1.54)));
		RayTracer rt = new RayTracer(scene);
		long begin = System.currentTimeMillis();
		rt.execute();
		long end = System.currentTimeMillis();
		rt.getImage().save("basic.jpg", "jpeg");
		System.out.println("Execution time: "+ (end - begin) +" ms");		
	}

}
