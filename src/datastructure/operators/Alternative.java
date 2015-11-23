package datastructure.operators;

import datastructure.Drawing;
import datastructure.Operator;
import factories.operators.AlternativeFactory;
import visitors.Visitor;

/**
 * This class is the representation of an operation.
 * It takes a boolean and an array of two drawings, 
 * and draws the first drawing if the boolean is true, 
 * and the second otherwise
 */

public class Alternative<T> implements Operator<T>, AlternativeFactory{

  private Drawing[] drawings;
  //if the condition is true, draws the first drawing of the list.
  private boolean firstWanted;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/  
  public Alternative() {
    this.drawings = new Drawing[0];
  }
  
  private Alternative(Drawing[] drawings, boolean firstWanted) {
    this.drawings = drawings;
    this.firstWanted = firstWanted;
  }
  
  /*============================*/
  /*========== Getters =========*/
  /*============================*/
  public Drawing[] getDrawings() {
    return this.drawings;
  }

  public boolean getFirstWanted() {
    return this.firstWanted;
  }

  /*===============================================================*/
  /*============ Methods dedicated to each export mode ============*/
  /*===============================================================*/
  @Override
  public Visitor<T> render(Visitor<T> visitor, Object[] optionalParams) {
    return visitor.visitAlternative(this.getDrawings(), this.getFirstWanted(), optionalParams);
  }

  @Override
  public Alternative createAlternative(Drawing[] drawings,
      boolean firstWanted) {
    return new Alternative(drawings, firstWanted);
  }

}
