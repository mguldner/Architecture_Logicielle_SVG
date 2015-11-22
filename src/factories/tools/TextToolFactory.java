package factories.tools;

import datastructure.tools.TextTool;
import managers.ColorManager;

public interface TextToolFactory {
  public TextTool createTextTool(ColorManager colorManager);
  
  public TextTool createTextTool(ColorManager colorManager, String fontName, 
      int fontSize, int fontStyle);
}
