package dataStructure.tools;

import dataStructure.Tool;

public class TextTool extends Tool {
	/*==============================*/
	/*========== Constants =========*/
	/*==============================*/
	private final String DEFAULT_FONT_NAME = "Arial";
	private final int DEFAULT_FONT_SIZE = 1;
	private final String DEFAULT_FONT_STYLE = "";

	
	/*==============================*/
	/*========== Variables =========*/
	/*==============================*/
	private String fontName;
	private int fontSize;
	private String fontStyle;

	
	/*=================================*/
	/*========== Constructors =========*/
	/*=================================*/
	public TextTool() {
		super();
		this.fontName = this.DEFAULT_FONT_NAME;
		this.fontSize = this.DEFAULT_FONT_SIZE;
		this.fontStyle = this.DEFAULT_FONT_STYLE;
	}
	public TextTool(String color) {
		super(color);
		this.fontName = this.DEFAULT_FONT_NAME;
		this.fontSize = this.DEFAULT_FONT_SIZE;
		this.fontStyle = this.DEFAULT_FONT_STYLE;
	}
	public TextTool(String color, String fontName, int fontSize, String fontStyle) {
		super();
		this.fontName = fontName;
		this.fontSize = fontSize;
		this.fontStyle = fontStyle;
	}	

	
	/*========================================*/
	/*============ Shared Methods ============*/
	/*========================================*/

	
	/*===============================================================*/
	/*============ Methods dedicated to each export mode ============*/
	/*===============================================================*/
	
		/*=================================================*/
		/*================== SVG export ===================*/
		/*=================================================*/
	@Override
	public String applySvgTool() {
		return "font-family=\"" + this.fontName + "\" " +
				"font-size=\"" + this.fontSize + "\" " +
				"stroke=\"" + this.getHexaColorCode() + "\"";		
	}
	
		/*=================================================*/
		/*================== Java export ==================*/
		/*=================================================*/
	@Override
	public void applyJavaTool() {
		// TODO Auto-generated method stub
	}

}
