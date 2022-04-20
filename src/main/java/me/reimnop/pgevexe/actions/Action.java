package me.reimnop.pgevexe.actions;

import me.reimnop.pgevexe.block_entity.TerminalBlockEntity;

public abstract class Action {
    public abstract void tick(TerminalBlockEntity blockEntity);
    public abstract boolean shouldContinue();
}
