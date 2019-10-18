package maidez.practices.familycountrydream.configs.lwy;

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
                    new ParticularBuildingBuff(2, "花园洋房"),
                    new ParticularBuildingBuff(1, "钢结构房"),
                    new ParticularBuildingBuff(1, "平房")
            ));

    public static final Environment 营商环境 = new Environment("营商环境",
            Lists.newArrayList(
                    new OfferingBuff(0.2),
                    new ParticularBuildingBuff(1, "木材厂"),
                    new ParticularBuildingBuff(1, "便利店")
            ));

    public static final Environment 头雁效应 = new Environment("头雁效应",
            Lists.newArrayList(
                    new ParticularBuildingBuff(1, "民食斋"),
                    new ParticularBuildingBuff(2, "企鹅机械")
            ));

    public static final Environment 四好农村路 = new Environment("四好农村路",
            Lists.newArrayList(
                    new ParticularBuildingBuff(1, "加油站"),
                    new ParticularBuildingBuff(2, "菜市场"),
                    new ParticularBuildingBuff(1, "平房")
            ));

    public static final Environment 国庆 = new Environment("国庆",
            Lists.newArrayList(
                    new OfferingBuff(0.2),
                    new PlayingStatusBuff(1, PlayingStatusEnum.ONLINE),
                    new PlayingStatusBuff(1, PlayingStatusEnum.OFFLINE)
            ));

    public static final Environment 电子商务 = new Environment("电子商务",
            Lists.newArrayList(
                    new ParticularBuildingBuff(1.5, "纺织厂"),
                    new ParticularBuildingBuff(1, "服装店"),
                    new ParticularBuildingBuff(1, "便利店")
            ));

    public static final Environment 市民文化节 = new Environment("市民文化节",
            Lists.newArrayList(
                    new ParticularBuildingBuff(2, "图书馆"),
                    new PlayingStatusBuff(0.2, PlayingStatusEnum.ONLINE)
            ));

    public static final Environment 家电下乡 = new Environment("家电下乡",
            Lists.newArrayList(
                    new ParticularBuildingBuff(1, "商贸中心"),
                    new ParticularBuildingBuff(2, "零件厂"),
                    new ParticularBuildingBuff(1, "五金店")
            ));

    public static final Environment 扶贫攻坚 = new Environment("扶贫攻坚",
            Lists.newArrayList(
                    new ParticularBuildingBuff(1.5, "木屋"),
                    new ParticularBuildingBuff(1.5, "平房"),
                    new ParticularBuildingBuff(1, "小型公寓")
            ));

    public static final Environment 文化蓝图 = new Environment("文化蓝图",
            Lists.newArrayList(
                    new ParticularBuildingBuff(2, "空中别墅"),
                    new PlayingStatusBuff(0.2, PlayingStatusEnum.ONLINE)
            ));

    public static final Environment 护校安园 = new Environment("护校安园",
            Lists.newArrayList(
                    new ParticularBuildingBuff(2, "学校"),
                    new ParticularBuildingBuff(2, "木屋")
            ));

    public static final Environment 家电下乡2 = new Environment("家电下乡2",
            Lists.newArrayList(
                    new ParticularBuildingBuff(2, "零件厂"),
                    new ParticularBuildingBuff(1, "五金店"),
                    new ParticularBuildingBuff(1, "电厂")
            ));

    public static final Environment 服务示范区 = new Environment("服务示范区",
            Lists.newArrayList(
                    new ParticularBuildingBuff(1.5, "便利店"),
                    new ParticularBuildingBuff(1.5, "菜市场")
            ));
}
