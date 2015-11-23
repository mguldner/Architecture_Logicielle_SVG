package datastructure; 

import managers.ColorManager;

import visitors.Visitor;

/**
 * This class allows the user to easily add new tools.
 */
public abstract class Tool<T> {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  private ColorManager colorManager;
    
  /*=================================*/  
  /*========== Constructors =========*/
  /*=================================*/  
  public Tool() {
    this.colorManager = new ColorManager();
  }
  
  public Tool(ColorManager colorManager) {
    this.colorManager = colorManager;
  }

  
  /*============================*/  
  /*========== Getters =========*/
  /*============================*/  
  public ColorManager getColorManager() {
    return this.colorManager;
  }
  /**
   * Getter.
   * @return the hexacode corresponding to the color
   */
  public int[] getRgbColorCode() {
    return this.getColorManager().getRgbCode();
  }

  
  /*========================================*/  
  /*============ Shared Methods ============*/
  /*========================================*/  
  public abstract Visitor<T> render(Visitor<T> visitor, Object[] optionalParams);

}
