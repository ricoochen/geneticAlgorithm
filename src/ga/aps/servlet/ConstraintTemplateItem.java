package ga.aps.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import ga.aps.controller.entity.APS_ConstraintTemplateItem;
import ga.aps.controller.factory.ConstraintTemplateItemFactory;

/**
 * Servlet implementation class ConstraintTemplateItem
 */
public class ConstraintTemplateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConstraintTemplateItem() {
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
		String SiteCode 	= request.getParameter("SiteCode"); 
		String TemplateCode	= request.getParameter("TemplateCode");
		
		try {
		    if (TemplateCode == null && SiteCode == null) {

		    } else {		        
		    	List<APS_ConstraintTemplateItem> list = new ArrayList<APS_ConstraintTemplateItem>();
		    	list = ConstraintTemplateItemFactory.getInstance().findAll(SiteCode,TemplateCode);	
		        String json = JSON.toJSONString(list);

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
