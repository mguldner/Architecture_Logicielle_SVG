package datastructure.tools;

import datastructure.Tool;
import managers.ColorManager;
import utils.Constants;
import visitors.Visitor;

/**
 * This class allows the user to easily add new TextTools 
 * (basic types being HexaTextTool and RgbTextTool).
 * If the user wants to add a new "export" mode (basic export modes are 
 * to SVG and to Java), they need to declare a new abstract method:
 * <code>
 *  public abstract void applyNewExportModeTool();
 * </code>
 * The <code>applyNewExportModeTool</code> method will have to be 
 * implemented for all pens.
 */
public class TextTool extends Tool {  
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  private String fontName;
  private int fontSize;
  private int fontStyle;

  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  /**
   * Constructor.
   */
  public TextTool() {
    super();
    this.fontName = Constants.DEFAULT_FONT_NAME;
    this.fontSize = Constants.DEFAULT_FONT_SIZE;
    this.fontStyle = Constants.DEFAULT_FONT_STYLE;
  }
  /**
   * Constructor with a color manager. 
   * @param colorManager color manager
   */
  public TextTool(ColorManager colorManager) {
    super(colorManager);
    this.fontName = Constants.DEFAULT_FONT_NAME;
    this.fontSize = Constants.DEFAULT_FONT_SIZE;
    this.fontStyle = Constants.DEFAULT_FONT_STYLE;
  }
  /**
   * Constructor with color, fontName, fontSize and fontStyle.
   * @param colorManager color manager
   * @param fontName as a string
   * @param fontSize as an int
   * @param fontStyle as a string
   */
  public TextTool(ColorManager colorManager, String fontName, 
                  int fontSize, int fontStyle) {
    super(colorManager);
    this.fontName = fontName;
    this.fontSize = fontSize;
    this.fontStyle = fontStyle; 
  }  

  public String getFontName() {
    return this.fontName;
  }
  
  public int getFontSize() {
    return this.fontSize;
  }
  
  public int getFontStyle() {
    return this.fontStyle;
  }
  
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  @Override
  public String render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitTextTool(this.getFontName(), 
                                 this.getFontSize(), 
                                 this.getFontStyle(), 
                                 this.getRgbColorCode(), optionalParams);
  }

}
