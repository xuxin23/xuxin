// xuxin-javascript库
// COPY RIGHT 2013



/**
 * 封装的一个执行ajax请求的通用函数
 */

function ajax(options) {

	// 如果用户没有提供某个选项的对象，这些选项在下面的注释中简述这样呢
	options = {
		// HTTP 请求的类型
		type: options.type || "POST",
		// 请求的 URL
		url: options.url || "",
		// 请求的数据类型
		contentType: options.contentType || "application/x-www-form-urlencoded",
		// 请求的数据
		data: options.data || "",

		// 请求超时的时间
		timeout: options.timeout || 5000,
		// 请求完成(不管成功还是失败)、请求失败、请求成功 时执行的函数
		onComplete: options.onComplete || function() {},
		onError: options.onError || function() {},
		onSuccess: options.onSuccess || function() {},

		// 服务器将会返回的数据类型，这一默认值用于判断服务器返回的数据并作相应动作
		returnType: options.returnType || ""
	};

	// 创建请求对象(封装的方法)
	var xml = createXMLHttpRequest();

	// 初始化异步请求
	xml.open(options.type, options.url, true);

	// 设置请求参数类型(告知服务器端如何解析传递的参数)
	xml.setRequestHeader("Content-Type", options.contentType);

	// 我们在请求后等待 5 秒，超时则放弃
	var timeoutLength = options.timeout;

	// 记录请求是否成功完成
	var requestDone = false;

	// 初始化一个 5 秒后执行的回调函数，用于取消请求(如果尚未完成的话)
	setTimeout(function() {
		requestDone = true;
	}, timeoutLength);

	// 监听文档状态的更新
	xml.onreadystatechange = function() {
		// 保持等待，直到数据完全加载，并保证请求并未超时
		if (xml.readyState == 4 && !requestDone) {

			// 检查是否请求成功(封装的方法)
			if (httpSuccess(xml)) {

				// 以服务器返回的数据作为参数调用成功回调的函数
				options.onSuccess(httpData(xml, options.returnType));

				// 否则就发生了错误，执行错误回调函数
			} else {
				options.onError();
			}

			// 调用完成回调函数
			options.onComplete();

			// 为避免内存泄露，清理文档
			xml = null;
		}
	};

	// 建立与服务器的连接
	xml.send(options.data);
}


/**
 * 生成兼容的XMLHttpRequest对象
 */

function createXMLHttpRequest() {
	if (typeof XMLHttpRequest == 'undefined') {
		XMLHttpRequest = function() {
			// Internet Explorer使用ActiveXObject来创建新的XMLHttpRequest对象
			return new ActiveXObject(
			// IE 5 使用的XMLHTTP对象和IE 6 不同
			navigator.userAgent.indexOf("MSIE t 5") >= 0 ?
				"Microsoft.XMLHTTP" : "Msxml2.XMLHTTP");
		};
	}
	return new XMLHttpRequest();
}

/**
 * 将数据结构串行化为兼容HTTP的参数模式
 * @param a ：要串行化的参数
 */

function serialize(param) {
	// 串行化结果的数组
	var arr = [];

	// 若传入的参数是数组，假定它们是表单元素的数组
	if (param.constructor == Array) {

		// 串行化表单元素
		for (var i = 0; i < param.length; i++) {
			arr.push(param[i].name + "=" + encodeURIComponent(param[i].value));
		}

		// 否则，假定这是一个键值对对象
	} else {

		// 串行化键值对
		for (var j in param) {
			arr.push(j + "=" + encodeURIComponent(param[j]));
		}
	}

	// 返回串行化结果
	return arr.join("&");
}

/**
 * 检查服务器HTTP响应的成功状态
 */

function httpSuccess(xmlHttpRequest) {
	try {
		// 如果得不到服务器状态，且我们正在请求本地文件，认为成功
		return !xmlHttpRequest.status && location.protocol == "file:" ||

		// 所有 200 到 300 间的状态码表示成功
		(xmlHttpRequest.status >= 200 && xmlHttpRequest.status < 300) ||

		// 文档未修改也算成功
		xmlHttpRequest.status == 304 ||

		// Safari 在文档未修改时返回空状态
		navigator.userAgent.indexOf("Safari") >= 0 && typeof xmlHttpRequest.status == "undefined";
	} catch (e) {}

	// 若检查状态失败，就假定请求是失败的
	return false;
}

/**
 * 从 HTTP 响应中解析数据
 * @param r : 一个XMLHttpRequest对象
 * @param type ：可选参数，期望从服务器得到的数据类型(xml,script,text,html,"")
 * @returns
 */

function httpData(r, type) {
	// 获取 content-type 首部
	var ct = r.getResponseHeader("content-type");

	// 若没有提供默认的类型，判断服务器返回的是否是 XML 形式
	var data = !type && ct && ct.indexOf("xml") >= 0;

	// 若是，获得 XML 文档对象，否则返回文本内容
	data = type == "xml" || data ? r.responseXML : r.responseText;

	// 若指定类型是 "script" ,则以 JavaScript 形式执行返回文本
	if (type == "script") {
		eval.call(window, data);
	}

	// 返回响应数据 (或为 XML 文档或为文本字符串)
	return data;
}