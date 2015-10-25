package datastructure.tools.pens;

import datastructure.tools.Pen;
import utils.UsefulFunctions;

/**
 * 
 * This pen takes the color in hexadecimal.
 *
 */
public class HexaPen extends Pen {	
	/*=================================*/
	/*========== Constructors =========*/
	/*=================================*/
	public HexaPen() {
		super();
	}
	public HexaPen(String color) {
		super(UsefulFunctions.convertHexaToRGB(color));
	}
	public HexaPen(int thickness) {
		super(thickness);
	}
	public HexaPen(String color, int thickness) {
		super(UsefulFunctions.convertHexaToRGB(color), thickness);
	}

}
