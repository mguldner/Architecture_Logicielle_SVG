package datastructure.tools;

import datastructure.Tool;
import managers.ColorManager;
import utils.Constants;
import visitors.Visitor;

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
public class Pen extends Tool {
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
  
  public Pen(ColorManager colorManager) {
    super(colorManager);
    this.thickness = Constants.DEFAULT_PEN_THICKNESS;
  }
  
  public Pen(ColorManager colorManager, int thickness) {
    super(colorManager);
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
  public String render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitPen(this.getThickness(), this.getRgbColorCode(), optionalParams);
  }
}
