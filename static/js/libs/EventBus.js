function EventBus(){
	var instance = this;
	var listeners = {};

	function FunctionCall(scope, func){
	  this.scope = scope;
	  this.func = func;
	};

	FunctionCall.prototype.invoke = function(args){
		this.func.apply(this.scope,args);
	};


	function propagateEvent(array,args){
	  var size = array.length;
		var copy = array.slice();
		for(var i = 0;i < size;i++){
			copy[i].invoke(args);
		}
	};
	/* Returns a copy of the listener attached to the
   *	current event
   */
	instance.listeners = function(eventType) {
		var array = listeners[eventType.name] || [];
		return array.slice();
	};

	/* Add a listener to a given event
	 *
	 */
	instance.addListener = function(event, listener, scope) {
		var eventName = event.eventName;
		var funcCall = new FunctionCall(scope, listener);
		var array = listeners[eventName];
		if (array) {
			array.push(funcCall);
		} else {
			listeners[eventName] = [ funcCall ];
		}
	};

	instance.on = instance.addListener;

	instance.once = function(eventType, listener, scope) {
		var funcCall = new FunctionCall(scope, listener);
		var newListener = function() {
			funcCall.invoke();
			instance.removeListener(eventType, newListener);
		};
		instance.on(eventType, newListener);
	};

	instance.removeListener = function(eventType, listener) {
		var array = listeners[eventType.name] || [];
		array = array.slice();
		var size = array.length;
		for ( var i = 0; i < size; i++) {
			if (array[i] === listener) {
				listeners[eventType.name].slice(i, 1);
			}
		}
	};

	instance.emit = function(event) {
		var eventName = event.eventName;
		var array = listeners[eventName] || [];
		var args = [ event ];
		propagateEvent(array, args);

		// propagate to parent
		for ( var parent = event.superclass ? event.superclass.name : null; parent != null;) {
			if (listeners[parent]) {
				array = listeners[parent];
				propagateEvent(array, args);
			}
			var a = eval(parent);
			parent = a.parent ? a.parent.name : null;
		}
	};
};

eventBus = new EventBus();
// Base class for all events
EventBus.createEvent = function(eventName) {
	var eventfunc = eval("function "
			+ eventName
			+ "(a,b,c){\
    this.data = function(){\
	  	return a;\
  	};\
  	this.eventName = '" + eventName  + "';" +
  	"this.source = function(){\
  		return b;\
	  };\
    this.target = function(){\
	  	return c;\
    };\
  	eventBus.emit(this);\
	};");
	return eval(eventName);
};
Event = EventBus.createEvent("Event");
//
EventBus.newEventType = function(newName, parent) {
	// Function that performs hierarchy
	this.extend = function(subClass, superClass) {
		var F = function() {
		};
		F.prototype = superClass.prototype;
		subClass.prototype = new F();
		subClass.prototype.constructor = subClass;
		subClass.prototype.superclass = superClass;
		if (superClass.prototype.constructor == Object.prototype.constructor) {
			superClass.prototype.constructor = superClass;
		}
	};
	var parent = parent || Event;
	func = EventBus.createEvent(newName);
	func.parent = parent;
	func.eventName = newName;
	window[newName] = func;
	this.extend(func, parent);
};