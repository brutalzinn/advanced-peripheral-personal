package de.srendi.advancedperipherals.common.addons.computercraft.peripheral;

import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IComputerAccess;
import de.srendi.advancedperipherals.common.blocks.base.PeripheralTileEntity;
import de.srendi.advancedperipherals.common.configuration.AdvancedPeripheralsConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerDetectorPeripheral extends BasePeripheral {

    private final List<IComputerAccess> connectedComputers = new ArrayList<>();

    public PlayerDetectorPeripheral(String type, PeripheralTileEntity tileEntity) {
        super(type, tileEntity);
    }

    public List<IComputerAccess> getConnectedComputers() {
        return connectedComputers;
    }

    @LuaFunction(mainThread = true)
    public final List<String> getPlayersInRange(int range) throws LuaException {
        if (AdvancedPeripheralsConfig.enablePlayerDetector) {
            double rangeNegative = -(double) range;
            List<PlayerEntity> players = tileEntity.getWorld().getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(tileEntity.getPos().add(rangeNegative, rangeNegative, rangeNegative), tileEntity.getPos().add((double) range + 1, (double) range + 1, (double) range + 1)));
            List<String> playersName = new ArrayList<>();
            for (PlayerEntity name : players) {
                playersName.add(name.getName().getString());
            }
            return playersName;
        }
        return Collections.emptyList();
    }

    @LuaFunction(mainThread = true)
    public final boolean isPlayersInRange(int range) throws LuaException {
        if (AdvancedPeripheralsConfig.enablePlayerDetector) {
            double rangeNegative = -(double) range;
            List<PlayerEntity> players = tileEntity.getWorld().getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(tileEntity.getPos().add(rangeNegative, rangeNegative, rangeNegative), tileEntity.getPos().add((double) range + 1, (double) range + 1, (double) range + 1)));
            return !players.isEmpty();
        }
        return false;
    }

    @LuaFunction(mainThread = true)
    public final boolean isPlayerInRange(int range, String username) throws LuaException {
        if (AdvancedPeripheralsConfig.enablePlayerDetector) {
            double rangeNegative = -(double) range;
            List<PlayerEntity> players = tileEntity.getWorld().getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(tileEntity.getPos().add(rangeNegative, rangeNegative, rangeNegative), tileEntity.getPos().add((double) range + 1, (double) range + 1, (double) range + 1)));
            List<String> playersName = new ArrayList<>();
            for (PlayerEntity name : players) {
                playersName.add(name.getName().getString());
            }
            return playersName.contains(username);
        }
        return false;
    }
}
