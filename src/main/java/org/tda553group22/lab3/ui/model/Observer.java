package org.tda553group22.lab3.ui.model;

import org.tda553group22.lab3.math.Vector2;

public interface Observer {
    void actOnMove(Vector2 pos, double angle);
}
