package maidez.practices.familycountrydream.configs.lwy;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.buff.*;
import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

import java.util.List;

import static maidez.practices.familycountrydream.components.Constants.AA;
import static maidez.practices.familycountrydream.components.Constants.BILLION;
import static maidez.practices.familycountrydream.components.Constants.MILLION;
import static maidez.practices.familycountrydream.components.Constants.TRILLION;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Buildings {
    //industrial buildings
    public static final Building.IndustrialBuilding 造纸厂 = new Building.IndustrialBuilding("造纸厂", 31.1 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "图书城")
    ));

    public static final Building.IndustrialBuilding 食品厂 = new Building.IndustrialBuilding("食品厂", 127 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "菜市场")
    ));

    public static final Building.IndustrialBuilding 纺织厂 = new Building.IndustrialBuilding("纺织厂", 25.5 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "服装店"),
            new BuildingTypeBuff(0.6, BuildingTypeEnum.COMMERCIAL)
    ));

    public static final Building.IndustrialBuilding 木材厂 = new Building.IndustrialBuilding("木材厂", 31.1 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "木屋")
    ));

    public static final Building.IndustrialBuilding 电厂 = new Building.IndustrialBuilding("电厂", 150 * TRILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(1.4, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.IndustrialBuilding 钢铁厂 = new Building.IndustrialBuilding("钢铁厂", 6.23 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "钢结构房"),
            new BuildingTypeBuff(0.6, BuildingTypeEnum.INDUSTRIAL)
    ));

    public static final Building.IndustrialBuilding 零件厂 = new Building.IndustrialBuilding("零件厂", 1.55 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "五金店"),
            new ParticularBuildingBuff(1.5, "企鹅机械")
    ));

    public static final Building.IndustrialBuilding 企鹅机械 = new Building.IndustrialBuilding("企鹅机械", 691 * BILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "零件厂"),
            new GlobalBuff(0.2)
    ));

    public static final Building.IndustrialBuilding 水厂 = new Building.IndustrialBuilding("水厂", 7.86 * TRILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.25, PlayingStatusEnum.OFFLINE)
    ));

    public static final Building.IndustrialBuilding 人民石油 = new Building.IndustrialBuilding("人民石油", 519 * BILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "加油站"),
            new PlayingStatusBuff(0.2, PlayingStatusEnum.OFFLINE)
    ));


    //commercial buildings

    public static final Building.CommercialBuilding 菜市场 = new Building.CommercialBuilding("菜市场", 34.5 * AA
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "食品厂")
    ));

    public static final Building.CommercialBuilding 五金店 = new Building.CommercialBuilding("五金店", 31.1 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "零件厂")
    ));

    public static final Building.CommercialBuilding 便利店 = new Building.CommercialBuilding("便利店", 127 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "居民楼")
    ));

    public static final Building.CommercialBuilding 服装店 = new Building.CommercialBuilding("服装店", 31.1 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "纺织厂")
    ));

    public static final Building.CommercialBuilding 图书城 = new Building.CommercialBuilding("图书城", 1.55 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "学校"),
            new ParticularBuildingBuff(3, "造纸厂")
    ));

    public static final Building.CommercialBuilding 学校 = new Building.CommercialBuilding("学校", 31.1 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "图书城")
    ));

    public static final Building.CommercialBuilding 民食斋 = new Building.CommercialBuilding("民食斋", 3.23 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "空中别墅"),
            new PlayingStatusBuff(0.4, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.CommercialBuilding 媒体之声 = new Building.CommercialBuilding("媒体之声", 839 * BILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.2, PlayingStatusEnum.OFFLINE),
            new GlobalBuff(0.1)
    ));

    public static final Building.CommercialBuilding 商贸中心 = new Building.CommercialBuilding("商贸中心", 1.59 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "花园洋房"),
            new OfferingBuff(0.3)
    ));

    public static final Building.CommercialBuilding 加油站 = new Building.CommercialBuilding("加油站", 1.87 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(1.5, "人民石油"),
            new PlayingStatusBuff(0.3, PlayingStatusEnum.OFFLINE)
    ));

    //residential buildings    

    public static final Building.ResidentialBuilding 居民楼 = new Building.ResidentialBuilding("居民楼", 127 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "便利店")
    ));

    public static final Building.ResidentialBuilding 钢结构房 = new Building.ResidentialBuilding("钢结构房", 31.1 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "钢铁厂")
    ));

    public static final Building.ResidentialBuilding 木屋 = new Building.ResidentialBuilding("木屋", 63.6 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(5, "木材厂")
    ));

    public static final Building.ResidentialBuilding 平房 = new Building.ResidentialBuilding("平房", 34.3 * TRILLION
            , Lists.newArrayList(
            new BuildingTypeBuff(1, BuildingTypeEnum.RESIDENTIAL)
    ));

    public static final Building.ResidentialBuilding 人才公寓 = new Building.ResidentialBuilding("人才公寓", 8.73 * TRILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.8, PlayingStatusEnum.ONLINE),
            new BuildingTypeBuff(0.6, BuildingTypeEnum.INDUSTRIAL)
    ));

    public static final Building.ResidentialBuilding 小型公寓 = new Building.ResidentialBuilding("小型公寓", 150 * TRILLION
            , Lists.newArrayList(
            new OfferingBuff(0.7)
    ));

    public static final Building.ResidentialBuilding 中式小楼 = new Building.ResidentialBuilding("中式小楼", 2.18 * TRILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.6, PlayingStatusEnum.ONLINE),
            new BuildingTypeBuff(0.45, BuildingTypeEnum.RESIDENTIAL)
    ));

    public static final Building.ResidentialBuilding 花园洋房 = new Building.ResidentialBuilding("花园洋房", 1.59 * TRILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "商贸中心"),
            new OfferingBuff(0.3)
    ));

    public static final Building.ResidentialBuilding 空中别墅 = new Building.ResidentialBuilding("空中别墅", 790 * BILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "民食斋"),
            new PlayingStatusBuff(0.4, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.ResidentialBuilding 复兴公馆 = new Building.ResidentialBuilding("复兴公馆", 434 * BILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE),
            new OfferingBuff(0.1)
    ));

    public static final List<Building> ALL_BUILDINGS = Lists.newArrayList(
            造纸厂, 食品厂, 纺织厂, 木材厂, 电厂, 钢铁厂, 零件厂, 企鹅机械, 水厂, 人民石油,
            菜市场, 五金店, 便利店, 服装店, 学校, 图书城, 民食斋, 媒体之声, 商贸中心, 加油站,
            居民楼, 钢结构房, 木屋, 平房, 人才公寓, 小型公寓, 中式小楼, 花园洋房, 空中别墅, 复兴公馆
    );
}
