package utils;

public class UsefulFunctions {
  
  public static int[] convertHexaToRGB(String hexaCode) {
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
