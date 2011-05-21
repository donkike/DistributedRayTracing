package raytracing;

public abstract class SceneObject {
	
	protected String name;
	protected Material material;
	protected Vector pos;
	protected boolean light;
	
	public boolean isLight() {
		return light;
	}
	
	public void setLight(boolean light) {
		this.light = light;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
