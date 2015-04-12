function Console(){
	var that = this;
	eventBus.on(LoadEvent, function(){
		that.view = $('#console');
		that.view.keyup(function(event){
			if(event.keyCode==13){
				that.execute(that.view.val());
				that.view.val('');
			}
		});		
	}, this);
};

Console.prototype.execute = function(text){
	var params = text.split(" ");
	var command = params[0];
	params.splice(0,1);
	this.executeCommand({command: command, params: params});
};
Console.prototype.executeCommand = function(command) {
	if(typeof window[command.command] === 'function')
		window[command.command](command.params);
	else
		alert("No es un comando valido");
};

var commandLine = new Console();

function add(params){
	if(params.length != 5){
		alert("Error: Tiene que tener los parametros (code, nombre, pbi, latitud y longitud)");
		return;
	}
	$.ajax({
		type : 'POST',
		//@Path("new/{code}/{name}/{lat}/{lon}/{pbi}")
		url : 'rest/country/new/' + params[0] + '/' + params[1] + '/' + params[3] + '/' + params[4] + '/' + params[2],
		dataType : 'json',
		contentType : 'application/json',
		success: function(country){
			new SetCountryEvent(country);
		}
	});
};

function load(params){
	if(params.length != 1){
		alert("Error: Tiene que tener los parametros (code)");
		return;
	}
	$.ajax({
		type: 'GET',
		//@Path("get/{code}")
		url: 'rest/country/get/' + params[0],
		dataType: 'json',
		contentType: 'application/json',
		success: function(country){
			new SetCountryEvent(country);
		}
	});
};

function buyCB(params){
	if(params.length != 3){
		alert("Error: Tiene que tener los parametros (level, lat, lon)");
		return;
	}
	$.ajax({
		type: 'POST',
		//@Path("unit/buy/centralBase/{code}/{level}/{lat}/{lon}")
		url: 'rest/unit/buy/centralBase/' + game.country.code + '/' + params[0] + '/' + params[1] + '/' + params[2],
		dataType: 'json',
		contentType: 'application/json',
		success: function(country){
			new UpdateCountryEvent(country);
		}
	});
}