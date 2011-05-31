package image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	
	private BufferedImage image;
	
	public Image(int width, int height) {
		createImage(width, height);
	}
	
	public void createImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public void save(String filename, String format) {
		try {
			File file = new File("images/" + filename);
			ImageIO.write(image, format, file);
			System.out.println("Saved image to " + file.getAbsolutePath() + " in " + format + " format");
		} catch (IOException ioe) {
			System.out.println("Could not save image: " + ioe.getMessage());
		}
	}
	
	public void writePixel(int x, int y, Color color) {
		image.setRGB(x, y, color.getRGB());
	}
	
	public void writePixel(int x, int y, int RGB) {
		image.setRGB(x, y, RGB);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public int getHeight() {
		return image.getHeight();
	}
	
	public static Image generateRandomImage(int width, int height) {
		Image randomImage = new Image(width, height);
		float colorComponents[] = new float[3];
		for (int i = 0; i < randomImage.getWidth(); i++) {
			for (int j = 0; j < randomImage.getHeight(); j++) {
				for (int k = 0; k < 3; k++) colorComponents[k] = (float)Math.random();
				Color color = new Color(colorComponents[0], colorComponents[1], colorComponents[2]);
				randomImage.writePixel(i, j, color);
			}
		}
		return randomImage;
	}
	
	public static Image generateImage(int[][] colors) {
		Image image = new Image(colors[0].length, colors.length);
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < colors[0].length; j++) 
				image.writePixel(j, i, colors[i][j]);			
		}
		return image;
	}

}
