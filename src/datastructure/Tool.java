package datastructure; 

import utils.Constants;
import visitors.Visitor;

/**
 * This class allows the user to easily add new tools.
 */
public abstract class Tool {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/  
  private int[] rgbColorCode;
  
  
  
  /*=================================*/  
  /*========== Constructors =========*/
  /*=================================*/  
  public Tool() {
    this.rgbColorCode = Constants.DEFAULT_COLORCODE;
  }
  
  public Tool(int[] color) {
    this.rgbColorCode = color;
  }

  
  /*============================*/  
  /*========== Getters =========*/
  /*============================*/  
  /**
   * Getter.
   * @return the hexacode corresponding to the color
   */
  public int[] getRgbColorCode() {
    return rgbColorCode;
  }

  
  /*========================================*/  
  /*============ Shared Methods ============*/
  /*========================================*/  
  public abstract String render(Visitor visitor, Object[] optionalParams);

}
