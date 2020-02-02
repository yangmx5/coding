set -x
cd ../../
DIR=$(pwd)
docker run -d -e "AXE_ENV=ONLINE" -v $DIR:/opt/ -p 80:80 python:3.7.6 sh /opt/axe/deploy/start.sh
