package factories.operators;

import datastructure.Drawing;
import datastructure.operators.Alternative;

public interface AlternativeFactory {
  public Alternative createAlternative(Drawing[] drawings, boolean firstWanted);
}
