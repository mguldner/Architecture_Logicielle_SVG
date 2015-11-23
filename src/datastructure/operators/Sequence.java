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
public class Sequence<T> implements Operator<T>, SequenceFactory {
  
  private Drawing[] drawings;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/  
  public Sequence() {
    this.drawings = new Drawing[0];
  }
  
  public Sequence(Drawing[] drawings) {
    this.drawings = drawings;
  }
  

  /*============================*/
  /*========== Getters =========*/
  /*============================*/
  public Drawing[] getDrawings() {
    return this.drawings;
  }
  
  /*===============================================================*/
  /*============ Methods dedicated to each export mode ============*/
  /*===============================================================*/
  public Visitor<T> render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitSequence(this.getDrawings(), optionalParams);
  }

  @Override
  public Sequence createSequence(Drawing[] drawings) {
    return new Sequence(drawings);
  }
  
}
