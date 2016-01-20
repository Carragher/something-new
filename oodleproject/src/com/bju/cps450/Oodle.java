/* Oodle.java
 * Author: Ethan McGee
 * Date: 2014-01-23
 * 
 * Purpose: Main class for Oodle compiler project
 */

package com.bju.cps450;
import com.bju.cps450.lexer.Lexer;
import jargs.gnu.CmdLineParser;
import jargs.gnu.CmdLineParser.IllegalOptionValueException;
import jargs.gnu.CmdLineParser.UnknownOptionException;

import java.io.*;


import com.bju.cps450.lexer.LexerException;

public class Oodle
{
	/* printHelp
	 * Arguments:
	 * 
	 * Purpose: Writes a help statement to standard out
	 */
	public static void printHelp() {
		System.out.println("Oodle Compiler");
		System.out.println("v 0.1");
		System.out.println("Author: <name>");
		System.out.println("");
		System.out.println("Usage:");
		System.out.println(" java -jar oodle.jar [options] [files]");
	}

	public static void setDs() {
		Globals.dsTest = true;
	}
	
	/* main
	 * Arguments:
	 *  @args - the list of command line arguments
	 * Purpose: main execution function for compiler
	 */
    public static void main(String[] args) throws IOException, IllegalOptionValueException, UnknownOptionException, LexerException {

		CmdLineParser parser = new CmdLineParser();
    	//command line options
		CmdLineParser.Option help = parser.addBooleanOption('?', "help");
		CmdLineParser.Option token = parser.addBooleanOption("ds");
		//parse command line arguments
		parser.parse(args);
		
		//set applicable values from options class
		if ((Boolean)parser.getOptionValue(help, false)) {
			printHelp();
			return;
		}

		if ((Boolean)parser.getOptionValue(token, false)) {
			setDs();

		}
		int argLen = parser.getRemainingArgs().length ;

		if (argLen <= 0 ){
			throw new IOException("no files to lex");
		}


		String[] file = parser.getRemainingArgs();
		FileManager.initArray = file;
		FileManager.generateTemp();
		PushbackReader reader = new PushbackReader(new InputStreamReader(new FileInputStream(FileManager.file)));
		Lexer lexer = new Lexer(reader);




    }
}

