package com.zacharias.zacmod.datagen;

import com.zacharias.zacmod.block.ModBlock;
import com.zacharias.zacmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlock.RUBY_BLOCK.get());

        add(ModBlock.RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlock.RUBY_ORE.get(), ModItems.ROUGH_RUBY.get()));

        add(ModBlock.DEEPSLATE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlock.DEEPSLATE_RUBY_ORE.get(), ModItems.ROUGH_RUBY.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
