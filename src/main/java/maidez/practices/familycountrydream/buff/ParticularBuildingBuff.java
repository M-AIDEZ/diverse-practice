package maidez.practices.familycountrydream.buff;

import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class ParticularBuildingBuff extends Buff {
    private String targetBuildingName;

    public ParticularBuildingBuff(double magnification, String targetBuildingName) {
        super(magnification);
        this.targetBuildingName = targetBuildingName;
    }

    @Override
    public boolean effectOnBuildings(Building building, PlayingStatusEnum playingStatusEnum) {
        return targetBuildingName.equals(building.getName());
    }

    @Override
    public boolean effectOnOffer() {
        return false;
    }
}
