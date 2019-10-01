package maidez.practices.familycountrydream.configs.lwy;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.buff.*;
import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

import java.util.List;

import static maidez.practices.familycountrydream.components.Constants.BILLION;
import static maidez.practices.familycountrydream.components.Constants.MILLION;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Buildings {
    //industrial buildings
    public static final Building.IndustrialBuilding 造纸厂 = new Building.IndustrialBuilding("造纸厂", 155D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "图书城")
    ));

    public static final Building.IndustrialBuilding 食品厂 = new Building.IndustrialBuilding("食品厂", 546D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "菜市场")
    ));

    public static final Building.IndustrialBuilding 纺织厂 = new Building.IndustrialBuilding("纺织厂", 136D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "服装店"),
            new BuildingTypeBuff(0.45, BuildingTypeEnum.COMMERCIAL)
    ));

    public static final Building.IndustrialBuilding 木材厂 = new Building.IndustrialBuilding("木材厂", 155D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "木屋")
    ));

    public static final Building.IndustrialBuilding 电厂 = new Building.IndustrialBuilding("电厂", 161D * MILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.8, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.IndustrialBuilding 钢铁厂 = new Building.IndustrialBuilding("钢铁厂", 38.8D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "钢结构房"),
            new BuildingTypeBuff(0.45, BuildingTypeEnum.INDUSTRIAL)
    ));

    public static final Building.IndustrialBuilding 零件厂 = new Building.IndustrialBuilding("零件厂", 12.9D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "五金店"),
            new ParticularBuildingBuff(1, "企鹅机械")
    ));

    public static final Building.IndustrialBuilding 企鹅机械 = new Building.IndustrialBuilding("企鹅机械", 16.2D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "零件厂"),
            new GlobalBuff(0.1)
    ));

    public static final Building.IndustrialBuilding 水厂 = new Building.IndustrialBuilding("水厂", 48.9D * MILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.2, PlayingStatusEnum.OFFLINE)
    ));


    //commercial buildings

    public static final Building.CommercialBuilding 菜市场 = new Building.CommercialBuilding("菜市场", 546D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "食品厂")
    ));

    public static final Building.CommercialBuilding 五金店 = new Building.CommercialBuilding("五金店", 155D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "零件厂")
    ));

    public static final Building.CommercialBuilding 便利店 = new Building.CommercialBuilding("便利店", 1.95D * BILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "居民楼")
    ));

    public static final Building.CommercialBuilding 服装店 = new Building.CommercialBuilding("服装店", 546D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "纺织厂")
    ));

    public static final Building.CommercialBuilding 图书城 = new Building.CommercialBuilding("图书城", 12.9D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(2, "学校"),
            new ParticularBuildingBuff(2, "造纸厂")
    ));

    public static final Building.CommercialBuilding 学校 = new Building.CommercialBuilding("学校", 38.8D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(3, "图书城")
    ));

    public static final Building.CommercialBuilding 民食斋 = new Building.CommercialBuilding("民食斋", 18.5D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "空中别墅"),
            new PlayingStatusBuff(0.2, PlayingStatusEnum.ONLINE)
    ));

    public static final Building.CommercialBuilding 媒体之声 = new Building.CommercialBuilding("媒体之声", 19.7D * MILLION
            , Lists.newArrayList(
            new GlobalBuff(0.05),
            new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE)
    ));

    public static final Building.CommercialBuilding 商贸中心 = new Building.CommercialBuilding("商贸中心", 12.4D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "花园洋房"),
            new OfferingBuff(0.1)
    ));

    public static final Building.CommercialBuilding 加油站 = new Building.CommercialBuilding("加油站", 27.4D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(0.5, "人民石油"),
            new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE)
    ));

    //residential buildings    

    public static final Building.ResidentialBuilding 居民楼 = new Building.ResidentialBuilding("居民楼", 546D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "便利店")
    ));

    public static final Building.ResidentialBuilding 钢结构房 = new Building.ResidentialBuilding("钢结构房", 546D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "钢铁厂")
    ));

    public static final Building.ResidentialBuilding 木屋 = new Building.ResidentialBuilding("木屋", 155D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(4, "木材厂")
    ));

    public static final Building.ResidentialBuilding 平房 = new Building.ResidentialBuilding("平房", 601D * MILLION
            , Lists.newArrayList(
            new BuildingTypeBuff(0.8, BuildingTypeEnum.RESIDENTIAL)
    ));

    public static final Building.ResidentialBuilding 人才公寓 = new Building.ResidentialBuilding("人才公寓", 18.1D * MILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.4, PlayingStatusEnum.ONLINE),
            new BuildingTypeBuff(0.3, BuildingTypeEnum.INDUSTRIAL)
    ));

    public static final Building.ResidentialBuilding 小型公寓 = new Building.ResidentialBuilding("小型公寓", 45.8D * MILLION
            , Lists.newArrayList(
            new OfferingBuff(0.4)
    ));

    public static final Building.ResidentialBuilding 中式小楼 = new Building.ResidentialBuilding("中式小楼", 17D * MILLION
            , Lists.newArrayList(
            new PlayingStatusBuff(0.2, PlayingStatusEnum.ONLINE),
            new BuildingTypeBuff(0.15, BuildingTypeEnum.RESIDENTIAL)
    ));

    public static final Building.ResidentialBuilding 花园洋房 = new Building.ResidentialBuilding("花园洋房", 6.61D * MILLION
            , Lists.newArrayList(
            new ParticularBuildingBuff(1, "商贸中心"),
            new OfferingBuff(0.1)
    ));

    public static final List<Building> ALL_BUILDINGS = Lists.newArrayList(
            造纸厂, 食品厂, 纺织厂, 木材厂, 电厂, 钢铁厂, 零件厂, 企鹅机械, 水厂,
            菜市场, 五金店, 便利店, 服装店, 学校, 图书城, 民食斋, 媒体之声, 商贸中心, 加油站,
            居民楼, 钢结构房, 木屋, 平房, 人才公寓, 小型公寓, 中式小楼, 花园洋房
    );
}
