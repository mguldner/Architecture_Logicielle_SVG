package factories.operators;

import datastructure.Drawing;
import datastructure.operators.Loop;

public interface LoopFactory<T> {
  public Loop<T> createLoop(Drawing<T>[] drawings, int numberIterations, String change,
                         Object[] changeParams);
}
