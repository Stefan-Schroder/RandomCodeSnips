def LeFunction(Array):#How normal people do it
    CopyArray = Array
    return CopyArray

def LeRetardFunction(Array):#How python does it
    CopyArray = []
    for A in Array:
        CopyArray.append(A)
    return CopyArray
        
FirstArray = ["E","B","O","L","A"]
NormalArray = LeFunction(FirstArray)
PythonArray = LeRetardFunction(FirstArray)

print("",FirstArray,"FirstArray unchanged.\n",
      NormalArray,"NormalArray before changing, copied like a normal person would.\n",
      PythonArray,"PythonArray, copied like a retard.\n")


FirstArray[0] = "A"#ONLY CHANGE WAS MADE TO FIRSTARRAY, after the copying
print("",FirstArray,"Changed the first element to an A.\n",
      NormalArray,"Unchanged array that was copied like a normal person changed?\n",
      PythonArray,"The unconfortable moment when you do things wrong but they work. :|")