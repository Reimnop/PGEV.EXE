package me.reimnop.pgevexe.actions;

import me.reimnop.pgevexe.TerminalBlockEntity;

public abstract class Action {
    public abstract void tick(TerminalBlockEntity blockEntity);
    public abstract boolean shouldContinue();
}
