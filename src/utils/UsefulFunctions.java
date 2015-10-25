package utils;

/**
 * This class contains several useful functions.
 */
public class UsefulFunctions {
  /**
   * This function convert an string representing a color with its
   * hexadecimal code to an array of int representing the rgb code.
   * @param hexaCode string that is the hexadecimal code of the color
   * @return an array of int representing the rgb code
   */
  public static int[] convertHexaToRgb(String hexaCode) { 
    int[] rgbCode = new int[3];
    
    switch (hexaCode.length()) {
      case 7:
        rgbCode[0] = Integer.parseInt(hexaCode.substring(1, 3), 16);
        rgbCode[1] = Integer.parseInt(hexaCode.substring(3, 5), 16);
        rgbCode[2] = Integer.parseInt(hexaCode.substring(5), 16);
        break;
  
      default:
        throw new Error("Invalid hexadecimal code");
    }
    
    return rgbCode;
  }
 
}
