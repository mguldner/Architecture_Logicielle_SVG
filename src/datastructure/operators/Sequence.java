package datastructure.operators;

import datastructure.Drawing;
import datastructure.Operator;
import factories.operators.SequenceFactory;
import visitors.Visitor;

/**
 * This class is the representation of an operation.
 * It takes an array of drawings and draws each of them in 
 * the order of the array.
 */
public class Sequence<T> extends Operator<T> implements SequenceFactory {
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/  
  public Sequence() {
    super();
  }
  
  private Sequence(Drawing[] drawings) {
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
  public Visitor<T> render(Visitor<T> visitor, Object[] optionalParams) {
    return visitor.visitOperator(this.applyFunction(), optionalParams);
  }

  @Override
  public Sequence createSequence(Drawing[] drawings) {
    return new Sequence(drawings);
  }
  
}
