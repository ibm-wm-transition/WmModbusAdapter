package com.wm.adapter.WmModBusAdapter.listener;

import java.util.List;
import java.util.Locale;

import javax.resource.ResourceException;

import com.wm.adapter.WmModBosAdapter.WmModBosAdapter;
import com.wm.adapter.WmModBosAdapter.WmModBusAdapterConstants;
import com.wm.adapter.WmModBusAdapter.connection.WmModBusAdapterConnection;
import com.wm.adk.metadata.WmDescriptor;
import com.wm.adk.notification.ClusterAware;
import com.wm.adk.notification.WmConnectedListener;
import com.wm.adk.notification.WmNotification;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;
import com.wm.lang.ns.NSName;

public class CoilListener extends WmConnectedListener implements ClusterAware, WmModBusAdapterConstants {

	//This class is not been used!!!!

	private static final String cacheManagerName = "ModBusCache";
	private static final String cacheName = "Coils";

	@Override
	public void fillWmDescriptor(WmDescriptor d, Locale l) throws ResourceException {
		d.setDescriptions(WmModBosAdapter.getInstance().getAdapterResourceBundleManager(), l);

	}

	@Override
	public void listenerShutdown() {
		try {
			((WmModBusAdapterConnection) retrieveConnection()).destroyConnection();
		} catch (ResourceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void listenerStartup() throws ResourceException {
		//	WmModBosAdapter.retrieveLogger().logDebug(9999, "Check point: in listenerStartup() ");
		((WmModBusAdapterConnection)retrieveConnection()).connectModBusServer();

	}

	@Override
	public Object waitForData() throws ResourceException {
		//WmModBosAdapter.retrieveLogger().logDebug(9999, "Check point: in waitForData() ");
		List notifications = getRegisteredNotifications();
		int numberOfNotifications = notifications.size();
		while (numberOfNotifications > 0) {
			// Get last notification in list
			WmNotification last = (WmNotification) notifications.get(numberOfNotifications - 1);
			if (((WmNotification) last).enabled())
				break;
			numberOfNotifications--;
		}

		if (numberOfNotifications == 0) {
			WmModBosAdapter.retrieveLogger().logInfo(LISTENER_NOTIFICATION_NOT_AVAILABLE,
					new String[] { this._listenerNodeName.getFullName() });
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ie) {
			}
			return null;
		}


		WmModBusAdapterConnection success=null;
		success = (WmModBusAdapterConnection) retrieveConnection();
		return success;
	}



}

