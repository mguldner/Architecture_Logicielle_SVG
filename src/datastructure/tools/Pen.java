package datastructure.tools;

import datastructure.Tool;
import utils.Constants;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * This class allows the user to easily add new Pens 
 * (basic types being HexaPen and RgbPen).
 * If the user wants to add a new "export" mode (basic export modes are 
 * to SVG and to Java), they need to declare a new abstract method:
 * <code>
 *  public abstract void applyNewExportModeTool();
 * </code>
 * The <code>applyNewExportModeTool</code> method will have to be 
 * implemented for all pens.
 */
public abstract class Pen extends Tool {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  private int thickness;

  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public Pen() {
    super();
    this.thickness = Constants.DEFAULT_PEN_THICKNESS;
  }
  
  public Pen(int thickness) {
    super();
    this.thickness =  thickness;
  }
  
  public Pen(int[] color) {
    super(color);
    this.thickness = Constants.DEFAULT_PEN_THICKNESS;
  }
  
  public Pen(int[] color, int thickness) {
    super(color);
    this.thickness = thickness;
  }

  
  /*============================*/
  /*========== Getters =========*/
  /*============================*/
  /**
   * Getter.
   * @return the int corresponding to the thickness of the tool
   */
  public int getThickness() {
    return thickness;
  }

  
  /*===================================*/
  /*========== Shared Methods =========*/
  /*===================================*/

  
  /*===============================================================*/
  /*============ Methods dedicated to each export mode ============*/
  /*===============================================================*/
  
  /*=================================================*/
  /*================== SVG export ===================*/
  /*=================================================*/
  @Override
  public String applySvgTool() {
    int[] rgbColorCode = this.getRgbColorCode();
    return "stroke-width=\"" + this.getThickness() + "\" " 
            + "stroke=\"rgb(" + rgbColorCode[0] + ","
            + rgbColorCode[1] + ","
            + rgbColorCode[2]
            + ")\"";
  }
  
  /*=================================================*/
  /*================== Java export ==================*/
  /*=================================================*/
  @Override
  public void applyJavaTool(Graphics2D graph) {
    int[] rgbColorCode = this.getRgbColorCode();
    graph.setColor(new Color(rgbColorCode[0], rgbColorCode[1], rgbColorCode[2]));
    graph.setStroke(new BasicStroke(this.getThickness()));
  }
}
