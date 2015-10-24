package dataStructure;

public abstract class Tool {
	private String hexaColorCode;
	
	public String getHexaColorCode() {
		return hexaColorCode;
	}
	
	public abstract void applySvgTool();
	public abstract void applyJavaTool();

}
