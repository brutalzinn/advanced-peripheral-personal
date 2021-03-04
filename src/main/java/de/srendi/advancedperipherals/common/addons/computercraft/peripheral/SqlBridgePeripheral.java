package de.srendi.advancedperipherals.common.addons.computercraft.peripheral;


import dan200.computercraft.api.lua.LuaFunction;
import de.srendi.advancedperipherals.common.addons.sqlbridge.ConnectionFactory;
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
    @LuaFunction(mainThread = true)
    public final boolean Connect(String data_url,String username, String password){
ConnectionFactory factory_db = new ConnectionFactory();
factory_db.setDatabase_url(data_url);
factory_db.setPassword(password);
factory_db.setUsername(username);

    }
}