package com.wm.adapter.WmModBosAdapter;

import java.util.ListResourceBundle;
import com.wm.adk.ADKGLOBAL;

public class WmModBosAdapterResourceBundle extends ListResourceBundle implements WmModBusAdapterConstants {

	static final String IS_PKG_NAME = "/WmModBosAdapter/";
	private static final String OH_DEFAULT="doc/OnlineHelp/AdapterOH.html";

	static final Object[][] _contents = {
			// adapter type display name.
			{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "ModBus Adapter"}
			// adapter type descriptions.
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "Adapter for Client connection to ModBus Server "}
			// adapter type vendor.
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_VENDORNAME, "Software AG"}
			//Copyright URL Page
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_THIRDPARTYCOPYRIGHTURL, IS_PKG_NAME + "copyright.html"}
			//Copyright Encoding
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_COPYRIGHTENCODING, "UTF-8"}
			//About URL Page
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_ABOUT, IS_PKG_NAME + "About.html"}
			//Release Notes URL Page
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_RELEASENOTEURL, IS_PKG_NAME + "ReleaseNotes.html"}

			//The online help link to the adapter's "help" information.
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL, 
				IS_PKG_NAME + OH_DEFAULT}

			//The online help link to the adapter's "about" information.
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_ABOUT + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL, 
				IS_PKG_NAME + OH_DEFAULT}

			// online help link to the connection types supported. 
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_LISTCONNECTIONTYPES + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL, 
				IS_PKG_NAME + OH_DEFAULT}
			// online help link to adapter's list of connections (backend resource)
			,{ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_LISTRESOURCES + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL, 
				IS_PKG_NAME + OH_DEFAULT}
			// online help link to adapter's list of listener
			, { ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_LISTLISTENERS + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL,
				IS_PKG_NAME + OH_DEFAULT }
			// online help link to adapter's list of listener types
			, { ADAPTER_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_LISTLISTENERTYPES + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL,
				IS_PKG_NAME + OH_DEFAULT }

			// the connection type display name.
			,{CONNECTION_TYPE + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME,
			"ModBus  Server Connection"}
			// the connection type description.
			,{CONNECTION_TYPE + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"connection for ModBus server"}
			// connection type online help link. 
			,{CONNECTION_TYPE + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL,
				IS_PKG_NAME + OH_DEFAULT}

			,{MODBUS_CONNECTION + ADKGLOBAL.RESOURCEBUNDLEKEY_GROUP, "ModBus Connection" }
			,{MODBUS_CONNECTION + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "Connection to a ModBus Server" }
			,{MODBUS_SERVER_HOST_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "ModBus Server Hostname" }
			,{MODBUS_SERVER_HOST_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "ModBus Server hostname" }
			,{MODBUS_SERVER_PORT_NUMBER + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "ModBus Server Port" }
			,{MODBUS_SERVER_PORT_NUMBER + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "ModBus Server port" }


			// for Enquiry and Transaction service template
			,{SERVICE_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Write Single Coil" },
			{SERVICE_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "Write Single Coil to ModBus Server" },
			{SERVICE_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL,
				IS_PKG_NAME + OH_DEFAULT },
			{ SERVICE_REG_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Write Single Register" },
			{ SERVICE_REG_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "Write Single Register to ModBus Server" },
			{ SERVICE_REG_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL,
				IS_PKG_NAME + OH_DEFAULT }
			,{SERVICE_READ_COIL_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Read Coils" },
			{SERVICE_READ_COIL_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "Read Coils from ModBus Server" },
			{SERVICE_READ_COIL_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL,
				IS_PKG_NAME + OH_DEFAULT },
			{ SERVICE_READ_REG_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Read Registers" },
			{ SERVICE_READ_REG_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "Read Register from ModBus Server" },
			{ SERVICE_READ_REG_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL,
				IS_PKG_NAME + OH_DEFAULT }

			// property for service template
			,{GROUP_MEMBER_SERVICE_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "ModBus Service Name" }
			,{GROUP_MEMBER_SERVICE_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "ModBus server service name" },

			// properties for both adapter service template and
			// message polling notification template
			{ GROUP_MEMBER_INPUT_PARAMETER_NAMES + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Input Parameter" },
			{ GROUP_MEMBER_INPUT_PARAMETER_NAMES + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Input for Sample server function invocation" },
			{ GROUP_MEMBER_INPUT_FIELD_NAMES + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Input Field" },
			{ GROUP_MEMBER_INPUT_FIELD_NAMES + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Input for Sample server function invocation" },
			{ GROUP_MEMBER_INPUT_FIELD_TYPES + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Input Field Type" },
			{ GROUP_MEMBER_INPUT_FIELD_TYPES + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Input type for Sample server function invocation" },
			{ GROUP_MEMBER_OUTPUT_PARAMETER_NAMES + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Output Parameter" },
			{ GROUP_MEMBER_OUTPUT_PARAMETER_NAMES + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Output for Sample server function invocation" },
			{ GROUP_MEMBER_OUTPUT_FIELD_NAMES + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Output Field" },
			{ GROUP_MEMBER_OUTPUT_FIELD_NAMES + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Output for Sample server function invocation" },
			{ GROUP_MEMBER_OUTPUT_FIELD_TYPES + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Output Field Type" },
			{ GROUP_MEMBER_OUTPUT_FIELD_TYPES + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Output type for Sample server function invocation" }

			, { LISTENER_TYPE + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Modbus Server Listener" },
			{ LISTENER_TYPE + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "Listener for Modbus server notification" },
			{ LISTENER_TYPE + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL,
				IS_PKG_NAME + OH_DEFAULT }


			// REMOVED added support polling notification
			// for message polling notification template
			// for message polling group NOT USED
			, { GROUP_MESSAGE_POLLING + ADKGLOBAL.RESOURCEBUNDLEKEY_GROUP, "Message Polling" },
			{ GROUP_MESSAGE_POLLING + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Poll on Sample server for notification message" }

			// properties for message listener notification template
			, { GROUP_MEMBER_POLLING_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Monitor" },
			{ GROUP_MEMBER_POLLING_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "ModBus server polling event name" },
			{ GROUP_MEMBER_INPUT_FIELD_VALUES + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Coil Location" },
			{ GROUP_MEMBER_INPUT_FIELD_VALUES + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Input for ModBus server Coil Listener" },
			{ COIL_SYNC_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME,
			"Synchronous Coil Listener" },
			{ COIL_SYNC_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Synchronously process the ModBus server  Coil Listener notification message" },
			{ COIL_ASYNC_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME,
			"Asynchronous Coil Listener" },
			{ COIL_ASYNC_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"Asynchronously process the ModBus server  Coil Listener notification message" },
			{ COIL_SYNC_TEMPLATE + ADKGLOBAL.RESOURCEBUNDLEKEY_HELPURL,
				IS_PKG_NAME + OH_DEFAULT }
			// for asynchronous listener notification group
			, { GROUP_ASYNC_LISTENING + ADKGLOBAL.RESOURCEBUNDLEKEY_GROUP, "Listener Notification" },
			{ GROUP_ASYNC_LISTENING + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION, "Listener notification" }

			// properties for asynchronous listener notification template
			, { GROUP_NOTIFICATION_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DISPLAYNAME, "Monitor" },
			{ GROUP_NOTIFICATION_NAME + ADKGLOBAL.RESOURCEBUNDLEKEY_DESCRIPTION,
			"ModBus server notification listener name" }


			// adapter logging message
			, { Integer.toString(CONNECTION_INITILIZATION), "Initializing Modbus Connection" },
			{ Integer.toString(CONNECTION_DESTROY), "Destroying Modbus Connection" },
			{ Integer.toString(CLOSE_CONNECTION_EXCEPTION), "Error while closing Modbus Connection: \"{0}\"." },
			{ Integer.toString(ERROR), "Error: \"{0}\"." }

			// adapter exception messages
			, { Integer.toString(RESOURCE_CONN_EXCEPTION), "Resource Connection Exception:" }
			,{"9999", "ModBus Adapter Info: \"{0}\"."}
			, { Integer.toString(RESOURCE_DOMAIN_EXCEPTION), "Register Resource Domain Exception:" },
			{ Integer.toString(INVALID_INPUT_PARAMETER), "Invalid Input Parameters" },
			{ Integer.toString(RESOURCE_DOMAIN_LOOKUP), "Look up the resource domain \"{0}\" : \"{1}\"." }

			, { Integer.toString(SERVICE_EXCEPTION), "Service Exception: \"{0}\"." }

			, { Integer.toString(POLLING_NOTIFICATION_EXCEPTION), "Message Polling Exception: \"{0}\"." }

			, { Integer.toString(LISTENER_CONN_EXCEPTION), "Resource Listener Connection Exception:" },
			{ Integer.toString(LISTENER_NOTIFICATION_EXCEPTION), "Listener Notification Exception:" },
			{ Integer.toString(SYNCHRONOUS_NOTIFICATION), "Synchronous notification: \"{0}\"." },
			{ Integer.toString(ASYNCHRONOUS_NOTIFICATION), "ASynchronous notification: \"{0}\"." },
			{ Integer.toString(LISTENER_NOTIFICATION_NOT_AVAILABLE),
			"There is no enabled notification for listener: \"{0}\"." }
	};

	public Object[][] getContents() {
		// TODO Auto-generated method stub
		return _contents;
	}

}
