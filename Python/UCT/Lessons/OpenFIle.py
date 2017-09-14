file = open("OpenTest.txt","rt")
print(file.read())
file.close()

file = open("OpenTest.txt","a")
file.write(input(":"))
file.close()