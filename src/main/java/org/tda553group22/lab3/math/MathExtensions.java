package org.tda553group22.lab3.math;

public final class MathExtensions {
    /**
     * Maps a value from one range to another.
     *
     * @param value The value to map
     * @param fromMin The minimum of the source range
     * @param fromMax The maximum of the source range
     * @param toMin The minimum of the target range
     * @param toMax The maximum of the target range
     * @return The mapped value
     */
    public static double map(
            double value,
            double fromMin,
            double fromMax,
            double toMin,
            double toMax) {
        return toMin + (toMax - toMin) * ((value - fromMin) / (fromMax - fromMin));
    }
}
