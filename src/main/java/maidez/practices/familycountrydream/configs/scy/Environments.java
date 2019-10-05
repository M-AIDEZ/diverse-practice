package maidez.practices.familycountrydream.configs.scy;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.buff.*;
import maidez.practices.familycountrydream.components.Environment;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

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

    public static final Environment 美丽街区 = new Environment("美丽街区",
            Lists.newArrayList(
                    new ParticularBuildingBuff(2, "人才公寓"),
                    new ParticularBuildingBuff(1, "居民楼"),
                    new ParticularBuildingBuff(1, "木屋")
            ));

    public static final Environment 国庆 = new Environment("国庆",
            Lists.newArrayList(
                    new OfferingBuff(0.2),
                    new PlayingStatusBuff(1, PlayingStatusEnum.ONLINE),
                    new PlayingStatusBuff(1, PlayingStatusEnum.OFFLINE)
            ));
}
