var page = require('webpage').create();
phantom.outputEncoding = "gbk";
page.open("https://blog.csdn.net/u010760374", function (status) {
    if (status == "success") {
        console.log(page.title);
        page.render("D:\\file\\endcy.png");
        page.paperSize = {format: 'A4', orientation: 'portrait', border: '1cm'};
        page.render("D:\\file\\endcy.pdf")
    } else {
        console.log("Page failed to load");
    }
    phantom.exit(0);
})