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

        // package com.ibochello.entity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class BotPlayerEntity extends Mob {

    public BotPlayerEntity(EntityType<? extends Mob> type, Level level) {
        super(type, level);
        this.setCustomName(Component.literal("IBOCHELLO"));
        this.setCustomNameVisible(true);
    }

    @Override
    public void tick() {
        super.tick();
        //package com.ibochello.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BotPlayerEntity extends Mob {

    public BotPlayerEntity(EntityType<? extends Mob> type, Level level) {
        super(type, level);
        this.setCustomName(Component.literal("IBOCHELLO"));
        this.setCustomNameVisible(true);
    }

    @Override
    public void tick() {
        super.tick();

        Level level = this.level;
        if (!level.isClientSide) {
            BlockPos pos = this.blockPosition();
            BlockState blockState = level.getBlockState(pos.below());

            // Eğer botun altındaki blok yatak ise uyuyormuş gibi yap
            if (blockState.getBlock() instanceof BedBlock) {
                // Bot uyuyor, zaman donması vs. mantığı burada uygulanabilir
                // Örneğin bot uyuduğunda oyuncuların uyku durumunu etkileyebilirsin
            }
        }
    }
}

    }
}

        //
    }
}
