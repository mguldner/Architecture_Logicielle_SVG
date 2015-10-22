package operators;

import dataStructure.Drawing;
import dataStructure.Operator;

public class Sequence extends Operator {

	@Override
	public void applySvgOperation() {
		Drawing[] selectedDrawings = this.applyFunction();
		// TODO Write here what to do to produce the corresponding section

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
