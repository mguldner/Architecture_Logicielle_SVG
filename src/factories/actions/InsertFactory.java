package factories.actions;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.actions.Insert;

public interface InsertFactory {
  public Insert createInsert(Drawing drawing, Path[] paths);
}
