package visitors;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.HashMap;

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
    graph.setColor(new Color(rgbColorCode[0], rgbColorCode[1], rgbColorCode[2]));
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
  public String visitOperator(Drawing[] drawings, Object[] optionalParams) {
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
  public String visitLoop(Drawing[] drawings, String[] changes, 
      HashMap<String,Double[]> changeParams, 
      Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }
    drawings[0].render(this, optionalParams);
    for (int j = 1; j < drawings.length; j++) {
      for (int i = 0; i < changeParams.size(); i++) {
        if (changes[i] == "rotation") {
          ((Graphics2D) optionalParams[0]).rotate(Math.toRadians(changeParams.get("rotation")[0]*j));
        }
        if (changes[i] == "translation") {
          ((Graphics2D) optionalParams[0]).translate(changeParams.get("translation")[0], 
              changeParams.get("translation")[1]);
        }
        if (changes[i] == "scaling") {
          ((Graphics2D) optionalParams[0]).scale(changeParams.get("scaling")[0], 
              changeParams.get("scaling")[1]);
        }
      }
      drawings[j].render(this, optionalParams);
      for (int i = 0; i < changeParams.size(); i++) {
        if (changes[i] == "rotation") {
          ((Graphics2D) optionalParams[0]).rotate(Math.toRadians(360 - changeParams.get("rotation")[0]*j));
        }
      }
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
  public String visitInsert(Drawing drawing, Path[] paths, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }

    Graphics2D graph = (Graphics2D)(optionalParams[0]);

    Shape oldClip = graph.getClip();

    for (Path path : paths) {
      graph.clip((Shape)path.render(this, optionalParams));
    }
    drawing.render(this, optionalParams);

    graph.setClip(oldClip);
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
