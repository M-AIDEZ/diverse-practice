package maidez.practices.familycountrydream;

import lombok.AllArgsConstructor;
import maidez.practices.familycountrydream.buff.Buff;

import java.util.List;

/**
 * Created by luwenyi on 2019/9/29.
 */
@AllArgsConstructor
public class Environment {
    private String name;

    private List<Buff> buffs;
}
