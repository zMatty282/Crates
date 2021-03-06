package it.matty.crate.crates.builders;

import it.matty.crate.CratePlugin;
import it.matty.crate.crates.ICrateManager;
import it.matty.crate.crates.crates.DefaultCrate;
import it.matty.crate.crates.rewards.DefaultReward;
import it.matty.crate.crates.rewards.Reward;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class CrateBuilder {
    private final ICrateManager manager = CratePlugin.getPlugin().getCrateManager();
    private final String name;
    private final ItemStack item;
    private final Set<Reward> rewards = new HashSet<>();
    private final DefaultCrate crate;

    public CrateBuilder(String name, ItemStack item) {
        this.name = name;
        this.item = item;

        this.crate = new DefaultCrate(name, item, new HashSet<>());
    }

    public CrateBuilder addReward(ItemStack itemStack, double percentage) {
        crate.addItem(new DefaultReward(itemStack, percentage));
        return this;
    }

    public void create() {
        CratePlugin.getPlugin().getCrateManager().addCrate(new DefaultCrate(name, item, rewards));
    }

}
