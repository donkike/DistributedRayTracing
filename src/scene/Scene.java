package scene;

import java.util.ArrayList;

public class Scene {
	
	private ArrayList<SceneObject> objects;
	
	public void addObject(SceneObject object) {
		objects.add(object);
	}
	
	public ArrayList<SceneObject> getObjects() {
		return objects;
	}
	
	public int getNumObjects() {
		return objects.size();
	}

}
