package dataStructure;
/**
 * 
 * This abstract class is the base of all the model structure.
 * The structure is defined as a tree, tree that has leaves (actions) and subtrees (operators).
 *
 */
public abstract class Drawing {
	
	public void generateSvgDrawing(int height, int width) {
		String svgCode = "<svg height=\"" + height + "\" width=\"" + width + "\" xmlns=\"http://www.w3.org/2000/svg\">\n";
		svgCode += this.generateSvgCode();
		svgCode += "</svg>";
		System.out.println(svgCode);
	};
	
	public abstract String generateSvgCode();
	
	public abstract void generateJavaDrawing();
}
