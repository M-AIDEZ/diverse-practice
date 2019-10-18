package maidez.practices.familycountrydream.configs.lwy;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.buff.BuildingTypeBuff;
import maidez.practices.familycountrydream.buff.GlobalBuff;
import maidez.practices.familycountrydream.buff.OfferingBuff;
import maidez.practices.familycountrydream.buff.PlayingStatusBuff;
import maidez.practices.familycountrydream.components.Policy;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

import java.util.List;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Policies {
    private static final Policy 家国之光 = new Policy("家国之光", new GlobalBuff(0.15));

    private static final Policy 一带一路建设 = new Policy("一带一路建设", new GlobalBuff(1));
    private static final Policy 自由贸易区建设 = new Policy("自由贸易区建设", new BuildingTypeBuff(3, BuildingTypeEnum.COMMERCIAL));
    private static final Policy 区域协调发展 = new Policy("区域协调发展", new BuildingTypeBuff(3, BuildingTypeEnum.RESIDENTIAL));

    private static final Policy 全面深化改革 = new Policy("全面深化改革", new GlobalBuff(2));
    private static final Policy 全面依法治国 = new Policy("全面依法治国", new PlayingStatusBuff(2, PlayingStatusEnum.ONLINE));
    private static final Policy 创新驱动 = new Policy("创新驱动", new BuildingTypeBuff(6, BuildingTypeEnum.INDUSTRIAL));
    private static final Policy 科教兴国 = new Policy("科教兴国", new PlayingStatusBuff(1.5, PlayingStatusEnum.OFFLINE));

    private static final Policy 制造强国 = new Policy("制造强国", new BuildingTypeBuff(12, BuildingTypeEnum.INDUSTRIAL));
    private static final Policy 优化营商环境 = new Policy("优化营商环境", new OfferingBuff(0.3));
    private static final Policy 减税降费 = new Policy("减税降费", new GlobalBuff(4));
    private static final Policy 普惠金融 = new Policy("普惠金融", new GlobalBuff(12));

    private static final Policy 新型城镇化 = new Policy("新型城镇化", new BuildingTypeBuff(24, BuildingTypeEnum.RESIDENTIAL));
    private static final Policy 乡村振兴 = new Policy("乡村振兴", new PlayingStatusBuff(8, PlayingStatusEnum.ONLINE));
    private static final Policy 精准扶贫 = new Policy("精准扶贫", new PlayingStatusBuff(8, PlayingStatusEnum.OFFLINE));
    private static final Policy 新一代人工智能 = new Policy("新一代人工智能", new GlobalBuff(8));

    private static final Policy 拍蝇打虎猎狐 = new Policy("拍蝇打虎猎狐", new PlayingStatusBuff(12, PlayingStatusEnum.OFFLINE));
    private static final Policy 蓝天保卫战 = new Policy("蓝天保卫战", new BuildingTypeBuff(9, BuildingTypeEnum.INDUSTRIAL));


    public static final List<Policy> ALL_POLICIES = Lists.newArrayList(
            家国之光,
            一带一路建设, 自由贸易区建设, 区域协调发展,
            全面深化改革, 创新驱动, 全面依法治国, 科教兴国,
            制造强国, 优化营商环境, 减税降费, 普惠金融,
            新型城镇化, 乡村振兴, 精准扶贫, 新一代人工智能,
            拍蝇打虎猎狐, 蓝天保卫战);
}
