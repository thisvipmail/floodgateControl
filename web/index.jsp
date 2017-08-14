<!DOCTYPE html>  
<html>  
<head>
	<meta charset="utf-8">  
    <title>WebSocket/SockJS Echo Sample (Adapted from Tomcat's echo sample)</title>  
  
    <script type="text/javascript">  
    
        var url = 'ws://' + window.location.host + '/floodgateControl/websocket.mvc?type=zl';  
        var ws;
        function connect() {  
        	
            ws = new WebSocket(url);  
  
            ws.onopen = function () {  
                console.log('Info: connection opened.');  
            };  
            ws.onmessage = function (event) {  
            	console.log('Received: ' + event.data);  
            };  
            ws.onclose = function (event) {  
            	console.log('Info: connection closed.');  
            	console.log(event);  
            };  
        }  
  
        function disconnect() {  
            if (ws != null) {  
                ws.close();  
                ws = null;  
            }  
        }  
        
        var url1 = 'ws://' + window.location.host + '/floodgateControl/websocket.mvc?type=zl2';  
        var ws1;
        function connect1() {  
        	
            ws1 = new WebSocket(url1);  
  
            ws1.onopen = function () {  
                console.log('Info: connection opened.');  
            };  
            ws1.onmessage = function (event) {  
            	console.log('Received: ' + event.data);  
            };  
            ws1.onclose = function (event) {  
            	console.log('Info: connection closed.');  
            	console.log(event);  
            };  
        }  
  
        function disconnect1() {  
            if (ws1 != null) {  
                ws1.close();  
                ws1 = null;  
            }  
        }
  
        function broadcast() {
    		$.ajax({
    			url : path + 'msg/broadcast',
    			type : "post",
    			data : {
    				text : $("#msg").val()
    			},
    			dataType : "json",
    			success : function(data) {
    				alert("发送成功");
    			}
    		});
    	}
    </script>  
</head>  
<body>  
	<button id="connect" onclick="connect();">Connect</button>  
	<button id="disconnect" onclick="disconnect();">Disconnect</button>  
	<button id="connect" onclick="connect1();">Connect1</button>  
	<button id="disconnect" onclick="disconnect1();">Disconnect1</button>  
	<hr />
	<input type="button" value="broadcast" onclick="broadcast()">
</body>  
</html>  