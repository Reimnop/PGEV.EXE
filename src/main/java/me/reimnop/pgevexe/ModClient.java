package me.reimnop.pgevexe;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModMain.TERMINAL_SCREEN_HANDLER, TerminalScreen::new);

        ClientPlayNetworking.registerGlobalReceiver(TerminalScreenHandler.UPDATE_TEXT_PACKET_ID, (client, handler, buf, responseSender) -> {
            String str = buf.readString();
            client.execute(() -> {
                if (client.currentScreen instanceof TerminalScreen screen) {
                    screen.updateText(str);
                }
            });
        });
    }
}
