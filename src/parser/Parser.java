package parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import scene.Scene;
import scene.SceneObject;

public class Parser {
	
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
		return scene;
	}
	
	public static SceneObject parseObject(Element object) {
		String type = object.getAttributeValue("type");
		Element position = object.getChild("position");
		double x = Double.parseDouble(position.getAttributeValue("x"));
	}

}
