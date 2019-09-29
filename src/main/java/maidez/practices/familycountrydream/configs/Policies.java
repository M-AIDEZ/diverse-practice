package maidez.practices.familycountrydream.configs;

import maidez.practices.familycountrydream.Policy;
import maidez.practices.familycountrydream.buff.BuildingTypeBuff;
import maidez.practices.familycountrydream.buff.GlobalBuff;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Policies {
    public static final Policy 一带一路建设 = new Policy("一带一路建设", new GlobalBuff(1));

    public static final Policy 自由贸易区建设 = new Policy("自由贸易区建设", new BuildingTypeBuff(3, BuildingTypeEnum.COMMERCIAL));

    public static final Policy 区域协调发展 = new Policy("区域协调发展", new BuildingTypeBuff(3, BuildingTypeEnum.RESIDENTIAL));

    public static final Policy 全面深化改革 = new Policy("全面深化改革", new GlobalBuff(1.5));
}
