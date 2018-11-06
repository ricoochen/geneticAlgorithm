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

	var cModel = new JSONModel();
	
	var pageController =  Controller.extend("sap.ga.aps.controller.aps.apsNav", {
		onInit: function (evt) {	
			var sDataPath = jQuery.sap.getModulePath("sap.ga.aps.model.data", "/apsNav.json");
			var oModel = new JSONModel(sDataPath);		
			this.getView().setModel(oModel);   
		},		
		
//		onToggleContextMenu: function(oEvent) {
//			if (oEvent.getParameter("pressed")) {
//				this.byId("spkfswTree").setContextMenu(
//					new Menu({
//						items: [
//							new MenuItem({text:"kfswModel>name"})
//						]
//					})
//				);
//			} else {
//				this.byId("spkfswTree").destroyContextMenu();
//			}
//		},
		
		handleSelectChange: function(oEvent) {
			var oTree = this.getView().byId("apsNavList").getList();
			oTree.setMode(oEvent.getParameter("selectedItem").getKey());
		},
		
		onapsNavListItem: function(oEvent){
			var oContext = oEvent.getSource().getBindingContext();
			
			if (oContext == "/apsNav/0/nodes/0"){
				//参数设置
				this.getOwnerComponent().getRouter().navTo("apsCssz");
			}else if(oContext == "/apsNav/0/nodes/0/nodes/0"){
				//过滤条件
				this.getOwnerComponent().getRouter().navTo("apsCsszGltj");
			}else if(oContext == "/apsNav/0/nodes/0/nodes/1"){
				//约束规则
				this.getOwnerComponent().getRouter().navTo("apsCsszYsgz");
			}else if(oContext == "/apsNav/0/nodes/0/nodes/2"){	
				//约束模板
				this.getOwnerComponent().getRouter().navTo("apsCsszYsmb");
			}else if(oContext == "/apsNav/0/nodes/1"){
				MessageToast.show(oContext);
			}else if(oContext == "/apsNav/0/nodes/2"){
				MessageToast.show(oContext);
			}else if(oContext == "/apsNav/0/nodes/3"){
				MessageToast.show(oContext);
			};
		},
		
		onapsNavButton: function() {
			var oRouter = this.getOwnerComponent().getRouter();
			oRouter.navTo("home");
		},
		
	});
	
	return pageController;
});
