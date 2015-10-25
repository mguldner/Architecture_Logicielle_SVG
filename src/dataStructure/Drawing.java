package dataStructure;

import javax.swing.JFrame;

/**
 * 
 * This abstract class is the base of all the model structure.
 * The structure is defined as a tree, tree that has leaves (actions) 
 * and subtrees (operators).
 *
 */
public abstract class Drawing {
	/*========================================*/ 
	/*============ Shared Methods ============*/
	/*========================================*/
	
	
	/*===============================================================*/
	/*============ Methods dedicated to each export mode ============*/
	/*===============================================================*/
	
		/*=================================================*/
		/*================== SVG export ===================*/
		/*=================================================*/
	/**
	 * This method produces the final svg export, giving it the height and 
	 * the width wanted by the user.
	 * @param height
	 * @param width
	 */
	public void generateSvgDrawing(int height, int width) {
		String svgCode = "<svg height=\"" + height 
		                 + "\" width=\"" + width 
		                 + "\" xmlns=\"http://www.w3.org/2000/svg\">\n";
		svgCode += this.generateSvgCode();
		svgCode += "</svg>";
		System.out.println(svgCode);
	};
	/**
	 * This method is useful to get the svg code of each part of the drawing.
	 * It is compulsory to have the code working. 
	 * @return the code of the drawing without the \<svg\> tags
	 */
	public abstract String generateSvgCode();
	
	
		/*=======================================================*/
		/*==================== Java export ======================*/
		/*=======================================================*/
	public void generateJavaDrawing(int height, int width) {
	  JFrame window = new JFrame();
	  window.setTitle("Drawing");
	  window.setSize(width, height);
	  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  window.setVisible(true);
	};
}
