package dataStructure.operators;

import dataStructure.Drawing;
import dataStructure.Operator;

public class Sequence extends Operator {
	
	public Sequence() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Sequence(Drawing[] drawings) {
		super(drawings);
	}

	@Override
	public String applySvgOperation() {
		Drawing[] selectedDrawings = this.applyFunction();
		String svgCode = "";
		for (int i=0; i < selectedDrawings.length; i++) {
			svgCode += selectedDrawings[i].generateSvgCode();
		}
		return svgCode;
	}

	@Override
	public void applyJavaOperation() {
		Drawing[] selectedDrawings = this.applyFunction();
		// TODO Write here what to do to produce the corresponding section

	}

	@Override
	public Drawing[] applyFunction() {
		//Here now need to modify the drawing array as we just want to draw all of them
		return this.getDrawings();
	}


}
