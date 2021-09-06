//导入模块是require
const http = require('http');
// 创建一个http server
http.createServer(function(request, response){
	//浏览器怎么认识hello server
	response.writeHead(200, {'Content-type':'text/html'});//以text-plian去解析hello server
	response.end("<strong>hello Server</strong>");
}).listen(8888);
console.log("启动的服务是：http：//localhost：8888")
