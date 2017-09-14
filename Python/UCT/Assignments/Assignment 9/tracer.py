#Stefan Schroder
#Tracer
#2016-05-10

FileName = input("***** Program Trace Utility *****\nEnter the name of the program file: ")
File = open(FileName, 'r')
LineList = []
Line = File.readline()
if(Line[0:-1]!="\"\"\"DEBUG\"\"\""):
    LineList.append("\"\"\"DEBUG\"\"\"\n"+Line[0:-1])
    for Lines in File:
        if "\n" in Lines:
            LineList.append(Lines[0:-1])
        else:
            LineList.append(Lines)
    File.close()
    for i in range (len(LineList)):
        if "def" in LineList[i]:
            LineList[i]+="\n    \"\"\"DEBUG\"\"\";print('"+LineList[i][LineList[i].find("def")+4:LineList[i].find("(")]+"')"
else:
    for lines in File:
        if "\"\"\"DEBUG\"\"\"" not in lines:
            if "\n" in lines:
                LineList.append(lines[0:-1])
            else:
                LineList.append(lines)
    File.close()
    


File = open(FileName, "w")
for i in range(len(LineList)):
    print(LineList[i],file=File,end="")
    if(i!=len(LineList)-1):
        print(file=File)
File.close()