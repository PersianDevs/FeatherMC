package org.bukkit.craftbukkit.entity;

import net.minecraft.server.EntityMinecartChest;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.inventory.CraftInventory;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.StorageMinecart;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("deprecation")
public class CraftMinecartChest extends CraftMinecart implements StorageMinecart {
    private final CraftInventory inventory;

    public CraftMinecartChest(CraftServer server, EntityMinecartChest entity) {
        super(server, entity);
        inventory = new CraftInventory(entity);
    }

    public Inventory getInventory() {
        return inventory;
    }
    @Override
    public void sendMessageColor(String message) {

    }
    @Override
    public String toString() {
        return "CraftMinecartChest{" + "inventory=" + inventory + '}';
    }

    public EntityType getType() {
        return EntityType.MINECART_CHEST;
    }
}
