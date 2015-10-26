package datastructure;

import visitors.Visitor;

/**
 * This abstract class is the base of all the model structure.
 * The structure is defined as a tree, tree that has leaves (actions) 
 * and subtrees (operators).
 */
public abstract class Drawing {
  /*========================================*/ 
  /*============ Shared Methods ============*/
  /*========================================*/
  
  public void export(Visitor visitor, int height, int width) {
    visitor.visitExport(this, height, width);
  }
  
  public abstract String render(Visitor visitor, Object[] optionalParams);
  
}
