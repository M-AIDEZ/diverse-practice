package maidez.practices.familycountrydream;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.components.Environment;
import maidez.practices.familycountrydream.configs.Buildings;
import maidez.practices.familycountrydream.configs.Cards;
import maidez.practices.familycountrydream.configs.Environments;
import maidez.practices.familycountrydream.configs.Policies;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;
import maidez.practices.familycountrydream.utils.MathUtils;
import maidez.practices.familycountrydream.utils.NumberUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by luwenyi on 2019/9/29.
 */
public class BestLayoutCalculator {

    public static void main(String[] args) {
        PlayingStatusEnum playingStatusEnum = PlayingStatusEnum.ONLINE;
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


        Board bestBoard = null;
        double maxIncome = Double.MIN_VALUE;
        List<List<Building.IndustrialBuilding>> ibCombinations = MathUtils.combination(industrialBuildings, 3);
        List<List<Building.CommercialBuilding>> cbCombinations = MathUtils.combination(commercialBuildings, 3);
        List<List<Building.ResidentialBuilding>> rbCombinations = MathUtils.combination(residentialBuildings, 3);
        for (List<Building.IndustrialBuilding> ibCombination : ibCombinations) {
            for (List<Building.CommercialBuilding> cbCombination : cbCombinations) {
                for (List<Building.ResidentialBuilding> rbCombination : rbCombinations) {
                    Board board = buildBoard();
                    board.industrial(ibCombination.get(0), ibCombination.get(1), ibCombination.get(2));
                    board.commercial(cbCombination.get(0), cbCombination.get(1), cbCombination.get(2));
                    board.residential(rbCombination.get(0), rbCombination.get(1), rbCombination.get(2));
                    double totalIncome = board.getTotalIncome(playingStatusEnum);
                    if (totalIncome > maxIncome) {
                        bestBoard = board;
                        maxIncome = totalIncome;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("=========DONE=========");
        System.out.println();
        bestBoard.print();
        System.out.println(bestBoard);
        System.out.println("总收入：" + NumberUtils.format(maxIncome, 3));
    }

    private static Board buildBoard() {
        List<Environment> environments = Lists.newArrayList(Environments.保税商圈);
        return new Board(Policies.ALL_POLICIES, environments, Cards.ALL_CARDS);
    }

}
