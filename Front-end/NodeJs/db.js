// 导入mysql依赖包
var mysql = require("mysql");

//创建mysql的connection对象
//配置数据链接的信息
var connection = mysql.createConnection({
	host:"127.0.0.1",
	port:"3306",
	user:"root",
	password:"1234",
	database:"font"
});

//开辟链接
connection.connect();
//执行curd
connection.query("select * from books", function(error, result, fiellds){
	if(error)throw error;
	console.log("results = ", result);
});
//关闭链接
connection.end();