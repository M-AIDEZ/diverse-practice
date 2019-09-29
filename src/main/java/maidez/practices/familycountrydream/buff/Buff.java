package maidez.practices.familycountrydream.buff;

import maidez.practices.familycountrydream.Building;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public abstract class Buff {
    protected double magnification;

    public Buff(double magnification) {
        this.magnification = magnification;
    }

    public void buff(Building building, PlayingStatusEnum playingStatusEnum) {
        if (takeEffect(building, playingStatusEnum)) {
            building.setIncome(building.getIncome() * magnification);
        }
    }

    public abstract boolean takeEffect(Building building, PlayingStatusEnum playingStatusEnum);
}
