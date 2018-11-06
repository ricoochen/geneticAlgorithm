package ga.aps.run;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

public class GenEntityMysql {
	
	private String packageOutPath = "ga.aps.controller.entity";	//指定实体生成所在包的路径
	private String authorName = "CHENRK";						//作者名字
	private String tablename = "APSdt_Import_Vehicle_Attribute";			//表名
	private String[] colnames; 									//列名数组
	private String[] colTypes; 									//列名类型数组
	private int[] colSizes; 									//列名大小数组
	private boolean f_util = false; 							//是否需要导入包java.util.*
	private boolean f_sql = false; 								//是否需要导入包java.sql.*
    
    //数据库连接
	
//	private static String prjpath = System.getProperty("user.dir");
//	private static String DBurl = prjpath + "\\WebContent\\access\\GAAPS.mdb";
//	private static String chgurl = DBurl.replaceAll("\\\\", "/");
//	private static String URL =  "jdbc:Access:///"+chgurl;
	//private static final String URL ="jdbc:Access://localhost:3306/network";
	private static final String NAME = "root";
	private static final String PASS = "";
	private static final String DRIVER ="com.hxtt.sql.access.AccessDriver";

	/*
	 * 构造函数
	 */
	public GenEntityMysql(){
		String zpath = this.getClass().getResource("/").getPath().replaceAll("%20"," ");
		zpath = zpath.substring(1,zpath.length()) + "GAAPS.mdb";
		String URL = "jdbc:Access:///" + zpath;
		
    	//创建连接
    	Connection con;
		//查要生成实体类的表
    	String sql = "select * from " + tablename;
    	PreparedStatement pStemt = null;
    	try {
    		try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		con = DriverManager.getConnection(URL,NAME,PASS);
			pStemt = con.prepareStatement(sql);
			ResultSetMetaData rsmd = pStemt.getMetaData();
			int size = rsmd.getColumnCount();	//统计列
			colnames = new String[size];
			colTypes = new String[size];
			colSizes = new int[size];
			for (int i = 0; i < size; i++) {
				colnames[i] = rsmd.getColumnName(i + 1);
				colTypes[i] = rsmd.getColumnTypeName(i + 1);
				
				if(colTypes[i].equalsIgnoreCase("datetime")){
					f_util = true;
				}
				if(colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")){
					f_sql = true;
				}
				colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
			}
			
			String content = parse(colnames,colTypes,colSizes);
			
			try {
				File directory = new File("");
				//System.out.println("绝对路径："+directory.getAbsolutePath());
				//System.out.println("相对路径："+directory.getCanonicalPath());
				String path=this.getClass().getResource("").getPath();
				
				System.out.println(path);
				System.out.println("src/?/"+path.substring(path.lastIndexOf("/ga/", path.length())) );
//				String outputPath = directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initcap(tablename) + ".java";
				String outputPath = directory.getAbsolutePath()+ "/src/"+this.packageOutPath.replace(".", "/")+"/"+initcap(tablename) + ".java";
				FileWriter fw = new FileWriter(outputPath);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(content);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
    }

	/**
	 * 功能：生成实体类主体代码
	 * @param colnames
	 * @param colTypes
	 * @param colSizes
	 * @return
	 */
	private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
		StringBuffer sb = new StringBuffer();
		
		//判断是否导入工具包
		if(f_util){
			sb.append("import java.util.Date;\r\n");
		}
		if(f_sql){
			sb.append("import java.sql.*;\r\n");
		}
		sb.append("package " + this.packageOutPath + ";\r\n");
		sb.append("\r\n");
		//注释部分
		sb.append("   /**\r\n");
		sb.append("    * "+tablename+" 实体类\r\n");
		sb.append("    * "+new Date()+" "+this.authorName+"\r\n");
		sb.append("    */ \r\n");
		//实体部分
		sb.append("\r\n\r\npublic class " + initcap(tablename) + "{\r\n");
		processAllAttrs(sb);//属性
		processAllMethod(sb);//get set方法
		sb.append("}\r\n");
		
    	//System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * 功能：生成所有属性
	 * @param sb
	 */
	private void processAllAttrs(StringBuffer sb) {
		
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + colnames[i] + ";\r\n");
		}
		
	}

	/**
	 * 功能：生成所有方法
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {
		
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tpublic void set" + initcap(colnames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " " + 
					colnames[i] + "){\r\n");
			sb.append("\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
			sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initcap(colnames[i]) + "(){\r\n");
			sb.append("\t\treturn " + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
		}
		
	}
	
	/**
	 * 功能：将输入字符串的首字母改成大写
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		
		char[] ch = str.toCharArray();
		if(ch[0] >= 'a' && ch[0] <= 'z'){
			ch[0] = (char)(ch[0] - 32);
		}
		
		return new String(ch);
	}

	/**
	 * 功能：获得列的数据类型
	 * @param sqlType
	 * @return
	 */
	private String sqlType2JavaType(String sqlType) {
		
		if(sqlType.equalsIgnoreCase("bit")){
			return "boolean";
		}else if(sqlType.equalsIgnoreCase("tinyint")){
			return "byte";
		}else if(sqlType.equalsIgnoreCase("smallint")){
			return "short";
		}else if(sqlType.equalsIgnoreCase("int")){
			return "int";
		}else if(sqlType.equalsIgnoreCase("bigint")){
			return "long";
		}else if(sqlType.equalsIgnoreCase("float")){
			return "float";
		}else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric") 
				|| sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money") 
				|| sqlType.equalsIgnoreCase("smallmoney")){
			return "double";
		}else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char") 
				|| sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar") 
				|| sqlType.equalsIgnoreCase("text")){
			return "String";
		}else if(sqlType.equalsIgnoreCase("datetime")){
			return "Date";
		}else if(sqlType.equalsIgnoreCase("image")){
			return "Blod";
		}
		
		return null;
	}
	
	/**
	 * 出口
	 * TODO
	 * @param args
	 */
	public static void main(String[] args) {
		
		new GenEntityMysql();
		
	}

}