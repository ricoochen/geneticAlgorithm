package ga.aps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
import ga.aps.controller.entity.APS_ConstaintTemplate;
import ga.aps.controller.factory.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Servlet implementation class ConstaintTemplate
 */

//@WebServlet(description = "约束模板编号", urlPatterns = { "/ConstaintTemplate" })

public class ConstaintTemplate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConstaintTemplate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);		
				
		//中文+类型Json
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		//前端传入参数
		String SiteCode 	= request.getParameter("SiteCode"); 
		String TemplateCode = request.getParameter("TemplateCode");
		
		//Json数组+对象
		PrintWriter out 	= response.getWriter();
		//JSONArray   ja 		= new JSONArray();  
		
		try {
		    if (TemplateCode == null) {
		    	List<APS_ConstaintTemplate> list = new ArrayList<APS_ConstaintTemplate>();
		    	list = ConstaintTemplateFactory.getInstance().findAll();	
		        String json = JSON.toJSONString(list);
		        
//		    	for(APS_ConstaintTemplate tc : list){
//		            JSONObject jo = new JSONObject();
//		            jo.put("SiteCode", 	tc.getSiteCode());
//		            jo.put("TemplateCode", tc.getTemplateCode()); 
//		            jo.put("TemplateText", tc.getTemplateText());
//		            ja.add(jo);
//		        };
		    	
		    	//输出数据
		        response.getWriter().println(json);
		        System.out.println(json);
		    	
		    } else {
		    	APS_ConstaintTemplate ConstaintTemplate = null;
		    	ConstaintTemplate = ConstaintTemplateFactory.getInstance().findById(SiteCode, TemplateCode);
		    	String json = JSON.toJSONString(ConstaintTemplate);
		    	
		    	//输出数据
		        response.getWriter().println(json);
		        System.out.println(json);
		    }
		    
		   
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}    
	}

}
