package maidez.practices.familycountrydream.configs;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.buff.BuildingTypeBuff;
import maidez.practices.familycountrydream.buff.GlobalBuff;
import maidez.practices.familycountrydream.buff.ParticularBuildingBuff;
import maidez.practices.familycountrydream.components.Environment;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Environments {

    public static final Environment 和谐家园 = new Environment("和谐家园",
            Lists.newArrayList(
                    new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL),
                    new ParticularBuildingBuff(1, "人才公寓"),
                    new ParticularBuildingBuff(1.5, "小型公寓")
            ));

    public static final Environment 保税商圈 = new Environment("保税商圈",
            Lists.newArrayList(
                    new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL),
                    new ParticularBuildingBuff(1, "商贸中心"),
                    new ParticularBuildingBuff(1.5, "五金店")
            ));

    public static final Environment 工业综合体 = new Environment("工业综合体",
            Lists.newArrayList(
                    new BuildingTypeBuff(0.3, BuildingTypeEnum.INDUSTRIAL),
                    new ParticularBuildingBuff(1, "企鹅机械")
            ));


    public static final Environment 文明城市 = new Environment("文明城市",
            Lists.newArrayList(
                    new GlobalBuff(0.2),
                    new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL)
            ));
}
