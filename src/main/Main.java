package main;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.actions.Draw;
import datastructure.actions.Fill;
import datastructure.actions.Insert;
import datastructure.actions.Label;
import datastructure.operators.Alternative;
import datastructure.operators.Loop;
import datastructure.operators.Sequence;
import datastructure.paths.BezierPath;
import datastructure.paths.PolygonalPath;
import datastructure.tools.Pen;
import datastructure.tools.TextTool;
import factories.actions.DrawFactory;
import factories.actions.FillFactory;
import factories.actions.InsertFactory;
import factories.actions.LabelFactory;
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
    /*======= FACTORIES =======*/
    /*=========================*/
    DrawFactory draw = new Draw();
    FillFactory fill = new Fill();
    InsertFactory insert = new Insert();
    LabelFactory label = new Label();
    
    /*=========================*/
    /*========= TOOLS =========*/
    /*=========================*/
    ColorManager redCm = new ColorManager("hex", "#ff0000");
    ColorManager greenCm = new ColorManager("hex", "#00ff00");
    
    Tool redPen = new Pen(redCm);
    Tool greenPen = new Pen(greenCm, 6);
    
    Tool textTool = new TextTool(greenCm);
    
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
        new Point2D(60, 60),
        new Point2D(60, 120),
        new Point2D(120,120),
    };
    Point2D[] pointsBezier = {
        new Point2D(10, 10),
        new Point2D(100, 150),
        new Point2D(50,5),
        new Point2D(150, 150)
    };     
    Point2D[] points4 = {
        new Point2D(10, 10),
        new Point2D(70, 10),
        new Point2D(70, 70),
        new Point2D(10, 70)
    };
    Point2D[] points5 = {
        new Point2D(20, 20),
        new Point2D(50, 20),
        new Point2D(50, 50),
        new Point2D(20, 50)
    };
    Point2D[] points6 = {
        new Point2D(12,12),
        new Point2D(18,6),
        new Point2D(150,56)
    };
    Path polygonalPath1 = new PolygonalPath(points1, false);
    Path polygonalPath2 = new PolygonalPath(points2, false);
    Path polygonalPath3 = new PolygonalPath(points3, true);
    Path polygonalPath4 = new PolygonalPath(points4, true);
    Path polygonalPath5 = new PolygonalPath(points5, true);
    Path polygonalPath6 = new PolygonalPath(points6, true);
    Path bezierPath = new BezierPath(pointsBezier, false);
    Path[] paths = {polygonalPath5};
    
    /*=========================*/
    /*======== DRAWINGS =======*/
    /*=========================*/
    Drawing draw1 = draw.createDraw(polygonalPath1, redPen);
    Drawing draw2 = draw.createDraw(polygonalPath2, greenPen);
    Drawing drawBezier = draw.createDraw(bezierPath, redPen);
    Drawing draw3 = draw.createDraw(polygonalPath3, redPen);
    Drawing fill1 = fill.createFill(polygonalPath6, greenCm);
    Drawing fill2 = fill.createFill(polygonalPath4, redCm);
    Drawing insert1 = insert.createInsert(fill1, paths);
    Drawing label1 = label.createLabel("Hello world", new Point2D(100, 100), (TextTool)textTool);
    Drawing[] drawingArray = {
        //draw1,
        //draw2,
        //fill1,
        fill2,
        insert1,
        label1,
        //drawBezier
    };

    //Example with a Sequence :
    Drawing sequence = new Sequence(drawingArray);
     
    //Example with an Alternative :
    //Drawing sequence = new Alternative(drawingArray,true);
    
    //Example with a Loop
    //Object[] changeParams = {15.0};
    //Drawing sequence = new Loop(drawingArray, 5, "rotation", changeParams);
    
    /*=========================*/
    /*======== EXPORTS ========*/
    /*=========================*/
    sequence.export(new VisitorSvg(), 200, 200);
    sequence.export(new VisitorJava(), 200, 200);

  }

}
