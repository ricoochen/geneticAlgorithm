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
 
	var pageController =  Controller.extend("sap.ga.aps.controller.aps.apsCssz", {
		
		onInit: function (evt) {
			//this.getView.setModel().setData();
			
			var oModel = new JSONModel();	
			
			this._ajaxfunConstaintTemplate(oModel);
					
			this.getView().setModel(oModel,"ct");
		},
		
		_ajaxfunConstaintTemplate:function(oModel){
			jQuery.ajax({
				type:"post",
				contentType:"application/json",
				url:"ConstaintTemplate",
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
		
		onapsCsszButton: function(oEvent) {
			var oModel = new JSONModel();
			var oRouter = this.getOwnerComponent().getRouter();
			oRouter.navTo("apsNav");
			this.getView().setModel(oModel,"gltj");
			this.getView().setModel(oModel,"ysgz");
			this.getView().setModel(oModel,"ysmb");
			this.byId("apsCsszTempCodeInput").setValue("");
		},
		
		handleValueHelp : function (oEvent) {
			
			var sInputValue = oEvent.getSource().getValue();

			this.inputId = oEvent.getSource().getId();
			
			
			// create value help dialog
			if (!this._valueHelpDialog) {
				this._valueHelpDialog = sap.ui.xmlfragment(
					"sap.ga.aps.fragment.apsCsszTempCode",
					this
				);
				this.getView().addDependent(this._valueHelpDialog);
			}

			// create a filter for the binding
			this._valueHelpDialog.getBinding("items").filter([new Filter(
				"templateCode",
				sap.ui.model.FilterOperator.Contains, sInputValue
			)]);

			// open value help dialog filtered by the input value
			this._valueHelpDialog.open(sInputValue);
		},
		
		_handleValueHelpSearch : function (evt) {
			var sValue = evt.getParameter("value");
			var oFilter = new Filter(
				"templateCode",
				sap.ui.model.FilterOperator.Contains, sValue
			);
			evt.getSource().getBinding("items").filter([oFilter]);
		},

		_handleValueHelpClose : function (evt) {
			var oSelectedItem = evt.getParameter("selectedItem");
			if (oSelectedItem) {
				var templateCodeInput = this.byId(this.inputId),
					//oText = this.byId('selectedKey'),
					sDescription = oSelectedItem.getDescription();

				templateCodeInput.setSelectedKey(sDescription);
				//oText.setText(sDescription);
			}
			evt.getSource().getBinding("items").filter([]);
		},

		suggestionItemSelected: function (evt) {

			var oItem = evt.getParameter('selectedItem'),
				//oText = this.byId('selectedKey'),
				sKey = oItem ? oItem.getKey() : '';

			//oText.setText(sKey);
		},
		
		onapsCsszContinue : function(evt){	
			var fcModel = new JSONModel();
			var crModel = new JSONModel();
			var ctModel = new JSONModel();
			
			//获取Input值
			var sInputValue = this.getView().byId("apsCsszTempCodeInput").getSelectedKey();

			//传入参数-过滤条件
			var fcurl  = "FilterCondition";
			var fcjson = { Action:"RT", SiteCode:"A010", TemplateCode:sInputValue };
			this._ajaxfunCsszList(fcModel,fcjson,fcurl);
			this.getView().setModel(fcModel,"gltj");
			
			//传入参数-约束规则
			var crurl  = "ConstraintRule";
			var crjson = { Action:"RT", SiteCode:"A010", TemplateCode:sInputValue };
			this._ajaxfunCsszList(crModel,crjson,crurl);
			this.getView().setModel(crModel,"ysgz");
			
			//传入参数-约束模板
			var cturl  = "ConstraintTemplateItem";
			var ctjson = { Action:"RT", SiteCode:"A010", TemplateCode:sInputValue };
			this._ajaxfunCsszList(ctModel,ctjson,cturl);
			this.getView().setModel(ctModel,"ysmb");
		},
		
		_ajaxfunCsszList:function(oModel,jsonData,callurl){
			jQuery.ajax({
				type:"post",
				data:jsonData,    
				//contentType:"application/json",
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