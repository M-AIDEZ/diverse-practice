package maidez.practices.familycountrydream.configs;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.buff.BuildingTypeBuff;
import maidez.practices.familycountrydream.buff.GlobalBuff;
import maidez.practices.familycountrydream.components.Policy;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;

import java.util.List;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Policies {
    private static final Policy 一带一路建设 = new Policy("一带一路建设", new GlobalBuff(1));

    private static final Policy 自由贸易区建设 = new Policy("自由贸易区建设", new BuildingTypeBuff(3, BuildingTypeEnum.COMMERCIAL));

    private static final Policy 区域协调发展 = new Policy("区域协调发展", new BuildingTypeBuff(3, BuildingTypeEnum.RESIDENTIAL));

    private static final Policy 全面深化改革 = new Policy("全面深化改革", new GlobalBuff(2));

    private static final Policy 创新驱动 = new Policy("创新驱动", new BuildingTypeBuff(1.5, BuildingTypeEnum.INDUSTRIAL));

    private static final Policy 家国之光 = new Policy("家国之光", new GlobalBuff(0.45));

    public static final List<Policy> ALL_POLICIES = Lists.newArrayList(一带一路建设, 自由贸易区建设, 区域协调发展, 全面深化改革, 家国之光, 创新驱动);
}
