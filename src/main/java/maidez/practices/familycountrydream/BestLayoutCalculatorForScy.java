package maidez.practices.familycountrydream;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.components.Environment;
import maidez.practices.familycountrydream.configs.scy.Buildings;
import maidez.practices.familycountrydream.configs.scy.Cards;
import maidez.practices.familycountrydream.configs.scy.Environments;
import maidez.practices.familycountrydream.configs.scy.Policies;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;
import maidez.practices.familycountrydream.utils.MathUtils;
import maidez.practices.familycountrydream.utils.NumberUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by luwenyi on 2019/9/29.
 */
public class BestLayoutCalculatorForScy {

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


        Board bestIncome = null;
        double maxIncome = Double.MIN_VALUE;
        Board bestCoefficient = null;
        double maxCoefficient = Double.MIN_VALUE;
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
                    double totalIncome = board.getTotalIncome(playingStatusEnum, false);
                    if (totalIncome > maxIncome) {
                        bestIncome = board;
                        maxIncome = totalIncome;
                    }

                    Board board2 = buildBoard();
                    board2.industrial(ibCombination.get(0), ibCombination.get(1), ibCombination.get(2));
                    board2.commercial(cbCombination.get(0), cbCombination.get(1), cbCombination.get(2));
                    board2.residential(rbCombination.get(0), rbCombination.get(1), rbCombination.get(2));
                    double totalCoefficient = board2.getTotalIncome(playingStatusEnum, true);
                    if (totalCoefficient > maxCoefficient) {
                        bestCoefficient = board2;
                        maxCoefficient = totalCoefficient;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("=========当前最佳收入=========");
        System.out.println();
        bestIncome.print();
        System.out.println("总收入：" + NumberUtils.format(maxIncome, 3));

        System.out.println();
        System.out.println();
        System.out.println("=========当前最佳系数=========");
        System.out.println();
        bestCoefficient.print();
        System.out.println("总系数：" + NumberUtils.format(maxCoefficient, 3));
    }

    private static Board buildBoard() {
        List<Environment> environments = Lists.newArrayList(Environments.和谐家园);
        return new Board(Policies.ALL_POLICIES, environments, Cards.ALL_CARDS);
    }

}
