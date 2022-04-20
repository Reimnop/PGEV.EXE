package me.reimnop.pgevexe.screen_handler;

import me.reimnop.pgevexe.ModMain;
import me.reimnop.pgevexe.Utils;
import me.reimnop.pgevexe.block_entity.TerminalBlockEntity;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class TerminalScreenHandler extends ScreenHandler {
    public static final Identifier UPDATE_TEXT_PACKET_ID = Utils.id("update_text");

    private String textBuffer;
    private TerminalBlockEntity blockEntity;

    private final PlayerEntity player;

    public TerminalScreenHandler(int syncId, PlayerInventory playerInventory, TerminalBlockEntity blockEntity) {
        this(syncId, playerInventory, "");
        this.blockEntity = blockEntity;
    }

    public TerminalScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, buf.readString());
    }

    public TerminalScreenHandler(int syncId, PlayerInventory playerInventory, String textBuffer) {
        super(ModMain.TERMINAL_SCREEN_HANDLER, syncId);
        player = playerInventory.player;
        this.textBuffer = textBuffer;
    }

    @Override
    public void sendContentUpdates() {
        super.sendContentUpdates();

        if (!player.world.isClient()) {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeString(blockEntity.getText());
            ServerPlayNetworking.send((ServerPlayerEntity) player, UPDATE_TEXT_PACKET_ID, buf);
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    public String getTextBuffer() {
        return textBuffer;
    }
}
