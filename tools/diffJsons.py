# encoding=utf-8


def diff(param_a, param_b):
    """
    a and b must same object
    :param param_a:
    :param param_b:
    :return:
    """
    if isinstance(param_a, dict):
        for key, value in param_a.items():
            item_a = param_a.get(key, None)
            item_b = param_b.get(key, None)
            if item_a != item_b:
                if isinstance(item_a, dict):
                    print("diff dict key: {}".format(key))
                elif isinstance(item_a, list):
                    print("diff list key: {}".format(key))
                    for item in item_a:
                        if item in item_b:
                            item_a.remove(item)
                            item_b.remove(item)
                    diff(item_a, item_b)

                else:
                    print("diff key: {} valueOfA: {}, valueOfB: {}".format(key, value, param_b.get(key, {})))
            else:
                pass
                # param_a.pop(key)
                # param_b.pop(key)
    elif isinstance(param_a, list):
        for item in param_a:
            if item in param_b:
                param_a.remove(item)
                param_b.remove(item)
            else:
                print("diff list item of a: {}".format(item))
        for item in param_b:
            if item in param_a:
                param_a.remove(item)
                param_b.remove(item)
            else:
                print("diff list item of b: {}".format(item))
        for item in param_a:
            item_list(item, param_b)
    else:
        print("not valid type")


def item_list(item, unknown_list):
    from copy import deepcopy
    for tmp in unknown_list:
        temp_item = deepcopy(item)
        if isinstance(item, dict) and "field_name" in temp_item:
            if isinstance(item, dict) and "field_name" in tmp:
                if temp_item.get("field_name") == tmp.get("field_name"):
                    print("find a: {} \nb: {}".format(temp_item, tmp))
        if isinstance(item, dict) and "task_name" in temp_item:
            if isinstance(item, dict) and "task_name" in tmp:
                if temp_item.get("task_name") == tmp.get("field_name"):
                    print("find a: {} \nb: {}".format(temp_item, tmp))


def diff_map(map1, map2):
    for key ,value in map1.items():
        pass



if __name__ == '__main__':
    with open("1.txt", "rt", encoding="utf-8") as test_a:
        with open("2.txt", "rt", encoding="utf-8") as test_b:
            import json

            file_a = test_a.read()
            file_b = test_b.read()

            file_a = json.loads(file_a)
            file_b = json.loads(file_b)
            diff(file_a, file_b)
