package factories.tools;

import datastructure.tools.Pen;
import managers.ColorManager;

public interface PenFactory {
  public Pen createPen(int thickness);
  
  public Pen createPen(ColorManager colorManager);
  
  public Pen createPen(ColorManager colorManager, int thickness);
}
