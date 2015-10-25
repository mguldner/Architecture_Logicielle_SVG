package dataStructure.tools;

import dataStructure.Tool;

public abstract class Pen extends Tool {
	/*==============================*/
	/*========== Constants =========*/
	/*==============================*/
	private final int DEFAULT_THICKNESS = 1;

	
	/*==============================*/
	/*========== Variables =========*/
	/*==============================*/
	private int thickness;

	
	/*=================================*/
	/*========== Constructors =========*/
	/*=================================*/
	public Pen() {
		super();
		this.thickness = this.DEFAULT_THICKNESS;
	}
	public Pen(int thickness) {
		super();
		this.thickness =  thickness;
	}
	public Pen(String color) {
		super(color);
		this.thickness = this.DEFAULT_THICKNESS;
	}
	public Pen(String color, int thickness){
		super(color);
		this.thickness = thickness;
	}

	
	/*============================*/
	/*========== Getters =========*/
	/*============================*/
	/**
	 * Getter
	 * @return the int corresponding to the thickness of the tool
	 */
	public int getThickness() {
		return thickness;
	}

	
	/*===================================*/
	/*========== Shared Methods =========*/
	/*===================================*/

	
	/*===============================================================*/
	/*============ Methods dedicated to each export mode ============*/
	/*===============================================================*/
	
		/*=================================================*/
		/*================== SVG export ===================*/
		/*=================================================*/
	@Override
	/** 
	 * @return the part of code related to drawing with a pen in SVG
	 */
	public String applySvgTool() {
		return "stroke-width=\"" + this.getThickness() + "\" " +
				"stroke=\""+ this.getHexaColorCode() + "\"";
	}
	
		/*=================================================*/
		/*================== Java export ==================*/
		/*=================================================*/
	@Override
	public void applyJavaTool() {
		// TODO Auto-generated method stub
	}
}
