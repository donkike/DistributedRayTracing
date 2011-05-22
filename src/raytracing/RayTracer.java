package raytracing;

import scene.*;

public class RayTracer {
	
	private Scene scene;
	
	public RayTracer(Scene scene) {
		this.scene = scene;
	}
	
	public void execute() {
		for (int i = 0; i < scene.getNumObjects(); i++) {
			SceneObject object = scene.getObject(i);
			
		}
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
}
