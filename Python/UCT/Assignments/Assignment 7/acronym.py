#Stefan Schoder
#Acronym
#2016-04-21

IgnorList = input("Enter words to be ignored separated by commas:\n").upper().split(", ")
FList = input("Enter a title to generate its acronym:\n").upper().split()

Acronym = ""
for words in FList:
    if words not in IgnorList:
        Acronym += words[0]
    
print("The acronym is: "+Acronym)