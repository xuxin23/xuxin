
var init = function() {
	initContainer({
		id:'container'
	});
}

var play = function() {
	var width = document.getElementById('width').value;
	var height = document.getElementById('height').value;
	var HSpeed = document.getElementById('HSpeed').value;

	var box = new Box({
		HSpeed:HSpeed,
		width:width,
		height:height
	});
	box.init();
	Box.run(box);
}



