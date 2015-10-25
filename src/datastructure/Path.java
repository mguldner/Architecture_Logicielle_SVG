package datastructure;

import utils.Constants;
import utils.Point2D;

import java.awt.Graphics2D;


/**
 * This class allows the user to easily add new paths 
 * (basic types being PolygonalPath and BezierCurve)
 * If the user wants to add a new "export" mode (basic export modes are 
 * to SVG and to Java), they need to declare a new abstract method:
 * <code>
 *  public abstract void generateNewExportModePath();
 * </code>
 * The <code>generateNewExportModePath</code> method will have to be 
 * implemented for all paths.
 *
 */
public abstract class Path {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  /**
   * points: Array of points represented in 2D.
   * closed: true if the path is closed.
   */
  private Point2D[] points;
  private boolean closed;

  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public Path(Point2D[] points) {
    this.points = points;
    this.closed = Constants.DEFAULT_PATH_CLOSED;
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
   * @return a string that represents the "path part" of a svg component.
   */
  public abstract String generateSvgPath();
  
  /*=================================================*/
  /*================== Java export ==================*/
  /*=================================================*/
  public abstract void generateJavaPath(Graphics2D graph);

}
