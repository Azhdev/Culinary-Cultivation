package com.Girafi.culinarycultivation.event;

import com.Girafi.culinarycultivation.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import static com.Girafi.culinarycultivation.handler.ConfigurationHandler.*;

public class SheepsDropsMutton {

    public static double rand;

    @SubscribeEvent
    public void LivingDropsEvent(LivingDropsEvent DropsEvent) {
        rand = Math.random();
        if (ShouldSheepsDropMutton == true) {
            if (DropsEvent.entityLiving instanceof EntitySheep &! DropsEvent.entityLiving.isChild()) {
                if (DropsEvent.entityLiving.isBurning()) {
                    DropsEvent.entityLiving.dropItem(ModItems.cookedMutton, 1);

                } else {
                    DropsEvent.entityLiving.dropItem(ModItems.mutton, 1);

                    if (rand > 0.6D) {

                        if (DropsEvent.entityLiving.isBurning()) {
                            DropsEvent.entityLiving.dropItem(ModItems.cookedMutton, 1);

                        } else {
                            DropsEvent.entityLiving.dropItem(ModItems.mutton, 1);
                        }
                    }
                }
            }
        }
    }
}