package distributed;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.gridify.Gridify;

import raytracer.RayTracer;
import scene.Scene;

public class GridRenderer {
	
	private static Grid grid = null;
	
	public static void startGrid() throws GridException {
		if (grid == null)
			grid = GridFactory.start();
	}
	
	public static int[][] render(Scene scene) {
		return executeRayTracer(scene, 0, scene.getHeight());	
	}
	
	public static void stopGrid() {
		GridFactory.stop(false); // don't cancel jobs, wait for completion
	}
	
	@Gridify(taskClass=RayTracerTask.class)
	public static int[][] executeRayTracer(Scene scene, int fromRow, int toRow) {
		return new RayTracer(scene).execute(fromRow, toRow);
	}

}
