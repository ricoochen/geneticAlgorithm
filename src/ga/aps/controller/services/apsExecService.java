package ga.aps.controller.services;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorService;
import ga.aps.controller.dao.*;
import ga.aps.controller.dao.apsExecDao;
import ga.aps.controller.entity.*;
import ga.aps.controller.impl.apsExecImpl;
import ga.aps.controller.myConnection.*;

public class apsExecService implements apsExecDao  {

	private DBConnection dbc;
	private ThreadPool ThreadPool;
	private apsExecDao dao = null;
	
	public apsExecService() throws Exception {
		System.out.println("proxy-apsExecService");
		dbc = new DBConnection();
		dao = new apsExecImpl(dbc.getConnection());
	}
	
	//数据库连接+实现类Impl + 线程池
	public apsExecService(APScs_Thread_parameters ThreadPara) throws Exception{
		System.out.println("proxy-apsExecService");
		//数据库连接
		dbc = new DBConnection();
		ThreadPool = new ThreadPool(ThreadPara);
		dao = new apsExecImpl(dbc.getConnection(),ThreadPool.getThreadPool());		
	}
	
	//1.查询整车物料-数量-特征
	@Override
	public Map<String, Object> findVehicleInfo(String VersionNo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("proxy-ConstanintTemplateService-findVehicleInfo");
		Map<String, Object> map = dao.findVehicleInfo(VersionNo);
		dbc.close();
		return map;
	}
	
	//2.整车物料种群编制
	@Override
	public Map<String, Object> VehiclePopulation(long PopulationSize,Map<String, Object> map) throws Exception{
		Map<String, Object> mapPopulation = dao.VehiclePopulation(PopulationSize,map);
		dbc.close();
		return mapPopulation;
	}
	
	//3.种群适应度函数值计算	
	public Map<String, Object> PopulationFitness(APScs_Thread_parameters ThreadPara,APScs_Initial_Parameters Parameters,Map<String, Object> map) throws Exception{
		Map<String, Object> mapPopulation = dao.PopulationFitness(ThreadPara,Parameters,map);
		dbc.close();
		ThreadPool.ThreadShutdown();
		return mapPopulation;
	}
}
