package visitors;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.tools.TextTool;
import managers.ColorManager;
import utils.Point2D;

public abstract class Visitor {
  public abstract String visitPen(int thickness, int[] rgbColorCode, Object[] optionalParams);
  
  public abstract String visitTextTool(String fontName, int fontSize, int fontStyle, 
                                       int[] rgbColorCode, Object[] optionalParams);
  
  public abstract Object visitPolygonalPath(Point2D[] points, 
                                            boolean closed, Object[] optionalParams);  
  public abstract String visitOperator(Drawing[] drawings, Object[] optionalParams);
  
  public abstract String visitLoop(Drawing[] drawings, String change, Object[] changeparams, 
                                       Object[] optionalParams);
  
  public abstract String visitDraw(Path path, Tool tool, Object[] optionalParams);
  
  public abstract String visitFill(Path path, ColorManager color, Object[] optionalParams);

  public abstract String visitInsert(Drawing drawing, Path[] paths, Object[] optionalParams);

  public abstract String visitLabel(String text, Point2D position, 
                                    TextTool textTool, Object[] optionalParams);
  
  public abstract void visitExport(Drawing drawing, int height, int width);
  
}
