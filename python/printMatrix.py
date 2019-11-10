def printMatrix(matrix):
    ret = []
    if len(matrix) == 0:
        return []
    lens = len(matrix)
    cols = len(matrix[0])
    maxcircle = min(lens / 2, cols / 2)
    i = 1
    x = 0
    y = 0
    while i <= maxcircle:
        while x < cols - i:
            ret.append(matrix[y][x])
            x += 1
        while y < lens - i:
            ret.append(matrix[y][x])
            y += 1
        while x > 0 + i - 1:
            ret.append(matrix[y][x])
            x -= 1
        while y > 0 + i:
            ret.append(matrix[y][x])
            y -= 1
        i += 1
    while x >= 0 + i - 2:
        ret.append(matrix[y][x])
        x -= 1
    return ret


if __name__ == "__main__":
    # matrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
    matrix = [[1],[2]]
    for line in matrix:
        print("{}".format(line))
    print(printMatrix(matrix))
