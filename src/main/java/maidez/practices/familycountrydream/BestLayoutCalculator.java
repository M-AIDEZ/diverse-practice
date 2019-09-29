package maidez.practices.familycountrydream;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.components.Environment;
import maidez.practices.familycountrydream.configs.Buildings;
import maidez.practices.familycountrydream.configs.Cards;
import maidez.practices.familycountrydream.configs.Environments;
import maidez.practices.familycountrydream.configs.Policies;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;
import maidez.practices.familycountrydream.utils.NumberUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by luwenyi on 2019/9/29.
 */
public class BestLayoutCalculator {

    public static void main(String[] args) {
        List<Building.IndustrialBuilding> industrialBuildings = Buildings.ALL_BUILDINGS.stream()
                .filter(building -> building instanceof Building.IndustrialBuilding)
                .map(building -> (Building.IndustrialBuilding) building)
                .collect(Collectors.toList());

        List<Building.CommercialBuilding> commercialBuildings = Buildings.ALL_BUILDINGS.stream()
                .filter(building -> building instanceof Building.CommercialBuilding)
                .map(building -> (Building.CommercialBuilding) building)
                .collect(Collectors.toList());

        List<Building.ResidentialBuilding> residentialBuildings = Buildings.ALL_BUILDINGS.stream()
                .filter(building -> building instanceof Building.ResidentialBuilding)
                .map(building -> (Building.ResidentialBuilding) building)
                .collect(Collectors.toList());


        Board board = buildBoard();
        board.industrial(1, Buildings.食品厂);
        board.industrial(2, Buildings.纺织厂);
        board.industrial(3, Buildings.钢铁厂);

        board.commercial(1, Buildings.便利店);
        board.commercial(2, Buildings.菜市场);
        board.commercial(3, Buildings.民食斋);

        board.residential(1, Buildings.人才公寓);
        board.residential(2, Buildings.居民楼);
        board.residential(3, Buildings.钢结构房);

        Board beatBoard = board;
        beatBoard.print();
        double totalIncome = board.getTotalIncome(PlayingStatusEnum.ONLINE);
        System.out.println("总收入：" + NumberUtils.format(totalIncome));
    }

    private static Board buildBoard() {
        List<Environment> environments = Lists.newArrayList(Environments.保税商圈);
        return new Board(Policies.ALL_POLICIES, environments, Cards.ALL_CARDS);
    }

}
