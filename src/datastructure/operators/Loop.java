package datastructure.operators;

import java.util.HashMap;
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

public class Loop<T> implements Operator<T>, LoopFactory<T>{

  private Drawing drawing;
  
  // n represents the number of iteration for the Loop
  private int numberIterations;
  
  /* the parameters of the change : 
       for a rotation : a double that represents the angle
       for a translation : two double for the vector of translation
       for a scale : two double for horizontal and vertical*/
  private HashMap<String,Double[]> changeParams;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/  
  
  public Loop() {
    this.drawing = new Sequence();
  }

  
  public Loop(Drawing drawing, int numberIterations, 
      HashMap<String, Double[]> changeParams) {
    this.drawing = drawing;
    this.numberIterations = numberIterations;
    this.changeParams = changeParams;
  }
  
  /*============================*/
  /*========== Getters =========*/
  /*============================*/
  
  public int getNumberIterations() {
    return this.numberIterations;
  }
  

  public HashMap<String, Double[]> getChangeParams() {
    return this.changeParams;
  }

  /*===============================================================*/
  /*============ Methods dedicated to each export mode ============*/
  /*===============================================================*/
  public Visitor<T> render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitLoop(this.drawing, this.getNumberIterations(), 
        this.changeParams, optionalParams);
  }

  @Override
  public Loop createLoop(Drawing drawing, int numberIterations, 
      HashMap<String, Double[]> changeParams) {
    return new Loop(drawing, numberIterations, changeParams);
  }

}
