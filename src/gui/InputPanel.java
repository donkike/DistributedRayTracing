package gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.ListUtils;


public class InputPanel extends JPanel {
	
	private JLabel lblSceneFile;
	private JTextField txtSceneFile;
	private String defSceneFile;
	
	private JLabel lblOutputDir;
	private JTextField txtOutputDir;
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
		setLayout(new GridLayout(5,2));
		
		lblSceneFile = new JLabel("Scene File");
		txtSceneFile = new JTextField();
		defSceneFile = "";
		add(lblSceneFile);
		add(txtSceneFile);
		
		lblOutputDir = new JLabel("Output Directory");
		txtOutputDir = new JTextField();
		defOutputDir = "";
		add(lblOutputDir);
		add(txtOutputDir);
		
		lblOutputFile = new JLabel("Output File");
		txtOutputFile = new JTextField();
		defOutputFile = "";
		add(lblOutputFile);
		add(txtOutputFile);
		
		lblFormat = new JLabel("Format");
		cboFormat = new JComboBox(ListUtils.unique(ImageIO.getWriterFormatNames()));
		defFormat = "";
		add(lblFormat);
		add(cboFormat);
		
		lblGrid = new JLabel("Execute in grid?");
		chkGrid = new JCheckBox();
		add(lblGrid);
		add(chkGrid);
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

}
