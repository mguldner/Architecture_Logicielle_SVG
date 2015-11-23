package datastructure;

import visitors.Visitor;

/**
 * This abstract class allows the user to easily add new operations 
 * (basic types being Sequence, Alternative, Loop).
 */

public interface Operator<T> extends Drawing<T> {

  public abstract Visitor<T> render(Visitor<T> visitor, Object[] optionalParams);
  
}
