package scene;

import java.util.ArrayList;

public class Scene {
	
	private int width;
	private int height;
	private ArrayList<SceneObject> objects;
	
	public Scene(int width, int height) {
		objects = new ArrayList<SceneObject>();
		this.width = width;
		this.height = height;
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
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

}
