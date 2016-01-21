// xuxin-javascript库
// COPY RIGHT 2013


/**
 * 模拟getElementsByClass()类选择器
 * 获取.class修饰的对象数组
 * @param className:要获取的class类型
 * @param outId:查询的范围
 */
function getElementsByClass(className,outId) {
	var element = document.getElementById(outId)||document;			//查找范围
	var temobj = element.getElementsByTagName('*')||document.all;	//查找范围的所有对象
	var classnames = [];											//接收数组
	
	for (var i=0;i<temobj.length;i++) {
		var child = temobj[i];
		var classname = child.className.split(' ');					//提取对象的多个class
		for (var j=0;j<classname.length;j++) {
			if (classname[j] == className) {
				classnames.push(child);								//将符合的对象添加到数组
				break;												//和java一样，中止当前循环
			}
		}
	}
	return classnames;
}

/**
 * 检查元素是否有用一个指定的特性
 * @param elem：检查的元素
 * @param name：检查是否有可用的属性
 * @returns {Boolean}
 */
function hasAttribute(elem,name) {
	return elem.getAttribute(name) != null;
}

/**
 * 取消事件冒泡的通用方法
 * @param e: W3C的事件对象
 */
function stopBubble(e) {
	if (e && e.stopPropagation) {				//如果传入了事件对象，那么就是非IE浏览器
		e.stopPropagation();					//因此它支持W3C的stopPropagation()方法
	} else {
		window.event.cancelBubble = true;		//否则，我们得使用IE的方式来取消事件冒泡
	}
}

/**
 * 阻止浏览器默认行为的通用方法
 * @param e：W3C的事件对象
 */
function stopDefault(e) {
	if (e && e.preventDefault) {				//防止默认浏览器行为(W3C)
		e.preventDefault();
	} else {									//IE中阻止浏览器行为的捷径
		window.event.returnValue = false;		
	}
}

/**
 * 获取指定元素(elem)的真实、最终的样式属性(name)
 * 不足：这个函数忽略其他的计量单位(比如使用百分比)
 * @param elem：元素
 * @param name：属性
 */
function getStyle(elem,name) {
	if (elem.style[name]) {						//如果属性存在于style[]中，那么它已被设置了(并且是当前的)
		return elem.style[name];
	}
	
	else if (elem.currentStyle) {				//否则，尝试使用IE的方法
		return elem.currentStyle[name];
	}
	
	else if (document.defaultView && document.defaultView.getComputedStyle) {		//或者W3C的方法，如果存在的话
		name = name.replace(/([A-Z])/g,"-$1");	//它使用的通用的'text-align'的样式规则而非'textAlign'
		name = name.toLowerCase();
		
		var s = document.defaultView.getComputedStyle(elem, "");					//获取样式对象并获取属性(存在的话)值
		return s && s.getPropertyValue(name);
	}
	
	else {										//否则，用户使用的是其他浏览器
		return null;
	}
}

/**
 * 获取元素相对于整个文档的X(水平，左端)位置
 * @param elem
 */
function pageX(elem) {
	return elem.offsetParent ?								//查看我们是否位于根元素
			elem.offsetLeft + pageX(elem.offsetParent) : 	//如果我们能继续得到上一个元素，增加当前的偏移量并继续向上递归
			elem.offsetLeft;								//否则，获取当前的偏移量
}

/**
 * 获取元素相对于整个文档的Y(垂直，顶端)位置
 * @param elem
 */
function pageY(elem) {
	return elem.offsetParent ?								//查看我们是否位于根元素
			elem.offsetTop + pageY(elem.offsetParent) :		//如果我们能继续得到上一个元素，增加当前的偏移量并继续向上递归
			elem.offsetTop;									//否则，获取当前的偏移量
}

/**
 * 获取元素相对于父亲元素的X(水平)位置
 * @param elem
 */
function parentX(elem) {
	return elem.parentNode == elem.offsetParent ? 			//如果offsetParent是元素的父亲，那么提前退出
			elem.offsetLeft : 
			pageX(elem) - pageX(elem.parentNode);			//否则，需要找到元素和元素的父亲相对于整个页面位置，并计算他们之间的差
}

/**
 * 获取元素相对于父亲元素的Y(垂直)位置
 * @param elem
 */
function parentY(elem) {
	return elem.parentNode == elem.offsetParent ? 			//如果offsetParent是元素的父亲，那么提前退出
			elem.offsetTop : 
			pageY(elem) - pageY(elem.parentNode);			//否则，需要找到元素和元素的父亲相对于整个页面位置，并计算他们之间的差
}