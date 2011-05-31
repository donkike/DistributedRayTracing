package distributed;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.gridify.Gridify;

import raytracing.RayTracer;
import scene.Scene;

public class GridRenderer {
	
	@SuppressWarnings("unchecked")
	public static void render(Scene scene) throws GridException {
		GridFactory.start();
		try {
			long begin = System.currentTimeMillis();
			int numNodes = GridFactory.grid().nodes().size();
			int height = scene.getHeight();
			int delta = height / numNodes;
			for (int i = 0; i < height; i += delta) executeRayTracer(scene, i, i + delta < height ? i + delta : height);
			System.out.println("Running time: " + (System.currentTimeMillis() - begin));
		} finally {
			GridFactory.stop(true);
		}
	}
	
	@Gridify
	public static void executeRayTracer(Scene scene, int fromRow, int toRow) {
		new RayTracer(scene).execute(fromRow, toRow);
	}

}
