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
public class PolygonalPath<T> extends Path<T> {
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/ 
  public PolygonalPath() {
    super();
  }
  
  private PolygonalPath(Point2D[] points) { 
    super(points);
  }
  
  private PolygonalPath(Point2D[] points, boolean closed) {
    super(points, closed);
  }

  
  /*========================================*/
  /*============ Shared methods ============*/
  /*========================================*/
  public Visitor<T> render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitPolygonalPath(this.getPoints(), this.isClosed(), optionalParams);
  }

  @Override
  public PolygonalPath createPath(Point2D[] points, boolean closed) {
    return new PolygonalPath(points, closed);
  }

  @Override
  public PolygonalPath createPath(Point2D[] points) {
    // TODO Auto-generated method stub
    return new PolygonalPath(points);
  }

}
