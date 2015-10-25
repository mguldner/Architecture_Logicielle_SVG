package dataStructure;

public abstract class Tool {
	/*==============================*/
	/*========== Constants =========*/
	/*==============================*/
	private final String DEFAULT_COLORCODE = "#fff";

	
	/*==============================*/
	/*========== Variables =========*/
	/*==============================*/	
	private String hexaColorCode;
	
	
	
	/*=================================*/	
	/*========== Constructors =========*/
	/*=================================*/	
	public Tool() {
		this.hexaColorCode = this.DEFAULT_COLORCODE;
	}
	public Tool(String color) {
		this.hexaColorCode = color;
	}

	
	/*============================*/	
	/*========== Getters =========*/
	/*============================*/	
	/**
	 * Getter
	 * @return the hexacode corresponding to the color
	 */
	public String getHexaColorCode() {
		return hexaColorCode;
	}

	
	/*========================================*/	
	/*============ Shared Methods ============*/
	/*========================================*/	

	
	/*===============================================================*/	
	/*============ Methods dedicated to each export mode ============*/
	/*===============================================================*/	
	/* The idea here is to create functions that return what is "needed" to apply the drawing.
	 * 
	 * Basically, for a svg we need a string that will be inserted in a svg component.
	 */
	
		/*=================================================*/
		/*================== SVG export ===================*/
		/*=================================================*/
	public abstract String applySvgTool();
	
		/*=================================================*/
		/*================== Java export ==================*/
		/*=================================================*/
	public abstract void applyJavaTool();

}
