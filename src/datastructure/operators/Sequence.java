package datastructure.operators;

import datastructure.Drawing;
import datastructure.Operator;
import visitors.Visitor;

/**
 * This class is the representation of an operation.
 * It takes an array of drawings and draws each of them in 
 * the order of the array.
 */
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
  public String render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitSequence(this.applyFunction(), optionalParams);
  }
  
}
