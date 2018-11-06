package ga.aps.controller.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.*;
import ga.aps.controller.dao.apsExecDao;
import ga.aps.controller.myConnection.*;
import ga.aps.controller.factory.ConstraintTemplateItemFactory;
import ga.aps.controller.entity.*;
import ga.aps.controller.callable.*;

public class apsExecImpl implements apsExecDao {
	private Connection conn;
	private ExecutorService threadpool;
	
	private PreparedStatement stat = null;
	
	public apsExecImpl(Connection conn) {
		this.conn = conn;
	}

	public apsExecImpl(Connection conn,ExecutorService threadpool) {
		this.conn = conn;
		this.threadpool = threadpool;
	}

	//1.查询整车物料数量特征值
	@Override
	public Map<String, Object> findVehicleInfo(String VersionNo) throws Exception {
		// TODO Auto-generated method stub
		String sqlVehicle 	= "select * from APSdt_Import_Vehicle 			where VersionNo = ?";
		String sqlAttribute = "select * from APSdt_Import_Vehicle_Attribute where VersionNo = ?";
		
		//整车物料及数量
		stat = conn.prepareStatement(sqlVehicle);
		stat.setString(1, VersionNo);
		ResultSet rsVehicle = stat.executeQuery();
		//整车特征值
		stat = conn.prepareStatement(sqlAttribute);
		stat.setString(1, VersionNo);
		ResultSet rsAttribute = stat.executeQuery();
		
		APSdt_Import_Vehicle 			vehicle   = null;
		APSdt_Import_Vehicle_Attribute 	attribute = null;
		
		List<APSdt_Import_Vehicle> 			 listVehicle   = new ArrayList<APSdt_Import_Vehicle>();
		List<APSdt_Import_Vehicle_Attribute> listAttribute = new ArrayList<APSdt_Import_Vehicle_Attribute>();
		
		while(rsVehicle.next()) {			
			vehicle = new APSdt_Import_Vehicle();			
			vehicle.setVersionNo(rsVehicle.getString(1));
			vehicle.setOrderNo(rsVehicle.getInt(2));
			vehicle.setSiteCode(rsVehicle.getString(3));
			vehicle.setMaterial(rsVehicle.getString(4));
			vehicle.setPoNumber(rsVehicle.getString(5));
			vehicle.setAmount(rsVehicle.getLong(6));
			vehicle.setCreatDate(rsVehicle.getDate(7));
			vehicle.setCreatUser(rsVehicle.getString(8));
			listVehicle.add(vehicle);
		}

		while(rsAttribute.next()) {			
			attribute = new APSdt_Import_Vehicle_Attribute();			
			attribute.setVersionNO(rsAttribute.getString(1));
			attribute.setAttriNo(rsAttribute.getString(2));
			attribute.setSiteCode(rsAttribute.getString(3));
			attribute.setMaterial(rsAttribute.getString(4));
			attribute.setATBEZ(rsAttribute.getString(5));
			attribute.setATWRT(rsAttribute.getString(6));
			listAttribute.add(attribute);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vehicle", listVehicle);
		map.put("attribute", listAttribute);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> VehiclePopulation(long PopulationSize,Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		//参数定义
		long PopuIndex = 0;
		List<APSdt_Import_Vehicle> 			 listVehicle   = (List<APSdt_Import_Vehicle>) map.get("vehicle");
		List<APSdt_Import_Vehicle_Attribute> listAttribute = (List<APSdt_Import_Vehicle_Attribute>) map.get("attribute");
		
		//存储整车物料清单
		APScs_group_entity		 strucMatnr = null;
		List<APScs_group_entity> listMatnr  = new ArrayList<APScs_group_entity>();
		List<APScs_group_entity> shuffleMat = new ArrayList<APScs_group_entity>();
		
		//获取整车物料组清单		
		for(int i=0;i<listVehicle.size();i++) {
			for(int j=0;j<listVehicle.get(i).getAmount();j++) {
				strucMatnr = new APScs_group_entity();
				strucMatnr.setPopuNo(0);
				strucMatnr.setSerialNo(j);
				strucMatnr.setMaterial(listVehicle.get(i).getMaterial());
				listMatnr.add(strucMatnr);
			}
		}
		
		//根据种群规模数随机打乱物料清单		
		for(int i=1;i<=PopulationSize;i++) {
			//list随机shuffle
			int j=0;
			Collections.shuffle(listMatnr); 
			
			for(APScs_group_entity strMat : listMatnr){
				strucMatnr = new APScs_group_entity();
				strucMatnr.setPopuNo(i);
				strucMatnr.setSerialNo(j);
				strucMatnr.setMaterial(strMat.getMaterial());
				shuffleMat.add(strucMatnr);
				j++;
			}
		}
		
		Map<String, Object> mapMaterial = new HashMap<String, Object>();
		mapMaterial.put("Material", shuffleMat);		
		return mapMaterial;
	}
	
	//3.种群适应度函数值计算
	@SuppressWarnings({ "unchecked"})
	@Override
	public Map<String, Object> PopulationFitness(APScs_Thread_parameters ThreadPara,APScs_Initial_Parameters Parameters,Map<String, Object> map) throws Exception{
		//参数定义
		int x = 0;
		int y = 0;
		
		//线程参数
		CompletionService<List<APScs_group_entity>> ServicedailyProduction  = null;
		CompletionService<List<APScs_group_entity>> ServicedailyProportions = null;
		
		//约束模板
		List<APS_ConstraintTemplateItem> conStraintTemplate = new ArrayList<APS_ConstraintTemplateItem>();
		
		//获取约束规则
		conStraintTemplate = ConstraintTemplateItemFactory.getInstance().findAll(Parameters.getSiteCode(), Parameters.getTemplateCode());
		
		
		//获取种群随机组合
		List<APScs_group_entity> shuffleMat = (List<APScs_group_entity>) map.get("Material");
		List<APScs_group_entity> listProduction = new ArrayList<APScs_group_entity>();
		//种群组合适应度函数值计算
		
		for(APS_ConstraintTemplateItem ConstraintTemplateStruc: conStraintTemplate) {
			//过滤条件不为空
			if(ConstraintTemplateStruc.getFilterConditionCode() != null || ConstraintTemplateStruc.getFilterConditionCode().length() != 0) {
				
			}
			
		}
		
		ServicedailyProduction 	= new ExecutorCompletionService<List<APScs_group_entity>>(threadpool);
		ServicedailyProportions = new ExecutorCompletionService<List<APScs_group_entity>>(threadpool);
		
		while( x < Parameters.getPopulation() ) {
			listProduction = new ArrayList<APScs_group_entity>();
			for(APScs_group_entity struc : shuffleMat) {
				if (struc.getPopuNo() == x) {
					listProduction.add(struc);
				}
			}	
			ServicedailyProduction.submit(new dailyProduction(listProduction));
			x++;
		}

		List<APScs_group_entity> listResult = new ArrayList<APScs_group_entity>();
		List<APScs_group_entity> listAll = new ArrayList<APScs_group_entity>();
		
		while(y < Parameters.getPopulation()) {
			listResult = null;
			listResult = ServicedailyProduction.take().get();
			listAll.addAll(listResult);
			
			//接收返回结果并执行下一约束规则
			if(listResult != null) {
				ServicedailyProportions.submit(new dailyProportions(listResult));
			}
			
			y++;
		}
	
		for(int i=0;i<listAll.size();i++) {
			System.out.println(String.valueOf(listAll.get(i).getPopuNo()) + "   " + listAll.get(i).getMaterial() + "   " +  String.valueOf(listAll.get(i).getSerialNo()));
		}

		//results.get();
		System.out.println("main program working end");
		
		return null;
	}

}
