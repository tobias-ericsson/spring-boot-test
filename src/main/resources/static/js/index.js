var stompClient = null;
var names = ["Stomper", "Tester", "Fester","Blizz"];
var myName = names[Math.floor(Math.random() * 4)];
console.log("myName "+myName);

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            var socket = new SockJS('/stomp');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
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
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }