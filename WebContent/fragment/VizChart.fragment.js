sap.ui.define([
	"jquery.sap.global",
	"sap/viz/ui5/controls/VizFrame",
	"sap/viz/ui5/data/FlattenedDataset",
	"sap/viz/ui5/data/DimensionDefinition",
	"sap/viz/ui5/data/MeasureDefinition",
	"sap/viz/ui5/controls/common/feeds/FeedItem",
	"sap/ui/model/json/JSONModel"
], function(jQuery, VizFrame, FlattenedDataset, DimensionDefinition, MeasureDefinition, FeedItem, JSONModel) {
	"use strict";

	return sap.ui.jsfragment("sap.ga.aps.fragment.VizChart", {
		createContent: function(controller) {

			var oVizFrame = new VizFrame({
				height: "700px",
				width: "100%",
				vizType: "vertical_bullet",
				uiConfig: {
					applicationSet: 'fiori'
				}
			});

			var oDataset = new FlattenedDataset({
				dimensions: new DimensionDefinition({
					name: "Ice Cream",
					value: "{id}"
				}),
				measures: [
					new MeasureDefinition({
						name: "Temperature",
						value: "{temperature}"
					}),
					new MeasureDefinition({
						name: "Target Temperature",
						value: "{target}"
					})
				],
				data: "{/Temperatures}"
			});

			oVizFrame.setDataset(oDataset);

			oVizFrame.addFeed(new FeedItem({
				uid: "valueAxis",
				type: "Measure",
				values: [
					"Temperature"
				]
			}));

			oVizFrame.addFeed(new FeedItem({
				uid: "targetValues",
				type: "Measure",
				values: [
					"Target Temperature"
				]
			}));

			oVizFrame.addFeed(new FeedItem({
				uid: "categoryAxis",
				type: "Dimension",
				values: [ "Ice Cream" ]
			}));

			oVizFrame.setVizProperties({
				plotArea: {
					showGap: true
				},
				title: {
					visible: false
				},
				valueAxis: {
					title: {
						text: controller.getOwnerComponent().getModel("i18n").getResourceBundle().getText("chartContainerTemperature")
					}
				}
			});

			var sDataPath = jQuery.sap.getModulePath("sap.ga.aps.model.data", "/IceCreamTestData.json");
			var oModel = new JSONModel(sDataPath);
			controller.getView().setModel(oModel);

			return oVizFrame;
		}
	});
});
