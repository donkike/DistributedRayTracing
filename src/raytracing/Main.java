package raytracing;

import org.gridgain.grid.GridException;

import parser.Parser;

import distributed.GridRenderer;
import scene.Scene;
import math.*;
import scene.*;
import scene.objects.Sphere;
import image.Color;
import image.Image;

public class Main {
	
	public static void main(String[] args) {
		
		Scene scene = null;
		try {
			scene = Parser.parse("scenes/basic.xml");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		RayTracer rt = new RayTracer(scene);
		long begin = System.currentTimeMillis();
		int[][] imageColors = rt.execute();
		Image.generateImage(imageColors).save("basicWithParse.jpg", "jpg");
		/*try {
			GridRenderer.render(scene);
		} catch(GridException ge) {
			System.err.println("GridException: " + ge.getMessage());
		}*/
		long end = System.currentTimeMillis();
		//rt.getImage().save("basic.jpg", "jpeg");
		System.out.println("Execution time: "+ (end - begin) +" ms");
	}

}
