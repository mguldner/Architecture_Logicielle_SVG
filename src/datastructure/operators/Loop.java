package datastructure.operators;

import datastructure.Drawing;
import datastructure.Operator;
import factories.operators.LoopFactory;
import visitors.Visitor;

/**
 * This class is the representation of an operation.
 * It takes an array of drawings and a number n of iterations and 
 * draws the drawings n time.
 * We can imagine that the user will want to :
 * translate Points2D
 * rotate (Points2D), float 
 * change the color Color
 * change the size float
 * (for a text, change the font)
 * 
 */

public class Loop extends Operator implements LoopFactory{

  // n represents the number of iteration for the Loop
  private int numberIterations;
  
  // the change to operate : rotation or rotation for the moment
  private String change;
  
  // the parameters of the change : 
      // for a rotation : a double that represents the angle
      // for a translation : two double for the vector of translation
  private Object[] changeParams;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/  
  
  public Loop() {
    super();
  }
  
  private Loop(Drawing[] drawings, int numberIterations, String change, 
               Object[] changeParams) {
    super(drawings);
    this.numberIterations = numberIterations;
    this.change = change;
    this.changeParams = changeParams;
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
      for (int j = 0; j < this.getDrawings().length; j++) {
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
    return visitor.visitLoop(this.applyFunction(), this.change, this.changeParams, optionalParams);
  }

  @Override
  public Loop createLoop(Drawing[] drawings, int numberIterations,
      String change, Object[] changeParams) {
    return new Loop(drawings, numberIterations, change, changeParams);
  }

}
