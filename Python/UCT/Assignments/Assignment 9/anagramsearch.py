#Stefan Schroder
#Anogram search 
#2016-05-10
print("***** Anagram Finder *****")
try:
    f = open("EnglishWords.txt","r")
    line = f.readline()
    while line[0:-1] != "START":
        line = f.readline()
    #print("done")
    Word = input("Enter a word:\n").lower()
    List = []
    WordDic = {}
    for i in range(len(Word)):
        if Word[i] not in WordDic:
            WordDic[Word[i]]=1
        else:
            WordDic[Word[i]]+=1
    #print(WordDic)
    WordList = []
    for lines in f:
        WordList.append(lines[0:-1])
    f.close()
    #print(len(WordList))
    FinalList = []
    for line in WordList:
        if len(line)==len(Word):
            if Word[0] in line:
                lineDic = {}
                for i in range(len(line)):
                    if line[i] not in lineDic:
                        lineDic[line[i]]=1
                    else:
                        lineDic[line[i]]+=1        
                if(lineDic==WordDic and line!=Word):
                    FinalList.append(line)
    FinalList.sort()
    if(len(FinalList)!=0):
        print(FinalList)
    else:
        print("Sorry, anagrams of '"+Word+"' could not be found.")
except:
    print("Sorry, could not find file 'EnglishWords.txt'.")