package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

public interface Workshop<T extends Loadable> extends CanLoadUnordered<T>, PositionFunctions {
    boolean withinRange(Vector2 pos);

    double getRange();
}
