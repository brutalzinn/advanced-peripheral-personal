
# AdvancedPeripherals

![Logo](https://www.bisecthosting.com/images/CF/Advanced_Peripherals/BH_AP_Header.png "Logo")

# advanced-peripheral-personal

[This repository is a clone of AdvancedPeripherals](https://github.com/Seniorendi/AdvancedPeripherals)

This is my small implementation to advanced peripheral mod. Advanced Peripherals is a mod that adds many useful extensions for ComputerCraft. The mod aims to add features that were
available in 1.12.2 of mods like PeripheralsPlusOne.


Current new methods to computercraft:

Refined Storage implementation

New events to refined storage pheriperal:

| Event       | Name        | Parameter 1 | Parameter 2 | Description                                                  |
|-------------|-------------|-------------|-------------|--------------------------------------------------------------|
| rs_crafting | rs_crafting | String name | int count   | Fires when a new crafting request in refined storage network |

> How to read this list: methodname(params):return

New refined storage pheriperal methods: 

listCraftableItems() for refined storage pheriperal: table 

New block Sql Bridge -> You can execute queries to mysql directily from minecraft!

Sql Bridge methods:

Connect(String databaseLink,String username, String password): bool

queryResult(string sql query) for sql bridge pheriperal: table

queryExec(string sql query)for sql bridge pheriperal: boolean


Original Documentation: https://docs.srendi.de

