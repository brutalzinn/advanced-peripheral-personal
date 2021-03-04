package de.srendi.advancedperipherals.common.addons.computercraft.peripheral;


import dan200.computercraft.api.lua.LuaFunction;
import de.srendi.advancedperipherals.common.addons.sqlbridge.ConnectionFactory;
import de.srendi.advancedperipherals.common.blocks.base.PeripheralTileEntity;
import de.srendi.advancedperipherals.common.configuration.AdvancedPeripheralsConfig;
import net.minecraft.tileentity.TileEntity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlBridgePeripheral extends BasePeripheral {

private static ConnectionFactory factory;

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
    public final boolean Connect(String data_url,String username, String password) {
        ConnectionFactory factory_db = new ConnectionFactory();
        factory_db.setDatabase_url(data_url);
        factory_db.setPassword(password);
        factory_db.setUsername(username);
        try {
            factory_db.createConnectionToMySql();
            factory = factory_db;
            System.out.print("banco conectado");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    @LuaFunction(mainThread = true)
    public final boolean Query(String sql) {
        Connection conn = null;
        PreparedStatement prepareStament = null;
        try {
            prepareStament = factory.createConnectionToMySql().prepareStatement(sql);
            prepareStament.execute();

            System.out.print("banco conectado");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    }