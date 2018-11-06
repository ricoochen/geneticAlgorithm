package ga.aps.controller.callable;

import java.util.concurrent.Callable;

import ga.aps.controller.entity.APScs_group_entity;

import java.util.*;

public class dailyProduction implements Callable<List<APScs_group_entity>>{
	private List<APScs_group_entity> list;
	
	public dailyProduction(List<APScs_group_entity> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	@Override
	public List<APScs_group_entity> call() throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++) {
			list.get(i).setFgProduction(1);
		}
		return list;		
	}
}
