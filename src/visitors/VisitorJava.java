package visitors;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import exports.ResultPanel;
import utils.Point2D;

public class VisitorJava extends Visitor {

  @Override
  public String visitPen(int thickness, int[] rgbColorCode, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }
    Graphics2D graph = (Graphics2D) optionalParams[0];
    graph.setColor(new Color(rgbColorCode[0], rgbColorCode[1], rgbColorCode[2]));
    graph.setStroke(new BasicStroke(thickness));
    return "Ok";
  }

  @Override
  public String visitTextTool(String fontName, int fontSize, String fontStyle,
      int[] rgbColorCode, Object[] optionalParams) {
    // TODO Auto-generated method stub
    return "Ok";
  }

  @Override
  public Shape visitPolygonalPath(Point2D[] points, boolean closed,
      Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }
    
    GeneralPath polygon = new GeneralPath();
    
    polygon.moveTo(points[0].getX(), points[0].getY());
    
    for (int i = 1; i < points.length; i++) {
      polygon.lineTo(points[i].getX(), points[i].getY());
    }
    
    if (closed) {
      polygon.closePath();
    }
    return polygon;
  }
  

  @Override
  public Shape visitBezierPath(Point2D[] points, boolean closed,
      Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }
    GeneralPath bezier = new GeneralPath();
    
    bezier.moveTo(points[0].getX(), points[0].getY());
    bezier.curveTo(points[1].getX(), points[1].getY(), 
        points[2].getX(), points[2].getY(), 
        points[3].getX(), points[3].getY());
    
    if (closed) {
      bezier.closePath();
    }
    
    return bezier;
  }

  @Override
  public String visitSequence(Drawing[] drawings, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }

    for (int i = 0; i < drawings.length; i++) {
      drawings[i].render(this, optionalParams);
    }
    return "Ok";
  }

  @Override
  public String visitDraw(Path path, Tool tool, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }    
    tool.render(this, optionalParams);
    path.render(this, optionalParams);
    return "Ok";
  }

  @Override
  public void visitExport(Drawing drawing, int height, int width) {
    JFrame window = new JFrame();
    window.setTitle("Drawing");
    window.setSize(width, height);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setContentPane(new ResultPanel(drawing));
    window.setVisible(true);
  }

}
