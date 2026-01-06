package com.sculkman.eldritchythings.common.item;

import com.mojang.logging.LogUtils;
import com.sculkman.eldritchythings.EldritchyThings;
import com.sculkman.eldritchythings.common.entity.StarVampireEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

public class DebugStaffSVBlood extends Item {
    public DebugStaffSVBlood(Properties pProperties) {
        super(pProperties);
    }
    private static final Logger LOGGER = LogUtils.getLogger();


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pPlayer.hasPose(Pose.CROUCHING)) {
            StarVampireEntity.StarVampireHunger--;
        } else {
            StarVampireEntity.StarVampireHunger++;
        }
        LOGGER.info(String.valueOf(StarVampireEntity.StarVampireHunger));
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
