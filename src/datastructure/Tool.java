package datastructure;

import java.awt.Graphics2D;

public abstract class Tool {
	/*==============================*/
	/*========== Constants =========*/
	/*==============================*/
	private final int[] DEFAULT_COLORCODE = {250,250,250};

	
	/*==============================*/
	/*========== Variables =========*/
	/*==============================*/	
	private int[] rgbColorCode;
	
	
	
	/*=================================*/	
	/*========== Constructors =========*/
	/*=================================*/	
	public Tool() {
		this.rgbColorCode = this.DEFAULT_COLORCODE;
	}
	public Tool(int[] color) {
		this.rgbColorCode = color;
	}

	
	/*============================*/	
	/*========== Getters =========*/
	/*============================*/	
	/**
	 * Getter.
	 * @return the hexacode corresponding to the color
	 */
	public int[] getRgbColorCode() {
		return rgbColorCode;
	}

	
	/*========================================*/	
	/*============ Shared Methods ============*/
	/*========================================*/	

	
	/*===============================================================*/	
	/*============ Methods dedicated to each export mode ============*/
	/*===============================================================*/	
	/* The idea here is to create functions that return what is "needed" 
	 * to apply the drawing.
	 * 
	 * Basically, for a svg we need a string that will be inserted in a 
	 * svg component.
	 */
	
		/*=================================================*/
		/*================== SVG export ===================*/
		/*=================================================*/
	public abstract String applySvgTool();
	
		/*=================================================*/
		/*================== Java export ==================*/
		/*=================================================*/
	public abstract void applyJavaTool(Graphics2D g);

}
