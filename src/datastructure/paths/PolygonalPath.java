package datastructure.paths;

import datastructure.Path;
import utils.Point2D;
import visitors.Visitor;

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
  public Object render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitPolygonalPath(this.getPoints(), this.isClosed(), optionalParams);
  }

}
