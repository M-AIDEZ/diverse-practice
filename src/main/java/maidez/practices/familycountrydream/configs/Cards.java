package maidez.practices.familycountrydream.configs;

import maidez.practices.familycountrydream.Card;
import maidez.practices.familycountrydream.buff.BuildingTypeBuff;
import maidez.practices.familycountrydream.buff.GlobalBuff;
import maidez.practices.familycountrydream.buff.OfferingBuff;
import maidez.practices.familycountrydream.buff.PlayingStatusBuff;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Cards {
    //上海
    public static final Card 中共一大会址 = new Card("中共一大会址", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
    public static final Card 城隍庙豫园 = new Card("城隍庙豫园", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
    public static final Card 东方明珠电视塔 = new Card("东方明珠电视塔", new GlobalBuff(0.1));
    public static final Card 世博会中国馆 = new Card("世博会中国馆", new PlayingStatusBuff(0.1, PlayingStatusEnum.ONLINE));
    public static final Card 外滩 = new Card("外滩", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
    public static final Card 浦东新区自贸区 = new Card("浦东新区自贸区", new BuildingTypeBuff(0.3, BuildingTypeEnum.INDUSTRIAL));
    public static final Card 中国国际进口博览会 = new Card("中国国际进口博览会", new OfferingBuff(0.02));
    public static final Card 上海美术电影制片厂 = new Card("上海美术电影制片厂", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
    public static final Card 石库门 = new Card("石库门", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
    public static final Card 本帮菜 = new Card("本帮菜", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
    //江苏
    public static final Card 太湖 = new Card("太湖", new PlayingStatusBuff(0.1, PlayingStatusEnum.ONLINE));
    public static final Card 昆曲 = new Card("昆曲", new PlayingStatusBuff(0.1, PlayingStatusEnum.ONLINE));
    public static final Card 江南园林 = new Card("江南园林", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
    public static final Card 大闸蟹 = new Card("大闸蟹", new OfferingBuff(0.02));
    public static final Card 南京长江大桥 = new Card("南京长江大桥", new GlobalBuff(0.1));
    public static final Card 花果山 = new Card("花果山", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
    public static final Card 华西村 = new Card("华西村", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
    public static final Card 淮扬菜 = new Card("淮扬菜", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
    public static final Card 宜兴紫砂壶 = new Card("宜兴紫砂壶", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
    public static final Card 雨花台 = new Card("雨花台", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
    //浙江
    public static final Card 西湖 = new Card("西湖", new GlobalBuff(0.1));
    public static final Card 绿水青山就是金山银山的理念 = new Card("绿水青山就是金山银山的理念", new GlobalBuff(0.1));
    public static final Card 越剧 = new Card("越剧", new PlayingStatusBuff(0.1, PlayingStatusEnum.ONLINE));
    public static final Card 世界互联网大会 = new Card("世界互联网大会", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
    public static final Card 义乌小商品 = new Card("义乌小商品", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
    public static final Card 普陀山 = new Card("普陀山", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
    public static final Card 嘉兴南湖红船 = new Card("嘉兴南湖红船", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
    public static final Card 杭州湾跨海大桥 = new Card("杭州湾跨海大桥", new OfferingBuff(0.02));
    public static final Card 宁波舟山港 = new Card("宁波舟山港", new BuildingTypeBuff(0.3, BuildingTypeEnum.INDUSTRIAL));
    public static final Card 浙菜 = new Card("浙菜", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
}
