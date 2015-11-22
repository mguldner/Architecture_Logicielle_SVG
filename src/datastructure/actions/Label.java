package datastructure.actions;


import datastructure.Action;
import datastructure.tools.TextTool;
import utils.Point2D;
import visitors.Visitor;


/**
 * This class is the representation of one type of Action.
 * This Action enables to put a label on a Drawing.
 */
public class Label implements Action {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  /**
   * text: the text of the label.
   * position: the position of the label.
   * textTool: the TextTool too use.
   */
  private String text;
  private Point2D position;
  private TextTool textTool;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  /**
   * Construct a drawing by filling a closed path.
   * @param text the text of the label.
   * @param position the position of the label.
   * @param textTool the TextTool to use.
   */
  public Label(String text, Point2D position, TextTool textTool) {
    this.text = text;
    this.position = position;
    this.textTool = textTool;
  }
  
  public Label(String text, Point2D position) {
    this(text, position, new TextTool());
  }
  
  public Label(String text, TextTool textTool) {
    this(text, new Point2D(0,0));
  }
  
  public Label() {
    this("", new Point2D());
  }
    
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  @Override
  public String render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitLabel(text, position, textTool, optionalParams);
  }

}
