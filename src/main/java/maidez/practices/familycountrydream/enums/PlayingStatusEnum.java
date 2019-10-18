package maidez.practices.familycountrydream.enums;

import lombok.Getter;

/**
 * Created by luwenyi on 2019/9/29.
 */
public enum PlayingStatusEnum {
    ONLINE(1D),
    OFFLINE(0.5D);

    @Getter
    private double coefficient;

    PlayingStatusEnum(double coefficient) {
        this.coefficient = coefficient;
    }
}
