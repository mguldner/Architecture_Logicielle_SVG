package factories.paths;

import datastructure.Path;
import utils.Point2D;

public interface PathFactory {
  public Path createPath(Point2D[] points, boolean closed);
  
  public Path createPath(Point2D[] points);
}
