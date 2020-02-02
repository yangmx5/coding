import os
import yaml


def get_conf():
    env = os.environ.get('AXE_ENV', 'LOCAL')
    path = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    file_name = "conf/axe.{}.yml".format(env.lower())
    conf_path = os.path.join(path, file_name)
    with open(conf_path, 'r') as conf:
        ret = yaml.load(conf, Loader=yaml.SafeLoader)
        return ret


if __name__ == '__main__':
    print(get_conf())
