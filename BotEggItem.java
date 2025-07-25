package com.ibochello.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class BotEggItem extends Item {

    public BotEggItem() {
        super(new Properties().stacksTo(16));
    }

    // package com.ibochello.item;

import com.ibochello.entity.BotPlayerEntity;
import com.ibochello.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BotEggItem extends Item {
    public BotEggItem() {
        super(new Properties().stacksTo(16));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            BlockPos pos = player.blockPosition().above();

            BotPlayerEntity bot = new BotPlayerEntity(ModEntities.BOT_PLAYER.get(), level);
            bot.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, player.getYRot(), player.getXRot());
            level.addFreshEntity(bot);

            level.playSound(null, pos, SoundEvents.EGG_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}

}
