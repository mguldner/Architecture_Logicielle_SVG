package factories.actions;

import datastructure.Path;
import datastructure.Tool;
import datastructure.actions.Draw;

public interface DrawFactory {
  public Draw createDraw(Path path, Tool tool);
}
