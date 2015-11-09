package exports;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportSvg {

  public static String path = "./svgPicture.svg";
  
  /**
   * This function enables to export the SVG text in a file.
   * @param text the SVG text to export.
   */
  public static void export(String text) {
    
    try {
      FileWriter fw = new FileWriter(path);
      BufferedWriter output = new BufferedWriter(fw);
      
      output.write(text);
      output.flush();
      output.close();
    } catch (IOException ioe) {
      System.out.println("Error catched : " + ioe);
    }
  }
}