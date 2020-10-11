class SimpleServer {


    static searchLink() {


        document.addEventListener('click', function (event) {
            // If the event target doesn't match bail
            if (!event.target.hasAttribute('data-goto')) return;

            event.stopPropagation();
            event.preventDefault();

            //console.log(event.target.dataset.goto);
            let goto = event.target.dataset.goto; //$(this).data('goto');
            if (goto == null) {
                return;
            }
            let url = "/page/" + goto;
            $("#content").load(url, '', function (response, status, xhr) {
                console.log("load finish");
            });
            console.log(url + " " + goto);
        });
    }

}


$(function () {
     SimpleServer.searchLink()
})