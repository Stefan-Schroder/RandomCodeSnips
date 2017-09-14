def readFile():
    filename = input("File name: ")
    try:
        f = open(filename,"r")
    except:
        readFile()
    line = f.readline()
    while(line!=""):
        print(line)
        line = f.readline()
    f.close()
    


f = open("hello.txt","w")
print("Ello bro",file=f)
f.close()

readFile()