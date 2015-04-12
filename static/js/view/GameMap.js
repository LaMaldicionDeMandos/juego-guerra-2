function GameMap(){
	var that = this;
	this.map = null;
	this.units = null;
	this.container;
	eventBus.on(MapLoadedEvent, function(event){
		that.map = event.data();
		google.maps.event.addListener(that.map, 'center_changed', function(){
			var position = that.map.getCenter();
			that.setLabel(position.toString());			
		});
		that.label = $('#mapLabel');
		that.setLabel(that.map.getCenter().toString());
		that.setCircle();
	}, this);
	eventBus.on(SetCountryEvent, function(event){
		var country = event.data();
		var center = new google.maps.LatLng(country.lat, country.lon);
		that.map.setCenter(center);
	}, this);
	eventBus.on(ArriveUnitsEvent, function(event){
		that.clearMap();
		that.units = event.data();
		that.addUnits(that.units);
	}, this);
};

//Private Methods
GameMap.prototype.clearMap = function(){
	if(this.units==undefined) return;
	for(var i=0;i<this.units.length;i++){
		this.units[i].marker.setMap(null);
	}
};

GameMap.prototype.addUnits = function(units){
	for(var i=0;i<this.units.length;i++){
		this.addUnit(this.units[i]);
	}
};

GameMap.prototype.addUnit = function(unit){
	var myLatLng = new google.maps.LatLng(unit.lat, unit.lon);
	var flag = new google.maps.MarkerImage('images/flags/' + unit.countryCode + '.png',
			new google.maps.Size(16,12),
			new google.maps.Point(0,0),
			new google.maps.Point(26,26));
    unit.marker = new google.maps.Marker({
    	position: myLatLng,
    	map: this.map,
    	icon: 'images/icons/' + unit.type + '.png',
    	shadow: flag,
    	title: unit.name
    });
};

GameMap.prototype.setCircle = function(){
	this.container = $('#mapContainer');
	this.circle = $('#mapCircle');
	this.circle.css('top', this.container.height()/2 - 8);
	this.circle.css('left', this.container.width()/2 - 8);
};

GameMap.prototype.setLabel = function(label){
	this.label.text(label);
};

var mapView = new GameMap();