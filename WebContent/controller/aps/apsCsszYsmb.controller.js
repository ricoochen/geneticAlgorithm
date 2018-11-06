//sap.ui.controller("sap.ga.aps.controller.aps.apsCsszYsmb", {

/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf view.aps.apsCsszYsmb
*/
//	onInit: function() {
//
//	},

/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf view.aps.apsCsszYsmb
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf view.aps.apsCsszYsmb
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf view.aps.apsCsszYsmb
*/
//	onExit: function() {
//
//	}

//});

sap.ui.define([
	"jquery.sap.global",
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel",
	"sap/ui/core/format/NumberFormat",
	"sap/ui/core/UIComponent",
	"sap/m/MessageToast",
	"sap/m/library",
	'sap/ui/model/Filter',
	'sap/ui/core/Fragment'
], function(jQuery, Controller, JSONModel, NumberFormat,UIComponent, MessageToast, MobileLibrary, Filter, Fragment) {
	"use strict";
 
	var pageController =  Controller.extend("sap.ga.aps.controller.aps.apsCsszYsmb", {
		
		onInit: function (evt) {
			var sDataPath = jQuery.sap.getModulePath("sap.ga.aps.model.data", "/apsCssz.json");
			var oModel = new JSONModel(sDataPath);		
			this.getView().setModel(oModel,"Plant"); 
			
			var cModel = new JSONModel();
			var callurl = "FilterCondition";
			var fcjson = { Action:"RC",SiteCode:"",TemplateCode:"" };
			this._ajaxfunCsszGltjFccode(cModel,fcjson,callurl);
			this.getView().setModel(cModel,"Fccode");
		},
		
		onapsCsszGltjFccode:function(evt){
			var plant  = this.getView().byId("apsCsszGltjWerks").getSelectedKey();
			if (plant.length == 0){
				MessageToast.show("请输入工厂");
			};
		},
	
		onapsCsszGltjContinue:function(evt){
			var plant  = this.getView().byId("apsCsszGltjWerks").getSelectedKey();
			var fccode = this.getView().byId("apsCsszGltjFccode").getSelectedKey();
			
			if (plant.length == 0){
				MessageToast.show("请输入工厂");
			}else{
				var tModel = new JSONModel();
				var callurl = "FilterCondition";
				var tbjson = {Action:"RC",SiteCode:plant,TemplateCode:fccode };
				this._ajaxfunCsszGltjTable(tModel, tbjson, callurl);
				this.getView().setModel(tModel,"gltj");	
			}

		},
		
		onNavBack: function(oEvent) {
			var oRouter = this.getOwnerComponent().getRouter();
			oRouter.navTo("apsNav");
		},
		
		onCreate: function(oEvent){
			MessageToast.show("请输入工厂");
		},
		
		onEdit: function(oEvent){
			MessageToast.show("请输入工厂");
		},
		
		onDelete: function(oEvent){
			MessageToast.show("请输入工厂");
		},
		
		_ajaxfunCsszGltjFccode:function(oModel ,jsonData, callurl){
			jQuery.ajax({
				type:"post",  
				data:jsonData,   
				url:callurl,
				dataType:"json",
				async:false, 
				cache:false,
				success:function(oData,response,xhr){
					oModel.setData(oData);
				},
				error:function(){
					jQuery.sap.log.debug("Something went wrong while retrieving the data");
				}
			});	
		},
		
		_ajaxfunCsszGltjTable:function(oModel ,jsonData, callurl){
			jQuery.ajax({
				type:"post",  
				data:jsonData,   
				url:callurl,
				dataType:"json",
				async:false, 
				cache:false,
				success:function(oData,response,xhr){
					oModel.setData(oData);
				},
				error:function(){
					jQuery.sap.log.debug("Something went wrong while retrieving the data");
				}
			});	
		},
	});
	
	return pageController;
});