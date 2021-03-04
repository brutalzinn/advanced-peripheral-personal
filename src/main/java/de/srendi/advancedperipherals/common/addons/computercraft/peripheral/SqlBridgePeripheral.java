package de.srendi.advancedperipherals.common.addons.computercraft.peripheral;


import dan200.computercraft.api.lua.LuaFunction;
import de.srendi.advancedperipherals.common.addons.sqlbridge.ConnectionFactory;
import de.srendi.advancedperipherals.common.blocks.base.PeripheralTileEntity;
import de.srendi.advancedperipherals.common.configuration.AdvancedPeripheralsConfig;
import net.minecraft.tileentity.TileEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            System.out.print("connected to mysql");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.print("Error with mysql connection.");
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    @LuaFunction(mainThread = true)
    public final Object[] Query(String sql) {
        Connection conn = null;
        PreparedStatement prepareStament = null;
        HashMap<Integer, Object> items = new HashMap<>();
        Map<String, Object> row = new HashMap<>();

        try {
            prepareStament = factory.createConnectionToMySql().prepareStatement(sql);
            ResultSet rs = prepareStament.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                // Represent a row in DB. Key: Column name, Value: Column value
                for (int i = 1; i <= columnCount; i++) {
                    // Note that the index is 1-based
                    String colName = rsmd.getColumnName(i);
                    Object colVal = rs.getObject(i);
                    row.put(colName, colVal);
                }

            }

            return new Object[]{row};
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }
    }