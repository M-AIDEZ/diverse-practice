package maidez.practices.familycountrydream.enums;

import lombok.Getter;

/**
 * Created by luwenyi on 2019/9/29.
 */
public enum BuildingTypeEnum {
    INDUSTRIAL("工业"),
    COMMERCIAL("商业"),
    RESIDENTIAL("住宅");

    @Getter
    private String desc;

    BuildingTypeEnum(String desc) {
        this.desc = desc;
    }
}
