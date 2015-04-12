function List(){
	var that = this;
	this.units=null;
	eventBus.on(ArriveUnitsEvent, function(event){
		that.units = event.data();
		that.view = $('#units');
		that.view.box = $('#unitListBox');
		that.view.box.empty();
		for(var i=0; i<that.units.length;i++){
			that.view.box.append(new UnitItem(that.units[i]).component);
		}
	}, this);
	
};

function UnitItem(unit){
	var that = this;
	var led;
	if(unit.state=='UNAVAILABLE')
		led = 'images/grey_led.png';
	this.component = $("<div id='" + unit.id + "' class='row'>" +
			"<div class='leftPanel'>" + unit.name + "</div>" + 
			"<div class='rightPanel'><img src='" + led + "' class='right'/></div>" +
			"</div>");
	
};

var list = new List();