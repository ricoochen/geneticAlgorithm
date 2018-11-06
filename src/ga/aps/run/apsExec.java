package ga.aps.run;

import java.util.*;
import ga.aps.controller.dao.*;
import ga.aps.controller.factory.*;
import ga.aps.controller.entity.*;

public class apsExec {

	@SuppressWarnings({ "unchecked"})
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//参数设置
		APScs_Initial_Parameters Parameters = null;
		APScs_Initial_ProductionDay prodStru = null;
		List<APScs_Initial_ProductionDay> prodDay = new ArrayList<APScs_Initial_ProductionDay>();
		//生产天数
		for(int i=1;i<6;i++) {
			prodStru = new APScs_Initial_ProductionDay();
			prodStru.setDayno(i);
			prodStru.setAmount(600);
			prodDay.add(prodStru);	
		}	
		
		//初始值
		Parameters = new APScs_Initial_Parameters();
		Parameters.setSiteCode("A010");
		Parameters.setPopulation(100);
		Parameters.setVersionNo("20181030001");
		Parameters.setTemplateCode("M0000000003");
		Parameters.setProdDay(prodDay);

		APScs_Thread_parameters ThreadPara = null;
		
		//2。获取整车物料、数量、特性值
		Map<String, Object> map = new HashMap<String, Object>();
		map = apsExecFactory.getInstance(ThreadPara).findVehicleInfo(Parameters.getVersionNo());
		
		//2。整车物料种群随机组合
		map = apsExecFactory.getInstance(ThreadPara).VehiclePopulation(Parameters.getPopulation(),map);
		
		//3.种群适应度目标值计算
		ThreadPara = new APScs_Thread_parameters(10,1000,10,100);
		map = apsExecFactory.getInstance(ThreadPara).PopulationFitness(ThreadPara,Parameters,map);

		//List<APScs_group_entity> listVehicle = (List<APScs_group_entity>) map.get("Material");
		
		//3.整车种群适应度目标值计算

		//3。并行—整车随机分组
		//4。迭代循环
		//41。并行-适应度目标值计算（日产量、日比例、均衡、批量、密度、切换、爬坡）
		//42。并行-选择（轮盘赌）
		//43。并行-交叉
		//44。并行-变异
		//45。并行-新种群
	}

}
