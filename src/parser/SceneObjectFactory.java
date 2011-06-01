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
	
	public static Cylinder createCylinder(Element info){
		Material material = createMaterial(info.getChild("material"));
		double radius = Double.parseDouble(info.getChild("radius").getAttributeValue("value"));
		Element aInfo = info.getChild("a");
		double ax = Double.parseDouble(aInfo.getAttributeValue("x"));
		double ay = Double.parseDouble(aInfo.getAttributeValue("y"));
		double az = Double.parseDouble(aInfo.getAttributeValue("z"));
		Element bInfo = info.getChild("b");
		double bx = Double.parseDouble(bInfo.getAttributeValue("x"));
		double by = Double.parseDouble(bInfo.getAttributeValue("y"));
		double bz = Double.parseDouble(bInfo.getAttributeValue("z"));
		return new Cylinder(radius, new Vector(ax,ay,az), new Vector(bx,by,bz), material);
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
	
	public static Light createLight(Element info) {
		int type = Integer.parseInt(info.getAttributeValue("type"));
		Element position = info.getChild("position");
		double x = Double.parseDouble(position.getAttributeValue("x"));
		double y = Double.parseDouble(position.getAttributeValue("y"));
		double z = Double.parseDouble(position.getAttributeValue("z"));
		Element ambientInfo = info.getChild("ambient");
		Color ambient = new Color(Integer.parseInt(ambientInfo.getAttributeValue("red")),
								Integer.parseInt(ambientInfo.getAttributeValue("green")),
								Integer.parseInt(ambientInfo.getAttributeValue("blue")));
		Element diffuseInfo = info.getChild("diffuse");
		Color diffuse = new Color(Integer.parseInt(diffuseInfo.getAttributeValue("red")),
								Integer.parseInt(diffuseInfo.getAttributeValue("green")),
								Integer.parseInt(diffuseInfo.getAttributeValue("blue")));
		Element specularInfo = info.getChild("specular");
		Color specular = new Color(Integer.parseInt(specularInfo.getAttributeValue("red")),
								Integer.parseInt(specularInfo.getAttributeValue("green")),
								Integer.parseInt(specularInfo.getAttributeValue("blue")));
		return new Light(new Vector(x,y,z), ambient, diffuse, specular, type);
	}

}
