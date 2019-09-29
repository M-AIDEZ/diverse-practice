package maidez.practices.familycountrydream.components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import maidez.practices.familycountrydream.buff.Buff;

import java.util.List;

/**
 * Created by luwenyi on 2019/9/29.
 */
@AllArgsConstructor
@Getter
public class Environment {
    private String name;

    private List<Buff> buffs;
}
