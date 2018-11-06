sap.ui.define([
	"jquery.sap.global",
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel",
	"sap/ui/core/format/NumberFormat",
	"sap/ui/core/UIComponent",
	"sap/m/MessageToast",
	"sap/m/library"
], function(jQuery, Controller, JSONModel, NumberFormat,UIComponent, MessageToast, MobileLibrary) {
	"use strict";

	return Controller.extend("sap.ga.aps.controller.Startpage", {
		_data : {
			"date" : new Date()
		},
		
		//初始
		onInit: function() {
			var sDataPath = jQuery.sap.getModulePath("sap.ga.aps.model.data", "/News.json");
			var oModel = new JSONModel(sDataPath);
			this.getView().setModel(oModel, "news");
			
			var oModel1 = new JSONModel(this._data);
			this.getView().setModel(oModel1);
		},
		

		//算法应用
		onGaProcess: function(oEvent){
			this.getRouter().navTo("apsNav");
		},
		
		//ERP集成
		onErpProcess: function(){
			MessageToast.show("ERP集成...敬请期待");
		},
		
		//AI人工智能
		onAIpress: function(){
			MessageToast.show("AI智能...敬请期待");
		},
		
		//大数据
		onBigdatapress: function(){
			MessageToast.show("大数据...敬请期待");
		},

		getRouter: function() {
			return this.getOwnerComponent().getRouter();
		},

		formatJSONDate: function(date) {
			var oDate = new Date(Date.parse(date));
			return oDate.toLocaleDateString();
		},

	});
});
