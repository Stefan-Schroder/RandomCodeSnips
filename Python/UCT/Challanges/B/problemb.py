Text = ""

Line=input()

while Line!= "#":
    if(Line=="HALLO"):
        print("AFRIKAANS")
    elif(Line=="HELLO"):
        print("ENGLISH")
    elif(Line=="MOLO"):
        print("ISIXHOSA")
    elif(Line=="BONJOUR"):
        print("FRENCH")
    elif(Line=="SAWUBONA"):
        print("ISIZULU")
    elif(Line=="MARHABA"):
        print("ARABIC")
    else:
        print("UNKNOWN")
    Line = input()