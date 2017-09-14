#Row
#Stefan Schroder
#2016-03-10

Rows = eval(input("Enter the start number: "))

String = ""
for i in range(Rows,Rows+7):
    String += "{0:>2}".format(str(i))
    if(i!=Rows+6):
        String += " "
    
print (String)