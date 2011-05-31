package distributed;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.gridify.Gridify;

import raytracing.RayTracer;

public class GridRenderer {
	
	public static void render(RayTracer rt) throws GridException {
		GridFactory.start();
		try {
			int numNodes = GridFactory.grid().nodes().size();
			int height = rt.getScene().getHeight();
			int delta = height / numNodes;
			for (int i = 0; i < height; i += delta) executeRT(rt, i, i + delta < height ? i + delta : height);
		} finally {
			GridFactory.stop(true);
		}
	}
	
	@Gridify
	public static void executeRT(RayTracer rt, int fromRow, int toRow) {
		rt.execute(fromRow, toRow);
	}

}
