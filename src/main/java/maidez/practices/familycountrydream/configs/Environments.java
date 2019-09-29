package maidez.practices.familycountrydream.configs;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.components.Environment;
import maidez.practices.familycountrydream.buff.BuildingTypeBuff;
import maidez.practices.familycountrydream.buff.GlobalBuff;
import maidez.practices.familycountrydream.buff.ParticularBuildingBuff;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Environments {
    public static final Environment 家国之光 = new Environment("家国之光",
            Lists.newArrayList(
                    new GlobalBuff(0.45)
            ));

    public static final Environment 和谐家园 = new Environment("和谐家园",
            Lists.newArrayList(
                    new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL),
                    new ParticularBuildingBuff(1,"人才公寓"),
                    new ParticularBuildingBuff(1.5, "小型公寓")
            ));
}
