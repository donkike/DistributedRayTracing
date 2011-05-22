package scene;

import java.util.ArrayList;

public class Scene {
	
	private ArrayList<SceneObject> objects;
	
	public Scene() {
		objects = new ArrayList<SceneObject>();
	}
	
	public void addObject(SceneObject object) {
		objects.add(object);
	}
	
	public SceneObject getObject(int i) {
		return objects.get(i);
	}
	
	public ArrayList<SceneObject> getObjects() {
		return objects;
	}
	
	public int getNumObjects() {
		return objects.size();
	}

}
