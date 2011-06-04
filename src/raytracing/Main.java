package raytracing;


import image.Image;

import org.gridgain.grid.GridException;
import distributed.GridRenderer;
import parser.Parser;
import scene.Scene;

public class Main {
	
	public static void main(String[] args) {
		
		Scene scene = null;
		try {
			scene = Parser.parse("scenes/basic.xml");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		if (args[0].equals("sec")){
			RayTracer rt = new RayTracer(scene);
			long begin = System.currentTimeMillis();
			int[][] imageColors = rt.execute();
			long end = System.currentTimeMillis();
			System.out.println("Execution time: "+ (end - begin) +" ms");
			Image.generateImage(imageColors).save("secuentialRender.jpg", "jpeg");
		}
		if (args[0].equals("par")){
			try {
				GridRenderer.render(scene);
			} catch(GridException ge) {
				System.err.println("GridException: " + ge.getMessage());
			}
		}
	}

}
