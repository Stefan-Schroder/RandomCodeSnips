#Stefan Schroder
#Encryption recursion
#2015-05-03

def encrypt(String):
    if(len(String)!=0):
        character = String[0]
        if(ord(character)==122):
            return "a"+str(encrypt(String[1:]))
        if(96<ord(character)<122):
            return str(chr(1+ord(character)))+str(encrypt(String[1:]))
        return character+str(encrypt(String[1:]))
    return ""
        
String = input("Enter a message:\n")
print("Encrypted message:\n"+encrypt(String))