package dataStructure;
public abstract class Operator implements Drawing {
	/**
	 * As we chose to define an operator as a function that is applied to an array of Drawings,
	 * we define here the drawings.
	 * The function and its parameters will be implemented in each inheriting class
	 */
	private Drawing[] drawings;
	
	/**
	 * These abstracts methods are implemented by each type of operator.
	 * They are necessary to interpret the logical drawing in a given export mode
	 */
	public abstract void applySvgOperation();
	public abstract void applyJavaOperation();
	
	/**
	 * This function applies the function defining each operation (identity for the sequence, 
	 * duplication for the loop etc...)
	 * @return an array of Drawings that will be drawn when the generateExportModeDrawing
	 * function will be called
	 */
	public abstract Drawing[] applyFunction();
	
	public Drawing[] getDrawings() {
		return this.drawings;
	}

	@Override
	public void generateSvgDrawing() {
		this.applySvgOperation();
	}

	@Override
	public void generateJavaDrawing() {
		this.applySvgOperation();
	}

}
