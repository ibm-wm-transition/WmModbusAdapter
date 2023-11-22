package com.wm.adapter.WmModBusAdapter.connection;

import java.io.IOException;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionRequestInfo;
import javax.security.auth.Subject;

import com.wm.adapter.WmModBosAdapter.WmModBosAdapter;
import com.wm.adapter.WmModBosAdapter.WmModBusAdapterConstants;
import com.wm.adk.connection.WmManagedConnection;
import com.wm.adk.error.AdapterConnectionException;
import com.wm.adk.error.AdapterException;
import com.wm.adk.metadata.ResourceDomainValues;
import com.wm.adk.metadata.WmAdapterAccess;

import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.*;
import de.re.easymodbus.server.ModbusServer;

public class WmModBusAdapterConnection extends WmManagedConnection implements WmModBusAdapterConstants{

	// private Connection _sampleConnection = null;
	private String _serverHost = "localhost";
	private String _serverPort = "502";
	ModbusClient modbusClient=null;
	private boolean listenerMode = false;

	public WmModBusAdapterConnection(String serverHost, String serverPort) {
		_serverHost=serverHost;
		_serverPort=serverPort;
	}

	protected void initializeConnection(Subject subject,ConnectionRequestInfo requestInfo) throws ResourceException{

		WmModBosAdapter.retrieveLogger().logInfo(CONNECTION_INITILIZATION);
		try {
			modbusClient = new ModbusClient(_serverHost,Integer.parseInt(_serverPort));
			WmModBosAdapter.retrieveLogger().logInfo(9999,"******* ModBus Client Established to host:"+_serverHost+" port:"+ _serverPort +"**********");
			this.connectModBusServer();
		}
		catch(Exception e) {
			AdapterConnectionException ace = WmModBosAdapter.getInstance().createAdapterConnectionException(
					RESOURCE_CONN_EXCEPTION, null, e);
			ace.setFatal(true);
			throw ace;
		}


	}
	public void connectModBusServer() {
		try
		{
			//	WmModBosAdapter.retrieveLogger().logInfo(9999,"Check point: connectModBusServer() ");
			modbusClient.Connect();
		}
		catch (Exception e)
		{		
			WmModBosAdapter.retrieveLogger().logInfo(9999,e+"");
		}	
	}

	public boolean writeSingleRegisterModBusServer(Integer registerLocation,String registerValue) {
		//WmModBosAdapter.retrieveLogger().logInfo(9999,"Check point: writeModBusServer() " +" registerLocation: "+ registerLocation +" registerValue: "+ registerValue);
		boolean success=true;

		if (registerLocation!=null&&registerValue!="") {
			try {
				boolean fvalue = registerValue.contains(".");

				if(fvalue) {
					modbusClient.WriteMultipleRegisters(registerLocation-1, ModbusClient.ConvertFloatToTwoRegisters(Float.parseFloat(registerValue)));
				}
				else {
					modbusClient.WriteSingleRegister(registerLocation-1, Integer.parseInt(registerValue));
				}
			} catch (NumberFormatException | ModbusException | IOException e) {
				success=false;
				e.printStackTrace();
			}
		}

		return success;

	}
	public boolean writeSingleCoilModBusServer(Integer registerLocation,Boolean registerValue) {
		boolean success=true;
		if (registerLocation!=null&&registerValue!=null) {
			try {

				modbusClient.WriteSingleCoil(registerLocation-1, registerValue);
			} catch (NumberFormatException | ModbusException | IOException e) {
				success=false;
				e.printStackTrace();
			}
		}

		return success;

	}

	public boolean[] readCoilsModBusServer(Integer coilStartingLocation,Integer coilQuantity) {
		boolean[] result = null; 
		if (coilStartingLocation!=null&&coilQuantity!=null) {
			try {

				result=modbusClient.ReadCoils(coilStartingLocation-1, coilQuantity);
			} catch (NumberFormatException | ModbusException | IOException e) {
				result=null;
				e.printStackTrace();
			}
		}

		return result;

	}

