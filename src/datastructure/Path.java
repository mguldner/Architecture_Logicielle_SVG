package datastructure;

import java.awt.Graphics2D;

import utils.Point2D;

public abstract class Path {
	/*==============================*/
	/*========== Constants =========*/
	/*==============================*/
	private final boolean DEFAULT_PATH_CLOSED = false;

	
	/*==============================*/
	/*========== Variables =========*/
	/*==============================*/
	private Point2D[] points;
	private boolean closed;

	
	/*=================================*/
	/*========== Constructors =========*/
	/*=================================*/
	public Path(Point2D[] points) {
		this.points = points;
		this.closed = DEFAULT_PATH_CLOSED;
	}
	public Path(Point2D[] points, boolean closed) {
		this.points = points;
		this.closed = closed; 
	}

	
	/*============================*/
	/*========== Getters =========*/
	/*============================*/
	public Point2D[] getPoints() {
		return points;
	}
	public boolean isClosed() {
		return closed;
	}
	
	
	/*========================================*/
	/*============ Shared Methods ============*/
	/*========================================*/
	
	
	/*===============================================================*/
	/*============ Methods dedicated to each export mode ============*/
	/*===============================================================*/
	/* The idea here is to create functions that return what is "needed" 
	 * to apply the drawing.
	 * 
	 * Basically, for a svg we need a string that will be inserted in a 
	 * svg component.
	 * 
	 * On the other hand, for a Java export that will be executed, we need 
	 * the points that will be used by the library to generate a drawing.
	 */
	
		/*=================================================*/
		/*================== SVG export ===================*/
		/*=================================================*/
	/**
	 * @return a string that represents the "path part" of a svg component
	 */
	public abstract String generateSvgPath();
	
		/*=================================================*/
		/*================== Java export ==================*/
		/*=================================================*/
	public abstract void generateJavaPath(Graphics2D g);

}
