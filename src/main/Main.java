package main;

import dataStructure.actions.Draw;
import dataStructure.operators.Sequence;
import dataStructure.paths.PolygonalPath;
import dataStructure.tools.pens.HexaPen;
import utils.Point2D;

public class Main {
	/**
	 * Put here all your instructions to create your drawing
	 */
	public static void main(String[] args) {
		HexaPen redPen = new HexaPen("#ff0000");
		Point2D[] points1 = {
			new Point2D(6,6),
			new Point2D(12, 12)
		};
		Point2D[] points2 = {
				new Point2D(12,12),
				new Point2D(18,6)
		};
		
		PolygonalPath polygonalPath1 = new PolygonalPath(points1, false);
		PolygonalPath polygonalPath2 = new PolygonalPath(points2, false);
		
		Draw draw1 = new Draw(polygonalPath1, redPen);
		Draw draw2 = new Draw(polygonalPath2, redPen);
		Draw[] drawingArray = {
				draw1,
				draw2
		};
		
		Sequence sequence = new Sequence(drawingArray);
		
		sequence.generateSvgDrawing(200,200);

	}

}
