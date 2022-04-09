package me.reimnop.pgevexe;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class TerminalScreen extends Screen implements ScreenHandlerProvider<TerminalScreenHandler> {
    private static final Identifier TEXTURE = Utils.id("textures/gui/terminal.png");

    private final TerminalScreenHandler screenHandler;

    private static final int backgroundWidth = 256;
    private static final int backgroundHeight = 256;

    private final ArrayList<String> lines = new ArrayList<>();
    private int x;
    private int y;

    public TerminalScreen(TerminalScreenHandler handler, PlayerInventory inventory, Text title) {
        super(title);
        screenHandler = handler;

        updateText(handler.getTextBuffer());
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    protected void init() {
        super.init();

        x = (width - backgroundWidth) / 2;
        y = (height - backgroundHeight) / 2;
    }

    public void updateText(String text) {
        lines.clear();

        if (text.length() == 0) {
            return;
        }

        String[] linesArr = text.split("\n");
        lines.addAll(List.of(linesArr));
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

        // Content
        int yOffset = 18;
        for (String line : lines) {
            String currentLine = "";
            for (int i = 0; i < line.length(); i++) {
                if (textRenderer.getWidth(currentLine) < 235) {
                    currentLine += line.charAt(i);
                }
                else {
                    textRenderer.draw(matrices, currentLine, 8, yOffset, 16777215);
                    currentLine = "" + line.charAt(i);
                    yOffset += 10;
                }
            }
            textRenderer.draw(matrices, currentLine, 8, yOffset, 16777215);
            yOffset += 10;
        }

        matrixStack.pop();
        RenderSystem.applyModelViewMatrix();
        RenderSystem.disableDepthTest();
    }

    public void removed() {
        if (client.player != null) {
            screenHandler.close(client.player);
        }
    }

    public void close() {
        client.player.closeHandledScreen();
        super.close();
    }

    @Override
    public TerminalScreenHandler getScreenHandler() {
        return screenHandler;
    }
}
