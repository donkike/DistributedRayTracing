package image;

public class Color extends java.awt.Color {
	
	private static final long serialVersionUID = 1L;

	public Color(float r, float g, float b) {
		super(r, g, b);
	}
	
	public Color(int r, int g, int b) {
		super(r, g, b);
	}
	
	public Color multiply(float num) {
		return new Color(getRed() * num, getGreen() * num, getBlue() * num);
	}
	
	public Color combine(Color c) {
		float colorComponents[][] = { getColorComponents(null), c.getColorComponents(null) };
		float newColorComponents[] = new float[3];
		for (int i = 0; i < newColorComponents.length; i++) 
			newColorComponents[i] = (colorComponents[0][i] + colorComponents[1][i]) / 2;
		return new Color(newColorComponents[0], newColorComponents[1], newColorComponents[2]);
	}

}