	public boolean readSingleCoilModBusServer(Integer coilStartingLocation) {
		boolean[] result = null; 
		if (coilStartingLocation!=null) {
			try {
				result=modbusClient.ReadCoils(coilStartingLocation-1, 1);
			} catch (NumberFormatException | ModbusException | IOException e) {
				result=null;
				e.printStackTrace();
			}
		}

		return result[0];

	}


	public int[] readRegistersModBusServer(Integer registerStartingLocation,Integer registerQuantity) {
		int[] result = null; 
		if (registerStartingLocation!=null&&registerQuantity!=null) {
			try {

				result=modbusClient.ReadHoldingRegisters(registerStartingLocation-1, registerQuantity);
			} catch (NumberFormatException | ModbusException | IOException e) {
				result=null;
				e.printStackTrace();
			}
		}

		return result;

	}

	public Boolean adapterCheckValue(String serviceName,
			String resourceDomainName,
			String[][] values,
			String testValue) throws AdapterException {
		return null;
	}


	public ResourceDomainValues[] adapterResourceDomainLookup(String serviceName, String resourceDomainName, String[][] values)
			throws AdapterException {

		String[] fieldNames = null;
		String[] fieldTypes = null;

		if (resourceDomainName.equals(DOMAIN_FUNCTION_NAMES)) {
			return new ResourceDomainValues[] {
					new ResourceDomainValues(resourceDomainName, new String[]{"ModBus Read/Write Service"})};
		}
		// REMOVED !
		else if (resourceDomainName.equals(DOMAIN_POLLING_NAMES)) {
			return new ResourceDomainValues[] {
					new ResourceDomainValues(resourceDomainName, new String[] {"ModBus Read"})};
		}
		// added for listener notification
		else if (resourceDomainName.equals(DOMAIN_NOTIFICATION_NAME)) {
			return new ResourceDomainValues[] {
					new ResourceDomainValues(resourceDomainName, new String[] {"ModBus Sync Read/Write"})};
		}
		// because input parameters and input field types have been declared as
		// tuple, they are looked up together
		else if (resourceDomainName.equals(GROUP_MEMBER_INPUT_PARAMETER_NAMES) ||
				resourceDomainName.equals(GROUP_MEMBER_INPUT_FIELD_TYPES)) {

			if (serviceName.equals(SERVICE_TEMPLATE)) {
				fieldNames = new String[] {"SingleCoilLocation","SingleCoilValue"};
				fieldTypes = new String[] {"java.lang.String","java.lang.Boolean"};

			} else if (serviceName.equals(SERVICE_REG_TEMPLATE)){
				fieldNames = new String[] {"SingleRegisterLocation","SingleRegisterValue"};
				fieldTypes = new String[] {"java.lang.String","java.lang.String"};

			}
			else if (serviceName.equals(SERVICE_READ_COIL_TEMPLATE)){
				fieldNames = new String[] {"StartingCoilAddress","Quantity"};
				fieldTypes = new String[] {"java.lang.String","java.lang.String"};

			}
			else if (serviceName.equals(SERVICE_READ_REG_TEMPLATE)){
				fieldNames = new String[] {"StartingHoldingRegisterAddress","Quantity"};
				fieldTypes = new String[] {"java.lang.String","java.lang.String"};

			}else if (serviceName.equals(COIL_SYNC_TEMPLATE)) {
				fieldNames = new String[] {"CoilAddress"};
				fieldTypes = new String[] {"java.lang.String"};

			}
			else {
				fieldNames = new String[] {};
				fieldTypes = new String[] {};

			}
			return new ResourceDomainValues[] {
					new ResourceDomainValues(GROUP_MEMBER_INPUT_PARAMETER_NAMES, fieldNames),
					new ResourceDomainValues(GROUP_MEMBER_INPUT_FIELD_TYPES, fieldTypes)};
		}
		else if (resourceDomainName.equals(GROUP_MEMBER_OUTPUT_PARAMETER_NAMES) ||
				resourceDomainName.equals(GROUP_MEMBER_OUTPUT_FIELD_TYPES)) {

			if (serviceName.equals(SERVICE_TEMPLATE)) {
				fieldNames = new String[] {"success"};
				fieldTypes = new String[] {"java.lang.String"};
			} 
			else if (serviceName.equals(COIL_SYNC_TEMPLATE)) {
				WmModBosAdapter.retrieveLogger().logInfo(9999,"I am COIL_SYNC_TEMPLATE() ");
				fieldNames = new String[] {"coilRead[].coilValue","coilRead[].coilLocation"};
				fieldTypes = new String[] {"java.lang.Object[]","java.lang.Object[]" };


			}
			else if (serviceName.equals(COIL_ASYNC_TEMPLATE)) {
				WmModBosAdapter.retrieveLogger().logInfo(9999,"I am COIL_ASYNC_TEMPLATE() ");
				fieldNames = new String[] {"coilRead[].coilValue","coilRead[].coilLocation"};
				fieldTypes = new String[] {"java.lang.Object[]","java.lang.Object[]" };


			}
			else {
				//degistir!
				fieldNames = new String[] {"readBuffer","bytesRead"};
				fieldTypes = new String[] {"java.lang.Object","java.lang.String"};
			}
			return new ResourceDomainValues[] {
					new ResourceDomainValues(GROUP_MEMBER_OUTPUT_FIELD_TYPES, fieldTypes),
					new ResourceDomainValues(GROUP_MEMBER_OUTPUT_FIELD_NAMES, fieldNames),
					new ResourceDomainValues(GROUP_MEMBER_OUTPUT_PARAMETER_NAMES, fieldNames)};
		}
		else
			return null;
	}


