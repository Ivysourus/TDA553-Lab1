package org.tda553group22.lab3.ui;

import org.tda553group22.lab3.main.PositionFunctions;

public interface GameObject<T> extends HasSprite, PositionFunctions {
    T getInner();
}
