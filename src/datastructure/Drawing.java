package datastructure;

import visitors.Visitor;

/**
 * This abstract class is the base of all the model structure.
 * The structure is defined as a tree, tree that has leaves (actions) 
 * and subtrees (operators).
 */
public interface Drawing<T> {
  /*========================================*/ 
  /*============ Shared Methods ============*/
  /*========================================*/
  
  default void export(Visitor<T> visitor, int height, int width) {
    visitor.visitExport(this, height, width);
  }
  
  public Visitor<T> render(Visitor<T> visitor, Object[] optionalParams);
  
}