	public void destroyConnection() throws ResourceException {
		WmModBosAdapter.retrieveLogger().logDebug(CONNECTION_DESTROY);
		try {
			modbusClient.Disconnect();
			modbusClient = null;
		} catch (IOException e) {
			WmModBosAdapter.retrieveLogger().logError(CLOSE_CONNECTION_EXCEPTION, new String[] { e.getLocalizedMessage() });
			AdapterConnectionException ace =
					WmModBosAdapter.getInstance().createAdapterConnectionException(
							RESOURCE_CONN_EXCEPTION, null, e);
		}

	}
	/*
	 * Specifies that initialization is required immediately after a connection
	 * is created for the first time.
	 */
	protected boolean initializationRequired() {
		//	WmModBosAdapter.retrieveLogger().logInfo(9999,"Check point: initializationRequired() ");
		return true;
	}

	public void registerResourceDomain(WmAdapterAccess access) throws AdapterException {

		try 
		{
			// register all the resource domain look up here
			access.addResourceDomainLookup(null, DOMAIN_FUNCTION_NAMES, this);
			access.addResourceDomainLookup(null, DOMAIN_INPUT_PARAMETER_NAMES, this);
			access.addResourceDomainLookup(null, DOMAIN_INPUT_FIELD_TYPES, this);
			access.addResourceDomainLookup(null, DOMAIN_INPUT_FIELD_NAMES, this);
			access.addResourceDomainLookup(null, DOMAIN_OUTPUT_PARAMETER_NAMES, this);
			access.addResourceDomainLookup(null, DOMAIN_OUTPUT_FIELD_TYPES, this);
			access.addResourceDomainLookup(null, DOMAIN_OUTPUT_FIELD_NAMES, this);
			access.addResourceDomainLookup(null, DOMAIN_POLLING_NAMES, this);
			access.addResourceDomainLookup(null, DOMAIN_NOTIFICATION_NAME, this);
		} catch (Exception ex) {
			throw WmModBosAdapter.getInstance().createAdapterException(1002, ex);
		}

	}

	//check this one more
	public void setToListenerMode(boolean flag) throws AdapterConnectionException {
		ModbusServer ser = new ModbusServer();
		try {
			ser.Listen();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (listenerMode != flag) {
			this.setToListenerMode(flag);
			listenerMode = flag;
		}
		return;
	}

}
