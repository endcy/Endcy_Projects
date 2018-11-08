var filePath = 'D:\\project\\getWebData\\src\\main\\resources\\hello.js';
if (fs.exists(filePath) && fs.isFile(filePath)) {
    var ins = fs.open(filePath, 'r'); //r 读取文件;w 写文件，会覆盖;a 写文件，追加;rb 读取二进制流;rw 写入二进制流
    while (!ins.atEnd()) {
        var buffer = ins.readLine();
        console.log(buffer);
    }
}