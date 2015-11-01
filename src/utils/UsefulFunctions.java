package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains several useful functions.
 */
public class UsefulFunctions {
  /**
   * This method gives the name of the color code that has been used.
   * @param colorCode as a String
   * @return a string representing the color code
   */
  public static String getColorCodeType(String colorCode) {
    String[] colorType = {
      "hex"
    };
    String[] patterns = {
      "^#([a-fA-F0-9]{3}){1,2}"  
    };
    
    int indexFound = -1;
    
    for (int i = 0; i < patterns.length && indexFound == -1; i++) {
      Pattern pattern = Pattern.compile(patterns[i]);
      Matcher matcher = pattern.matcher(colorCode);
      if (matcher.matches()) {        
        indexFound = i;
      }
    }
    
    if (indexFound != -1) {
      return colorType[indexFound];      
    } else {
      return "unknown";      
    }
  }
  /**
   * This function tests if the given array could represent a rgb code.
   * @param arrayToTest array of int
   * @return true if it could be an rgb code
   */
  public static boolean arrayIsRgbCode(int[] arrayToTest) {
    if (arrayToTest.length != 3) {
      return false;
    }
    boolean allIsOk = true;
    for (int i = 0; i < arrayToTest.length && allIsOk; i++) {
      if (arrayToTest[i] < 0 || arrayToTest[i] > 250) {
        allIsOk = false;
      }
    }
    return allIsOk;
  }
  /**
   * This functions checks the colorCode given is matching its refType.
   * @param refType string that defines a color representation (rgb, hex...)
   * @param colorCode representation of a color
   * @return true if the colorCode corresponds to the reference type
   */
  public static boolean typesCorrespond(String refType, Object colorCode) {
    if (colorCode instanceof String) {
      return refType == getColorCodeType((String) colorCode);
    }
    if (colorCode instanceof int[] && refType == "rgb") {
      return arrayIsRgbCode((int[]) colorCode);
    }
    return false;
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
  public static String toString(double[][] matrix) {
    String result = "(";
    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i != matrix.length - 2 || j != matrix[0].length - 1) {
          result += matrix[i][j] + ",";
        }
        else {
          result += matrix[i][j];
        }
      }
    }
    result += ")";
    return result;
  }
  public static double[][] MatrixRotation(double d){
    double[][] matrix = {
        {Math.cos(d), -Math.sin(d), 0},
        {Math.sin(d), Math.cos(d), 0},
        {0, 0,1}};
    return matrix;
  }
}
