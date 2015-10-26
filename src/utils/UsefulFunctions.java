package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains several useful functions.
 */
public class UsefulFunctions {
  public static String getColorCodeType(String colorCode) {
    String[] patterns = {
      "^#[a-fA-F0-9]{3}|[a-fA-F0-9]{6}"  
    };
    Pattern pattern = Pattern.compile(patterns[0]);
    Matcher matcher = pattern.matcher(colorCode);
    
    if (matcher.find())
      System.out.println(colorCode + ": Ok");
    else
      System.out.println(colorCode + ": Not Ok");
      
    return "Ok";
  }
  
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
