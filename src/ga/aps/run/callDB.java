package ga.aps.run;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import ga.aps.controller.entity.APS_ConstaintTemplate;
import ga.aps.controller.factory.ConstaintTemplateFactory;

public class callDB {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
    	List<APS_ConstaintTemplate> list = new ArrayList<APS_ConstaintTemplate>();
    	list = ConstaintTemplateFactory.getInstance().findAll();		
    	
    	 JSONArray  jsonarray = new JSONArray();  
    	 JSONObject jsonobj   = new JSONObject();  	
    	
    	for(APS_ConstaintTemplate tl : list){
            JSONObject jo = new JSONObject();
            jo.put("id", tl.getSiteCode());
            jo.put("time", tl.getTemplateCode());             
            jsonarray.add(jo);
        }
    	
    	System.out.println(jsonarray);

	}

}
