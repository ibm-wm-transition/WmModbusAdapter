package com.wm.adapter.WmModBusAdapter.connection;

import java.util.Locale;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionRequestInfo;
import javax.security.auth.Subject;

import com.wm.adapter.WmModBosAdapter.WmModBosAdapter;
import com.wm.adapter.WmModBosAdapter.WmModBusAdapterConstants;
import com.wm.adapter.WmModBusAdapter.service.ModBusCoilRead;
import com.wm.adapter.WmModBusAdapter.service.ModBusRegisterRead;
import com.wm.adapter.WmModBusAdapter.service.ModBusRegisterWrite;
import com.wm.adapter.WmModBusAdapter.service.ModBusWrite;
import com.wm.adk.connection.WmManagedConnection;
import com.wm.adk.connection.WmManagedConnectionFactory;
import com.wm.adk.error.AdapterException;
import com.wm.adk.info.ResourceAdapterMetadataInfo;
import com.wm.adk.metadata.WmDescriptor;

public class WmModBusAdapterConnectionFactory extends WmManagedConnectionFactory implements WmModBusAdapterConstants {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modBusServerHostName = "localhost";
	private String modBusServerPortNumber = "502";


	public String getModBusServerPortNumber() {
		return modBusServerPortNumber;
	}

	public void setModBusServerPortNumber(String modBusServerPortNumber) {
		this.modBusServerPortNumber = modBusServerPortNumber;
	}

	public String getModBusServerHostName() {
		return modBusServerHostName;
	}

	public void setModBusServerHostName(String modBusServerHostName) {
		this.modBusServerHostName = modBusServerHostName;
	}



	public WmManagedConnection createManagedConnectionObject(Subject subject, ConnectionRequestInfo connectionRequestInfo)
			throws ResourceException {
		//WmModBosAdapter.retrieveLogger().logInfo(9999, "Check point: createManagedConnectionObject ");
		return new WmModBusAdapterConnection(modBusServerHostName, modBusServerPortNumber);
	}


	public void fillResourceAdapterMetadataInfo(ResourceAdapterMetadataInfo info, Locale locale) throws AdapterException {

		WmModBosAdapter.getInstance().fillResourceAdapterMetadataInfo(info, locale);
		info.addServiceTemplate(ModBusWrite.class.getName());
		info.addServiceTemplate(ModBusRegisterWrite.class.getName());
		info.addServiceTemplate(ModBusCoilRead.class.getName());
		info.addServiceTemplate(ModBusRegisterRead.class.getName());
	}


	public void fillWmDescriptor(WmDescriptor d, Locale l) throws AdapterException {

		d.createGroup(MODBUS_CONNECTION,
				new String[] {MODBUS_SERVER_HOST_NAME, MODBUS_SERVER_PORT_NUMBER });

		d.setMinStringLength(MODBUS_SERVER_HOST_NAME, 1);
		d.setMinStringLength(MODBUS_SERVER_PORT_NUMBER, 1);

		d.setDescriptions(
				WmModBosAdapter.getInstance().getAdapterResourceBundleManager(), l); 
	}

}
