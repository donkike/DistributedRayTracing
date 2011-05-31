package parser;

import image.Color;

import math.Vector;

import org.jdom.Element;

import scene.*;
import scene.objects.*;

public class SceneObjectFactory {
	
	public static Plane createPlane(Element info){
		Material material = createMaterial(info.getChild("material"));
		Element minInfo = info.getChild("min");
		double minx = Double.parseDouble(minInfo.getAttributeValue("x"));
		double miny = Double.parseDouble(minInfo.getAttributeValue("y"));
		double minz = Double.parseDouble(minInfo.getAttributeValue("z"));
		Element maxInfo = info.getChild("max");
		double maxx = Double.parseDouble(maxInfo.getAttributeValue("x"));
		double maxy = Double.parseDouble(maxInfo.getAttributeValue("y"));
		double maxz = Double.parseDouble(maxInfo.getAttributeValue("z"));
		Element oInfo = info.getChild("other");
		double ox = Double.parseDouble(oInfo.getAttributeValue("x"));
		double oy = Double.parseDouble(oInfo.getAttributeValue("y"));
		double oz = Double.parseDouble(oInfo.getAttributeValue("z"));
		return new Plane(new Vector(minx,miny,minz), new Vector(maxx,maxy,maxz), new Vector(ox,oy,oz),
						 material, Boolean.parseBoolean(info.getAttributeValue("infinite")));
	}
	
	public static Sphere createSphere(Element info) {
		Material material = createMaterial(info.getChild("material"));
		double radius = Double.parseDouble(info.getChild("radius").getAttributeValue("value"));
		Element position = info.getChild("position");
		double x = Double.parseDouble(position.getAttributeValue("x"));
		double y = Double.parseDouble(position.getAttributeValue("y"));
		double z = Double.parseDouble(position.getAttributeValue("z"));
		return new Sphere(new Vector(x, y, z), radius, material);
	}
	
	public static Material createMaterial(Element info) {
		Element colorInfo = info.getChild("color");
		Color color = new Color(Integer.parseInt(colorInfo.getAttributeValue("red")),
								Integer.parseInt(colorInfo.getAttributeValue("green")),
								Integer.parseInt(colorInfo.getAttributeValue("blue")));
		double diffuse = Double.parseDouble(info.getChild("diffuse").getAttributeValue("value"));
		double refraction = Double.parseDouble(info.getChild("refraction").getAttributeValue("value"));
		double reflection = Double.parseDouble(info.getChild("reflection").getAttributeValue("value"));
		return new Material(color, reflection, diffuse, refraction);
	}

}
