var page = require('webpage').create();
phantom.outputEncoding = "gbk";
page.open("https://blog.csdn.net/u010760374", function (status) {
    if (status == "success") {
        console.log(page.title);
        page.render("D:\\file\\endcy_0.png");
        page.includeJs("http://code.jquery.com/jquery-1.10.1.min.js",function () {
            page.evaluate(function () {
                $('.title-blog').html('My PhantomJS');
                // $(document).attr("title","ok");
                // $("title").html("");
            });
            page.render("D:\\file\\endcy_1.png");
        });
    } else {
        console.log("Page failed to load");
    }
    phantom.exit(0);
})