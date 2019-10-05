package maidez.practices.familycountrydream.buff;

import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class GlobalBuff extends Buff {

    public GlobalBuff(double magnification) {
        super(magnification);
    }

    @Override
    public boolean effectOnBuildings(Building building, PlayingStatusEnum playingStatusEnum) {
        return true;
    }

    @Override
    public boolean effectOnOffer() {
        return false;
    }
}
