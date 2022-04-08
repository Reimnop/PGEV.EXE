package me.reimnop.pgevexe;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TerminalScreen extends Screen implements ScreenHandlerProvider<TerminalScreenHandler> {
    private static final Identifier TEXTURE = Utils.id("textures/gui/terminal.png");

    private final TerminalScreenHandler screenHandler;

    private static final int backgroundWidth = 176;
    private static final int backgroundHeight = 166;
    private int x;
    private int y;

    public TerminalScreen(TerminalScreenHandler handler, PlayerInventory inventory, Text title) {
        super(title);
        screenHandler = handler;
    }

    @Override
    protected void init() {
        super.init();

        x = (width - backgroundWidth) / 2;
        y = (height - backgroundHeight) / 2;
    }

    protected void drawBackground(MatrixStack matrices) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        drawBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);

        MatrixStack matrixStack = RenderSystem.getModelViewStack();
        matrixStack.push();
        matrixStack.translate(x, y, 0.0D);
        RenderSystem.applyModelViewMatrix();
        RenderSystem.disableDepthTest();

        // Title
        textRenderer.draw(matrices, title, 8, 6, 4210752);

        matrixStack.pop();
        RenderSystem.applyModelViewMatrix();
        RenderSystem.disableDepthTest();
    }

    @Override
    public TerminalScreenHandler getScreenHandler() {
        return screenHandler;
    }
}
