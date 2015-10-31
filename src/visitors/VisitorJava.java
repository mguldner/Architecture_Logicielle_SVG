package visitors;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.tools.TextTool;
import exports.ResultPanel;
import managers.ColorManager;
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
  public String visitTextTool(String fontName, int fontSize, int fontStyle,
      int[] rgbColorCode, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }
    
    Graphics2D graph = (Graphics2D) optionalParams[0];
    
    graph.setFont(new Font(fontName, fontStyle, fontSize));
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
    
    Graphics2D graph = (Graphics2D)(optionalParams[0]);
    
    tool.render(this, optionalParams);
    graph.draw((Shape)path.render(this, optionalParams));
    return "Ok";
  }
  
  @Override
  public String visitFill(Path path, ColorManager color,
      Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }  
   
    Graphics2D graph = (Graphics2D)(optionalParams[0]);
    int[] rgbColor = color.getRgbCode();
    
    graph.setColor(new Color(rgbColor[0], rgbColor[1], rgbColor[2]));
    graph.fill((Shape)path.render(this, optionalParams));
    return "Ok";
  }

  @Override
  public String visitInsert(Drawing drawing, Path path, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }
    
    Graphics2D graph = (Graphics2D)(optionalParams[0]);
    
    Shape oldClip = graph.getClip();
    
    new ResultPanel(drawing).paintComponent(graph);
    graph.clip((Shape)path.render(this, optionalParams));
    
    Shape newClip = graph.getClip();
    graph.setClip(oldClip);
    graph.draw(newClip);
    return "Ok";
  }
  
  @Override
  public String visitLabel(String text, Point2D position, TextTool textTool,
      Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }
    
    Graphics2D graph = (Graphics2D)(optionalParams[0]);
    
    textTool.render(this, optionalParams);
    graph.drawString(text, position.getX(), position.getY());
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
