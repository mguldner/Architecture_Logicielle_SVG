package datastructure.operators;

import datastructure.Drawing;
import datastructure.Operator;
import visitors.Visitor;

/**
 * This class is the representation of an operation.
 * It takes an array of drawings and a number n of iterations and 
 * draws the drawings n time.
 */

public class Loop extends Operator{

  // n represents the number of iteration for the Loop
  private int n;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/  
  
  public Loop() {
    super();
  }
  
  public Loop(Drawing[] drawings) {
    super(drawings);
  }
  
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  
  @Override
  public Drawing[] applyFunction() {
    Drawing[] drawings = new Drawing[this.getDrawings().length * this.n];
    int compt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        drawings[compt] = this.getDrawings()[j];
        compt++;
      }
    }
      
    
    return drawings;
  }

  /*===============================================================*/
  /*============ Methods dedicated to each export mode ============*/
  /*===============================================================*/
  public String render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitSequence(this.applyFunction(), optionalParams);
  }

}
