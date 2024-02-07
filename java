const socket = new WebSocket('ws://localhost:3000');

socket.onopen = function(event) {
    console.log('WebSocket connection established.');
};

socket.onmessage = function(event) {
    const messages = document.getElementById('messages');
    const message = document.createElement('div');
    message.innerText = event.data;
    messages.appendChild(message);
};

document.getElementById('sendButton').addEventListener('click', sendMessage);

function sendMessage() {
    const messageInput = document.getElementById('messageInput');
    const message = messageInput.value;
    socket.send(message);
    messageInput.value = '';
}
