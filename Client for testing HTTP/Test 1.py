import sys
import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
HOST = socket.gethostbyname(socket.gethostname())
print(HOST)
s.connect((HOST,8089))
header = b"""GET / HTTP/1.1\n\n"""
s.send(header)
result = s.recv(10000)
while (len(result) > 0):
    print(result.decode())
    result = s.recv(10000) 
s.close()
