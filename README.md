
# AdvancedPeripherals

![Logo](https://www.bisecthosting.com/images/CF/Advanced_Peripherals/BH_AP_Header.png "Logo")

# advanced-peripheral-personal

[This repository is a clone of AdvancedPeripherals](https://github.com/Seniorendi/AdvancedPeripherals)

This is my small implementation to advanced peripheral mod. Advanced Peripherals is a mod that adds many useful extensions for ComputerCraft. The mod aims to add features that were
available in 1.12.2 of mods like PeripheralsPlusOne.



New events to refined storage pheriperal:

| Event       | Name        | Parameter 1 | Parameter 2 | Description                                                  |
|-------------|-------------|-------------|-------------|--------------------------------------------------------------|
| rs_crafting | rs_crafting | String name | int count   | Fires when a new crafting request in refined storage network |


New methods to computercraft:

| Method | Block | Return | Description |
|-------------|-------------|-------------|-------------|
| listCraftingItems() | rsBridge | table | return list with all crafting in execution |
| Connect(String databaseLink,String username, String password) | SqlBridge | boolean |  return boolean if sucess or false if gets error  |
| queryResult(string sql query) | SqlBridge | table | return a table with sql return |
| queryExec(string sql query) | SqlBridge | boolean | return boolean if sucess or false if gets error |




Original Documentation: https://docs.srendi.de

