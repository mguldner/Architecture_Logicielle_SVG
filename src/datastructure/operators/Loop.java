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
  private int numberIterations;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/  
  
  public Loop() {
    super();
  }
  
  public Loop(Drawing[] drawings) {
    super(drawings);
  }
  
  /*============================*/
  /*========== Getters =========*/
  /*============================*/
  
  public int getNumberIterations() {
    return this.numberIterations;
  }
  
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  
  @Override
  public Drawing[] applyFunction() {
    Drawing[] drawings = new Drawing[this.getDrawings().length * this.getNumberIterations()];
    int compt = 0;
    for (int i = 0; i < this.getNumberIterations(); i++) {
      for (int j = 0; j < numberIterations; j++) {
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
    return visitor.visitOperator(this.applyFunction(), optionalParams);
  }

}
