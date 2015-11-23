package factories.operators;

import java.util.HashMap;

import datastructure.Drawing;
import datastructure.operators.Loop;

public interface LoopFactory {
  public Loop createLoop(Drawing drawings, int numberIterations,
                         HashMap<String, Double[]> changeParams);
}
