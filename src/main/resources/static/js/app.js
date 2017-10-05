var projectBoosterTpl = "<div id=\"projectBooster\" class=\"form-group col-sm-6\"><label> <input type=\"checkbox\" id=\"{{id}}\" name=\"projectBooster\" value=\"{{name}}\">" +
    "<strong>{{name}}</strong>" +
    "<p class=\"help-block\">{{#description}}{{& .}}{{/description}}</p></label></div>";

$(function () {
    var ws = null;
    var wsConnect = function () {
        ws = new WebSocket('ws://localhost:8080/boosters');
        ws.onmessage = function (event) {
            console.log("Data"+event)
            console.log("Data Body"+event.data)
            var boosterJson = JSON.parse(event.data);
            displayBooster(boosterJson);
        };

        ws.onopen = function (event) {
            ws.send("");
        };

    };

    var wsDisconnect = function () {
        if (ws != null) {
            ws.close();
        }
        console.log("Disconnected");
    };

    var displayBooster = function (boosterJson) {
        if (boosterJson) {
            var html = Mustache.to_html(projectBoosterTpl, boosterJson);
            $('#catalogs').append(html);
        }
    };

    wsConnect();
});