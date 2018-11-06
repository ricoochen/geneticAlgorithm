package ga.aps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ga.aps.controller.entity.APS_FilterCondition;
import ga.aps.controller.factory.*;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class FilterCondition
 */
public class FilterCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterCondition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
				
		//中文+类型Json
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		//前端传入参数
		String Action		= request.getParameter("Action");
		String SiteCode 	= request.getParameter("SiteCode"); 
		String FiltercCode	= request.getParameter("TemplateCode");

		PrintWriter out 	= response.getWriter();
		
		try {
			if (Action.equals("RT")) {
			    if (FiltercCode == null && SiteCode == null) {
	//		    	List<APS_FilterCondition> list = new ArrayList<APS_FilterCondition>();
	//		    	list = FilterConditionFactory.getInstance().findAll();	
	//		        String json = JSON.toJSONString(list);
	//		        System.out.println(json);
	//
	//		    	//输出数据
	//		        response.getWriter().println(json);
	//		        System.out.println(json);
			    	
			    } else {
	//		    	APS_FilterCondition FilterCondition = null;
	//		    	FilterCondition = FilterConditionFactory.getInstance().findById(SiteCode, FiltercCode);
	//		    	String json = JSON.toJSONString(FilterCondition);
	//		    	//输出数据
	//		        response.getWriter().println(json);
	//		        System.out.println(json);
			        
			    	List<APS_FilterCondition> list = new ArrayList<APS_FilterCondition>();
			    	list = FilterConditionFactory.getInstance().findAll(SiteCode,FiltercCode);	
			        String json = JSON.toJSONString(list);
	
			    	//输出数据
			        response.getWriter().println(json);
			        System.out.println(json);
			    }
		    }else if( Action.equals("RC") ) {
		    	List<APS_FilterCondition> list = new ArrayList<APS_FilterCondition>();
		    	list = FilterConditionFactory.getInstance().findFccodeAll(SiteCode,FiltercCode);	
		        String json = JSON.toJSONString(list);

		    	//输出数据
		        response.getWriter().println(json);
		    }    
		   
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}    
	}

}
