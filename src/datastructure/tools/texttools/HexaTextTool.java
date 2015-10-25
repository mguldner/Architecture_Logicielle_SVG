package datastructure.tools.texttools;

import datastructure.tools.TextTool;
import utils.UsefulFunctions;

/**
 * This text tool takes the color in hexadecimal.
 */
public class HexaTextTool extends TextTool {  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/ 
  public HexaTextTool() {
    super();
  }
  
  public HexaTextTool(String color) {
    super(UsefulFunctions.convertHexaToRgb(color));
  }
  
  public HexaTextTool(String color, String fontName, int fontSize, String fontStyle) {
    super(UsefulFunctions.convertHexaToRgb(color), fontName, fontSize, fontStyle);
  }
}
