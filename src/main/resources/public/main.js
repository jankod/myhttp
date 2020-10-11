class SimpleServer {



}

$(function () {
    $("a").on('click', function (e) {
        e.stopPropagation();
        let goto = $(this).data('goto');
        if(goto == null) {
            return ;
        }
        let url = "/page?name=" + goto;
        $("#content").load(url, '', function (response, status, xhr) {
            console.log("load finish");
        });
        console.log(url + " " + goto);
    });
})