cd /opt
pip install -r requirement.txt >/opt/log.txt 2>&1
cd axe
python manage.py runserver 0.0.0.0:80 >/opt/log.txt 2>&1
