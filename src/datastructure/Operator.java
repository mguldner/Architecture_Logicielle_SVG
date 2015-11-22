package datastructure;

import visitors.Visitor;

/**
 * This abstract class allows the user to easily add new operations 
 * (basic types being Sequence, Alternative, Loop).
 */
public abstract class Operator implements Drawing {
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
   *         generateExportModeDrawing method will be called
   */
  public abstract Drawing[] applyFunction();
  
  public abstract String render(Visitor visitor, Object[] optionalParams);
  
}
