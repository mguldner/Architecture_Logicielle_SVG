package dataStructure;

public abstract class Tool {
	/**
	 * Constants
	 */
	private final String DEFAULT_COLORCODE = "#fff";
	
	/**
	 * Variables
	 */
	private String hexaColorCode;
	
	/**
	 * Constructors
	 */
	public Tool() {
		this.hexaColorCode = this.DEFAULT_COLORCODE;
	}
	public Tool(String color) {
		this.hexaColorCode = color;
	}
	
	
	/**
	 * Getters
	 */
	
	/**
	 * Getter
	 * @return the hexacode corresponding to the color
	 */
	public String getHexaColorCode() {
		return hexaColorCode;
	}
	
	
	public abstract String applySvgTool();
	public abstract void applyJavaTool();

}
