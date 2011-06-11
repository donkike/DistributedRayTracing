package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
	
	private JButton btnRender;
	private JButton btnClear;
	
	public ButtonPanel() {
		setPreferredSize(new Dimension(0, 200));
		setLayout(new GridLayout(2,3));
		
		btnRender = new JButton("Render");
		add(new JLabel());
		add(btnRender);
		add(new JLabel());
		
		btnClear = new JButton("Clear");
		add(new JLabel());
		add(btnClear);
		add(new JLabel());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
