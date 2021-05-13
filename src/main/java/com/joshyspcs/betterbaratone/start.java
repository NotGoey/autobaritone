package com.joshyspcs.betterbaratone;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.GoalXZ;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class start extends CommandBase {
    public static int x;
    public static int z;
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] params) throws CommandException {

        Main.logger.info("execute called");
        
        if (params != null && params.length == 2) {
            x = Integer.parseInt(params[0]);
            z = Integer.parseInt(params[1]);
            Main.logger.info("sucess");
            Main.startt = new Thread(){
                public void run(){
                    BaritoneAPI.getSettings().allowSprint.value = true;
                    BaritoneAPI.getSettings().primaryTimeoutMS.value = 2000L;
                    while (Main.stated) {
                        try {
                        BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(new GoalXZ(start.x, start.z));
                        Thread.sleep(1500);
                        } catch (Exception e) {
                            Main.logger.info(e);
                        }
                    }
                }
            };
            Main.stated = true;
            Main.startt.start();
        } else {
            Main.logger.info("error");
        }
    }

    @Override
    public String getName() {
        return "ab";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "command.ab.usage";
    }

    @Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}
}