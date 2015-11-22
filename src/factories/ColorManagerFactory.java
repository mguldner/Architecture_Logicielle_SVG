package factories;

import managers.ColorManager;

public interface ColorManagerFactory {
  public ColorManager createColorManager(String colorType, Object color);
}
