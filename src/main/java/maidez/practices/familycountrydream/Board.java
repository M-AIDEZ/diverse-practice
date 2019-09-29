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

import java.util.List;
import java.util.Set;

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
        List<Buff> allBuffs = getAllBuffs();
        for (Building ib : BUILDINGS) {
            if (ib == null) {
                continue;
            }
            double coefficient = 1D;
            for (Buff buff : allBuffs) {
                coefficient = buff.buff(coefficient, ib, playingStatusEnum);
            }
            totalIncome += coefficient * ib.getIncome();
        }
        return totalIncome * playingStatusEnum.getCoefficient();
    }

    private List<Buff> getAllBuffs() {
        List<Buff> allBuffs = Lists.newArrayList();
        for (Building building : BUILDINGS) {
            if (building == null) {
                continue;
            }
            allBuffs.addAll(building.getBuffs());
        }

        for (Policy policy : policies) {
            allBuffs.add(policy.getBuff());
        }

        for (Environment environment : environments) {
            allBuffs.addAll(environment.getBuffs());
        }

        for (Card card : cards) {
            allBuffs.add(card.getBuff());
        }

        return allBuffs;
    }
}
