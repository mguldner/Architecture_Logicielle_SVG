package managers;

import factories.ColorManagerFactory;
import utils.Constants;
import utils.UsefulFunctions;

public class ColorManager implements ColorManagerFactory {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  private String colorType;
  private Object color;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  /**
   * Constructor.
   */
  public ColorManager() {
    if (UsefulFunctions.typesCorrespond(Constants.DEFAULT_COLOR_TYPE,
                                        Constants.DEFAULT_COLORCODE)) {
      this.colorType = Constants.DEFAULT_COLOR_TYPE;
      this.color = Constants.DEFAULT_COLORCODE;
    } else {
      throw new Error("Default color type and color code are not compatible");
    }
  }
  /**
   * Constructor with a colorType and a color.
   * @param colorType is a String like rgb or hex
   * @param color is the representation of the color (int[] or String for instance)
   */
  private ColorManager(String colorType, Object color) {
    if (UsefulFunctions.typesCorrespond(colorType, color)) {
      this.colorType = colorType;
      this.color = color;      
    } else {
      throw new Error("Color type and color code are not compatible");
    }
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
  /**
   * This method gets the color of the ColorManager but in the int[] format.
   * @return a valid int[] that reprensents a rgb color
   */
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
  @Override
  public ColorManager createColorManager(String colorType, Object color) {
    return new ColorManager(colorType, color);
  }
  
}
