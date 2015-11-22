package factories.operators;

import datastructure.Drawing;
import datastructure.operators.Loop;

public interface LoopFactory {
  public Loop createLoop(Drawing[] drawings, int numberIterations, String change,
                         Object[] changeParams);
}
