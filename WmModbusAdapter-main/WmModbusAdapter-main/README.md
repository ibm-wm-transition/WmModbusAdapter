# WmModbusAdapter
Webmethods Modbus Adapter

Modbus Adapter version 1.0

Capabilities: 

# 1 Modbus Connection

# 2 Modbus Service
+ Write Single Coil
- Write Single Register
+ Read Coils
- Read Registers

# 3 Modbus Listener 
+ Synchronous Coil Listener
- Asynchronous Coil Listener
 
 Tested with 
 https://sourceforge.net/projects/easymodbustcpserver/ 
 
 **1. ModBus Connection**
 
**2. ModBusAdapter Service**
 
 WmModBus Adapter had 4 different capabilities. You can read and Write coils and Registers. 
 
 - Write Single Coil
 + Write Single Register
 - Read Coils
 + Read Registers
 
 ![image](https://media.github.softwareag.com/user/3346/files/4c77e653-cca3-49e0-ab1b-80b32ad5c9f7)

Modbus Adapter Service gives you flexibility to read or write any type or amount of data.

For that, You need to provide 2 inputs. 

1. the starting point
2. Number of coils or registers that you want to read/write.
 
 ![image](https://media.github.softwareag.com/user/3346/files/5736d6fc-1213-4468-862a-13c122d93447)

