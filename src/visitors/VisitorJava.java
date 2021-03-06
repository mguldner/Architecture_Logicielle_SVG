package visitors;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.tools.TextTool;
import exports.ResultPanel;
import managers.ColorManager;
import utils.Point2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.util.HashMap;


import javax.swing.JFrame;


public class VisitorJava extends Visitor<Shape> {

  @Override
  public Visitor<Shape> visitPen(int thickness, int[] rgbColorCode, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }
    Graphics2D graph = (Graphics2D) optionalParams[0];
    graph.setColor(new Color(rgbColorCode[0], rgbColorCode[1], rgbColorCode[2]));
    graph.setStroke(new BasicStroke(thickness));
    return this;
  }

  @Override
  public Visitor<Shape> visitTextTool(String fontName, int fontSize, int fontStyle,
      int[] rgbColorCode, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }

    Graphics2D graph = (Graphics2D) optionalParams[0];

    graph.setFont(new Font(fontName, fontStyle, fontSize));
    graph.setColor(new Color(rgbColorCode[0], rgbColorCode[1], rgbColorCode[2]));
    return this;
  }

  @Override
  public Visitor<Shape> visitPolygonalPath(Point2D[] points, boolean closed,
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
    this.setResult(polygon);
    return this;
  }

  @Override
  public Visitor<Shape> visitBezierPath(Point2D[] points, boolean closed,
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
    this.setResult(bezier);
    return this;
  }

  @Override
  public Visitor<Shape> visitDraw(Path<Shape> path, Tool<Shape> tool, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }  

    Graphics2D graph = (Graphics2D)(optionalParams[0]);

    tool.render(this, optionalParams);
    graph.draw((Shape)path.render(this, optionalParams).getResult());
    return this;
  }

  @Override
  public Visitor<Shape> visitFill(Path<Shape> path, ColorManager color,
      Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }  

    Graphics2D graph = (Graphics2D)(optionalParams[0]);
    int[] rgbColor = color.getRgbCode();

    graph.setColor(new Color(rgbColor[0], rgbColor[1], rgbColor[2]));
    graph.fill((Shape)path.render(this, optionalParams).getResult());
    return this;
  }

  @Override
  public Visitor<Shape> visitInsert(Drawing<Shape> drawing, Path<Shape>[] paths,
                                    Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }

    Graphics2D graph = (Graphics2D)(optionalParams[0]);

    Shape oldClip = graph.getClip();
    for (Path<Shape> path : paths) {
      graph.clip((Shape)path.render(this, optionalParams).getResult());
    }
    drawing.render(this, optionalParams);

    graph.setClip(oldClip);
    return this;
  }

  @Override
  public Visitor<Shape> visitLabel(String text, Point2D position, TextTool<Shape> textTool,
      Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }

    Graphics2D graph = (Graphics2D)(optionalParams[0]);

    textTool.render(this, optionalParams);
    graph.drawString(text, position.getX(), position.getY());
    return this;
  }

  @Override
  public void visitExport(Drawing<Shape> drawing, int height, int width) {
    JFrame window = new JFrame();
    window.setTitle("Drawing");
    window.setSize(width, height);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setContentPane(new ResultPanel(drawing));
    window.setVisible(true);
  }

  @Override
  public Visitor<Shape> visitSequence(Drawing[] drawings, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }

    for (int i = 0; i < drawings.length; i++) {
      drawings[i].render(this, optionalParams);
    }

    return this;
  }

  @Override
  public Visitor<Shape> visitAlternative(Drawing[] drawings, boolean firstWanted,
      Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }

    if (firstWanted) {
      drawings[0].render(this, optionalParams);
    } else {
      drawings[1].render(this, optionalParams);
    }
    return this;
  }

  @Override
  public Visitor<Shape> visitLoop(Drawing<Shape> drawing, int numIterations,
      HashMap<String, Double[]> changeParams, Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }

    for (int i = 0; i < numIterations; i++) {
      if (changeParams.containsKey("rotation")) {
        Double[] value = changeParams.get("rotation");
        ((Graphics2D)optionalParams[0]).rotate(Math.toRadians(value[0]));
        drawing.render(this, optionalParams);
      }
      if (changeParams.containsKey("translation")) {
        Double[] value = changeParams.get("translation");
        ((Graphics2D)optionalParams[0]).translate(value[0], value[1]);
        drawing.render(this, optionalParams);
      }
      if (changeParams.containsKey("scale")) {
        Double[] value = changeParams.get("scale");
        ((Graphics2D)optionalParams[0]).scale(value[0], value[1]);
        drawing.render(this, optionalParams);
      }
    }
    return this;
  }

}
