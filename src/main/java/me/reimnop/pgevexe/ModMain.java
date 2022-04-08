package me.reimnop.pgevexe;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModMain implements ModInitializer {

	public static final String MODID = "pgevexe";

	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static final Identifier TERMINAL = Utils.id("terminal");

	public static final TerminalBlock TERMINAL_BLOCK = new TerminalBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool());
	public static BlockEntityType<TerminalBlockEntity> TERMINAL_BLOCK_ENTITY;
	public static ScreenHandlerType<TerminalScreenHandler> TERMINAL_SCREEN_HANDLER;

	static {
		TERMINAL_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(TERMINAL, TerminalScreenHandler::new);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("WHAT THE FUCK WHY");

		Registry.register(Registry.BLOCK, TERMINAL, TERMINAL_BLOCK);
		Registry.register(Registry.ITEM, TERMINAL, new BlockItem(TERMINAL_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

		TERMINAL_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, TERMINAL, FabricBlockEntityTypeBuilder.create(TerminalBlockEntity::new, TERMINAL_BLOCK).build());
	}
}
