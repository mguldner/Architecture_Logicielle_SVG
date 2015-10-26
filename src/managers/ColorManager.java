package managers;

import utils.Constants;
import utils.UsefulFunctions;

public class ColorManager {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  private String colorType;
  private Object color;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public ColorManager() {
    this.colorType = Constants.DEFAULT_COLOR_TYPE;
    this.color = Constants.DEFAULT_COLORCODE;
  }
  
  public ColorManager(String colorType, Object color) {
    this.colorType = colorType;
    this.color = color;
  }
  
  /*============================*/
  /*========== Getters =========*/
  /*============================*/
  public String getColorType() {
    return this.colorType;
  }
  public Object getColor() {
    return this.color;
  }
  
  /*============================*/
  /*========== Methods =========*/
  /*============================*/
  public int[] getRgbCode() {
    int[] rgbToReturn = new int[3];
    switch (this.getColorType()) {
      case "rgb":
        rgbToReturn = (int[]) this.getColor();
        break;
      case "hex":
        rgbToReturn = UsefulFunctions.convertHexaToRgb((String) this.getColor());
        break;
      default:
        break;
    }
    return rgbToReturn;
  }
  
}
