package visitors;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import managers.ColorManager;
import utils.Point2D;

public abstract class Visitor {
  public abstract String visitPen(int thickness, int[] rgbColorCode, Object[] optionalParams);
  
  public abstract String visitTextTool(String fontName, int fontSize, String fontStyle, 
                                       int[] rgbColorCode, Object[] optionalParams);
  
  public abstract Object visitPolygonalPath(Point2D[] points, boolean closed, Object[] optionalParams);
  
  public abstract String visitSequence(Drawing[] drawings, Object[] optionalParams);
  
  public abstract String visitDraw(Path path, Tool tool, Object[] optionalParams);
  
  public abstract String visitFill(Path path, ColorManager color, Object[] optionalParams);
  
  public abstract void visitExport(Drawing drawing, int height, int width);
  
}
