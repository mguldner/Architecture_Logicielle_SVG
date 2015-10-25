package datastructure.tools;

import java.awt.Graphics2D;

import datastructure.Tool;

/**
 * This class allows the user to easily add new TextTools 
 * (basic types being HexaTextTool and RgbTextTool)
 * 
 * If the user wants to add a new "export" mode (basic export modes are 
 * to SVG and to Java), they need to declare a new abstract method:
 * <code>
 *  public abstract void applyNewExportModeTool();
 * </code>
 * The <code>applyNewExportModeTool</code> method will have to be 
 * implemented for all pens.
 */
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
	public TextTool(int[] color) {
		super(color);
		this.fontName = this.DEFAULT_FONT_NAME;
		this.fontSize = this.DEFAULT_FONT_SIZE;
		this.fontStyle = this.DEFAULT_FONT_STYLE;
	}
	public TextTool(int[] color, String fontName, 
	                int fontSize, String fontStyle) {
		super(color);
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
	  int[] rgbColorCode = this.getRgbColorCode();
		return "font-family=\"" + this.fontName + "\" "
				+ "font-size=\"" + this.fontSize + "\" "
				+ "stroke=\"rgb(" + rgbColorCode[0] + ","
        + rgbColorCode[1] + ","
        + rgbColorCode[2] + ","
        + ")\"";	
	}
	
		/*=================================================*/
		/*================== Java export ==================*/
		/*=================================================*/
	@Override
	public void applyJavaTool(Graphics2D g) {
		// TODO Auto-generated method stub
	}

}
