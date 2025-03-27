package com.derpysenpaiii.lolmod.misc;

import net.minecraft.nbt.CompoundTag;

public class ModPlayerStats {
    private float abilityPower = 0;

    public float getAbilityPower() {
        return abilityPower;
    }

    public void setAbilityPower(float amount) {
        this.abilityPower = amount;
    }

    public void addAbilityPower(float amount) {
        this.abilityPower += amount;
    }

    public void saveNBT(CompoundTag tag) {
        tag.putFloat("ability_power", abilityPower);
    }

    public void loadNBT(CompoundTag tag) {
        abilityPower = tag.getFloat("ability_power");
    }
}
