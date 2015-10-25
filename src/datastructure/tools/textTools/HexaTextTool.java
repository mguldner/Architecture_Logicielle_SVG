package datastructure.tools.textTools;

import datastructure.tools.TextTool;
import utils.UsefulFunctions;

/**
 * 
 * This text tool takes the color in hexadecimal.
 *
 */
public class HexaTextTool extends TextTool {	
	/*=================================*/
	/*========== Constructors =========*/
	/*=================================*/
	public HexaTextTool() {
		super();
	}
	public HexaTextTool(String color) {
		super(UsefulFunctions.convertHexaToRGB(color));
	}
	public HexaTextTool(String color, String fontName, int fontSize, String fontStyle) {
		super(UsefulFunctions.convertHexaToRGB(color), fontName, fontSize, fontStyle);
	}
}
