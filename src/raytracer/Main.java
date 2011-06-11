package raytracer;

import java.io.IOException;

import gui.MainFrame;
import image.Image;

import org.gridgain.grid.GridException;

import com.newrelic.org.apache.commons.cli.CommandLine;
import com.newrelic.org.apache.commons.cli.CommandLineParser;
import com.newrelic.org.apache.commons.cli.HelpFormatter;
import com.newrelic.org.apache.commons.cli.Option;
import com.newrelic.org.apache.commons.cli.Options;
import com.newrelic.org.apache.commons.cli.ParseException;
import com.newrelic.org.apache.commons.cli.PosixParser;

import distributed.GridRenderer;
import parser.Parser;
import scene.Scene;
import util.Reader;

public class Main {
	
	private static Options options;
	
	private static void generateOptions() {
		options = new Options();
		Option grid = new Option("g", "grid", false, "execute in parallel using GridGain");
		Option file = new Option("o", "output-file", true, "specify name of output file image; "
														+ "defaults to output-image.jpg");
		file.setArgName("filename");
		Option format = new Option("f", "format", true, "specify format of output image file; "
														+ "defaults to jpeg");
		format.setArgName("format");
		Option output = new Option("d", "output-dir", true, "specify output directory for image; "
															+ "defaults to current directory");
		output.setArgName("directory");
		
		Option interactive = new Option("i", "interactive", false, "execute application in interactive mode");
		Option help = new Option("h", "help", false, "show help and example usage");
		options.addOption(grid);
		options.addOption(file);
		options.addOption(format);
		options.addOption(output);
		options.addOption(interactive);
		options.addOption(help);
	}
	
	public static void printUsage() {
		HelpFormatter help = new HelpFormatter();
		help.printHelp("./RayTracer.[sh|bat] <scene_file> [options]", "options:", options, "");
	}
	
	public static void main(String[] args) {
		generateOptions();
		CommandLineParser parser = new PosixParser();
		CommandLine line = null;
		try {
			line = parser.parse(options, args);
		} catch (ParseException pe) {
			System.err.println("Error getting argument options: " + pe.getMessage());
			return;
		}
		
		if (line.hasOption('i')) {
			new MainFrame();
			/*try {
				GridRenderer.startGrid();
				new MainFrame();
			} catch(GridException ge) {
				System.err.println("Error executing in grid: " + ge.getMessage());
			} finally {
				GridRenderer.stopGrid();
			}*/
			return;
		}
		
		if (line.hasOption('h') || line.getArgs().length < 1) {
			printUsage();
			return;
		}	
		
		String scenefile = line.getArgs()[0];
		String filename = line.getOptionValue('o', "output-image.jpg");
		String format = line.getOptionValue('f', "jpeg");
		String directory = line.getOptionValue('d', null);
		boolean grid = line.hasOption('g');
		Scene scene = null;
		try {
			scene = Parser.parse(scenefile);
		} catch (Exception e) {
			System.err.println("Could not parse scene file: " + e.getMessage());
			return;
		}
		int[][] imageColors = null;
		if (grid) {
			try {
				GridRenderer.startGrid();
				
				long begin = System.currentTimeMillis();
				imageColors = GridRenderer.render(scene);
				long end = System.currentTimeMillis();
				
				System.out.println("Distributed execution time: " + (end - begin) + " ms");
			} catch(GridException ge) {
				System.err.println("Could not render scene in grid: " + ge.getMessage());
			} finally {
				GridRenderer.stopGrid();
			}
		} else {
			RayTracer rt = new RayTracer(scene);
			long begin = System.currentTimeMillis();
			imageColors = rt.execute();
			long end = System.currentTimeMillis();
			System.out.println("Execution time: "+ (end - begin) + " ms");
		}
		Image.generateImage(imageColors).save(directory, filename, format);
	}

}
