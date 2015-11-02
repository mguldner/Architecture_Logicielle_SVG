package datastructure.paths;

import datastructure.Path;
import utils.Constants;
import utils.Point2D;
import visitors.Visitor;

/**
 * This class is the representation of a path.
 * It creates a path where all the points are linked
 * by lines.
 *
 */
public class BezierPath extends Path {
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/ 
  
  /**
   * Create a Bezier path with the given points.
   * @param points have to be (begin point, first Bezier control point, 
   *        second Bezier control point, end point).
   * @param closed true if the path is closed.
   */
  public BezierPath(Point2D[] points, boolean closed) {
    super(points, closed);
    if (points.length != 4) {
      throw new Error("Unvalid arguments : 4 points needed");
    }
  }
  
  public BezierPath(Point2D[] points) { 
    this(points, Constants.DEFAULT_PATH_CLOSED);
  }
  
  /*========================================*/
  /*============ Shared methods ============*/
  /*========================================*/
  public Object render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitBezierPath(this.getPoints(), this.isClosed(), optionalParams);
  }

}
