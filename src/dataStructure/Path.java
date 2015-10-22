package dataStructure;

import utils.Point2D;

public abstract class Path {
	private Point2D[] points;
	
	public Point2D[] getPoints() {
		return points;
	}
	
	public abstract Point2D[] generatePath();

}
