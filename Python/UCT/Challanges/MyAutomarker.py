'''FirstLine = input("Their output:\n")
First =[]
while FirstLine!="":
    First.append(FirstLine)
    FirstLine = input()
    
SecondLine = input("Your output:\n")
Second = []
while SecondLine!="":
    Second.append(SecondLine)
    SecondLine = input()
'''
File = open("First.txt","r")
First = File.readlines()
File.close()

File = open("Second.txt","r")
Second = File.readlines()
File.close()

Equal = True
if(len(Second)==len(First)):
    print("Equal lengths")
for i in range(len(First)):
    if (First[i]!=Second[i]):
        Equal = False
        print("Line "+str(i)+"\n1-"+First[i]+"\n2-"+Second[i])

if(Equal):
    print("Match")
else:
    print("Dont match")