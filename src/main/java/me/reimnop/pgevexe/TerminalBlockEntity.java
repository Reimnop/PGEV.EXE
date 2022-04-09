package me.reimnop.pgevexe;

import me.reimnop.pgevexe.actions.Action;
import me.reimnop.pgevexe.actions.ClearAction;
import me.reimnop.pgevexe.actions.DelayAction;
import me.reimnop.pgevexe.actions.TypeWriteAction;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;

public class TerminalBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory {
    // <----------------------->

    private Scene[] scenes = new Scene[] {
            new Scene(new Action[] {
                    new TypeWriteAction("WELCOME.\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("WELCOME TO ", 1),
                    new TypeWriteAction("PGEV.EXE\n\n", 4),
                    new DelayAction(6),
                    new TypeWriteAction("WHY ARE YOU HERE?\n> ", 1),
                    new DelayAction(6),
                    new TypeWriteAction("your mother\n\n", 1),
                    new DelayAction(3),
                    new TypeWriteAction("PLEASE, CLOSE PGEV.EXE\n> ", 1),
                    new DelayAction(6),
                    new TypeWriteAction("your grandmother\n\n", 1),
                    new DelayAction(3),
                    new TypeWriteAction("PLEASE, TYPE \"exit\" TO CLOSE PGEV.EXE\n> ", 1),
                    new DelayAction(6),
                    new TypeWriteAction("exit", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("Wait.\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("Are you still here?\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("I asked you to close pgev.exe, didn't I?\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("I probably forgot to say you should never open it again.\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("I'll close it for you.\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("You better delete the file actually.", 1),
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("Okay, I'm not joking. The file is LITERALLY named PGEV.exe.\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("It's a goddamn Peer Gynt Ench Version, do you expect this file to be safe or something?\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("Do you even listen?\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("Close the file.\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("Right now.", 1),
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("ENCH\n\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("Ench is a character made by enchart and the antagonist of enchart's Peer Gynt level.", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("HISTORY\n\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("In enchart's Peer Gynt, Ench got stabbed by the pink triangle and tried to kill the player that got in his way with the help of his new powers. After a while a strange \"Leader\" sign appears and stabs Ench to turn him into his Leader form. Then he starts trying to smash the player with hammers and after a few tries he traps the player between pink walls that going to crush him. But right before it some other shapes appear, save the player from walls and kill Ench.", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("APPEARANCE\n\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("Ench is a mint square with black eyes and mouth white hands. He also had a pink triangle in the right side before his death. In his corrupted form, his mouth is replaced by four teeth and his body is pink. In the Leader form, he has his regular mouth, and some parts of his body are chipped.", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("TRIVIA\n\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("- Ench's full name is Enchariud\n- Ench is often mistakenly called as Leader because of the Leader sign in the middle of enchart’s Peer Gynt.\n- Ench's PA Wiki page content is included in pgev.ex", 1),
                    new ClearAction(),
                    new TypeWriteAction("PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE", 0)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE", 0)
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE PGEV.EXE", 0)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("PLEASE STOP aHR0cHM6Ly", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("WE'RE ALL 90aW55dXJs IN DANGER", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("I LOVE PGEV, IT'S LmNvbS9wZ2 THE BEST LEVEL IN PA!", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("This file does not contain any V2ZG90ZXhl", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("Please consider playing Peer Gynt by Enchariud! https://stea", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("nd, Arbis has to collect all four Po", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("ped creatures that swirled around the weird bi", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("235095218855084032", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("LEADER LEADER DATAM LEADER DATAMANAGER LEADER DATAM TATAM MANAGER DATAMANAGER LEAADER DA", 1)
            }),
            new Scene(new Action[] {
                    new ClearAction()
            }),
            new Scene(new Action[] {
                    new ClearAction(),
                    new TypeWriteAction("Sorry, but you will not understand my message. ", 1),
                    new DelayAction(6),
                    new TypeWriteAction("Nothing bad will happen. ", 1),
                    new DelayAction(6),
                    new TypeWriteAction("Thanks for staying here.\n", 1),
                    new DelayAction(6),
                    new TypeWriteAction("- L", 1),
            })
    };
    private int sceneIndex = 0;

    // <----------------------->

    private String text = "";

    private boolean used = false;

    public TerminalBlockEntity(BlockPos pos, BlockState state) {
        super(ModMain.TERMINAL_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, TerminalBlockEntity blockEntity) {
        blockEntity.tick();
    }

    public void use() {
        if (!used) {
            used = true;
        }
    }

    public void tick() {
        if (used && sceneIndex < scenes.length) {
            if (scenes[sceneIndex].shouldContinue()) {
                scenes[sceneIndex].tick(this);
            }
            else {
                used = false;
                sceneIndex++;

                if (sceneIndex >= scenes.length) {
                    world.removeBlock(pos, false);
                    world.createExplosion(null, null, null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 5.0F, true, Explosion.DestructionType.DESTROY);
                }

                markDirty();
            }
        }
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.putInt("Scene", sceneIndex);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        if (nbt.contains("Scene")) {
            sceneIndex = nbt.getInt("Scene");
        }
        else {
            sceneIndex = 0;
        }
        super.readNbt(nbt);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new TerminalScreenHandler(syncId, inv, this);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeString(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
