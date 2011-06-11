package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
	
	public static final String RENDER = "render";
	public static final String CLEAR = "clear";
	
	private MainFrame main;
	private JButton btnRender;
	private JButton btnClear;
	
	public ButtonPanel(MainFrame main) {
		this.main = main;
		setPreferredSize(new Dimension(0, 200));
		setLayout(new GridLayout(2,3));
		
		btnRender = new JButton("Render");
		btnRender.setActionCommand(RENDER);
		btnRender.addActionListener(this);
		add(new JLabel());
		add(btnRender);
		add(new JLabel());
		
		btnClear = new JButton("Clear");
		btnClear.setActionCommand(CLEAR);
		btnClear.addActionListener(this);
		add(new JLabel());
		add(btnClear);
		add(new JLabel());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals(RENDER)) {
			main.render();
		} else if (command.equals(CLEAR)) {
			main.reset();
		}
	}

}
