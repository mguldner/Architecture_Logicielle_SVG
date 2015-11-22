package factories.operators;

import datastructure.Drawing;
import datastructure.operators.Sequence;

public interface SequenceFactory {
  public Sequence createSequence(Drawing[] drawings);
}
