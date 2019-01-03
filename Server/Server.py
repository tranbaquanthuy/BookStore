import socket
import threading
import base64
import pyodbc
import datetime
import time
bind_ip = socket.gethostname()
bind_port = 8089

cnxn = pyodbc.connect("Driver={ODBC Driver 13 for SQL Server};"
                      "Server=localhost;"
                      "Database=QuanLyNhaSach;"
                      "Trusted_Connection=yes;")
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((bind_ip, bind_port))
server.listen(5)  # max backlog of connections
print ("Listening on {}:{}".format(bind_ip, bind_port))
rowdata = []
loginstate  = False
check  = False
listClient = []
usernameClient = []
class Player:
  def __init__ (self, socket, name = "" ):
        self.socket = socket 
        self.name = name
  def setName(self, name) :
         self.name = name 
def DeleteAccount(username):
   cursor = cnxn.cursor()
   try :
    cursor.execute("Delete from taikhoan where username  = '" + str(username) +"'")
    cnxn.commit()
    rowdata.append(str("Success").strip())
   except :
    rowdata.append(str("Failed").strip())
def DeleteLoaiSach(maLoaiSach):
   cursor = cnxn.cursor()
   try :
    cursor.execute("Delete from loaisach where maLoaiSach  = '" + maLoaiSach +"'")
    cnxn.commit()
    rowdata.append(str("Success").strip())
   except :
    rowdata.append(str("Failed").strip())
def CreateSach(maLoaiSach,maTacGia,maSach,tenSach,giaMua):
   cursor = cnxn.cursor()
   try :
    cursor.execute("Insert into  sach(maSach,tenSach,maLoaiSach,giaMua,maTacGia,moTa) values  ('"+ maSach +"','" + tenSach  +"','" + maLoaiSach+"','" + giaMua+"','"  + maTacGia+ "',' ')")
    cnxn.commit()
    rowdata.append(str("Success").strip())
   except :
    rowdata.append(str("Failed").strip())
def CreateLoaiSach(tenLoaiSach,maLoaiSach):
   cursor = cnxn.cursor()
   try :
    cursor.execute("Insert into  loaisach(maLoaiSach,tenLoaiSach) values  ('" + maLoaiSach +"', '" + tenLoaiSach + "')")
    cnxn.commit()
    rowdata.append(str("Success").strip())
   except :
    rowdata.append(str("Failed").strip())
def Login_Checking(username , password):
    cursor = cnxn.cursor()
    cursor.execute("select * from taikhoan where username='"+ str(username).strip() + "' And pass='" + str(password).strip() + "'")
    for row in cursor:
     rowdata.append(str(row.id).strip())
     rowdata.append(str(row.name).strip())
     rowdata.append(str(row.chucVu).strip())
def SearchAccount():
    cursor = cnxn.cursor()
    cursor.execute("Select * from taikhoan")
    for row in cursor:
     rowdata.append(str(row.id).strip())
     rowdata.append(str(row.name).strip())
     rowdata.append(str(row.username).strip())
     rowdata.append(str(row.passwrd).strip())
     rowdata.append(str(row.chucVu).strip())
def SearchLoaiSach():
    cursor = cnxn.cursor()
    cursor.execute("Select * from loaisach")
    for row in cursor:
     rowdata.append(str(row.maLoaiSach).strip())
     rowdata.append(str(row.tenLoaiSach).strip())
def CreateAccount(username,password,name,ID,chucvu):
  cursor = cnxn.cursor()
  try :
    cursor.execute("sp_createaccount '" + username + "','" + password +"','" + name + "','" + ID +"','" +chucvu+ "'")
    cnxn.commit()
    rowdata.append(str("Success").strip())
  except:
    rowdata.append(str("Failed").strip())

def UpdateAccount(username,password,name,ID,chucvu):
  cursor = cnxn.cursor()
  try :
    cursor.execute("Update taikhoan set username  ='" + username + "', passwrd= '" + password +"',name ='" + name  +"',chucVu='" +chucvu+ "' Where id ='" + ID + "'")
    cnxn.commit()
    rowdata.append(str("Success").strip())
  except:
    rowdata.append(str("Failed").strip())
