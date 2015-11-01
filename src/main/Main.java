package main;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.actions.Draw;
import datastructure.operators.Alternative;
import datastructure.operators.Loop;
import datastructure.operators.Sequence;
import datastructure.paths.PolygonalPath;
import datastructure.tools.Pen;
import managers.ColorManager;
import utils.Point2D;
import utils.UsefulFunctions;
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
      new Point2D(60, 60),
      new Point2D(120, 120)
    };
    Point2D[] points2 = {
        new Point2D(12, 12),
        new Point2D(18, 6)
    };
    Point2D[] points3 = {
        new Point2D(60, 60),
        new Point2D(120, 120),
        new Point2D(60, 120)        
        };
    
    Path polygonalPath1 = new PolygonalPath(points1, false);
    Path polygonalPath2 = new PolygonalPath(points2, false);
    Path polygonalPath3 = new PolygonalPath(points3, false);
    
    /*=========================*/
    /*======== DRAWINGS =======*/
    /*=========================*/
    Drawing draw1 = new Draw(polygonalPath1, redPen);
    Drawing draw2 = new Draw(polygonalPath2, greenPen);
    Drawing draw3 = new Draw(polygonalPath3, redPen);
    Drawing[] drawingArray = {
        draw1,
    };
    

    //Example with a Sequence :
    //Drawing sequence = new Sequence(drawingArray);
     
    //Example with an Alternative :
    //Drawing sequence = new Alternative(drawingArray,true);
    
    //Example with a Loop
    Object[] changeParams = {15.0};
    Drawing sequence = new Loop(drawingArray, 5, "rotation", changeParams);
    
    /*=========================*/
    /*======== EXPORTS ========*/
    /*=========================*/
    sequence.export(new VisitorSvg(), 200, 200);
    sequence.export(new VisitorJava(), 200, 200);

  }

}
