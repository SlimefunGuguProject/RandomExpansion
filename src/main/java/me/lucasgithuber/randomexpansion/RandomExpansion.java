package me.lucasgithuber.randomexpansion;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.lucasgithuber.randomexpansion.Resources.*;
import me.lucasgithuber.randomexpansion.gear.MonsterBoots;
import me.lucasgithuber.randomexpansion.gear.MonsterChest;
import me.lucasgithuber.randomexpansion.gear.MonsterHelmet;
import me.lucasgithuber.randomexpansion.gear.MonsterLeggings;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomExpansion extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }
        ItemStack itemGroupItem = new CustomItemStack(Material.COMMAND_BLOCK, "&4随机拓展", "", "&a> 单击打开");

        NamespacedKey itemGroupId = new NamespacedKey(this, "RANDOMEXPANSION");
        ItemGroup itemGroup = new ItemGroup(itemGroupId, itemGroupItem);

        /*
         *reinforced membrane
         */
        SlimefunItemStack REINFORCED_PHANTOM_MEMBRANE = new SlimefunItemStack("REINFORCED_PHANTOM_MEMBRANE", Material.PHANTOM_MEMBRANE, "&b&l强化幽灵膜 ", "&7&n用于制造怪兽盔甲的抗性膜");

        ItemStack[] recipe = {SlimefunItems.HARDENED_METAL_INGOT, SlimefunItems.REINFORCED_PLATE, SlimefunItems.HARDENED_METAL_INGOT,
                SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.PHANTOM_MEMBRANE), SlimefunItems.REINFORCED_PLATE,
                SlimefunItems.HARDENED_METAL_INGOT, SlimefunItems.REINFORCED_PLATE, SlimefunItems.HARDENED_METAL_INGOT};

        new ReinforcedPhantomMembrane(itemGroup, REINFORCED_PHANTOM_MEMBRANE, RecipeType.ENHANCED_CRAFTING_TABLE, recipe).register(this);
         /*
         *monster helmet i guess
         */
        SlimefunItemStack MONSTER_HELMET = new SlimefunItemStack("MONSTER_HELMET", Material.CHAINMAIL_HELMET, "&8怪兽头盔", "&8+25%恐吓并提供夜视能力");

        ItemStack[] MONSTER_HELMET_RECIPE = {SlimefunItems.SYNTHETIC_SAPPHIRE, REINFORCED_PHANTOM_MEMBRANE , SlimefunItems.SYNTHETIC_SAPPHIRE,
                REINFORCED_PHANTOM_MEMBRANE, null, REINFORCED_PHANTOM_MEMBRANE,
                null, null, null,};

        new MonsterHelmet(itemGroup, MONSTER_HELMET, RecipeType.ARMOR_FORGE, MONSTER_HELMET_RECIPE).register(this);
         /*
         *monster chestplate
         */

        SlimefunItemStack MONSTER_CHEST = new SlimefunItemStack("MONSTER_CHESTPLATE", Material.CHAINMAIL_CHESTPLATE, "&8怪兽胸甲", "&8+25%恐吓");

        ItemStack[] MONSTER_CHEST_RECIPE = {REINFORCED_PHANTOM_MEMBRANE, null, REINFORCED_PHANTOM_MEMBRANE,
                REINFORCED_PHANTOM_MEMBRANE, SlimefunItems.SYNTHETIC_SAPPHIRE, REINFORCED_PHANTOM_MEMBRANE,
                REINFORCED_PHANTOM_MEMBRANE, REINFORCED_PHANTOM_MEMBRANE, REINFORCED_PHANTOM_MEMBRANE,};

        new MonsterChest(itemGroup, MONSTER_CHEST, RecipeType.ARMOR_FORGE, MONSTER_CHEST_RECIPE).register(this);
        /*
         *monster leggings yikes
         */

        SlimefunItemStack MONSTER_LEGGINGS = new SlimefunItemStack("MONSTER_LEGGINGS", Material.CHAINMAIL_LEGGINGS, "&8怪兽护腿", "&8+25%恐吓");

        ItemStack[] MONSTER_LEGGINGS_RECIPE = {SlimefunItems.SYNTHETIC_SAPPHIRE, REINFORCED_PHANTOM_MEMBRANE, SlimefunItems.SYNTHETIC_SAPPHIRE,
                REINFORCED_PHANTOM_MEMBRANE, null, REINFORCED_PHANTOM_MEMBRANE,
                REINFORCED_PHANTOM_MEMBRANE, null, REINFORCED_PHANTOM_MEMBRANE,};

        new MonsterLeggings(itemGroup, MONSTER_LEGGINGS, RecipeType.ARMOR_FORGE, MONSTER_LEGGINGS_RECIPE).register(this);
        /*
         *monster boots '-' what did u expect
         */

        SlimefunItemStack MONSTER_BOOTS = new SlimefunItemStack("MONSTER_BOOTS", Material.CHAINMAIL_BOOTS, "&8怪兽靴子", "&8+25%恐吓");

        ItemStack[] MONSTER_BOOTS_RECIPE = {SlimefunItems.SYNTHETIC_SAPPHIRE, null, SlimefunItems.SYNTHETIC_SAPPHIRE,
                REINFORCED_PHANTOM_MEMBRANE, null, REINFORCED_PHANTOM_MEMBRANE,
                REINFORCED_PHANTOM_MEMBRANE, null, REINFORCED_PHANTOM_MEMBRANE,};

        new MonsterBoots(itemGroup, MONSTER_BOOTS, RecipeType.ARMOR_FORGE, MONSTER_BOOTS_RECIPE).register(this);

        /*
        *Animal dust
         */


        SlimefunItemStack ANIMAL_DUST= new SlimefunItemStack("ANIMAL_DUST", Material.REDSTONE, "&4禽兽粉", "&4一种神秘的肉粉");

        ItemStack[] ANIMAL_DUST_RECIPE = {new ItemStack(Material.MUTTON), null, null, null ,null ,null ,null ,null ,null};

        new AnimalDust(itemGroup, ANIMAL_DUST, RecipeType.ORE_CRUSHER, ANIMAL_DUST_RECIPE).register(this);

        /*
        *Animal ingot
         */

        SlimefunItemStack ANIMAL_INGOT= new SlimefunItemStack("ANIMAL_INGOT", Material.NETHER_BRICK, "&4禽兽锭", "&4一种神秘的肉锭");

        ItemStack[] ANIMAL_INGOT_RECIPE = {ANIMAL_DUST, null, null, null ,null ,null ,null ,null ,null};

        new AnimalIngot(itemGroup, ANIMAL_INGOT, RecipeType.SMELTERY, ANIMAL_INGOT_RECIPE).register(this);
        /*
        *Monster dust
         */

        SlimefunItemStack MONSTER_DUST= new SlimefunItemStack("MONSTER_DUST", Material.GUNPOWDER, "&c腐肉粉", "");

        ItemStack[] MONSTER_DUST_RECIPE = {new ItemStack(Material.ROTTEN_FLESH), null, null, null ,null ,null ,null ,null ,null};

        new MonsterDust(itemGroup, MONSTER_DUST, RecipeType.ORE_CRUSHER, MONSTER_DUST_RECIPE).register(this);

        /*
        *Dark Heart
         */


        SlimefunItemStack DARK_HEART= new SlimefunItemStack("DARK_HEART", Material.MAGMA_CREAM, "&4黑暗之心", "&7包含各种生物的精华...");

        ItemStack[] DARK_HEART_RECIPE = {MONSTER_DUST, SlimefunItems.ESSENCE_OF_AFTERLIFE, MONSTER_DUST, SlimefunItems.VILLAGER_RUNE, ANIMAL_INGOT, SlimefunItems.VILLAGER_RUNE, MONSTER_DUST, SlimefunItems.VILLAGER_RUNE, MONSTER_DUST};

        new DarkHeart(itemGroup, DARK_HEART, RecipeType.ANCIENT_ALTAR, DARK_HEART_RECIPE).register(this);
    }
    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return "github.com/lucasGithuber/RandomExpansion/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}