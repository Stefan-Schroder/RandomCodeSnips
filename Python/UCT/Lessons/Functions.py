Name = ""
Age = ""
Number = ""
print("Hello")
def Table (N,A,Nu):
    Name = N
    Age = A
    Number = Nu
    Stuff = Name+Age+Number
    return Stuff
    
    
def Printer():
    print(Name,Age,Number) 
    

name = input("Name: ")
age = input("Age: ")
number = input("Number: ")
Table(name,age,number)
Printer()

