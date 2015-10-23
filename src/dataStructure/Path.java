package dataStructure;

import utils.Point2D;

public abstract class Path {
	private Point2D[] points;
	
	public Point2D[] getPoints() {
		return points;
	}
	
	/*============ Functions dedicated to each export mode ============*/
	/* The idea here is to create functions that return what is "needed" to apply the drawing.
	 * 
	 * Basically, for a svg we need a string that will be inserted in a svg component.
	 * 
	 * On the other hand, for a Java export that will be executed, we need the points that will be used by
	 * the library to generate a drawing.
	 **/
	
	/**
	 * @return a string that represents the "path part" of a svg component
	 */
	public abstract String generateSvgPath();
	public abstract Point2D[] generateJavaPath();

}
