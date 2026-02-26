package org.tda553group22.lab3.core;

import org.tda553group22.lab3.math.Vector2;

public interface Workshop<T extends Loadable> extends CanLoadUnordered<T>, PositionFunctions {
    double getRange();

    boolean isWithinRange(Vector2 pos);

    boolean canAccept(Loadable load);
}
