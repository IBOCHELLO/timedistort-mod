package com.ibochello.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;

public class BotPlayerEntity extends Mob {

    public BotPlayerEntity(EntityType<? extends Mob> type, Level level) {
        super(type, level);
        this.setCustomName(Component.literal("IBOCHELLO"));
        this.setCustomNameVisible(true);
    }

    @Override
    public void tick() {
        super.tick();

        // Bot'un yapacağı işlemler buraya yazılır
        // Örneğin uyku kontrolü ve hareket
    }
}
