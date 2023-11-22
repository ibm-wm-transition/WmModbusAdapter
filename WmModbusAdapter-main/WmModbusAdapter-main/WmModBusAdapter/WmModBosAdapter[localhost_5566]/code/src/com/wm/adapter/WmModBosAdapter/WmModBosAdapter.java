package com.wm.adapter.WmModBosAdapter;

import java.util.Locale;


import com.wm.adapter.WmModBusAdapter.connection.WmModBusAdapterConnectionFactory;
import com.wm.adapter.WmModBusAdapter.listener.CoilListener;
import com.wm.adapter.WmModBusAdapter.listener.CoilListenerAsyncNotification;
import com.wm.adapter.WmModBusAdapter.listener.CoilListenerSyncNotification;
import com.wm.adk.WmAdapter;
import com.wm.adk.error.AdapterException;
import com.wm.adk.info.AdapterTypeInfo;
import com.wm.adk.log.ARTLogger;

public class WmModBosAdapter extends WmAdapter implements WmModBusAdapterConstants {

	private static ARTLogger _logger;
	private static WmModBosAdapter _instance = null;


	public WmModBosAdapter() throws AdapterException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cleanup()
	{
		if (_logger != null)
			_logger.close();
	} 

	public static ARTLogger retrieveLogger()
	{
		return _logger;
	}

	@Override
	public void fillAdapterTypeInfo(AdapterTypeInfo info, Locale locale) {
		info.addConnectionFactory(WmModBusAdapterConnectionFactory.class.getName());
		info.addListenerType(CoilListener.class.getName());
		info.addNotificationType(CoilListenerSyncNotification.class.getName());
		info.addNotificationType(CoilListenerAsyncNotification.class.getName());	
	}

	@Override
	public String getAdapterJCASpecVersion() {
		return ADAPTER_JCA_VERSION;
	}

	@Override
	public int getAdapterMajorCode() {
		return ADAPTER_MAJOR_CODE;
	}

	@Override
	public String getAdapterName() {
		return ADAPTER_NAME;
	}

	@Override
	public String getAdapterResourceBundleName() {
		return ADAPTER_SOURCE_BUNDLE_NAME;
	}

	@Override
	public String getAdapterVersion() {
		return ADAPTER_VERSION;
	}

	@Override
	public void initialize() throws AdapterException {
		_logger = new ARTLogger(getAdapterMajorCode(), 
				getAdapterName(), 
				getAdapterResourceBundleName());

	}
	public static WmModBosAdapter getInstance() {
		synchronized(WmModBosAdapter.class) {
			if (_instance != null) {
				return _instance;
			}

			try {
				_instance = new WmModBosAdapter();
				return _instance;
			} catch (Throwable t) {
				t.printStackTrace();
				return null;
			}
		}
	}

}