def UpdateSach(maSach,tenSach,tenTacGia,tenLoaiSach,giaMua,tongSoLuong):
  cursor = cnxn.cursor()
  try :
    cursor.execute("Update sach,tacgia set tenSach  ='" + tenSach + "', giaMua= '" + giaMua +"',name ='" + name  +"',chucVu='" +chucvu+ "' Where id ='" + ID + "'")
    cnxn.commit()
    rowdata.append(str("Success").strip())
  except:
    rowdata.append(str("Failed").strip())
def UpdateLoaiSach(tenLoaiSach,maLoaiSach):
  cursor = cnxn.cursor()
  try :
    cursor.execute("Update loaisach set tenLoaiSach  ='" + tenLoaiSach + "' Where maLoaiSach = '" + maLoaiSach + "'")
    cnxn.commit()
    rowdata.append(str("Success").strip())
  except:
    rowdata.append(str("Failed").strip())
def Book_Searching(SearchData,Attribute):
    cursor = cnxn.cursor()
    n = "'" + str(SearchData).strip() + "'"
    if Attribute == "All"  :
     cursor.execute("Select * from sach,tacgia,loaisach,kho Where dbo.tacgia.maTacGia  = dbo.sach.maTacGia and dbo.sach.maLoaiSach  = dbo.loaisach.maLoaiSach and dbo.sach.maSach = dbo.kho.maSach")
    else:   
     cursor.execute("Select * from sach,tacgia,loaisach,kho Where CHARINDEX(" + n +"," + Attribute + ") > 0 and dbo.tacgia.maTacGia  = dbo.sach.maTacGia and dbo.sach.maLoaiSach  = dbo.loaisach.maLoaiSach and dbo.sach.maSach = dbo.kho.maSach")
    for row in cursor: 
      rowdata.append(str(row.maSach).strip())
      rowdata.append(str(row.tenSach).strip())
      rowdata.append(str(row.tenTacGia).strip())
      rowdata.append(str(row.tenLoaiSach).strip())
      rowdata.append(str(row.giaMua).strip())
      rowdata.append(str(row.tongSoLuong).strip())
def _generate_headers(response_code):
        """
        Generate HTTP response headers.
        Parameters:
            - response_code: HTTP response code to add to the header. 200 and 404 supported
        Returns:
            A formatted HTTP header for the given response_code
        """
        header = ''
        if response_code == 200:
            header += 'HTTP/1.1 200 OK\n'
        elif response_code == 404:
            header += 'HTTP/1.1 404 Not Found\n'

        time_now = time.strftime("%a, %d %b %Y %H:%M:%S", time.localtime())
        header += 'Date: {now}\n'.format(now=time_now)
        header += 'Server: Simple-Python-Server\n'
        header += 'Connection: close\n\n' # Signal that connection will be closed after completing the request
        return header
def SearchAdvanced(tentacgia,loaisach):
    cursor = cnxn.cursor()   
    cursor.execute("Select * from sach,tacgia,loaisach,kho Where  dbo.tacgia.maTacGia  = dbo.sach.maTacGia and dbo.sach.maLoaiSach  =dbo.loaisach.maLoaiSach and dbo.sach.maSach = dbo.kho.maSach and dbo.tacgia.tenTacGia = '" + tentacgia + "' and dbo.loaisach.tenLoaiSach ='" + loaisach + "'")
    for row in cursor: 
      rowdata.append(str(row.maSach).strip())
      rowdata.append(str(row.tenSach).strip())
      rowdata.append(str(row.tenTacGia).strip())
      rowdata.append(str(row.tenLoaiSach).strip())
      rowdata.append(str(row.giaMua).strip())
      rowdata.append(str(row.tongSoLuong).strip())
