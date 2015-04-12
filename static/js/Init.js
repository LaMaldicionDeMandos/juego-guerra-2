var map = null;
EventBus.newEventType('LoadEvent');
EventBus.newEventType('MapLoadedEvent');
EventBus.newEventType('SetCountryEvent');
EventBus.newEventType('UpdateCountryEvent');
EventBus.newEventType('ArriveUnitsEvent');
function initialize(){
	var myOptions = {
	          center: new google.maps.LatLng(-34.6037, -58.3815),
	          zoom: 12,
	          mapTypeId: google.maps.MapTypeId.HYBRID
	        };
	map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
	new MapLoadedEvent(map);
	new LoadEvent();
};

function Game(){
	var that = this;
	this.units = null;
	this.country = null;
	this.enemyUnits = null;
	eventBus.on(SetCountryEvent, function(event){
		that.onSetCountry(event.data());
	}, this);
	eventBus.on(UpdateCountryEvent, function(event){
		that.onUpdateCountry(event.data());
	}, this);
	eventBus.on(ArriveUnitsEvent, function(event){
		that.units = event.data();		
	}, this);
};

Game.prototype.onSetCountry = function(country){
	this.country = country;
	this.getUnits();
};

Game.prototype.onUpdateCountry = function(country){
	this.country = country;
	this.getUnits();
};

Game.prototype.getUnits = function(){
	$.ajax({
		type : 'GET',
		//@Path("unit/get/{code}")
		url : 'rest/unit/get/' + this.country.code,
		dataType : 'json',
		contentType : 'application/json',
		success: function(units){
			new ArriveUnitsEvent(units);
		}
	});
};

var game = new Game();