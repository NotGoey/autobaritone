package com.joshyspcs.betterbaratone;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class stop extends CommandBase {
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] params) throws CommandException {
        Main.logger.info("execute called");
        Main.startt = null;
        Main.stated = false;
    }

    @Override
    public String getName() {
        return "abs";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "command.abs.usage";
    }

    @Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}
}
