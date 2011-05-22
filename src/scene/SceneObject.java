package scene;

public abstract class SceneObject implements Primitive {
	
	protected String name;
	protected Material material;
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
