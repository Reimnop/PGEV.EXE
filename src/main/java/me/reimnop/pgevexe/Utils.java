package me.reimnop.pgevexe;

import net.minecraft.util.Identifier;

public class Utils {
    public static Identifier id(String path) {
        return new Identifier(ModMain.MODID, path);
    }
}
