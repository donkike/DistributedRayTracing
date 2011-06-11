package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private InputPanel inputPanel;
	private ButtonPanel buttonPanel;

	public MainFrame() {
		setSize(800,600);
		
		setLayout(new BorderLayout());
		
		inputPanel = new InputPanel();
		inputPanel.setDefaults("", "images", "output_image.jpg", "jpeg");
		inputPanel.resetDefaultValues();
		add(inputPanel, BorderLayout.CENTER);
		
		buttonPanel = new ButtonPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
