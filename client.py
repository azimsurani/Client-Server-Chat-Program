import socket
s = socket.socket()
host = socket.gethostname()
port = 12345
s.connect((host,port))

while True:
    print('Server : ', end='')
    msg = s.recv(1024).decode('ascii')
    print(msg)
    if msg == 'bye':
        print('The chat has ended')
        s.send("bye".encode('ascii'))
        break
    else:
        print('Client : ', end="")
        msg = input()
        s.send(msg.encode('ascii'))
s.close()