package maidez.practices.familycountrydream;

import com.google.common.collect.Lists;
import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.components.Environment;
import maidez.practices.familycountrydream.configs.lwy.Buildings;
import maidez.practices.familycountrydream.configs.lwy.Cards;
import maidez.practices.familycountrydream.configs.lwy.Environments;
import maidez.practices.familycountrydream.configs.lwy.Policies;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;
import maidez.practices.familycountrydream.utils.MathUtils;
import maidez.practices.familycountrydream.utils.NumberUtils;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by luwenyi on 2019/9/29.
 */
public class BestLayoutCalculatorForLwy {

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


        Board bestOnline = null;
        double maxOnlineIncome = Double.MIN_VALUE;

        Board bestOffline = null;
        double maxOfflineIncome = Double.MIN_VALUE;

        Board bestOffer = null;
        double bestOfferIncome = Double.MIN_VALUE;
        double bestOfferCoefficient = Double.MIN_VALUE;

        List<List<Building.IndustrialBuilding>> ibCombinations = MathUtils.combination(industrialBuildings, 3);
        List<List<Building.CommercialBuilding>> cbCombinations = MathUtils.combination(commercialBuildings, 3);
        List<List<Building.ResidentialBuilding>> rbCombinations = MathUtils.combination(residentialBuildings, 3);
        for (List<Building.IndustrialBuilding> ibCombination : ibCombinations) {
            for (List<Building.CommercialBuilding> cbCombination : cbCombinations) {
                for (List<Building.ResidentialBuilding> rbCombination : rbCombinations) {
                    //online
                    Board onlineBoard = buildBoard();
                    onlineBoard.industrial(ibCombination.get(0), ibCombination.get(1), ibCombination.get(2));
                    onlineBoard.commercial(cbCombination.get(0), cbCombination.get(1), cbCombination.get(2));
                    onlineBoard.residential(rbCombination.get(0), rbCombination.get(1), rbCombination.get(2));
                    double onlineIncome = onlineBoard.getTotalIncome(PlayingStatusEnum.ONLINE);
                    if (onlineIncome > maxOnlineIncome) {
                        bestOnline = onlineBoard;
                        maxOnlineIncome = onlineIncome;
                    }

//                    offline
                    Board offlineBoard = buildBoard();
                    offlineBoard.industrial(ibCombination.get(0), ibCombination.get(1), ibCombination.get(2));
                    offlineBoard.commercial(cbCombination.get(0), cbCombination.get(1), cbCombination.get(2));
                    offlineBoard.residential(rbCombination.get(0), rbCombination.get(1), rbCombination.get(2));
                    double offlineIncome = offlineBoard.getTotalIncome(PlayingStatusEnum.OFFLINE);
                    if (offlineIncome > maxOfflineIncome) {
                        bestOffline = offlineBoard;
                        maxOfflineIncome = offlineIncome;
                    }

                    //offer
                    Board offerBoard = buildBoard();
                    offerBoard.industrial(ibCombination.get(0), ibCombination.get(1), ibCombination.get(2));
                    offerBoard.commercial(cbCombination.get(0), cbCombination.get(1), cbCombination.get(2));
                    offerBoard.residential(rbCombination.get(0), rbCombination.get(1), rbCombination.get(2));
                    double offerCoefficient = offerBoard.getOfferCoefficient();
                    double offerIncome = offerBoard.getTotalIncome(PlayingStatusEnum.ONLINE);
                    if (offerCoefficient > bestOfferCoefficient
                            || (offerCoefficient == bestOfferCoefficient && offerIncome > bestOfferIncome)) {
                        bestOffer = offerBoard;
                        bestOfferCoefficient = offerCoefficient;
                        bestOfferIncome = offerIncome;
                    }
                }
            }
        }
        System.out.println("\n=========最佳在线收入=========\n");
        bestOnline.print();
        System.out.println("总收入：" + NumberUtils.format(maxOnlineIncome, 3));

        System.out.println("\n=========最佳离线收入=========\n");
        bestOffline.print();
        System.out.println("总收入：" + NumberUtils.format(maxOfflineIncome, 3));

        System.out.println("\n=========最佳收货加成========\n");
        bestOffer.print();
        System.out.println("收货加成：" + NumberUtils.format(bestOfferCoefficient, 3));
        System.out.println("总收入：" + NumberUtils.format(bestOfferIncome, 3));
    }

    private static Board buildBoard() {
        List<Environment> environments = Lists.newArrayList(Environments.电子商务);
        return new Board(Policies.ALL_POLICIES, environments, Cards.ALL_CARDS);
    }

}
