package maidez.practices.familycountrydream.configs.scy;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.buff.*;
import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

import java.util.List;

import static maidez.practices.familycountrydream.components.Constants.KILO;
import static maidez.practices.familycountrydream.components.Constants.MILLION;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Buildings {
    //industrial buildings
    public static final Building.IndustrialBuilding 造纸厂 = new Building.IndustrialBuilding("造纸厂", 59.9D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "图书城")
    ));

    public static final Building.IndustrialBuilding 食品厂 = new Building.IndustrialBuilding("食品厂", 316D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "菜市场")
    ));

    public static final Building.IndustrialBuilding 纺织厂 = new Building.IndustrialBuilding("纺织厂", 10.5D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "服装店"),
            new BuildingTypeBuff(0.30, BuildingTypeEnum.COMMERCIAL)
    ));

    public static final Building.IndustrialBuilding 木材厂 = new Building.IndustrialBuilding("木材厂", 357D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "木屋")
    ));

    public static final Building.IndustrialBuilding 电厂 = new Building.IndustrialBuilding("电厂", 63.3D * KILO
            , Lists.newArrayList(
            new PlayingStatusBuff(0.8, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.IndustrialBuilding 钢铁厂 = new Building.IndustrialBuilding("钢铁厂", 186D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "钢结构房"),
            new BuildingTypeBuff(0.3, BuildingTypeEnum.INDUSTRIAL)
    ));

    public static final Building.IndustrialBuilding 零件厂 = new Building.IndustrialBuilding("零件厂", 9.16D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "五金店"),
            new ParticularBuildingBuff(0.5, "企鹅机械")
    ));

    public static final Building.IndustrialBuilding 企鹅机械 = new Building.IndustrialBuilding("企鹅机械", 13D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "零件厂"),
            new GlobalBuff(0.1)
    ));

    public static final Building.IndustrialBuilding 水厂 = new Building.IndustrialBuilding("水厂", 11.5D * KILO
            , Lists.newArrayList(
            new PlayingStatusBuff(0.10, PlayingStatusEnum.OFFLINE)
    ));


    //commercial buildings

    public static final Building.CommercialBuilding 菜市场 = new Building.CommercialBuilding("菜市场", 559D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "食品厂")
    ));

    public static final Building.CommercialBuilding 五金店 = new Building.CommercialBuilding("五金店", 65.9D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "零件厂")
    ));

    public static final Building.CommercialBuilding 便利店 = new Building.CommercialBuilding("便利店", 349D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "居民楼")
    ));

    public static final Building.CommercialBuilding 服装店 = new Building.CommercialBuilding("服装店", 65.9D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "纺织厂")
    ));

    public static final Building.CommercialBuilding 图书城 = new Building.CommercialBuilding("图书城", 5.68D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "学校"),
            new ParticularBuildingBuff(1, "造纸厂")
    ));

    public static final Building.CommercialBuilding 学校 = new Building.CommercialBuilding("学校", 18.3D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "图书城")
    ));

    public static final Building.CommercialBuilding 民食斋 = new Building.CommercialBuilding("民食斋", 156D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "空中别墅"),
            new PlayingStatusBuff(0.4, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.CommercialBuilding 媒体之声 = new Building.CommercialBuilding("媒体之声", 3.03 * MILLION
            , Lists.newArrayList(
            new GlobalBuff(0.05),
            new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE)
    ));

    public static final Building.CommercialBuilding 商贸中心 = new Building.CommercialBuilding("商贸中心", 1.91D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "花园洋房"),
            new OfferingBuff(0.1)
    ));

    public static final Building.CommercialBuilding 加油站 = new Building.CommercialBuilding("加油站", 1.23D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(0.5, "人民石油"),
            new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE)
    ));

    //residential buildings    

    public static final Building.ResidentialBuilding 居民楼 = new Building.ResidentialBuilding("居民楼", 1D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "便利店")
    ));

    public static final Building.ResidentialBuilding 钢结构房 = new Building.ResidentialBuilding("钢结构房", 559D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "钢铁厂")
    ));

    public static final Building.ResidentialBuilding 木屋 = new Building.ResidentialBuilding("木屋", 14.4D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "木材厂")
    ));

    public static final Building.ResidentialBuilding 平房 = new Building.ResidentialBuilding("平房", 199D * KILO
            , Lists.newArrayList(
            new BuildingTypeBuff(0.6, BuildingTypeEnum.RESIDENTIAL)
    ));

    public static final Building.ResidentialBuilding 人才公寓 = new Building.ResidentialBuilding("人才公寓", 9.28D * KILO
            , Lists.newArrayList(
            new PlayingStatusBuff(0.2, PlayingStatusEnum.ONLINE),
            new BuildingTypeBuff(0.15, BuildingTypeEnum.INDUSTRIAL)
    ));

    public static final Building.ResidentialBuilding 小型公寓 = new Building.ResidentialBuilding("小型公寓", 1.3D * MILLION
            , Lists.newArrayList(
            new OfferingBuff(0.4)
    ));

    public static final Building.ResidentialBuilding 中式小楼 = new Building.ResidentialBuilding("中式小楼", 7.59D * KILO
            , Lists.newArrayList(
            new PlayingStatusBuff(0.2, PlayingStatusEnum.ONLINE),
            new BuildingTypeBuff(0.15, BuildingTypeEnum.RESIDENTIAL)
    ));

    public static final Building.ResidentialBuilding 花园洋房 = new Building.ResidentialBuilding("花园洋房", 1.04D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "商贸中心"),
            new OfferingBuff(0.1)
    ));

    public static final List<Building> ALL_BUILDINGS = Lists.newArrayList(
            造纸厂, 食品厂, 纺织厂, 木材厂, 电厂, 钢铁厂, 零件厂, 企鹅机械, 水厂,
            菜市场, 五金店, 便利店, 服装店, 学校, 图书城, 民食斋,
            居民楼, 钢结构房, 木屋, 平房, 人才公寓, 中式小楼
    );
}
