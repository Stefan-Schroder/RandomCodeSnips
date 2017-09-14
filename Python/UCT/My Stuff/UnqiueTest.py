def mis(lst):
    for i in range(len(lst)):
        item = lst[0]
        del lst[0]
        try:
            number = lst.index(item)
            break
        except:
            pass
    else:
        return True
    return False

lists = [1,1,4,5]
print(mis(lists))