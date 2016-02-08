var stompClient = null;
var names = ["Stomper", "White Horse", "Gullag","Blizz","White Wolf"];
var myName = names[Math.floor(Math.random() * 5)];

        function setConnected(connected) {
            document.getElementById('connect').style.display = connected ? 'none' : 'inline';
            document.getElementById('disconnect').style.display = connected ? 'inline' : 'none';
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            var socket = new SockJS('/stomp');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                microAjax("/api/all", function (res) {
                    var responseJson = JSON.parse(res);
                    var k = responseJson.length;
                    while (k--) {
                         showMessage(responseJson[k]);
                    }
                });

                stompClient.subscribe('/topic/messages', function(response){
                    console.log(response);
                    showMessage(JSON.parse(response.body).message);
                });
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            document.getElementById('header').innerHTML = "Hello "+myName;
            document.getElementById('connect').innerHTML = "Connect as "+myName;
            console.log("Disconnected");
        }

        function logout() {
            window.location.href = "/logout";
            console.log("logged out");
        }

        function sendMessage() {
            var message = document.getElementById('message').value;
            var name = myName;
            stompClient.send("/app/stomp", {}, JSON.stringify({ 'message': name+": "+message }));
        }

        function showMessage(message) {
            var section = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            //section.appendChild(p);
            section.insertBefore( p, section.firstChild );
        }