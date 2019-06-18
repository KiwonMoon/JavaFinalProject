package edu.handong.analysis;

//import edu.handong.analysis.utils.NotEnoughArgumentException;
//import edu.handong.analysis.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JavaFinalProjectAnalyzer{
	
	String input = "";
	String output1 = "";
	String output2 = "";
	boolean help;
	
	public void run(String[] args) throws IOException {
		int numThreads = 10;
		Options options = new Options(); 
		createOption(options);
		
		Thread[] theads = new Thread[numThreads];
		
		
		try {
			if(args.length<5)
				throw new CustomizedException();
		} catch (CustomizedException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		System.out.println("print test");
		
		if(parseOption(options, args)){
			if (help){
				printHelp(options);
				return;
			}
		
			ZipReader zipReader = new ZipReader();
			
			//CustomizedGenerics<String> liness = zipReader.readFileInZip(input);
			ArrayList<String> result1 = zipReader.readFileInZip(input);
			ArrayList<String> result2 = zipReader.readFile2InZip(input);
			Utils.writeAFile(result1, output1);
			Utils.writeAFile(result2, output2);
			
		}
		
	}
	
	private boolean parseOption(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		
		try {
			CommandLine cmd = parser.parse(options, args);
			
			input = cmd.getOptionValue("i");
			output1 = cmd.getOptionValue("o");
			output2 = cmd.getOptionValue("o");
			help = cmd.hasOption("h");
			
		} catch(Exception e) {
			System.out.println(options);
			return false;
		}
		return true;
	}
	
	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "Java Final Project Analyzer";
		String footer = "" ;
		formatter.printHelp("JavaFinalProjectAnalyzer", header, options, footer, true);
	}
	
	private void createOption(Options options) {
		
		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set an input file path")
				.hasArg().argName("Input path").required().build());
		
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an output file path")
				.hasArg().argName("Output path").required().build());
		
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Show a Help page")
		        .argName("Help").build());
		
	}

}
