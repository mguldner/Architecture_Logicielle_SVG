package main;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.actions.Draw;
import datastructure.operators.Sequence;
import datastructure.paths.BezierPath;
import datastructure.paths.PolygonalPath;
import datastructure.tools.Pen;
import managers.ColorManager;
import utils.Point2D;
import visitors.VisitorJava;
import visitors.VisitorSvg;

/**
 * This class owns the main method.
 */
public class Main { 
  /**
   * Put here all your instructions to create your drawing.
   * @param args arguments
   */
  public static void main(String[] args) {    
    /*=========================*/
    /*========= TOOLS =========*/
    /*=========================*/
    ColorManager redCm = new ColorManager("hex", "#ff0000");
    ColorManager greenCm = new ColorManager("hex", "#00ff00");
    
    Tool redPen = new Pen(redCm);
    Tool greenPen = new Pen(greenCm, 6);
    
    
    /*=========================*/
    /*========= PATHS =========*/
    /*=========================*/
    Point2D[] points1 = {
      new Point2D(6, 6),
      new Point2D(12, 12),
      new Point2D(40, 70)
    };
    Point2D[] points2 = {
        new Point2D(12, 12),
        new Point2D(18, 6)
    };
    Point2D[] points3 = {
        new Point2D(12, 12),
        new Point2D(18, 6),
        new Point2D(150,56)
    };
    Point2D[] pointsBezier = {
        new Point2D(10, 10),
        new Point2D(100, 150),
        new Point2D(50,5),
        new Point2D(150, 150)
    };
    Path polygonalPath1 = new PolygonalPath(points1, false);
    Path polygonalPath2 = new PolygonalPath(points2, false);
    Path polygonalPath3 = new PolygonalPath(points3, true);
    Path bezierPath = new BezierPath(pointsBezier, false);
    
    
    /*=========================*/
    /*======== DRAWINGS =======*/
    /*=========================*/
    Drawing draw1 = new Draw(polygonalPath1, redPen);
    Drawing draw2 = new Draw(polygonalPath2, greenPen);
    Drawing drawBezier = new Draw(bezierPath, redPen);
    Drawing[] drawingArray = {
        draw1,
        draw2,
        drawBezier
    };
    
    Drawing sequence = new Sequence(drawingArray);
    
    
    /*=========================*/
    /*======== EXPORTS ========*/
    /*=========================*/
    sequence.export(new VisitorSvg(), 200, 200);
    sequence.export(new VisitorJava(), 200, 200);

  }

}