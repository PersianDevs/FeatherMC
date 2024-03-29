package org.bukkit.util.permissions;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

public final class CommandPermissions {
    private static final String ROOT = "bukkit.command";
    private static final String PREFIX = ROOT + ".";

    private CommandPermissions() {}

    public static Permission registerPermissions(Permission parent) {
        Permission commands = DefaultPermissions.registerPermission(ROOT, "Gives the user the ability to use all CraftBukkit commands", parent);

        DefaultPermissions.registerPermission(PREFIX + "plugins", "Allows the user to view the list of plugins running on this server", Bukkit.pluginsPermissionEnabled() ? PermissionDefault.OP : PermissionDefault.FALSE, commands); // FeatherMC
        DefaultPermissions.registerPermission(PREFIX + "reload", "Allows the user to reload the server settings", PermissionDefault.OP, commands);
        DefaultPermissions.registerPermission(PREFIX + "version", "Allows the user to view the version of the server", Bukkit.versionPermissionEnabled() ? PermissionDefault.OP : PermissionDefault.FALSE, commands); // FeatherMC

        commands.recalculatePermissibles();
        return commands;
    }
}
