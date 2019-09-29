package maidez.practices.familycountrydream;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import maidez.practices.familycountrydream.buff.Buff;
import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.components.Card;
import maidez.practices.familycountrydream.components.Environment;
import maidez.practices.familycountrydream.components.Policy;
import maidez.practices.familycountrydream.enums.BuildingTypeEnum;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;
import maidez.practices.familycountrydream.utils.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Board {

    public Board(List<Policy> policies, List<Environment> environments, List<Card> cards) {
        this.policies = policies;
        this.environments = environments;
        this.cards = cards;
    }


    private static final int BOUND = 3;
    // buildings
    private static final Building[] BUILDINGS = new Building[BOUND * BOUND];

    public void industrial(int position, Building.IndustrialBuilding toBuild) {
        build(position, BuildingTypeEnum.INDUSTRIAL, toBuild);
    }

    public void commercial(int position, Building.CommercialBuilding toBuild) {
        build(position, BuildingTypeEnum.COMMERCIAL, toBuild);
    }


    public void residential(int position, Building.ResidentialBuilding toBuild) {
        build(position, BuildingTypeEnum.RESIDENTIAL, toBuild);
    }

    public void print(){
        List<List<Building>> partition = Lists.partition(Lists.newArrayList(BUILDINGS), BOUND);
        for (List<Building> buildings : partition) {
            StringBuilder sb = new StringBuilder();
            for (Building building : buildings) {
                sb.append(building.getName()).append("      ");
            }
            sb.append("\n");
            System.out.println(sb);
        }
    }

    private static void build(int position, BuildingTypeEnum buildingTypeEnum, Building after) {
        //CHECK
        checkPosition(position);
        checkDuplicate(after);
        //MODIFY
        int index = position + getOffset(buildingTypeEnum) - 1;
        String beforeName = BUILDINGS[index] == null ? "空地" : BUILDINGS[index].getName();
        String afterName = after == null ? "空地" : after.getName();
        BUILDINGS[index] = after;
        System.out.println(position + "号" + buildingTypeEnum.getDesc() + "用地：已从 [ " + beforeName + " ] 改建为 [ " + afterName + " ] 。");
    }

    private static int getOffset(BuildingTypeEnum buildingTypeEnum) {
        switch (buildingTypeEnum) {
            case INDUSTRIAL:
                return 0 * BOUND;
            case COMMERCIAL:
                return 1 * BOUND;
            case RESIDENTIAL:
                return 2 * BOUND;
            default:
                throw new IllegalArgumentException("Unknown buildingTypeEnum " + buildingTypeEnum.getDesc());
        }
    }

    private static void checkPosition(int position) {
        if (position < 1 || position > BOUND) {
            throw new IllegalArgumentException("超出建筑范围");
        }
    }

    private static void checkDuplicate(Building after) {
        if (after != null) {
            Set<String> builtSet = Sets.newHashSet();
            for (Building building : BUILDINGS) {
                if (building != null) {
                    builtSet.add(building.getName());
                }
            }
            if (builtSet.contains(after.getName())) {
                System.out.println(after.getName() + "不可重复建造");
            }
        }
    }


    // other
    private List<Policy> policies;

    private List<Environment> environments;

    private List<Card> cards;

    public double getTotalIncome(PlayingStatusEnum playingStatusEnum) {
        double totalIncome = 0D;
        List<Buff> buildingBuffs = getBuildingBuffs();
        List<Buff> policyBuffs = getPolicyBuffs();
        List<Buff> cardBuffs = getCardBuffs();
        List<Buff> environmentBuffs = getEnvironmentBuffs();
        for (Building building : BUILDINGS) {
            if (building == null) {
                continue;
            }
            double buildingCoefficient = 1D;
            for (Buff buildingBuff : buildingBuffs) {
                if (buildingBuff.takeEffect(building, playingStatusEnum)) {
                    buildingCoefficient += buildingBuff.getMagnification();
                }
            }
            double policyCoefficient = 1D;
            for (Buff policyBuff : policyBuffs) {
                if (policyBuff.takeEffect(building, playingStatusEnum)) {
                    policyCoefficient += policyBuff.getMagnification();
                }
            }
            double cardCoefficient = 1D;
            for (Buff cardBuff : cardBuffs) {
                if (cardBuff.takeEffect(building, playingStatusEnum)) {
                    cardCoefficient += cardBuff.getMagnification();
                }
            }
            double environmentCoefficient = 1D;
            for (Buff environmentBuff : environmentBuffs) {
                if (environmentBuff.takeEffect(building, playingStatusEnum)) {
                    environmentCoefficient += environmentBuff.getMagnification();
                }
            }
            double income = building.getIncome() * buildingCoefficient * policyCoefficient * cardCoefficient * environmentCoefficient;
            System.out.println(building.getName() + "的收入：" + NumberUtils.format(income));
            totalIncome += income;
        }
        return totalIncome * playingStatusEnum.getCoefficient();
    }

    private List<Buff> getEnvironmentBuffs() {
        return environments.stream()
                .map(Environment::getBuffs)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<Buff> getCardBuffs() {
        return cards.stream()
                .map(Card::getBuff)
                .collect(Collectors.toList());
    }

    private List<Buff> getPolicyBuffs() {
        return policies.stream()
                .map(Policy::getBuff)
                .collect(Collectors.toList());
    }

    private List<Buff> getBuildingBuffs() {
        return Arrays.stream(BUILDINGS)
                .filter(Objects::nonNull)
                .map(Building::getBuffs)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
