package de.srendi.advancedperipherals.common.addons.refinedstorage;

import com.refinedmods.refinedstorage.api.autocrafting.craftingmonitor.ICraftingMonitorListener;
import com.refinedmods.refinedstorage.api.autocrafting.task.ICraftingTask;
import com.refinedmods.refinedstorage.api.network.INetwork;
import dan200.computercraft.api.peripheral.IComputerAccess;
import de.srendi.advancedperipherals.common.addons.computercraft.peripheral.RsBridgePeripheral;
import de.srendi.advancedperipherals.common.blocks.tileentity.RsBridgeTileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class RefinedStorageEvent implements ICraftingMonitorListener {
    private ICraftingTask lastElement;
    private INetwork network;
    private RsBridgeTileEntity tileEntity;
    public RefinedStorageEvent(INetwork network, RsBridgeTileEntity tileEntity) {
        this.network = network;
        this.tileEntity = tileEntity;
    }

    @Override
    public void onAttached() {
        System.out.println("Attrached..");
    }

    @Override
    public void onChanged() {

        RsBridgeTileEntity entity = tileEntity;
        for (ICraftingTask task : network.getCraftingManager().getTasks()) {
            ItemStack stack = task.getRequested().getItem();
            String name = ForgeRegistries.ITEMS.getKey(stack.getItem()).toString();
            int count = stack.getCount();
            if(lastElement != null && lastElement.getId() == task.getId()) {
                return;
            }
            for (IComputerAccess computer : entity.getConnectedComputers()) {
                computer.queueEvent("rs_crafting", name, count);
            }
            lastElement = task;
        }
    }
}