package maidez.practices.familycountrydream.configs;

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
    public static final Building.IndustrialBuilding 造纸厂 = new Building.IndustrialBuilding("造纸厂", 13.3D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "图书城")
    ));

    public static final Building.IndustrialBuilding 食品厂 = new Building.IndustrialBuilding("食品厂", 6.15D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "菜市场")
    ));

    public static final Building.IndustrialBuilding 纺织厂 = new Building.IndustrialBuilding("纺织厂", 3.32D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "服装店"),
            new BuildingTypeBuff(0.45, BuildingTypeEnum.COMMERCIAL)
    ));

    public static final Building.IndustrialBuilding 木材厂 = new Building.IndustrialBuilding("木材厂", 6.15D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "木屋")
    ));

    public static final Building.IndustrialBuilding 电厂 = new Building.IndustrialBuilding("电厂", 7.26D * MILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.5, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.IndustrialBuilding 钢铁厂 = new Building.IndustrialBuilding("钢铁厂", 1.1D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "钢结构房"),
            new BuildingTypeBuff(0.3, BuildingTypeEnum.INDUSTRIAL)
    ));

    public static final Building.IndustrialBuilding 零件厂 = new Building.IndustrialBuilding("零件厂", 1.1D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "五金店"),
            new ParticularBuildingBuff(1, "企鹅机械")
    ));

    public static final Building.IndustrialBuilding 企鹅机械 = new Building.IndustrialBuilding("企鹅机械", 737D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "零件厂"),
            new GlobalBuff(0.1)
    ));

    public static final Building.IndustrialBuilding 水厂 = new Building.IndustrialBuilding("水厂", 1.39D * MILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE)
    ));


    //commercial buildings

    public static final Building.CommercialBuilding 菜市场 = new Building.CommercialBuilding("菜市场", 155D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "食品厂")
    ));

    public static final Building.CommercialBuilding 五金店 = new Building.CommercialBuilding("五金店", 24.6D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "零件厂")
    ));

    public static final Building.CommercialBuilding 便利店 = new Building.CommercialBuilding("便利店", 45D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "居民楼")
    ));

    public static final Building.CommercialBuilding 服装店 = new Building.CommercialBuilding("服装店", 3.32D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "纺织厂")
    ));

    public static final Building.CommercialBuilding 图书城 = new Building.CommercialBuilding("图书城", 1.1D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "学校"),
            new ParticularBuildingBuff(2, "造纸厂")
    ));

    public static final Building.CommercialBuilding 学校 = new Building.CommercialBuilding("学校", 3.32D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "图书城")
    ));

    public static final Building.CommercialBuilding 民食斋 = new Building.CommercialBuilding("民食斋", 843D * KILO
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "空中别墅"),
            new PlayingStatusBuff(0.2, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.CommercialBuilding 媒体之声 = new Building.CommercialBuilding("媒体之声", 896D * KILO
            , Lists.newArrayList(
            new GlobalBuff(0.05),
            new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE)
    ));

    //residential buildings    

    public static final Building.ResidentialBuilding 居民楼 = new Building.ResidentialBuilding("居民楼", 24.6D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "便利店")
    ));

    public static final Building.ResidentialBuilding 钢结构房 = new Building.ResidentialBuilding("钢结构房", 13.3D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "钢铁厂")
    ));

    public static final Building.ResidentialBuilding 木屋 = new Building.ResidentialBuilding("木屋", 24.6D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "木材厂")
    ));

    public static final Building.ResidentialBuilding 平房 = new Building.ResidentialBuilding("平房", 14.6D * MILLION
            , Lists.newArrayList(
            new BuildingTypeBuff(0.6, BuildingTypeEnum.RESIDENTIAL)
    ));

    public static final Building.ResidentialBuilding 人才公寓 = new Building.ResidentialBuilding("人才公寓", 2.87D * MILLION
            , Lists.newArrayList(
            new BuildingTypeBuff(0.3, BuildingTypeEnum.INDUSTRIAL),
            new PlayingStatusBuff(0.4, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.ResidentialBuilding 小型公寓 = new Building.ResidentialBuilding("小型公寓", 1.3D * MILLION
            , Lists.newArrayList(
            new OfferingBuff(0.25)
    ));

    public static final Building.ResidentialBuilding 中式小楼 = new Building.ResidentialBuilding("中式小楼", 1.43D * MILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.2, PlayingStatusEnum.ONLINE),
            new BuildingTypeBuff(0.15, BuildingTypeEnum.RESIDENTIAL)
    ));

    public static final List<Building> ALL_BUILDINGS = Lists.newArrayList(
            造纸厂, 食品厂, 纺织厂, 木材厂, 电厂, 钢铁厂, 零件厂, 企鹅机械, 水厂,
            菜市场, 五金店, 便利店, 服装店, 学校, 图书城, 民食斋, 媒体之声,
            居民楼, 钢结构房, 木屋, 平房, 人才公寓, 小型公寓, 中式小楼
    );
}
