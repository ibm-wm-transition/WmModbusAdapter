package com.wm.adapter.WmModBusAdapter.listener;

import java.util.Locale;

import javax.resource.ResourceException;

import com.wm.adapter.WmModBosAdapter.WmModBosAdapter;
import com.wm.adapter.WmModBosAdapter.WmModBusAdapterConstants;
import com.wm.adapter.WmModBusAdapter.connection.WmModBusAdapterConnection;
import com.wm.adk.cci.record.WmRecord;
import com.wm.adk.cci.record.WmRecordFactory;
import com.wm.adk.error.AdapterException;
import com.wm.adk.metadata.WmTemplateDescriptor;
import com.wm.adk.notification.ClusterAware;
import com.wm.adk.notification.NotificationEvent;
import com.wm.adk.notification.NotificationResults;
import com.wm.adk.notification.SyncNotificationResults;
import com.wm.adk.notification.WmSyncListenerNotification;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;

public class CoilListenerSyncNotification extends WmSyncListenerNotification implements ClusterAware, WmModBusAdapterConstants {

	// eventName property
	private String notificationName;

	// outputParameterNames property
	private String[] inputParameterNames;


	// outputFieldTypes property
	private String[] inputFieldTypes;
	private String[] inputFieldValues;
	private String[] inputFieldNames;

	// outputParameterNames property
	private String[] outputParameterNames;

	// outputFieldNames property
	private String[] outputFieldNames;

	// outputFieldTypes property
	private String[] outputFieldTypes;

