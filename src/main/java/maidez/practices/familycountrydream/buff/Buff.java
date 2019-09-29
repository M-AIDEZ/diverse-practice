package maidez.practices.familycountrydream.buff;

import lombok.Getter;
import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public abstract class Buff {
    @Getter
    protected double magnification;

    public Buff(double magnification) {
        this.magnification = magnification;
    }

    public abstract boolean takeEffect(Building building, PlayingStatusEnum playingStatusEnum);
}
