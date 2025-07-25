package com.ibochello.init;

import com.ibochello.item.BotEggItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "timedistort");

    public static final RegistryObject<Item> BOT_EGG = ITEMS.register("bot_egg", BotEggItem::new);
}
