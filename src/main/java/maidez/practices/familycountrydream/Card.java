package maidez.practices.familycountrydream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import maidez.practices.familycountrydream.buff.Buff;

/**
 * Created by luwenyi on 2019/9/29.
 */
@AllArgsConstructor
@Getter
public class Card {
    private String name;

    private Buff buff;
}
