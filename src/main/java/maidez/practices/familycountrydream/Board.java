package maidez.practices.familycountrydream;

import java.util.List;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class Board {
    // buildings
    private Building.IndustrialBuilding ib1;
    private Building.IndustrialBuilding ib2;
    private Building.IndustrialBuilding ib3;

    private Building.CommercialBuilding cb1;
    private Building.CommercialBuilding cb2;
    private Building.CommercialBuilding cb3;

    private Building.ResidentialBuilding rb1;
    private Building.ResidentialBuilding rb2;
    private Building.ResidentialBuilding rb3;

    // other
    private List<Policy> policies;

    private List<Environment> environments;

    private List<Card> cards;

}
