package de.srendi.advancedperipherals.common.blocks.tileentity;

import de.srendi.advancedperipherals.common.addons.computercraft.peripheral.ChatBoxPeripheral;
import de.srendi.advancedperipherals.common.addons.computercraft.peripheral.SqlBridgePeripheral;
import de.srendi.advancedperipherals.common.blocks.base.PeripheralTileEntity;
import de.srendi.advancedperipherals.common.setup.TileEntityTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class SqlBridgeTileEntity extends PeripheralTileEntity<SqlBridgePeripheral>{

    private int tick;

    public SqlBridgeTileEntity() { this(TileEntityTypes.SQL_BRIDGE.get()); }

    public SqlBridgeTileEntity(final TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    @Override
    protected SqlBridgePeripheral createPeripheral() {
        return new SqlBridgePeripheral("sqlBridge", this);
    }


}