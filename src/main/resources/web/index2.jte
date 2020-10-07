@param String pero

@tag.page(
    page = pero,
    content = @`
        <a about=""></a>
        <script>
        function pero() {

        }
        </script>
        <p>Welcome, ${welcomePage.getUserName()}.</p>
    `,
    footer = @`
        <p>Thanks for visiting, come again soon!</p>
    `
)