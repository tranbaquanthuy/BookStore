import pyodbc
cnxn = pyodbc.connect("Driver={SQL Server Native Client 11.0};"
                      "Server=localhost\SQLEXPRESS;"
                      "Database=QuanLyNhaSach;"
                      "Trusted_Connection=yes;")
cursor = cnxn.cursor()
cursor.execute("Select * from loaisach")
for row in cursor:
    print(row)
