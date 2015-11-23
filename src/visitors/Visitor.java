package visitors;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.tools.TextTool;
import managers.ColorManager;
import utils.Point2D;

public abstract class Visitor<T> {
  public T result = null;
  
  public T getResult() {
    return result;
  }
  
  public void setResult(T result) {
    this.result = result;
  }
  
  /*=================================*/
  /*========== Tool Methods =========*/
  /*=================================*/
  public abstract Visitor<T> visitPen(int thickness, int[] rgbColorCode, Object[] optionalParams);
  
  public abstract Visitor<T> visitTextTool(String fontName, int fontSize, int fontStyle, 
                                       int[] rgbColorCode, Object[] optionalParams);
  
  /*=================================*/
  /*========== Path Methods =========*/
  /*=================================*/
  
  public abstract Visitor<T> visitPolygonalPath(Point2D[] points, 
      boolean closed, Object[] optionalParams);
  
  public abstract Visitor<T> visitBezierPath(Point2D[] points, boolean closed, 
                                             Object[] optionalParams);
  
  /*=====================================*/
  /*========== Operator Methods =========*/
  /*=====================================*/

  public abstract Visitor<T> visitOperator(Drawing<T>[] drawings, Object[] optionalParams);
  
  public abstract Visitor<T> visitLoop(Drawing<T>[] drawings, String change, Object[] changeparams, 
                                       Object[] optionalParams);
  
  /*===================================*/
  /*========== Action Methods =========*/
  /*===================================*/
  
  public abstract Visitor<T> visitDraw(Path<T> path, Tool<T> tool, Object[] optionalParams);
     
  public abstract Visitor<T> visitFill(Path<T> path, ColorManager color, Object[] optionalParams);

  public abstract Visitor<T> visitInsert(Drawing<T> drawing, Path<T>[] paths,
                              Object[] optionalParams);

  public abstract Visitor<T> visitLabel(String text, Point2D position, 
                                    TextTool<T> textTool, Object[] optionalParams);

  /*==================================*/
  /*========== Export Method =========*/
  /*==================================*/
   
  public abstract void visitExport(Drawing<T> drawing, int height, int width);
  
}
