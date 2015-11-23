package datastructure;

import visitors.Visitor; 

/**
 * This abstract class allows the user to easily add new types of actions 
 * (basic types being Draw, Fill, Insert and Labelise).
 */
public interface Action<T> extends Drawing<T> {
  
  public Visitor<T> render(Visitor<T> visitor, Object[] optionalParams);  
  
}