def handle_client_connection(client_socket,address):  
 while True:
  try  :
    request = client_socket.recv(1024)
    print(datetime.datetime.now())
    print("....Recieved packet from client: {}" .format(address))
    request_method = request.decode().split(' ')[0]
    content_dir = "web"
    data = request.decode()
    if request_method == "GET" or request_method == "HEAD":
                print(request)
                print("Method: {m}".format(m=request_method))
                print("Request Body: {b}".format(b=data))
                # Ex) "GET /index.html" split on space
                file_requested = data.split(' ')[1]

                # If get has parameters ('?'), ignore them
                file_requested =  file_requested.split('?')[0]
                
                if file_requested == "/":
                    file_requested = "/1.html"
                elif file_requested == "/2.html":
                    file_requested = "/2.html"
                elif file_requested == "/example.xml":
                    file_requested = "/example.xml"
                elif file_requested == "/example2.xml":
                    file_requested = "/example2.xml"
                filepath_to_serve = content_dir + file_requested
                print("Serving web page [{fp}]".format(fp=filepath_to_serve))

                # Load and Serve files content
                try:
                    f = open(filepath_to_serve, 'rb')
                    if request_method == "GET": # Read only for GET
                        response_data = f.read()
                    f.close()
                    response_header = _generate_headers(200)

                except Exception as e:
                    print("File not found. Serving 404 page.")
                    response_header = _generate_headers(404)
                    if request_method == "GET": # Temporary 404 Response Page
                        response_data = b"<html><body><center><h1>Error 404: File not found</h1></center><p>Head back to <a href='/'>dry land</a>.</p></body></html>"
                response = response_header.encode()
                
                if request_method == "GET":
                    response += response_data
                #listClient.remove(client_socket)
                client_socket.send(response)
                client_socket.close()
                break
    else:
    
     n = base64.b64decode(str(request.decode()))
     m = str(n)[2:len(str(n))-1].split("|.|")
     k = False 
     print(m)
     
     rowdata.clear()
     if len(m) == 4 :
      if m[3] == "Caculate" :
        client_socket.send('%rXTX'.encode() %(base64.b64encode(str(int(m[0])+int(m[1])).encode())))
        client_socket.close()
     if len(m) == 3 :
      if m[2] == "Login" :
       Login_Checking(m[0],m[1])
      elif m[2] == "Search" :
       Book_Searching(m[0],m[1])
      elif m[2] == "SearchAccount":
       SearchAccount()
      elif m[2] == "DeleteAccount":
       DeleteAccount(m[1])
      elif m[2] == "SearchLoaiSach":
       SearchLoaiSach()
      elif m[2] == "SearchAdvanced":
       SearchAdvanced(m[0],m[1])
      elif m[2] == "UpdateLoaiSach":
       UpdateLoaiSach(m[0],m[1])
      elif m[2] == "CreateLoaiSach":
       CreateLoaiSach(m[0],m[1])
      elif m[2] == "DeleteLoaiSach":
       DeleteLoaiSach(m[1])
      elif m[2]  == "Disconnect":
        client_socket.send('%rXTX\n'.encode() %(base64.b64encode("Disconnect".encode())))
        print("Client logout!!!")
        usernameClient.remove(listClient.index(client_socket))
        listClient.remove(client_socket)
        client_socket.close()
        break
        break
      elif m[2] == "ChatLogin"   :
        client  = Player(client_socket,m[1])
        listClient.append(client)
        if m[1] not in usernameClient :
            usernameClient.append(m[1])
        print("len listClient" + str(len(listClient)))
        print(listClient[0].name)
        for i in listClient :
            print("sending")
            i.socket.send((m[1]+ "  " + m[0]).encode())
            i.socket.send('\n'.encode())
        check = True
      elif m[2] == "Chat"   :
        if m[1] not in usernameClient :
            usernameClient.append(m[1])
        for i in listClient :
            print("sending")
            i.socket.send((m[1]+ ": " + m[0]).encode())
            i.socket.send('\n'.encode())
        check = True
     elif len(m) == 6 :
      if m[5] == "CreateAccount" :
          CreateAccount(m[0],m[1],m[2],m[3],m[4])
      elif m[5] == "UpdateAccount" :
         UpdateAccount(m[0],m[1],m[2],m[3],m[4])
      elif m[5] == "CreateSach" :
        CreateSach(m[0],m[1],m[2],m[3],m[4])
     if rowdata  :
      print("Data found!Sending packet...")
      print(rowdata)
      if m[2] == "Login" :
       loginstate = True
       client_socket.send('%rXTX%rXTX%r\n'.encode() % (base64.b64encode(rowdata[0].encode()),base64.b64encode(rowdata[1].encode()),base64.b64encode(rowdata[2].encode())))
      elif m[2] == "Search" :
       if len(rowdata) > 1 :
        for i  in  range(len(rowdata)) :
          client_socket.send('%rXTX'.encode() %(base64.b64encode(rowdata[i].encode())  )  )
        client_socket.send('\n'.encode())
       else :
          client_socket.send('%rXTX\n'.encode() % (base64.b64encode(rowdata[0].encode() )  ) )
      elif m[2] == "SearchAccount" and loginstate == True :
        print(loginstate)
        if len(rowdata) > 1 :
         for i  in  range(len(rowdata)) :
          client_socket.send('%rXTX'.encode() %(base64.b64encode(rowdata[i].encode())  )  )
         client_socket.send('\n'.encode())
        else :
         client_socket.send('%rXTX\n'.encode() % (base64.b64encode(rowdata[0].encode() )  ) )
      elif m[2] == "SearchAccount" and loginstate == False :
        client_socket.send('%rXTX'.encode() %(base64.b64encode("not login".encode())))
      elif m[2] == "DeleteAccount" or m[2] == "DeleteLoaiSach" :
         client_socket.send('%rXTX\n'.encode() %(base64.b64encode(rowdata[0].encode())  )  )
      elif m[2] == "SearchLoaiSach":
         if len(rowdata) > 1 :
           for i  in  range(len(rowdata)) :
             client_socket.send('%rXTX'.encode() %(base64.b64encode(rowdata[i].encode())  )  )
           client_socket.send('\n'.encode())
         else :
           client_socket.send('%rXTX\n'.encode() % (base64.b64encode(rowdata[0].encode() )  ) )
         
      elif m[2] == "SearchAdvanced":
         if len(rowdata) > 1 :
           for i  in  range(len(rowdata)) :
             client_socket.send('%rXTX'.encode() %(base64.b64encode(rowdata[i].encode())  )  )
           client_socket.send('\n'.encode())
         else :
           client_socket.send('%rXTX'.encode() % (base64.b64encode(rowdata[0].encode() )  ) )
           client_socket.send('\n'.encode())
      elif m[2] == "UpdateLoaiSach" or m[2] == "CreateLoaiSach":
           client_socket.send('%rXTX'.encode() % (base64.b64encode(rowdata[0].encode() )  ) )
           client_socket.send('\n'.encode())
      elif m[5] == "CreateAccount" or m[5] == "UpdateAccount"   :
         client_socket.send('%rXTX'.encode() %(base64.b64encode(rowdata[0].encode())  )  )
         client_socket.send('\n'.encode())
      elif m[5] == "CreateSach" :
         client_socket.send('%rXTX'.encode() %(base64.b64encode(rowdata[0].encode())  )  )
         client_socket.send('\n'.encode())
     elif  check != True :
      print("Data not found!Sending packet...")
      client_socket.send('no data'.encode())
      print(".......Closing connection........")
      if client_socket in listClient :
       listClient.remove(client_socket)
      client_socket.close()
      break
     check = False
  except:
    print("Client terminated connection!!!")
    for i in listClient :
      if i.socket == client_socket :
        n = i.name
        listClient.remove(i)
        if len(listClient) > 0 :
          for i in listClient :
            print("sending")
            i.socket.send((n+ " has been " + "logout , ciao !").encode())
            i.socket.send('\n'.encode())
          check = True
    if client_socket in listClient :
     n  = usernameClient[listClient.index(client_socket).name];
     usernameClient.remove(n)
     listClient.remove(client_socket)
     if len(listClient) > 0 :
      for i in listClient :
            print("sending")
            i.socket.send((n+ " has been " + "logout , ciao !").encode())
            i.socket.send('\n'.encode())
      check = True
    client_socket.close()
    break

while True:
    client_sock, address = server.accept()
    print ('Accepted connection from {}:{}'.format(address[0], address[1]))
    client_handler = threading.Thread(
        target=handle_client_connection,
        # without comma you'd get a... TypeError: handle_client_connection() argument after * must be a sequence, not _socketobject
        args=(client_sock,address[0],)  
    )
    client_handler.start() 
