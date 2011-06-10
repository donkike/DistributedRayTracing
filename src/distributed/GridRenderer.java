package distributed;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.gridify.Gridify;

import raytracer.RayTracer;
import scene.Scene;

public class GridRenderer {
	
	public static int[][] render(Scene scene) throws GridException {
		GridFactory.start();
		int[][] colors = null;
		try {
			long begin = System.currentTimeMillis();
			colors = executeRayTracer(scene, 0, scene.getHeight());
			long end = System.currentTimeMillis();
			System.out.println("Distributed execution time: " + (end - begin) + " ms");
		} finally {
			GridFactory.stop(false); // don't cancel jobs, wait for completion
		}
		return colors;
	}
	
	@Gridify(taskClass=RayTracerTask.class)
	public static int[][] executeRayTracer(Scene scene, int fromRow, int toRow) {
		return new RayTracer(scene).execute(fromRow, toRow);
	}

}
