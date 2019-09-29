package maidez.practices.familycountrydream.buff;

import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public abstract class Buff {
    protected double magnification;

    public Buff(double magnification) {
        this.magnification = magnification;
    }

    public double buff(double coefficient, Building building, PlayingStatusEnum playingStatusEnum) {
        if (takeEffect(building, playingStatusEnum)) {
            return coefficient * (1D + magnification);
        }
        return coefficient;
    }

    public abstract boolean takeEffect(Building building, PlayingStatusEnum playingStatusEnum);
}
