def threeZero(source):
    ret = []
    source.sort()
    print(source)
    i = 0
    length = len(source)
    while i < length:
        a = source[i]
        bi = min(i + 1,length-1)
        b = source[bi]
        ci = length - 1
        c = source[length - 1]
        while a + b + c > 0 and ci > i+1:
            c = source[ci - 1]
            ci -= 1
        while a + b + c > 0 and bi < length - 1:
            b = source[bi + 1]
            bi += 1
        if a + b + c == 0:
            ret.append([a, b, c])
        i += 1

    return ret


if __name__ == "__main__":
    source = [-1, 2, 0, -1, 1, -4]
    print(threeZero(source))
