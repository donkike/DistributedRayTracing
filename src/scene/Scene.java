package scene;

import java.io.Serializable;
import java.util.ArrayList;

public class Scene implements Serializable {
	
	private int width;
	private int height;
	private ArrayList<SceneObject> objects;
	private ArrayList<SceneObject> lights;
	
	public Scene(int width, int height) {
		objects = new ArrayList<SceneObject>();
		lights = new ArrayList<SceneObject>();
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
	
	public void addLight(SceneObject object){
		lights.add(object);
	}
	
	public SceneObject getLight(int i){
		return lights.get(i);
	}
	
	public ArrayList<SceneObject> getLights(){
		return lights;
	}
	
	public int getNumObjects() {
		return objects.size();
	}
	
	public int getNumLights(){
		return lights.size();
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setLights(ArrayList<SceneObject> lights) {
		this.lights = lights;
	}
	
	public void setObjects(ArrayList<SceneObject> objects) {
		this.objects = objects;
	}
	
	public String toString() {
		String value = "Scene:";
		value += "\n--Lights:";
		for (SceneObject light : lights) 
			value += "\n" + light.toString();
		value += "\n--Objects:";
		for (SceneObject object : objects)
			value += "\n" + object.toString();
		return value;
	}

}
