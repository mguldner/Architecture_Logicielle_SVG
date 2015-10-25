package datastructure.tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import datastructure.Tool;

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
	public Pen(int[] color) {
		super(color);
		this.thickness = this.DEFAULT_THICKNESS;
	}
	public Pen(int[] color, int thickness){
		super(color);
		this.thickness = thickness;
	}

	
	/*============================*/
	/*========== Getters =========*/
	/*============================*/
	/**
	 * Getter.
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
	  int[] rgbColorCode = this.getRgbColorCode();
		return "stroke-width=\"" + this.getThickness() + "\" " 
		        + "stroke=\"rgb(" + rgbColorCode[0] + ","
		        + rgbColorCode[1] + ","
		        + rgbColorCode[2]
		        + ")\"";
	}
	
		/*=================================================*/
		/*================== Java export ==================*/
		/*=================================================*/
	@Override
	public void applyJavaTool(Graphics2D g) {
	  int[] rgbColorCode = this.getRgbColorCode();
	  g.setColor(new Color(rgbColorCode[0], rgbColorCode[1], rgbColorCode[2]));
	  g.setStroke(new BasicStroke(this.getThickness()));
	}
}
