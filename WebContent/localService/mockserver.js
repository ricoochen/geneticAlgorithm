/*sap.ui.define([
	"sap/ui/core/util/MockServer"
], function (MockServer) {
	"use strict";

	return {

		init: function () {

			// create
			var oMockServer = new MockServer({
				rootUri:"/serviceUrl/"
//					"https://services.odata.org/V2/Northwind/Northwind.svc/"
			});

			var oUriParameters = jQuery.sap.getUriParameters();

			// configure mock server with a delay
			MockServer.config({
				autoRespond: true,
				autoRespondAfter: oUriParameters.get("serverDelay") || 1000
			});

			// simulate
			var sPath = jQuery.sap.getModulePath("sap.suite.ui.commons.demo.tutorial.localService");
			oMockServer.simulate(sPath + "/metadata.xml", sPath + "/mockdata");

			// start
			oMockServer.start();
		}
	};

});
*/

sap.ui.define([
	"sap/ui/core/util/MockServer"
], function (MockServer) {
	"use strict";
	
	var _sAppModulePath = "sap/ga/aps/",
		_sJsonFilesModulePath = _sAppModulePath + "localService/mockdata";

	return {

		init: function () {
			var sManifestUrl = jQuery.sap.getModulePath(_sAppModulePath + "manifest", ".json"),
				sJsonFilesUrl = jQuery.sap.getModulePath(_sJsonFilesModulePath),
				oManifest = jQuery.sap.syncGetJSON(sManifestUrl).data,
				oMainDataSource = oManifest["sap.app"].dataSources.invoiceRemote,
				sMetadataUrl = jQuery.sap.getModulePath(_sAppModulePath + oMainDataSource.settings.localUri.replace(".xml", ""), ".xml");

			// create
			var oMockServer = new MockServer({
				rootUri: oMainDataSource.uri
			});

			// configure
			MockServer.config({
				autoRespond: true,
				autoRespondAfter: 1000
			});

			// simulate
			oMockServer.simulate(sMetadataUrl, {
				sMockdataBaseUrl : sJsonFilesUrl
			});

			// start
			oMockServer.start();
		}
	};

});
