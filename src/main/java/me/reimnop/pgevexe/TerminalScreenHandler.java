package me.reimnop.pgevexe;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;

public class TerminalScreenHandler extends ScreenHandler {
    protected TerminalScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModMain.TERMINAL_SCREEN_HANDLER, syncId);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
