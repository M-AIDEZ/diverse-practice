package maidez.practices.familycountrydream;

import lombok.AllArgsConstructor;
import lombok.Data;
import maidez.practices.familycountrydream.buff.Buff;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;

import java.util.List;

/**
 * Created by luwenyi on 2019/9/29.
 */
@Data
@AllArgsConstructor
public abstract class Building {
    private String name;

    private double income;

    private List<Buff> buffs;

    public abstract BuildingTypeEnum getBuildingTypeEnum();

    public static class IndustrialBuilding extends Building {
        public IndustrialBuilding(String name, double income, List<Buff> buffs) {
            super(name, income, buffs);
        }

        @Override
        public BuildingTypeEnum getBuildingTypeEnum() {
            return BuildingTypeEnum.INDUSTRIAL;
        }
    }

    public static class CommercialBuilding extends Building {
        public CommercialBuilding(String name, double income, List<Buff> buffs) {
            super(name, income, buffs);
        }

        @Override
        public BuildingTypeEnum getBuildingTypeEnum() {
            return BuildingTypeEnum.COMMERCIAL;
        }
    }

    public static class ResidentialBuilding extends Building {
        public ResidentialBuilding(String name, double income, List<Buff> buffs) {
            super(name, income, buffs);
        }

        @Override
        public BuildingTypeEnum getBuildingTypeEnum() {
            return BuildingTypeEnum.RESIDENTIAL;
        }
    }

}
