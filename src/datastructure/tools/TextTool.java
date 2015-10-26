package datastructure.tools;

import datastructure.Tool;
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
  private String fontStyle;

  
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
   * Constructor with a color setting.
   * @param color is the rgb code in an array
   */
  public TextTool(int[] color) {
    super(color);
    this.fontName = Constants.DEFAULT_FONT_NAME;
    this.fontSize = Constants.DEFAULT_FONT_SIZE;
    this.fontStyle = Constants.DEFAULT_FONT_STYLE;
  }
  /**
   * Constructor with color, fontName, fontSize and fontStyle.
   * @param color rgb code as array
   * @param fontName as a string
   * @param fontSize as an int
   * @param fontStyle as a string
   */
  public TextTool(int[] color, String fontName, 
                  int fontSize, String fontStyle) {
    super(color);
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
  
  public String getFontStyle() {
    return this.getFontStyle();
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
