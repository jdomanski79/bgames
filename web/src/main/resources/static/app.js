window.onload = function(){
    let stompClient = null;

    function setConnected(connected){
        let connectedState = (connected) ? "block" : "none";
        let disconnectedState = (connected) ? "none" : "block";
        
        document.getElementById("connected") = connectedState;
        document.getElementById("disconnected") = disconnectedState;

    }

    function connect(){
        let socket = new SockJS('/game');

        stompClient = Stomp.over(socket);
        stompClient.connect({})

    }
}
