package com.wm.adapter.WmModBosAdapter;

import com.wm.adapter.WmModBusAdapter.connection.WmModBusAdapterConnectionFactory;
import com.wm.adapter.WmModBusAdapter.listener.CoilListener;
import com.wm.adapter.WmModBusAdapter.listener.CoilListenerAsyncNotification;
import com.wm.adapter.WmModBusAdapter.listener.CoilListenerSyncNotification;
import com.wm.adapter.WmModBusAdapter.service.ModBusCoilRead;
import com.wm.adapter.WmModBusAdapter.service.ModBusRegisterRead;
import com.wm.adapter.WmModBusAdapter.service.ModBusRegisterWrite;
import com.wm.adapter.WmModBusAdapter.service.ModBusWrite;


public interface WmModBusAdapterConstants {

	static final int ADAPTER_MAJOR_CODE = 9001;
	static final String ADAPTER_JCA_VERSION = "1.0";
	static final String ADAPTER_NAME = "WmModBusAdapter";
	static final String ADAPTER_VERSION = "9.12";

	//Using next statement creates cyclic class loading dependency issue
	//therefore, the resource bundle class name is fully spelled out
	//static final String ADAPTER_SOURCE_BUNDLE_NAME = MyAdapterResource.class.getName();
	static final String ADAPTER_SOURCE_BUNDLE_NAME ="com.wm.adapter.WmModBosAdapter.WmModBosAdapterResourceBundle";
	static final String SERVICE_TEMPLATE = ModBusWrite.class.getName();
	static final String SERVICE_REG_TEMPLATE = ModBusRegisterWrite.class.getName();
	static final String SERVICE_READ_COIL_TEMPLATE = ModBusCoilRead.class.getName();
	static final String SERVICE_READ_REG_TEMPLATE = ModBusRegisterRead.class.getName();
	static final String COIL_SYNC_TEMPLATE = CoilListenerSyncNotification.class.getName();
	static final String COIL_ASYNC_TEMPLATE = CoilListenerAsyncNotification.class.getName();
	// added at Phase 3 to support service template
	//static final String ENQUIRY_SERVICE_TEMPLATE = AccountEnquiry.class.getName();
	//static final String TRANSACTION_SERVICE_TEMPLATE = AccountTransaction.class.getName();

	// added at Phase 4 to support polling notification
	//static final String POLLING_TEMPLATE = MessagePolling.class.getName();

	// added at Phase 5 to support listener notification
	static final String LISTENER_TYPE = CoilListener.class.getName();
	//static final String ASYNCHRONOUS_NOTIFICATION_TEMPLATE = AsyncListening.class.getName();
	//static final String SYNCHRONOUS_NOTIFICATION_TEMPLATE = SynListener.class.getName();
	static final String CONNECTION_TYPE =WmModBusAdapterConnectionFactory.class.getName();

	static final String MODBUS_CONNECTION = "ModBusServerConnection";
	static final String MODBUS_SERVER_HOST_NAME = "modBusServerHostName";
	static final String MODBUS_SERVER_PORT_NUMBER = "modBusServerPortNumber";



	// Logging key
	public static final int CONNECTION_INITILIZATION = 101;
	public static final int CONNECTION_DESTROY = 102;
	public static final int CLOSE_CONNECTION_EXCEPTION = 103;
	public static final int ERROR = 104;

	// added at Phase 2 to support the connection
	public static final int RESOURCE_CONN_EXCEPTION = 105;
	// added at Phase 3 to support adapter services
	public static final int RESOURCE_DOMAIN_EXCEPTION = 1001;
	public static final int INVALID_INPUT_PARAMETER = 1002;
	public static final int RESOURCE_DOMAIN_LOOKUP = 1003;
	public static final int SERVICE_EXCEPTION = 2001;

	// added at Phase 4 to support polling notification
	public static final int POLLING_NOTIFICATION_EXCEPTION = 3001;


