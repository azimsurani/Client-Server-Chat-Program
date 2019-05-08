import socket

s = socket.socket()

host = socket.gethostname()

port = 12345

s.bind((host,port))

s.listen(1)

while True:
    c, address = s.accept()
    c.send("Hii".encode('ascii'))
    while True:
        print('Client : ', end='')
        msg = c.recv(1024).decode('ascii')
        print(msg)
        if msg == 'bye':
            print('The chat has ended')
            c.send("bye".encode('ascii'))
            break
        else:
            print('Server : ', end="")
            msg = input()
            c.send(msg.encode('ascii'))
    c.close()
