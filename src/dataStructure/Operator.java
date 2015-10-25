package dataStructure;
public abstract class Operator extends Drawing {
	/*==============================*/
	/*========== Variables =========*/
	/*==============================*/
	/*
	 * As we chose to define an operator as a function that is 
	 * applied to an array of Drawings,we define here the drawings.
	 * The function and its parameters will be implemented in each 
	 * inheriting class
	 */
	private Drawing[] drawings;
	
	
	/*=================================*/
	/*========== Constructors =========*/
	/*=================================*/
	public Operator() {
		this.drawings = new Drawing[0];
	}
	public Operator(Drawing[] drawings) {
		this.drawings = drawings;
	}

	
	/*============================*/
	/*========== Getters =========*/
	/*============================*/
	public Drawing[] getDrawings() {
		return this.drawings;
	}

	
	/*==========================================*/
	/*=============Shared Methods ==============*/
	/*==========================================*/
	/**
	 * This function applies the method defining each operation 
	 * (identity for the sequence, duplication for the loop etc...).
	 * @return an array of Drawings that will be drawn when the 
	 * generateExportModeDrawing method will be called
	 */
	public abstract Drawing[] applyFunction();
	
	
	/*===============================================================*/
	/*============ Methods dedicated to each export mode ============*/
	/*===============================================================*/
	
	/*
	 * These abstracts methods are implemented by each type of operator.
	 * They are necessary to interpret the logical drawing in a given 
	 * export mode.
	 * Depending they are associated to a Java export mode or not, they 
	 * will return nothing or they will return the code as a string.
	 */
	public abstract String applySvgOperation();
	public abstract void applyJavaOperation();
	
	/*
	 * These methods are just meant to have more meaningful methods names
	 */
	public String generateSvgCode() {
		return this.applySvgOperation();
	}
//	@Override
//	public void generateJavaDrawing() {
//		this.applyJavaOperation();
//	}

}
