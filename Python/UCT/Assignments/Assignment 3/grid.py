#Grrid
#Stefan Schroder
#2016-03-10

Number = eval(input("Enter the start number: "))

for Column in range(Number,Number+41,7):
    print("{0:>2}".format(Column),end="")
    for Row in range(Column+1,Column+7):
        print("{0:>3}".format(Row),end="")
    print()