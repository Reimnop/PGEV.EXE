package me.reimnop.pgevexe.actions;

import me.reimnop.pgevexe.actions.Action;
import me.reimnop.pgevexe.block_entity.TerminalBlockEntity;

public class Scene {
    private final Action[] actions;

    private int index = 0;

    public Scene(Action[] actions) {
        this.actions = actions;
    }

    public void tick(TerminalBlockEntity blockEntity) {
        if (actions[index].shouldContinue()) {
            actions[index].tick(blockEntity);
        }
        else {
            index++;
        }
    }

    public boolean shouldContinue() {
        return index < actions.length;
    }
}
