package datastructure;

import visitors.Visitor;

/**
 * This abstract class allows the user to easily add new operations 
 * (basic types being Sequence, Alternative, Loop).
 */
public interface Operator extends Drawing {

  public abstract String render(Visitor visitor, Object[] optionalParams);
  
}
