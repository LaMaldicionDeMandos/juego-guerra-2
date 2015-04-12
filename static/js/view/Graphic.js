function Graphic(){
	var that = this;
	eventBus.on(LoadEvent, function(){
		that.view = $('#graphInfo');
		that.view.chart = $('#graph');
	}, this);
	eventBus.on(SetCountryEvent, function(event){
		that.country = event.data();
		that.update();
	}, this);
	eventBus.on(UpdateCountryEvent, function(event){
		that.country = event.data();
		that.update();
	}, this);
};

Graphic.prototype.updateGraphs = function(){
	var stats = this.country.historyStats;
	var i = 0;
	var graphAvailableDynamic = [['Dia','Costo Fijo Estimado','Costo dinamico disponible estimado']];
	var stat;
	var sumFixedCost = 0;
	var sumDynamicCost = 0;
	for(i=0;i<stats.length;i++){
		stat = stats[i];
		sumFixedCost+=stat.fixedCost;
		sumDynamicCost+=stat.dynamicCost;
		graphAvailableDynamic[i+1] = [""+i, sumFixedCost, (stat.amount-sumFixedCost)/(360-i)];
	}
	var estimatedAmount = stat.amount;
	for(var j=i;j<360;j++){
		var estimatedFixedCost = sumFixedCost + sumFixedCost/i;
		var estimatedDynamicCost = sumDynamicCost/i;
		estimatedAmount-= ( estimatedFixedCost + estimatedDynamicCost);
		graphAvailableDynamic[j+1] = [""+j, estimatedFixedCost, (estimatedAmount-estimatedFixedCost)/(360-j)];
	}
	var data = google.visualization.arrayToDataTable(graphAvailableDynamic);
	var options = {
			title: this.country.name,
			hAxis: {title: 'Dias'},
			series: {0:{type:'line'}, 1:{type:'line'},2:{type:'line'}}
	};
	new google.visualization.ComboChart(document.getElementById("graph1")).draw(data, options);
};

Graphic.prototype.update = function(){
	if(this.country== undefined) return;
	this.updateGraphs();
};

var graphic = new Graphic();