package maidez.practices.familycountrydream.buff;

import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class BuildingTypeBuff extends Buff {
    private BuildingTypeEnum buildingTypeEnum;

    public BuildingTypeBuff(double magnification, BuildingTypeEnum buildingTypeEnum) {
        super(magnification);
        this.buildingTypeEnum = buildingTypeEnum;
    }

    @Override
    public boolean takeEffect(Building building, PlayingStatusEnum playingStatusEnum) {
        return buildingTypeEnum == building.getBuildingTypeEnum();
    }
}
