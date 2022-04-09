package me.reimnop.pgevexe.actions;

import me.reimnop.pgevexe.TerminalBlockEntity;

public class ClearAction extends Action {
    private boolean cleared = false;

    @Override
    public void tick(TerminalBlockEntity blockEntity) {
        cleared = true;
        blockEntity.setText("");
    }

    @Override
    public boolean shouldContinue() {
        return !cleared;
    }
}
