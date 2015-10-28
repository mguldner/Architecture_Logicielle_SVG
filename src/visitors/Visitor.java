package visitors;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import utils.Point2D;

public abstract class Visitor {
  
  /*=================================*/
  /*========== Tool Methods =========*/
  /*=================================*/
  public abstract String visitPen(int thickness, int[] rgbColorCode, Object[] optionalParams);
  
  public abstract String visitTextTool(String fontName, int fontSize, String fontStyle, 
                                       int[] rgbColorCode, Object[] optionalParams);
  
  /*=================================*/
  /*========== Path Methods =========*/
  /*=================================*/
  
  public abstract Object visitPolygonalPath(Point2D[] points, 
      boolean closed, Object[] optionalParams);
  
  public abstract Object visitBezierPath(Point2D[] points, boolean closed, Object[] optionalParams);
  
  /*=====================================*/
  /*========== Operator Methods =========*/
  /*=====================================*/
  
  public abstract String visitSequence(Drawing[] drawings, Object[] optionalParams);
  
  /*===================================*/
  /*========== Action Methods =========*/
  /*===================================*/
  
  public abstract String visitDraw(Path path, Tool tool, Object[] optionalParams);
    
  /*==================================*/
  /*========== Export Method =========*/
  /*==================================*/
  
  public abstract void visitExport(Drawing drawing, int height, int width);
  
}
