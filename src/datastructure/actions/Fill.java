package datastructure.actions;

import datastructure.Action;
import datastructure.Path;
import utils.Constants;
import utils.UsefulFunctions;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This class is the representation of one type of Action.
 * This action draws a path with a tool.
 */
public class Fill extends Action {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  /**
   * path: Path to follow.
   * tool: Tool to use.
   */
  private Path path;
  private int[] rgbColorCode;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public Fill(Path path) {
    this.path = path;
    this.rgbColorCode = Constants.DEFAULT_COLORCODE;
  }
  
  
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/

  
  /*===============================================================*/
  /*============ Methods dedicated to each export mode ============*/
  /*===============================================================*/
  
  /*=================================================*/
  /*================== SVG export ===================*/
  /*=================================================*/
  @Override
  public String applySvgAction() {
    String svgCode = "<path ";
    svgCode += path.generateSvgPath() + " ";
    svgCode += "style=\"rgb(" + rgbColorCode[0] + "," 
      + rgbColorCode[1] + "," + rgbColorCode[2] + ")\" ";
    svgCode += "/>\n";
    return svgCode;
  }

  /*=================================================*/
  /*================== Java export ==================*/
  /*=================================================*/
  @Override
  public void applyJavaAction(Graphics2D graph) {
    graph.setColor(new Color(rgbColorCode[0], rgbColorCode[1], rgbColorCode[2]));
    graph.fill(path.generateJavaPath());
  }

}
