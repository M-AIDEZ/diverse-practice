package maidez.practices.familycountrydream.buff;

import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class OfferingBuff extends Buff {

    public OfferingBuff(double magnification) {
        super(magnification);
    }

    @Override
    public boolean effectOnBuildings(Building building, PlayingStatusEnum playingStatusEnum) {
        return false;
    }

    @Override
    public boolean effectOnOffer() {
        return true;
    }
}