	/*
	 * Set eventName property value
	 *
	 * eventName is Sample Server service event name
	 */
	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}

	/*
	 * Get eventName property value
	 *
	 * return Sample Server service event name
	 */
	public String getNotificationName() {
		return this.notificationName;
	}

	public void setInputParameterNames(String[] inputParameterNames) {
		this.inputParameterNames = inputParameterNames;
	}

	public String[] getInputParameterNames() {
		return inputParameterNames;
	}

	public void setInputFieldValues(String[] inputFieldValues) {
		this.inputFieldValues = inputFieldValues;
	}

	public String[] getInputFieldValues() {
		return inputFieldValues;
	}

	public void setInputFieldTypes(String[] inputFieldTypes) {
		this.inputFieldTypes = inputFieldTypes;
	}

	public String[] getInputFieldTypes() {
		return inputFieldTypes;
	}
	public void setInputFieldNames(String[] inputFieldNames) {
		this.inputFieldNames = inputFieldNames;
	}

	public String[] getInputFieldNames() {
		return inputFieldNames;
	}

	/*
	 * Set outputParameterNames property value
	 *
	 * outputParameterName are Sample Server service invocation output parameter
	 * names. These parameters reflect the fully qualified structure names
	 */
	public void setOutputParameterNames(String[] outputParameterNames) {
		this.outputParameterNames = outputParameterNames;
	}

	/*
	 * Get outputParameterNames property value
	 *
	 * return Sample Server service invocation output parameter names. These
	 * parameters reflect the fully qualified structure names
	 */
	public String[] getOutputParameterNames() {
		return this.outputParameterNames;
	}

	/*
	 * Set outputFieldNames property value
	 *
	 * outputFieldNames are Sample Server service invocation output field names.
	 * These names are used to build the output signature
	 */
	public void setOutputFieldNames(String[] outputFieldNames) {
		this.outputFieldNames = outputFieldNames;
	}

	/*
	 * Get outputFieldNames property value
	 *
	 * return Sample Server service invocation output field names. These names
	 * are used to build the output signature
	 */
	public String[] getOutputFieldNames() {
		return this.outputFieldNames;
	}

	/*
	 * Set outputFieldTypes property value
	 *
	 * outputFieldTypes are Sample Server service invocation output field types.
	 * These types are used to build the output signature
	 */
	public void setOutputFieldTypes(String[] outputFieldTypes) {
		this.outputFieldTypes = outputFieldTypes;
	}

	/*
	 * Get outputFieldTypes property value
	 *
	 * return Sample Server service invocation output field types. These types
	 * are used to build the output signature
	 */
	public String[] getOutputFieldTypes() {
		return this.outputFieldTypes;
	}
	@Override
	public boolean supports(Object o) throws ResourceException {
		return true;
	}

	@Override
	public void fillWmTemplateDescriptor(WmTemplateDescriptor d, Locale l) throws ResourceException {
		// create a group, essentially a tab in Designer
		d.createGroup(GROUP_SYNC_LISTENING,
				new String[] {GROUP_NOTIFICATION_NAME,
						GROUP_MEMBER_INPUT_PARAMETER_NAMES,
						GROUP_MEMBER_INPUT_FIELD_NAMES,
						GROUP_MEMBER_INPUT_FIELD_TYPES,
						GROUP_MEMBER_OUTPUT_PARAMETER_NAMES,
						GROUP_MEMBER_OUTPUT_FIELD_NAMES,
						GROUP_MEMBER_OUTPUT_FIELD_TYPES});


		d.setRequired(GROUP_NOTIFICATION_NAME);


		d.createFieldMap(new String[] {GROUP_MEMBER_INPUT_PARAMETER_NAMES,
				GROUP_MEMBER_INPUT_FIELD_NAMES,
				GROUP_MEMBER_INPUT_FIELD_TYPES}, false);


		d.createFieldMap(new String[] {GROUP_MEMBER_OUTPUT_PARAMETER_NAMES,
				GROUP_MEMBER_OUTPUT_FIELD_NAMES,
				GROUP_MEMBER_OUTPUT_FIELD_TYPES}, false);


		d.createTuple(new String[] {GROUP_MEMBER_INPUT_PARAMETER_NAMES,
				GROUP_MEMBER_INPUT_FIELD_TYPES});


		d.createTuple(new String[] {GROUP_MEMBER_OUTPUT_PARAMETER_NAMES,
				GROUP_MEMBER_OUTPUT_FIELD_TYPES});


		d.setResourceDomain(GROUP_NOTIFICATION_NAME,
				DOMAIN_NOTIFICATION_NAME, null);

		d.setResourceDomain(GROUP_MEMBER_INPUT_PARAMETER_NAMES,
				DOMAIN_INPUT_PARAMETER_NAMES,
				new String[] {GROUP_NOTIFICATION_NAME});

		d.setResourceDomain(GROUP_MEMBER_INPUT_FIELD_TYPES,
				DOMAIN_INPUT_FIELD_TYPES,
				new String[] {GROUP_NOTIFICATION_NAME});

		d.setResourceDomain(GROUP_MEMBER_INPUT_FIELD_NAMES,
				WmTemplateDescriptor.INPUT_FIELD_NAMES,
				new String[] {GROUP_MEMBER_INPUT_PARAMETER_NAMES,
						GROUP_MEMBER_INPUT_FIELD_TYPES});

		d.setResourceDomain(GROUP_MEMBER_OUTPUT_PARAMETER_NAMES,
				DOMAIN_OUTPUT_PARAMETER_NAMES,
				new String[] {GROUP_NOTIFICATION_NAME});

		d.setResourceDomain(GROUP_MEMBER_OUTPUT_FIELD_TYPES,
				DOMAIN_OUTPUT_FIELD_TYPES,
				new String[] {GROUP_NOTIFICATION_NAME});

		d.setResourceDomain(GROUP_MEMBER_OUTPUT_FIELD_NAMES,
				WmTemplateDescriptor.OUTPUT_FIELD_NAMES,
				new String[] {GROUP_MEMBER_OUTPUT_PARAMETER_NAMES,
						GROUP_MEMBER_OUTPUT_FIELD_TYPES});
		d.setDescriptions(WmModBosAdapter.getInstance().getAdapterResourceBundleManager(), l);

	}

	/*
	 * Process the notification event and publishes them.
	 *
	 * an AdapterException is thrown if it encounters any problem return an
	 * AsyncNotificationResults
	 */
	public NotificationResults runNotification(NotificationEvent event) throws ResourceException {

		//WmModBosAdapter.retrieveLogger().logDebug(9999,"Check point: runNotification_SyncListener() ");
		SyncNotificationResults snr = null;
		WmRecord output = null;

		try {
			boolean[] success=null;
			success = ((WmModBusAdapterConnection) retrieveConnection()).readCoilsModBusServer(1, 10);
			output = WmRecordFactory.getFactory().createWmRecord("NotificationOutput");
			WmModBusAdapterConnection connection= (WmModBusAdapterConnection) event.getData();

			int inputLenght=this.getInputFieldValues().length;
			IData mainIData = IDataFactory.create();
			IDataCursor mainCursor = mainIData.getCursor();
			if (success==null)
			{
				IDataUtil.put(mainCursor, this.getOutputFieldNames()[0], "");

			}else {
				IData[] myParams = new IData[inputLenght];
				for(int i=0;i<inputLenght;i++) {
					myParams[i] = IDataFactory.create();
					IDataCursor paramsCursor = myParams[i].getCursor();
					String coilLocation =this.getInputFieldValues()[i];
					//  WmModBosAdapter.retrieveLogger().logInfo(SYNCHRONOUS_NOTIFICATION, new String[] { "coilLocation " + coilLocation });
					boolean coilValue= connection.readSingleCoilModBusServer(Integer.valueOf(coilLocation));	
					//  WmModBosAdapter.retrieveLogger().logInfo(SYNCHRONOUS_NOTIFICATION, new String[] { "coilValue " + coilValue });
					//IDataUtil.put(mainCursor, coilLocation, ""+coilValue);

					IDataUtil.put(paramsCursor, "coilValue", coilValue);
					IDataUtil.put(paramsCursor, "coilLocation", coilLocation);
					paramsCursor.destroy();
				}
				IDataUtil.put(mainCursor, "coilRead", myParams);
				// IDataUtil.put(mainCursor, this.getOutputFieldNames()[1], inputLenght);
			}
			output.setIData(mainIData);
			mainCursor.destroy();


		} catch (Exception e) {
			throw WmModBosAdapter.getInstance().createAdapterException(LISTENER_NOTIFICATION_EXCEPTION, e);
		}

		try {
			// doNotify(output);
			snr = invokeService(output);
			//WmModBosAdapter.retrieveLogger().logInfo(SYNCHRONOUS_NOTIFICATION, new String[] { "End invoking service..." });
		} catch (Throwable t) {
			snr = new SyncNotificationResults(this._notificationNodeName.getFullName(), false, t);
			snr.setHadError(true);
		}

		return snr;
	}

	public SyncNotificationResults invokeService(WmRecord rec) throws AdapterException {
		//	WmModBosAdapter.retrieveLogger().logInfo(SYNCHRONOUS_NOTIFICATION, new String[] { "Start invoking service..." });

		IDataCursor idc = null;
		try {
			idc = rec.getCursor();
			if ((idc != null) && (idc.first())) {
				do {
					String key = idc.getKey();
					Object o = idc.getValue();
					if (o == null)
						WmModBosAdapter.retrieveLogger().logInfo(SYNCHRONOUS_NOTIFICATION, new String[] { "key=" + key, "is null" });
				} while (idc.next());
			} else
				WmModBosAdapter.retrieveLogger().logInfo(SYNCHRONOUS_NOTIFICATION, new String[] { "idc is null, input=" + rec });
		} catch (Exception ex) {
			WmModBosAdapter.retrieveLogger().logInfo(LISTENER_NOTIFICATION_EXCEPTION, new String[] { ex.getLocalizedMessage() });
		} finally {
			if (idc != null)
				idc.destroy();
		}
		return super.invokeService(rec);
	}


}
