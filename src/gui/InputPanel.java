package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ListUtils;


public class InputPanel extends JPanel implements ActionListener {
	
	public static final String SCENE = "scene";
	public static final String DIR = "dir";
	
	private JLabel lblSceneFile;
	private JTextField txtSceneFile;
	private JButton btnSceneFile;
	private String defSceneFile;
	
	private JLabel lblOutputDir;
	private JTextField txtOutputDir;
	private JButton btnOutputDir;
	private String defOutputDir;
	
	private JLabel lblOutputFile;
	private JTextField txtOutputFile;
	private String defOutputFile;
	
	private JLabel lblFormat;
	private JComboBox cboFormat;
	private String defFormat;
	
	private JLabel lblGrid;
	private JCheckBox chkGrid;
	
	public InputPanel() {
		setPreferredSize(new Dimension(0, 400));
		setLayout(new GridLayout(5,3));
		
		lblSceneFile = new JLabel("Scene File");
		txtSceneFile = new JTextField();
		txtSceneFile.setEnabled(false);
		btnSceneFile = new JButton("...");
		btnSceneFile.setActionCommand(SCENE);
		btnSceneFile.addActionListener(this);
		defSceneFile = "";
		add(lblSceneFile);
		add(txtSceneFile);
		add(btnSceneFile);
		
		lblOutputDir = new JLabel("Output Directory");
		txtOutputDir = new JTextField();
		txtOutputDir.setEnabled(false);
		btnOutputDir = new JButton("...");
		btnOutputDir.setActionCommand(DIR);
		btnOutputDir.addActionListener(this);
		defOutputDir = "";
		add(lblOutputDir);
		add(txtOutputDir);
		add(btnOutputDir);
		
		lblOutputFile = new JLabel("Output File");
		txtOutputFile = new JTextField();
		defOutputFile = "";
		add(lblOutputFile);
		add(txtOutputFile);
		add(new JLabel());
		
		lblFormat = new JLabel("Format");
		cboFormat = new JComboBox(ListUtils.unique(ImageIO.getWriterFormatNames()));
		defFormat = "";
		add(lblFormat);
		add(cboFormat);
		add(new JLabel());
		
		lblGrid = new JLabel("Execute in grid?");
		chkGrid = new JCheckBox();
		add(lblGrid);
		add(chkGrid);
		add(new JLabel());
	}
	
	public void resetDefaultValues() {
		txtSceneFile.setText(defSceneFile);
		txtOutputDir.setText(defOutputDir);
		txtOutputFile.setText(defOutputFile);
		cboFormat.setSelectedItem(defFormat);
		chkGrid.setSelected(false);
	}
	
	public void setDefaults(String defSceneFile, String defOutputDir, String defOutputFile, String defFormat) {
		this.defSceneFile = defSceneFile;
		this.defOutputDir = defOutputDir;
		this.defOutputFile = defOutputFile;
		this.defFormat = defFormat;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		JFileChooser fc = new JFileChooser();
		if (command.equals(SCENE)) {
			fc.setAcceptAllFileFilterUsed(false);
			FileFilter ff = new FileNameExtensionFilter("scene file (.xml)", "xml");
			fc.setFileFilter(ff);
			if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
				txtSceneFile.setText(fc.getSelectedFile().getAbsolutePath());			
		} else if (command.equals(DIR)) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
				txtOutputDir.setText(fc.getCurrentDirectory().getAbsolutePath());
		}
	}

}
