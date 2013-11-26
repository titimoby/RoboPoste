<html>
<head>
    <script>
        $.get("/RoboPost/r/users", function(data) {
            console.log(data)
            var template = $('#users_select_template').html()
            var html = Mustache.to_html(template, data)
            $('#users_placeholder').html(html)
        })

        $.get("/RoboPost/r/messagesByUser?user=${currentUser.name}", function(data) {
            console.log(data)
            var template = $('#messages_template').html()
            var html = Mustache.to_html(template, data)
            $('#messages_placeholder').html(html)
        })
    </script>
</head>
<body>


    <div class="row" >
        <form id="postMessages" class="form-horizontal" role="form" method="post" action="/RoboPost/r/sendMessage">
            <div class="form-group">
                <label for="Recipient" class="col-sm-2 control-label">Recipient</label>
                <div class="col-sm-10" id="users_placeholder">
                </div>
            </div>
            <div class="form-group">
                <label for="Message" class="col-sm-2 control-label">Message</label>
                <div class="col-sm-10">
                    <textarea id="Message" class="form-control" name="message"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Send</button>
                </div>
            </div>
        </form>
    </div>

    <hr />

    <div class="row" >
        <div id="messages_placeholder"></div>
    </div>

    <div class="row" > &nbsp;</div>

    <script id="users_select_template" type="text/template">
        <select id="Recipient" class="form-control" name="recipient">
            {{#.}}
            <option style="background-color: {{.}};">{{name}}</option>
            {{/.}}
        </select>
    </script>

    <script id="messages_template" type="text/template">
        {{#.}}
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-3">
                <h3>{{to.name}}</h3>
                {{^dateDelivered}}not delivered{{/dateDelivered}}{{#dateDelivered}}sent {{dateDelivered}}{{/dateDelivered}}
            </div>
            <div class="col-md-7">
                <div class="well">
                {{message}}
                </div>
            </div>
        </div>
        {{/.}}
    </script>
</body>
</html>
