package com.ibochello;

import com.ibochello.init.ModEntities;
import com.ibochello.init.ModItems;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(TimedistortMod.MODID)
public class TimedistortMod {
    public static final String MODID = "timedistort";

    public TimedistortMod() {
        ModEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Diğer başlatma kodlarınız varsa buraya ekleyebilirsiniz
    }
}
