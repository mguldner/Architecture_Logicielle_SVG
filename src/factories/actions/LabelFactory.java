package factories.actions;

import datastructure.actions.Label;
import datastructure.tools.TextTool;
import utils.Point2D;

public interface LabelFactory {
  public Label createLabel(String text, Point2D position, TextTool textTool);
  
  public Label createLabel(String text, TextTool textTool);
  
  public Label createLabel(String text, Point2D position);
}
