<html>
<head>
    <script>
        $.get("/RoboPost/r/colors", function(data) {
            console.log(data)
            var template = $('#colors_select_template').html()
            var html = Mustache.to_html(template, data)
            $('#colors_placeholder').html(html)
        })
    </script>
</head>
<body>


    <div class="row" >
        <form id="login" class="form-horizontal" role="form" method="post" action="/RoboPost/r/register">
            <div class="form-group">
                <label for="Username" class="col-sm-2 control-label">User name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="Username" name="username">
                </div>
            </div>
            <div class="form-group">
                <label for="Color" class="col-sm-2 control-label">Color</label>
                <div class="col-sm-10" id="colors_placeholder">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Send</button>
                </div>
            </div>
        </form>
    </div>

    <script id="colors_select_template" type="text/template">
        <select id="Color" class="form-control" name="color">
            {{#.}}
            <option style="background-color: {{.}};">{{.}}</option>
            {{/.}}
        </select>
    </script>
</body>
</html>
