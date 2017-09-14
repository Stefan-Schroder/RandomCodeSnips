def ListEdit(List):
    newList=[]
    for i in range(len(List)):#PYTHON IS SO RETARDED
        PlaceHolder = List[i]
        newList.append(PlaceHolder)
    return newList

FirstList = ["Hello"]
print(FirstList)
Copy = ListEdit(FirstList)
print(Copy)
FirstList[0] = "olleH"
print(FirstList,"====",Copy)