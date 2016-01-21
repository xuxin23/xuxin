// 容器
var parentElement;

/**
 * 容器初始化
 * 		必输属性：id
 * 		可输属性：className width height
 * */
var initContainer = function(options) {
	parentElement = document.getElementById(options.id);
	parentElement.className = options.className || 'box_container';
	parentElement.style.position = 'relative';
	parentElement.style.width = options.width || '1340px';
	parentElement.style.height = options.height || '600px';
}

/*
 * 动力学盒子
 * 		可输属性：className top left width height HSpeed VSpeed
 * */
var Box = function(options) {
	this.top = options.top || 0;
	this.left = options.left || 0;
	this.width = options.width || '50px';
	this.height = options.height || '50px';
	this.className = options.className || 'box_box';
	this.HSpeed = options.HSpeed || 0; //横向速度
	this.VSpeed = options.VSpeed || 0; //竖向初始速度
	this.speed = 0;//最终速度
	this.time = 0; //运行时间
	this.gTime = 0; //加速度时间
	this.g = 10; //重力加速度
	this.element; //图形DOM
		
	this.init = function() {
		var element = document.createElement('div');
		element.style.top = this.top;
		element.style.left = this.left;
		element.style.width = this.width;
		element.style.height = this.height;
		element.className = this.className;
		element.style.position = 'absolute';
		parentElement.appendChild(element);
		this.element = element;
	};
}

Box.run = function(box) {
		box.time += 0.001;
		box.gTime += 0.001;
		box.speed = box.VSpeed + box.gTime * box.g * 100;
	   	box.top += box.speed * 0.001 + box.g * 0.001 * 0.001 * 1000;
		box.left += box.HSpeed * 0.001 * 10;
		box.element.style.top = box.top + 'px';
		box.element.style.left = box.left + 'px';

		if (box.top >= parseInt(parentElement.style.height) - parseInt(box.height)) {
			box.speed = -box.speed * 0.8;
			box.VSpeed = box.speed;
			box.gTime = 0;
		}

		if (box.left >= parseInt(parentElement.style.width) - parseInt(box.width)) {
			box.HSpeed = -box.HSpeed;
		} else if(box.left <= 0) {
			box.HSpeed = -box.HSpeed;
		}
		
		if (box.top < parseInt(parentElement.style.height) - parseInt(box.height) - 1 || box.speed < -0.1 || box.speed > 1) {
			setTimeout(function() {Box.run(box);}, 1);
		} else {
			setTimeout(function() {parentElement.removeChild(box.element)}, 5000);
		}
}


