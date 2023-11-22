package wm.wmModBusAdapter;

//--- <<IS-START-IMPORTS>> ---
import com.wm.adapter.WmModBosAdapter.WmModBosAdapter;
import com.wm.adk.admin.AdapterAdmin;
import com.wm.app.b2b.server.ServiceException;
import com.wm.data.IData;
//--- <<IS-END-IMPORTS>> ---

public class wmModBusAdapterAdmin {

    public static final void startUp (IData pipeline)
            throws ServiceException
    {
        // --- <<IS-START(startUp)>> ---
        AdapterAdmin.registerAdapter(WmModBosAdapter.getInstance());
        // --- <<IS-END>> ---         
    }
    public static final void shutDown (IData pipeline)
            throws ServiceException
    {
        // --- <<IS-START(shutDown)>> ---
    	WmModBosAdapter instance = WmModBosAdapter.getInstance();
        instance.cleanup();
        AdapterAdmin.unregisterAdapter(instance);
        // --- <<IS-END>> ---                
    }
	
}
