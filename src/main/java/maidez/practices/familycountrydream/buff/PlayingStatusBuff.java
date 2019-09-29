package maidez.practices.familycountrydream.buff;

import maidez.practices.familycountrydream.components.Building;
import maidez.practices.familycountrydream.enums.PlayingStatusEnum;

/**
 * Created by luwenyi on 2019/9/29.
 */
public class PlayingStatusBuff extends Buff {
    private PlayingStatusEnum playingStatusEnum;

    public PlayingStatusBuff(double magnification, PlayingStatusEnum playingStatusEnum) {
        super(magnification);
        this.playingStatusEnum = playingStatusEnum;
    }

    @Override
    public boolean takeEffect(Building building, PlayingStatusEnum playingStatusEnum) {
        return this.playingStatusEnum == playingStatusEnum;
    }
}
