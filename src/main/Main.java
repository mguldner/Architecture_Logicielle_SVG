package main;

import dataStructure.Drawing;
import dataStructure.Path;
import dataStructure.Tool;
import dataStructure.actions.Draw;
import dataStructure.operators.Sequence;
import dataStructure.paths.PolygonalPath;
import dataStructure.tools.pens.HexaPen;
import utils.Point2D;

public class Main {
	/*
	 * Put here all your instructions to create your drawing
	 */
	public static void main(String[] args) {
		/*=========================*/
		/*========= TOOLS =========*/
		/*=========================*/
		Tool redPen = new HexaPen("#ff0000");
		
		
		/*=========================*/
		/*========= PATHS =========*/
		/*=========================*/
		Point2D[] points1 = {
			new Point2D(6,6),
			new Point2D(12, 12)
		};
		Point2D[] points2 = {
				new Point2D(12,12),
				new Point2D(18,6)
		};
		Path polygonalPath1 = new PolygonalPath(points1, false);
		Path polygonalPath2 = new PolygonalPath(points2, false);
		
		
		/*=========================*/
		/*======== DRAWINGS =======*/
		/*=========================*/
		Drawing draw1 = new Draw(polygonalPath1, redPen);
		Drawing draw2 = new Draw(polygonalPath2, redPen);
		Drawing[] drawingArray = {
				draw1,
				draw2
		};
		
		Drawing sequence = new Sequence(drawingArray);
		
		
		/*=========================*/
		/*======== EXPORTS =======*/
		/*=========================*/
		sequence.generateSvgDrawing(200,200);

	}

}
