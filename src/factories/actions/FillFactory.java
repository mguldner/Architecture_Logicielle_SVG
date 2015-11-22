package factories.actions;

import datastructure.Path;
import datastructure.Tool;
import datastructure.actions.Fill;
import managers.ColorManager;

public interface FillFactory {
  public Fill createFill(Path path, ColorManager color);
  public Fill createFill(Path path);
}
