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

public class Alternative<T> extends Operator<T> implements AlternativeFactory{

  //if the condition is true, draws the first drawing of the list.
  private boolean firstWanted;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/  
  public Alternative() {
    super();
  }
  
  private Alternative(Drawing[] drawings, boolean firstWanted) {
    super(drawings);
    this.firstWanted = firstWanted;
  }
  
  /*============================*/
  /*========== Getters =========*/
  /*============================*/
  public boolean getFirstWanted() {
    return this.firstWanted;
  }
  
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  @Override
  public Drawing[] applyFunction() {
    Drawing[] drawing = new Drawing[1];
    if (this.getFirstWanted()) {
      drawing[0] = this.getDrawings()[0];
    } else {
      drawing[0] = this.getDrawings()[1];
    }
    return drawing;
  }

  /*===============================================================*/
  /*============ Methods dedicated to each export mode ============*/
  /*===============================================================*/
  @Override
  public Visitor<T> render(Visitor<T> visitor, Object[] optionalParams) {
    return visitor.visitOperator(this.applyFunction(), optionalParams);
  }

  @Override
  public Alternative createAlternative(Drawing[] drawings,
      boolean firstWanted) {
    return new Alternative(drawings, firstWanted);
  }

}
