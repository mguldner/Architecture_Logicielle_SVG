package visitors;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
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
    if (optionalParams == null || optionalParams.length < 1 || ! (optionalParams[0] instanceof Graphics2D)) {
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
  public String visitPolygonalPath(Point2D[] points, boolean closed,
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
    Graphics2D graph = (Graphics2D) optionalParams[0];
    graph.draw(polygon);
    return "Ok";
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

  public String visitLoop(Drawing[] drawings, String change, Object[] changeparams, 
      Object[] optionalParams) {
    if (optionalParams == null || optionalParams.length < 1 
        || ! (optionalParams[0] instanceof Graphics2D)) {
      throw new Error("No valid graphic given");
    }
    if (change == "rotation") {
      for (int i = 0; i < drawings.length; i++) {
        ((Graphics2D) optionalParams[0]).rotate(Math.toRadians((double)changeparams[0]));
        drawings[i].render(this, optionalParams);
      }
    }
    if (change == "translation") {
      for (int i = 0; i < drawings.length; i++) {
        ((Graphics2D) optionalParams[0]).translate((double)changeparams[0], 
              (double)changeparams[1]);
        drawings[i].render(this, optionalParams);
      }
    }
    if (change == "scaling") {
      for (int i = 0; i < drawings.length; i++) {
        ((Graphics2D) optionalParams[0]).scale((double)changeparams[0], 
            (double)changeparams[1]);
        drawings[i].render(this, optionalParams);
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
