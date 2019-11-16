def is_valid(str):
    stack = []
    ret_stack = []
    length = len(str)
    print("str length:{}".format(length))
    x =0
    y =0
    i = 0
    while i < length:
        if str[i] == '(':
            stack.append(str[i])
            ret_stack.append(i)
            x+=1
        elif str[i] == ')':
            if len(stack) == 0:
                stack.append(str[i])
                ret_stack.append(i)
            else:
                stack.pop()
                ret_stack.pop()
            y+= 1
        i += 1
    print("( {} ) {}".format(x,y))
    print(stack)
    print(ret_stack)

if __name__ == '__main__':
    # str ="{% set form_data = get_form_data_from_process(process, raw_value=True)%}{{ (get_form_data_value(form_data, 'direct_leader') == get_form_data_value(form_data, 'new_direct_leader')) or (get_form_data_value(form_data, 'direct_leader') == get_form_data_value(form_data, 'leader') or (get_form_data_value(form_data, 'direct_leader') == get_form_data_value(form_data, 'new_leader') and not (get_form_data_value(form_data, 'is_skip_new_leader_approval') == 1) ) and not (is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'direct_leader'), to_external_ids=[1]) or is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'leader'), to_external_ids=[1])))or ((is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'direct_leader'), to_external_ids=[1]) or is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'leader'), to_external_ids=[1])) and (is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'direct_leader'), to_external_ids=[1,458])))}}"
    # str = "{{% set form_data = get_form_data_from_process(process, raw_value=True)%}{{ get_form_data_value(form_data, 'is_skip_leader_approval') == 1 or (get_form_data_value(form_data, 'direct_leader') == get_form_data_value(form_data, 'new_leader')) or (get_form_data_value(form_data, 'leader') == get_form_data_value(form_data, 'new_direct_leader')) or (get_form_data_value(form_data, 'leader') == get_form_data_value(form_data, 'new_leader') and not (not get_form_data_value(form_data, 'is_skip_leader_approval') == 1 and get_form_data_value(form_data, 'is_skip_new_leader_approval') == 1) ) or ((is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'direct_leader'), to_external_ids=[1]) or is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'leader'), to_external_ids=[1])))}}"
    str = "{% set form_data = get_form_data_from_process(process))%}{{(get_form_data_value(form_data, 'new_direct_leader') == get_form_data_value(form_data, 'new_leader') and not (is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'direct_leader', raw_value=True), to_external_ids=[1]) or is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'leader'), to_external_ids=[1]))) or ((is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'direct_leader'), to_external_ids=[1]) or is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'leader'), to_external_ids=[1])) and (is_relation_user(process, ['self'], from_external_ids=get_form_data_value(form_data, 'new_direct_leader'), to_external_ids=[1,458])))}}"
    # str = "()((())"
    print(str[50:60])
    is_valid(str)


