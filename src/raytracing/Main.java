package raytracing;


import parser.Parser;
import scene.Scene;
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
		Image.generateImage(imageColors).save("basicWithParse.jpg", "jpeg");
		//Image.generateImage(imageColors).save("cylinder.jpg", "jpeg");
		/*try {
		//int[][] imageColors = rt.execute();
		//Image.generateImage(imageColors).save("basicWithParse.jpg", "jpeg");
		try {
			GridRenderer.render(scene);
		} catch(GridException ge) {
			System.err.println("GridException: " + ge.getMessage());
		}*/
		long end = System.currentTimeMillis();
		System.out.println("Execution time: "+ (end - begin) +" ms");
	}

}
