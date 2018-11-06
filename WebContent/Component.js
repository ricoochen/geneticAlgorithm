sap.ui.define([
	"sap/ui/core/UIComponent",
	"sap/ga/aps/model/models"
], function(UIComponent, models) {
	"use strict";

	return UIComponent.extend("sap.ga.aps.Component", {

		metadata: {
			manifest: "json"
		},

		/**
		 * The component is initialized by UI5 automatically during the startup of the app and calls the init method once.
		 * @public
		 * @override
		 */
		init: function() {
			// call the base component's init function
			UIComponent.prototype.init.apply(this, arguments);

			// set the device model
			this.setModel(models.createDeviceModel(), "device");

			// create the views based on the url/hash
			this.getRouter().initialize();
		},
		createContent: function() {
			// create root view
			return sap.ui.view("AppView", {
				viewName: "sap.ga.aps.view.App",
				type: "XML"
			});
		}
	});
});
