#Column
#Stefan Schroder
#2016-03-10

Column = eval(input("Enter a number: "))


for i in range(Column,Column+41,7):
    print("{0:>2}".format(str(i)))