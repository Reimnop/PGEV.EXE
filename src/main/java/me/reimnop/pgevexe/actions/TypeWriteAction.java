package me.reimnop.pgevexe.actions;

import me.reimnop.pgevexe.block_entity.TerminalBlockEntity;

public class TypeWriteAction extends Action {
    private final String text;
    private final int delay;

    private int currentIndex = 0;
    private int t = 0;

    public TypeWriteAction(String text, int delay) {
        this.text = text;
        this.delay = delay;
    }

    @Override
    public void tick(TerminalBlockEntity blockEntity) {
        if (t < delay) {
            t++;
            return;
        }
        t = 0;
        blockEntity.setText(blockEntity.getText() + text.charAt(currentIndex));
        currentIndex++;
    }

    @Override
    public boolean shouldContinue() {
        return currentIndex < text.length();
    }
}
