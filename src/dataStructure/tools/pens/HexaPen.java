package dataStructure.tools.pens;

import dataStructure.tools.Pen;

/**
 * 
 * This pen takes the color in hexadecimal.
 * This is the basic pen, the one corresponding to the original model in hexadecimal
 *
 */
public class HexaPen extends Pen {
	
	/**
	 * Constructors
	 */

	public HexaPen() {
		super();
	}
	public HexaPen(String color) {
		super(color);
	}
	public HexaPen(int thickness) {
		super(thickness);
	}
	public HexaPen(String color, int thickness) {
		super(color, thickness);
	}

}
