package datastructure;

import utils.Constants;
import utils.Point2D;
import visitors.Visitor;

/**
 * This class allows the user to easily add new paths 
 * (basic types being PolygonalPath and BezierCurve).
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
  public abstract Object render(Visitor visitor, Object[] optionalParams);
}
