package dataStructure.tools.textTools;

import dataStructure.tools.TextTool;

/**
 * 
 * This text tool takes the color in hexadecimal.
 * This is the basic text tool, the one corresponding 
 * to the original model in hexadecimal
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
		super(color);
	}
	public HexaTextTool(String color, String fontName, int fontSize, String fontStyle) {
		super(color, fontName, fontSize, fontStyle);
	}
}
