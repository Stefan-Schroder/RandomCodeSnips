#Stefan Schroder
#Anagram set
#2016-05-10
def SortDic(Dic):
    SortKey = sorted(Dic)
    for i in range(len(SortKey)):
        SortKey[i]=[SortKey[i],Dic[SortKey[i]]]    
    return str(SortKey)

Length = eval(input("***** Anagram Set Search *****"))

File = open("EnglishWords.txt","r")

Line = File.readline()
while Line != "START":
    Line = File.readline()[0:-1]
print("Searching")    

WordList = []    
for lines in File:
    WordList.append(lines[0:-1])
WordList.sort()
File.close()
WordDicWords = {}
for Lines in WordList:
    if len(Lines) == Length:
        WordDic = {}
        for i in range(len(Lines)):
            if Lines[i] not in WordDic:
                WordDic[Lines[i]]=1
            else:
                WordDic[Lines[i]]+=1
        String = SortDic(WordDic)
        if String in WordDicWords:
            WordDicWords[String]+=" "+Lines
        else:
            WordDicWords[String]=Lines
PairList = []
for Words in WordDicWords:
    if " " in WordDicWords[Words]:
        PairList.append(WordDicWords[Words].split())

FileName = input("Enter a name for the file: ")
File = open(FileName,"w")
PairList.sort()
for Pairs in PairList:
    print(Pairs,file=File)
File.close()