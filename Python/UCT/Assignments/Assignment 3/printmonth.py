#Calander print
#Stefan Schroder
#2016-03-12

Month = input("Enter the month ('January', ..., 'December'): ")
DayStart = input("Enter the start day ('Monday', ..., 'Sunday'): ")

Days = 31
if(Month == "February"):
    Days = 28
if(Month == "April" or Month=="June" or Month=="September" or Month=="November"):
    Days = 30

Start = 1
if(DayStart == "Tuesday"):
    Start = 0
elif(DayStart == "Wednesday"):
    Start = -1
elif(DayStart == "Thursday"):
    Start = -2
elif(DayStart == "Friday"):
    Start = -3
elif(DayStart == "Saturdat"):
    Start = -4
elif(DayStart == "Sunday"):
    Start = -5

print(Month,"\nMo Tu We Th Fr Sa Su")

for i in range(Start,Days+1,7):
    if(i>0):
        Row = "{0:>2}".format(i)
    else:
        Row = "  "
    for j in range(i+1,i+7):
        if j<=0:
            Row = Row+"   "
        elif Days>=j:
            Row = Row+"{0:>3}".format(j)
    print(Row)