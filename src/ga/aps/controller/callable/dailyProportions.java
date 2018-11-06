package ga.aps.controller.callable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import ga.aps.controller.entity.APScs_group_entity;

public class dailyProportions implements Callable<List<APScs_group_entity>> {
	private List<APScs_group_entity> list;
	
	public dailyProportions(List<APScs_group_entity> listResult) {
		// TODO Auto-generated constructor stub
		this.list = listResult;
	}

	@Override
	public List<APScs_group_entity> call() throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++) {			
		}		
		return list;
	}

}
