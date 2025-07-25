package com.ibochello.init;

import com.ibochello.entity.BotPlayerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, "timedistort");

    public static final RegistryObject<EntityType<BotPlayerEntity>> BOT_PLAYER = ENTITIES.register("bot_player",
            () -> EntityType.Builder.<BotPlayerEntity>of(BotPlayerEntity::new, MobCategory.MISC)
                    .sized(0.6F, 1.8F)
                    .build("bot_player"));
}
