package de.srendi.advancedperipherals.common.addons.computercraft.peripheral;


import de.srendi.advancedperipherals.common.blocks.base.PeripheralTileEntity;
import de.srendi.advancedperipherals.common.configuration.AdvancedPeripheralsConfig;
import net.minecraft.tileentity.TileEntity;

public class SqlBridgePeripheral extends BasePeripheral {



    public SqlBridgePeripheral(String type, PeripheralTileEntity<?> tileEntity) {
        super(type, tileEntity);
    }

    public SqlBridgePeripheral(String type, TileEntity tileEntity) {
        super(type, tileEntity);

    }

    @Override
    public boolean isEnabled() {
        return AdvancedPeripheralsConfig.enableSqlBridge;
    }
}