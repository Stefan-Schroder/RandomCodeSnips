#Stefan Schroder
#Recursive pairs
#2016-05-03

def Pairs(String,Pairz):
    
    if(len(String)!=0 and String[0]==String[1] ):
        Pairz+=1
        String = String[1:]
    if(len(String)==2 or len(String)==0):
        print("Number of pairs:",Pairz)
    else:
        String = String[1:]
        Pairs(String,Pairz)
    
String = input("Enter a message:\n")
Pairs(String,0)