	// added at Phase 5 to support listener notification
	public static final int LISTENER_CONN_EXCEPTION = 4001;
	public static final int LISTENER_NOTIFICATION_EXCEPTION = 5001;
	public static final int SYNCHRONOUS_NOTIFICATION = 5002;
	public static final int ASYNCHRONOUS_NOTIFICATION = 5004;
	public static final int LISTENER_NOTIFICATION_NOT_AVAILABLE = 5003;


	// properties for both the adapter service
	// and the message polling notification
	// properties for both the adapter service
	// and the message polling notification
	static final String GROUP_FUNCTION_INVOCATION = "ModBusServerWrite";
	static final String GROUP_MEMBER_FUNCTION_NAME = "functionName";

	// added at Phase 3 to support service template
	// properties for both the adapter service
	// and the message polling notification
	static final String GROUP_MEMBER_INPUT_PARAMETER_NAMES = "inputParameterNames";
	static final String GROUP_MEMBER_INPUT_FIELD_NAMES = "inputFieldNames";
	static final String GROUP_MEMBER_INPUT_FIELD_TYPES = "inputFieldTypes";
	static final String GROUP_MEMBER_OUTPUT_PARAMETER_NAMES = "outputParameterNames";
	static final String GROUP_MEMBER_OUTPUT_FIELD_NAMES = "outputFieldNames";
	static final String GROUP_MEMBER_OUTPUT_FIELD_TYPES = "outputFieldTypes";

	// added at Phase 3 to support service template
	// resource domain, names for both the adapter service
	// and the message polling notification configuration
	/*
		static final String INPUT_PARAMETER_NAMES_RD = "inputParameterNamesRD";
		static final String INPUT_FIELD_NAMES_RD = "inputFieldNamesRD";
		static final String INPUT_FIELD_TYPES_RD = "inputFieldTypesRD";
		static final String OUTPUT_PARAMETER_NAMES_RD = "outputParameterNamesRD";
		static final String OUTPUT_FIELD_NAMES_RD = "outputFieldNamesRD";
		static final String OUTPUT_FIELD_TYPES_RD = "outputFieldTypesRD";
	 */

	static final String GROUP_MESSAGE_POLLING = "ModBusServerAsynRead";
	static final String GROUP_MEMBER_POLLING_NAME = "pollingName";
	static final String GROUP_MEMBER_INPUT_FIELD_VALUES = "inputFieldValues";
	static final String DOMAIN_FUNCTION_NAMES = "functionNames";


	static final String DOMAIN_INPUT_PARAMETER_NAMES = "inputParameterNames";
	static final String DOMAIN_INPUT_FIELD_NAMES = "inputFieldNames";
	static final String DOMAIN_INPUT_FIELD_TYPES = "inputFieldTypes";
	static final String DOMAIN_OUTPUT_PARAMETER_NAMES = "outputParameterNames";
	static final String DOMAIN_OUTPUT_FIELD_NAMES = "outputFieldNames";
	static final String DOMAIN_OUTPUT_FIELD_TYPES = "outputFieldTypes";
	static final String DOMAIN_POLLING_NAMES = "pollingNames";
	static final String DOMAIN_NOTIFICATION_NAME = "notificationName";
	static final String GROUP_MEMBER_SERVICE_NAME="serviceName";





	// added at Phase 4 to support polling notification
	// resource domain, names for message polling notification configuration
	//	static final String POLLING_NAMES_RD = "pollingNamesRD";
	//	static final String FUNCTION_NAMES_RD = "functionNamesRD";
	// added at Phase 5 to support listener notification
	// group and properties for listener notification template
	static final String GROUP_ASYNC_LISTENING = "AsynchronousListening";
	static final String GROUP_SYNC_LISTENING = "SynchronousListening";
	static final String GROUP_MEMBER_EVENT_NAME = "eventName";
	static final String GROUP_NOTIFICATION_NAME = "notificationName";
	static final String GROUP_ASYN_NOTIFICATION_NAME = "asyncNotificationName";
	// added at Phase 5 to support listener notification
	// resource domain, names for listener notification configuration
	//static final String DOMAIN_NOTIFICATION_NAMES = "notificationNamesRD";
}
