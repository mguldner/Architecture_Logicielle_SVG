package dataStructure.paths;

import dataStructure.Path;
import utils.Point2D;

public class PolygonalPath extends Path {

	public PolygonalPath(Point2D[] points) {
		super(points);
	}
	public PolygonalPath(Point2D[] points, boolean closed) {
		super(points, closed);
	}

	@Override
	public String generateSvgPath() {
		String svgCode = "d=\"";
		Point2D[] points = this.getPoints();
		
		svgCode += "M" + points[0].getX() + " " + points[0].getY();
		for (int i = 1; i < this.getPoints().length; i++) {
			svgCode += " L" + points[i].getX() + " " + points[i].getY();
		}
		
		if (this.isClosed())
			svgCode += " Z";
		
		svgCode += "\"";
		return svgCode;
	}

	@Override
	public Point2D[] generateJavaPath() {
		return this.getPoints();
	}

}
