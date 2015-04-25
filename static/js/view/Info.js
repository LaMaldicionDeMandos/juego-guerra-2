function Info(){
	var that = this;
	this.country=null;
	eventBus.on(LoadEvent, function(){
		that.view = $('#info');
		that.view.title = $('#infoTitle');
		that.view.pbi = $('#infoPbi');
		that.view.reserve = $('#infoReserve');
		that.view.win = $('#infoWin');
		that.view.estimation = $('#infoEstimation');
		that.view.date = $('#infoDate');
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

Info.prototype.update = function(){
	this.view.title.text(this.country.name);
	this.view.pbi.text(this.country.pbi);
	this.view.reserve.text(this.country.reserve);
	this.view.win.text(this.country.pbiPercent*100 + '%');
	this.view.estimation.text(this.country.currentAmount);
	var minute = this.country.date.minute < 10 ? "0" + this.country.date.minute : this.country.date.minute;  
	this.view.date.text(this.country.date.day + " " + this.country.date.hour + ":" + minute);
};

var infoView = new Info();