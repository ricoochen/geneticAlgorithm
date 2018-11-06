package ga.aps.controller.dao;

import java.util.*;
import ga.aps.controller.entity.*;

public interface apsExecDao {
	
	//1.获取整车物料-数量-特征值
	public Map<String, Object> findVehicleInfo(String VersionNo) throws Exception;

	//2.整车物料种群编制
	public Map<String, Object> VehiclePopulation(long PopulationSize,Map<String, Object> map) throws Exception;
	
	//3.种群适应度函数值计算	
	public Map<String, Object> PopulationFitness(APScs_Thread_parameters ThreadPara,APScs_Initial_Parameters Parameters,Map<String, Object> map) throws Exception;
}
