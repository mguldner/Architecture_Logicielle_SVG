package datastructure.actions;


import datastructure.Action;
import datastructure.tools.TextTool;
import factories.actions.LabelFactory;
import utils.Point2D;
import visitors.Visitor;


/**
 * This class is the representation of one type of Action.
 * This Action enables to put a label on a Drawing.
 */
public class Label<T> implements Action<T>, LabelFactory {
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
  private TextTool<T> textTool;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  /**
   * Construct a drawing by filling a closed path.
   * @param text the text of the label.
   * @param position the position of the label.
   * @param textTool the TextTool to use.
   */
  private Label(String text, Point2D position, TextTool<T> textTool) {
    this.text = text;
    this.position = position;
    this.textTool = textTool;
  }
  
  private Label(String text, Point2D position) {
    this(text, position, new TextTool<T>());
  }
  
  private Label(String text, TextTool<T> textTool) {
    this(text, new Point2D(0,0));
  }
  
  public Label() {
    this("", new Point2D());
  }
    
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  @Override
  public Visitor<T> render(Visitor<T> visitor, Object[] optionalParams) {
    return visitor.visitLabel(text, position, textTool, optionalParams);
  }

  @Override
  public Label createLabel(String text, Point2D position, TextTool textTool) {
    return new Label(text, position, textTool);
  }

  @Override
  public Label createLabel(String text, TextTool textTool) {
    return new Label(text, textTool);
  }

  @Override
  public Label createLabel(String text, Point2D position) {
    return new Label(text, position);
  }

}
