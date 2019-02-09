package com.devironment.devironmentapi.backoffice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("backoffice")
class HtmlController @Autowired constructor(val notificationService: WasteNotificationService) {



    @GetMapping("connections")
    fun connections() : String {
        return notificationService.connections().size.toString()
    }

    // Checkout: https://medium.com/@codemwnci/kotlin-springboot-and-websockets-276029b22482
    @GetMapping()
    fun getRawHtmlOOOops(): String {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Chat - Websocket Kotlin</title>\n" +
                "\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "    <script src=\"//ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js\"></script>\n" +
                "\n" +
                "    <style>\n" +
                "        .full-height { height: 100%; }\n" +
                "        .input-text  { height: 10%;  }\n" +
                "        .chat-text   { height: 90%;  }\n" +
                "        .border      { border: 1px black; }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body class=\"full-height\">\n" +
                "<div class=\"container-fluid full-height\">\n" +
                "    <div class=\"row chat-text\">\n" +
                "        <div class=\"col-md-10 border chat-text\" id=\"chatbox\">\n" +
                "        </div>\n" +
                "        <div class=\"col-md-2 border chat-text\">\n" +
                "            <ul id=\"userlist\"></ul>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"row input-text border\">\n" +
                "        <div class=\"col-md-10\">\n" +
                "            <input type=\"text\" class=\"btn-block\" id=\"msg\" />\n" +
                "        </div>\n" +
                "        <div class=\"col-md-2\">\n" +
                "            <button type=\"button\" class=\"btn btn-primary btn-block btn-lg\" id=\"send\">\n" +
                "                Send\n" +
                "            </button>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "<script>\n" +
                "        //var webSocket = new WebSocket(\"ws://\" + location.hostname + \":\" + location.port + \"/chat\");\n" +
                "        var webSocket = new SockJS('/chat');\n" +
                "        webSocket.onmessage = function (msg) { receievMsg(JSON.parse(msg.data)) }\n" +
                "        webSocket.onclose = function() { alert(\"Server Disconnect You\"); }\n" +
                "        webSocket.onopen = function() {\n" +
                "            var name = \"\";\n" +
                "            while (name == \"\") name = prompt(\"Enter your name\");\n" +
                "            sendMessage(\"join\", name);\n" +
                "        }\n" +
                "        \$(\"#send\").click(function () {\n" +
                "            sendMessage(\"say\", \$(\"#msg\").val());\n" +
                "        });\n" +
                "        \$(\"#msg\").keypress(function(e) {\n" +
                "            if(e.which == 13) sendMessage(\"say\", e.target.value);\n" +
                "        });\n" +
                "        function sendMessage(type, data) {\n" +
                "            if (data !== \"\") {\n" +
                "                webSocket.send(JSON.stringify({type: type, data: data}));\n" +
                "                \$(\"#msg\").val(\"\");\n" +
                "                \$(\"#msg\").focus();\n" +
                "            }\n" +
                "        }\n" +
                "        function receievMsg(msg) {\n" +
                "            if (msg.msgType == \"say\") {\n" +
                "                \$(\"#chatbox\").append(\"<p>\"+msg.data+\"</p>\");\n" +
                "            }\n" +
                "            else if (msg.msgType == \"join\") {\n" +
                "                addUser(msg.data);\n" +
                "            }\n" +
                "            else if (msg.msgType == \"users\") {\n" +
                "                msg.data.forEach(function(el) { addUser(el); });\n" +
                "            }\n" +
                "            else if (msg.msgType == \"left\") {\n" +
                "                \$(\"#user-\"+msg.data.id).remove();\n" +
                "            }\n" +
                "        }\n" +
                "        function addUser(user) {\n" +
                "            \$(\"#userlist\").append(\"<li id='user-\"+user.id+\"'>\"+user.name+\"</li>\");\n" +
                "        }\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>"
    }
}