package datastructure.paths;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import datastructure.Path;
import utils.Point2D;

/**
 * This class is the representation of a path.
 * It creates a path where all the points are linked
 * by lines.
 *
 */
public class PolygonalPath extends Path {
	/*=================================*/
	/*========== Constructors =========*/
	/*=================================*/ 
	public PolygonalPath(Point2D[] points) {
		super(points);
	}
	public PolygonalPath(Point2D[] points, boolean closed) {
		super(points, closed);
	}

	
	/*========================================*/
	/*============ Shared methods ============*/
	/*========================================*/

	
	/*===============================================================*/
	/*============ Methods dedicated to each export mode ============*/
	/*===============================================================*/
	
		/*=================================================*/
		/*================== SVG export ===================*/
		/*=================================================*/
	@Override
	public String generateSvgPath() {
		String svgCode = "d=\"";
		Point2D[] points = this.getPoints();
		
		svgCode += "M" + points[0].getX() + " " + points[0].getY();
		for (int i = 1; i < this.getPoints().length; i++) {
			svgCode += " L" + points[i].getX() + " " + points[i].getY();
		}
		
		if (this.isClosed()) {
		  svgCode += " Z";		  
		}
		
		svgCode += "\"";
		return svgCode;
	}

		/*=================================================*/
		/*================== Java export ==================*/
		/*=================================================*/
	@Override
	public void generateJavaPath(Graphics2D g) {
		GeneralPath polygon = new GeneralPath();
		Point2D[] points = this.getPoints();
		
		polygon.moveTo(points[0].getX(), points[0].getY());
		
		for (int i = 1; i < points.length; i++) {
      polygon.lineTo(points[i].getX(), points[i].getY());
		};
		
		if (this.isClosed()) {
		  polygon.closePath();
		}
		g.draw(polygon);
	} 

}
