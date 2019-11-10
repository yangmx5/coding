class Cache():
    def __init__(self, size):
        self.size = size
        self.l = []
        self.d = {}

    def put(self, key,value):
        if len(self.d) >= self.size:
            remove = self.l[0]
            del self.d[remove]
        self.l.append(key)
        self.d[key] = value

    def get(self,key):
        if key in self.d.keys():
            self.l.remove(key)
            self.l.append(key)
            return self.d[key]
        else:
            return -1;

if __name__ == '__main__':
    cache = Cache(2)
    cache.put(1,1)
    cache.put(2,2)
    print(cache.get(1))
    cache.put(3,3)
    print(cache.get(2))
    import pdb;pdb.set_trace()
