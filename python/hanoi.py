def hanio(n, a, b, c):
    count = 0 
    if n == 1:
        return 1 
    else:
        count += hanio(n-1, a,c,b)
        count += hanio(1,a ,b, c)
        count += hanio(n-1, b, a ,c)
        return count

def move(n, a, buffer, c):
    if(n == 1):
        print(a,"->",c)
        return
    move(n-1, a, c, buffer)
    move(1, a, buffer, c)
    move(n-1, buffer, a, c)

if __name__ == "__main__":
    print(hanio(3 ,"a", "b", "c"))
    move(3, "a", "b", "c")