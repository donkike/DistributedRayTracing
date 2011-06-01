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
		if (num > 1) num = 1;
		if (num < 0) num = 0;
		return new Color(getColorComponents(null)[0] * num, getColorComponents(null)[1] * num, getColorComponents(null)[2] * num);
	}
	
	public Color combine(Color c) {
		float colorComponents[][] = { getColorComponents(null), c.getColorComponents(null) };
		float newColorComponents[] = new float[3];
		for (int i = 0; i < newColorComponents.length; i++) 
			newColorComponents[i] = (colorComponents[0][i] + colorComponents[1][i]) / 2;
		return new Color(newColorComponents[0], newColorComponents[1], newColorComponents[2]);
	}
	
	public static Color combine(Color[] colors) {
		float colorComponents[] = new float[3];
		for (int i = 0; i < colorComponents.length; i++) {
			for (int j = 0; j < colors.length; j++) colorComponents[i] += colors[j].getComponents(null)[i];
			colorComponents[i] /= colors.length;
		}
		return new Color(colorComponents[0], colorComponents[1], colorComponents[2]);
	}
	
	public static Color createColor(java.awt.Color color) {
		return new Color(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	public String toString() {
		return "Color(R:" + getRed() + ",G:" + getGreen() + ",B:" + getBlue() + ")";
	}

}
