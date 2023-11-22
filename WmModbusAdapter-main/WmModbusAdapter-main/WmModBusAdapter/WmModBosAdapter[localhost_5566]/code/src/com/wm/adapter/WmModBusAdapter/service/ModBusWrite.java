package com.wm.adapter.WmModBusAdapter.service;

import java.util.Locale;

import javax.resource.ResourceException;

import com.wm.adapter.WmModBosAdapter.WmModBosAdapter;
import com.wm.adapter.WmModBosAdapter.WmModBusAdapterConstants;
import com.wm.adapter.WmModBusAdapter.connection.WmModBusAdapterConnection;
import com.wm.adk.cci.interaction.WmAdapterService;
import com.wm.adk.cci.record.WmRecord;
import com.wm.adk.cci.record.WmRecordFactory;
import com.wm.adk.connection.WmManagedConnection;
import com.wm.adk.error.AdapterException;
import com.wm.adk.metadata.WmTemplateDescriptor;
import com.wm.data.IData;
import com.wm.data.IDataCursor;
import com.wm.data.IDataFactory;
import com.wm.data.IDataUtil;

public class ModBusWrite extends WmAdapterService implements WmModBusAdapterConstants {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7951627079653139042L;


	private String _functionName;


	private String[] _inputParameterNames;


	private String[] _inputFieldNames;


	private String[] _inputFieldTypes;


	private String[] _outputParameterNames;


	private String[] _outputFieldNames;


	private String[] _outputFieldTypes; 

	public ModBusWrite() {
	}

	public void setFunctionName(String functionName) {
		_functionName = functionName;
	}

	public String getFunctionName() {
		return _functionName;
	}

	public void setInputParameterNames(String[] inputParameterNames) {
		_inputParameterNames = inputParameterNames;
	}

	public String[] getInputParameterNames() {
		return _inputParameterNames;
	}

	public void setInputFieldNames(String[] inputFieldNames) {
		_inputFieldNames = inputFieldNames;
	}

	public String[] getInputFieldNames() {
		return _inputFieldNames;
	}

	public void setInputFieldTypes(String[] inputFieldTypes) {
		_inputFieldTypes = inputFieldTypes;
	}

	public String[] getInputFieldTypes() {
		return _inputFieldTypes;
	}

	public void setOutputParameterNames(String[] outputParameterNames) {
		_outputParameterNames = outputParameterNames;
	}

	public String[] getOutputParameterNames() {
		return _outputParameterNames;
	}

	public void setOutputFieldNames(String[] outputFieldNames) {
		_outputFieldNames = outputFieldNames;
	}

	public String[] getOutputFieldNames() {
		return _outputFieldNames;
	}

	public void setOutputFieldTypes(String[] outputFieldTypes) {
		_outputFieldTypes = outputFieldTypes;
	}

	public String[] getOutputFieldTypes() {
		return _outputFieldTypes;
	}

	public WmRecord execute(WmManagedConnection connection, WmRecord input)
			throws ResourceException {

		//WmModBosAdapter.retrieveLogger().logInfo(9999,"Check point: execute() ");
		WmRecord output = WmRecordFactory.getFactory().createWmRecord("nameNotUsed");
		boolean success = false;
		WmModBusAdapterConnection modbusConn=((WmModBusAdapterConnection)connection);

		IData mainIData = input.getIData();
		IDataCursor mainCursor = mainIData.getCursor();

		Boolean SingleCoilValue=null;
		Integer SingleCoilLocation=null;
		try {
			if (mainCursor.first("SingleCoilLocation")) {
				SingleCoilLocation = IDataUtil.getInt(mainCursor, "SingleCoilLocation",1);
			}
		} catch (Throwable t) {};

		try {
			if (mainCursor.first("SingleCoilValue")) {
				SingleCoilValue = IDataUtil.getBoolean(mainCursor, "SingleCoilValue");

			}} catch (Throwable t) {};

			mainCursor.destroy();
			mainIData = null;

			try {

				success= modbusConn.writeSingleCoilModBusServer(SingleCoilLocation, SingleCoilValue);

				//WmModBosAdapter.retrieveLogger().logDebug(9999,"<"+new Boolean(SingleCoilValue)+"> written");
			} catch (Throwable t) {
				success = false;
				modbusConn.destroy();
			}

			mainIData = IDataFactory.create();
			mainCursor = mainIData.getCursor();
			IDataUtil.put(mainCursor, this.getOutputFieldNames()[0], ""+success);
			output.setIData(mainIData);
			mainCursor.destroy();
			return output;
	}

	public void fillWmTemplateDescriptor(WmTemplateDescriptor d, Locale l)
			throws AdapterException {

		d.createGroup(GROUP_FUNCTION_INVOCATION,
				new String[] {GROUP_MEMBER_FUNCTION_NAME,
						GROUP_MEMBER_INPUT_PARAMETER_NAMES,
						GROUP_MEMBER_INPUT_FIELD_NAMES,
						GROUP_MEMBER_INPUT_FIELD_TYPES,
						GROUP_MEMBER_OUTPUT_PARAMETER_NAMES,
						GROUP_MEMBER_OUTPUT_FIELD_NAMES,
						GROUP_MEMBER_OUTPUT_FIELD_TYPES});


		d.setRequired(GROUP_MEMBER_FUNCTION_NAME);


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


		d.setResourceDomain(GROUP_MEMBER_FUNCTION_NAME,
				DOMAIN_FUNCTION_NAMES, null);

		d.setResourceDomain(GROUP_MEMBER_INPUT_PARAMETER_NAMES,
				DOMAIN_INPUT_PARAMETER_NAMES,
				new String[] {GROUP_MEMBER_FUNCTION_NAME});

		d.setResourceDomain(GROUP_MEMBER_INPUT_FIELD_TYPES,
				DOMAIN_INPUT_FIELD_TYPES,
				new String[] {GROUP_MEMBER_FUNCTION_NAME});

		d.setResourceDomain(GROUP_MEMBER_INPUT_FIELD_NAMES,
				WmTemplateDescriptor.INPUT_FIELD_NAMES,
				new String[] {GROUP_MEMBER_INPUT_PARAMETER_NAMES,
						GROUP_MEMBER_INPUT_FIELD_TYPES});

		d.setResourceDomain(GROUP_MEMBER_OUTPUT_PARAMETER_NAMES,
				DOMAIN_OUTPUT_PARAMETER_NAMES,
				new String[] {GROUP_MEMBER_FUNCTION_NAME});

		d.setResourceDomain(GROUP_MEMBER_OUTPUT_FIELD_TYPES,
				DOMAIN_OUTPUT_FIELD_TYPES,
				new String[] {GROUP_MEMBER_FUNCTION_NAME});

		d.setResourceDomain(GROUP_MEMBER_OUTPUT_FIELD_NAMES,
				WmTemplateDescriptor.OUTPUT_FIELD_NAMES,
				new String[] {GROUP_MEMBER_OUTPUT_PARAMETER_NAMES,
						GROUP_MEMBER_OUTPUT_FIELD_TYPES});
		d.setDescriptions(
				WmModBosAdapter.getInstance().getAdapterResourceBundleManager(), l);
	}
}