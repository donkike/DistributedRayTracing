package scene;

public class SceneObjectFactory {
	
	public SceneObject create(String objectName, Object... args) {
		try {
			Class cl = Class.forName(objectName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
