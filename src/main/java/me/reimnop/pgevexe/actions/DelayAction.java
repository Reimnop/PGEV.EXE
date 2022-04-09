package me.reimnop.pgevexe.actions;

import me.reimnop.pgevexe.TerminalBlockEntity;

public class DelayAction extends Action {
    private final int delay;
    private int t = 0;

    public DelayAction(int delay) {
        this.delay = delay;
    }

    @Override
    public void tick(TerminalBlockEntity blockEntity) {
        t++;
    }

    @Override
    public boolean shouldContinue() {
        return t < delay;
    }
}
