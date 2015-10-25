package datastructure.operators;

import java.awt.Graphics2D;

import datastructure.Drawing;
import datastructure.Operator;

public class Sequence extends Operator {
	/*=================================*/
	/*========== Constructors =========*/
	/*=================================*/ 
	public Sequence() {
		super();
	}
	public Sequence(Drawing[] drawings) {
		super(drawings);
	}

	
	/*========================================*/
	/*============ Shared Methods ============*/
	/*========================================*/
	@Override
	public Drawing[] applyFunction() {
		/*Here now need to modify the drawing array as
		 *we just want to draw all of them
		 **/
		return this.getDrawings();
	}

	
	/*===============================================================*/
	/*============ Methods dedicated to each export mode ============*/
	/*===============================================================*/
	
		/*=================================================*/
		/*================== SVG export ===================*/
		/*=================================================*/
	@Override
	public String applySvgOperation() {
		Drawing[] selectedDrawings = this.applyFunction();
		String svgCode = "";
		for (int i = 0; i < selectedDrawings.length; i++) {
			svgCode += selectedDrawings[i].generateSvgCode();
		}
		return svgCode;
	}

		/*=================================================*/
		/*================== Java export ==================*/
		/*=================================================*/
	@Override
	public void applyJavaOperation(Graphics2D g) {
		Drawing[] selectedDrawings = this.applyFunction();
		// TODO Write here what to do to produce the corresponding section
		for (int i = 0; i < selectedDrawings.length; i++) {
		  selectedDrawings[i].generateJavaCode(g);
		}
	}



}
