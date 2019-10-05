package maidez.practices.familycountrydream.configs.lwy;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.buff.BuildingTypeBuff;
import maidez.practices.familycountrydream.buff.GlobalBuff;
import maidez.practices.familycountrydream.buff.OfferingBuff;
import maidez.practices.familycountrydream.buff.PlayingStatusBuff;
import maidez.practices.familycountrydream.components.Card;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

import java.util.List;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Cards {
    //    //上海
//    private static final Card 中共一大会址 = new Card("中共一大会址", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
//    private static final Card 城隍庙豫园 = new Card("城隍庙豫园", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
//    private static final Card 东方明珠电视塔 = new Card("东方明珠电视塔", new GlobalBuff(0.1));
//    private static final Card 世博会中国馆 = new Card("世博会中国馆", new PlayingStatusBuff(0.1, PlayingStatusEnum.ONLINE));
//    private static final Card 外滩 = new Card("外滩", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
//    private static final Card 浦东新区自贸区 = new Card("浦东新区自贸区", new BuildingTypeBuff(0.3, BuildingTypeEnum.INDUSTRIAL));
//    private static final Card 中国国际进口博览会 = new Card("中国国际进口博览会", new OfferingBuff(0.02));
//    private static final Card 上海美术电影制片厂 = new Card("上海美术电影制片厂", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
//    private static final Card 石库门 = new Card("石库门", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
//    private static final Card 本帮菜 = new Card("本帮菜", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
//    //江苏
//    private static final Card 太湖 = new Card("太湖", new PlayingStatusBuff(0.1, PlayingStatusEnum.ONLINE));
//    private static final Card 昆曲 = new Card("昆曲", new PlayingStatusBuff(0.1, PlayingStatusEnum.ONLINE));
//    private static final Card 江南园林 = new Card("江南园林", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
//    private static final Card 大闸蟹 = new Card("大闸蟹", new OfferingBuff(0.02));
//    private static final Card 南京长江大桥 = new Card("南京长江大桥", new GlobalBuff(0.1));
//    private static final Card 花果山 = new Card("花果山", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
//    private static final Card 华西村 = new Card("华西村", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
//    private static final Card 淮扬菜 = new Card("淮扬菜", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
//    private static final Card 宜兴紫砂壶 = new Card("宜兴紫砂壶", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
//    private static final Card 雨花台 = new Card("雨花台", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
//    //浙江
//    private static final Card 西湖 = new Card("西湖", new GlobalBuff(0.1));
//    private static final Card 绿水青山就是金山银山的理念 = new Card("绿水青山就是金山银山的理念", new GlobalBuff(0.1));
//    private static final Card 越剧 = new Card("越剧", new PlayingStatusBuff(0.1, PlayingStatusEnum.ONLINE));
//    private static final Card 世界互联网大会 = new Card("世界互联网大会", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
//    private static final Card 义乌小商品 = new Card("义乌小商品", new BuildingTypeBuff(0.3, BuildingTypeEnum.COMMERCIAL));
//    private static final Card 普陀山 = new Card("普陀山", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
//    private static final Card 嘉兴南湖红船 = new Card("嘉兴南湖红船", new PlayingStatusBuff(0.1, PlayingStatusEnum.OFFLINE));
//    private static final Card 杭州湾跨海大桥 = new Card("杭州湾跨海大桥", new OfferingBuff(0.02));
//    private static final Card 宁波舟山港 = new Card("宁波舟山港", new BuildingTypeBuff(0.3, BuildingTypeEnum.INDUSTRIAL));
//    private static final Card 浙菜 = new Card("浙菜", new BuildingTypeBuff(0.3, BuildingTypeEnum.RESIDENTIAL));
//    //中国
//    private static final Card 中国制造 = new Card("中国制造", new BuildingTypeBuff(0.6, BuildingTypeEnum.INDUSTRIAL));
//
//
//    public static final List<Card> ALL_CARDS = Lists.newArrayList(
//            中共一大会址, 城隍庙豫园, 东方明珠电视塔, 世博会中国馆, 外滩, 浦东新区自贸区, 中国国际进口博览会, 上海美术电影制片厂, 石库门, 本帮菜,
//            太湖, 昆曲, 江南园林, 大闸蟹, 南京长江大桥, 花果山, 华西村, 淮扬菜, 宜兴紫砂壶, 雨花台,
//            西湖, 绿水青山就是金山银山的理念, 越剧, 义乌小商品, 世界互联网大会, 普陀山, 嘉兴南湖红船, 杭州湾跨海大桥, 宁波舟山港, 浙菜,
//            中国制造
//    );

    private static final Card 所有 = new Card("所有", new GlobalBuff(1.6));
    private static final Card 供货 = new Card("供货", new OfferingBuff(0.18));
    private static final Card 在线 = new Card("在线", new PlayingStatusBuff(1.2, PlayingStatusEnum.ONLINE));
    private static final Card 离线 = new Card("离线", new PlayingStatusBuff(1.4, PlayingStatusEnum.ONLINE));
    private static final Card 住宅 = new Card("住宅", new BuildingTypeBuff(2.4, BuildingTypeEnum.RESIDENTIAL));
    private static final Card 商业 = new Card("商业", new BuildingTypeBuff(2.4, BuildingTypeEnum.COMMERCIAL));
    private static final Card 工业 = new Card("工业", new BuildingTypeBuff(2.7, BuildingTypeEnum.INDUSTRIAL));

    public static final List<Card> ALL_CARDS = Lists.newArrayList(
            所有, 供货, 在线, 离线, 住宅, 商业, 工业
    );
}
