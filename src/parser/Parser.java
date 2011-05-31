package parser;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.util.StringUtils;

import scene.Scene;
import scene.SceneObject;

public class Parser {
	
	@SuppressWarnings("unchecked")
	public static Scene parse(String filename) throws Exception {
		File file = new File(filename);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(file);
		Element root = doc.getRootElement();
		Scene scene = new Scene(Integer.parseInt(root.getAttributeValue("width")), 
								Integer.parseInt(root.getAttributeValue("height")));
		ArrayList<SceneObject> objects = new ArrayList<SceneObject>();
		ArrayList<SceneObject> lights = new ArrayList<SceneObject>();
		List<Element> lightElements = root.getChild("lights").getChildren("light");
		for (Element light : lightElements) 
			lights.add(parseObject(light));
		List<Element> objectElements = root.getChild("objects").getChildren("object");
		for (Element object : objectElements) 
			objects.add(parseObject(object));
		scene.setLights(lights);
		scene.setObjects(objects);
		return scene;
	}
	
	public static SceneObject parseObject(Element object) {
		String type = object.getAttributeValue("type");
		Method method = null;
		try {
			method = SceneObjectFactory.class.getMethod("create" + StringUtils.capitalize(type), Element.class);
			return (SceneObject)method.invoke(null, object);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
