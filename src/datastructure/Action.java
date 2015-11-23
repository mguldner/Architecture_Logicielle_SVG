package datastructure;

import visitors.Visitor; 

/**
 * This abstract class allows the user to easily add new types of actions 
 * (basic types being Draw, Fill, Insert and Labelise).
 */
public interface Action extends Drawing {
  
  public Object render(Visitor visitor, Object[] optionalParams);  
  
}
