#Stefan Schroder
#Recusion palendrome
#2016-05-03

def Pala(Pos,String):
    length = len(String)
    if(length/2<Pos):
        return True
    if(String[Pos]==String[-Pos-1]):
        return Pala(Pos+1,String)
    return False

String = input("Enter a string:\n")
if(Pala(0,String)):
    print("Palindrome!")
else:
    print("Not a palindrome!")