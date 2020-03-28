#!/bin/bash

SCRIPTPATH="$( cd "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"
JAR_ABSOLUTE_PATH="$SCRIPTPATH/Tinei-Matewai.jar"

echo "Installing wiringpi"
sudo apt-get install -y wiringpi > /dev/null

echo "Cleaning space..."
rm -f "$JAR_ABSOLUTE_PATH"
echo "Downloading Tinei-Matewai.jar snapshot latest verion..."
wget -q -O "$JAR_ABSOLUTE_PATH" --content-disposition "https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=com.github.tousinho&a=Tinei-Matewai&v=LATEST&e=jar&c=jar-with-dependencies"
#curl -Ls -o "$JAR_ABSOLUTE_PATH" "https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=com.github.tousinho&a=Tinei-Matewai&v=LATEST&e=jar&c=jar-with-dependencies"

echo "Congifure Service..."
#sudo cp tinei.service /etc/systemd/system/tinei.service

echo "Starting application..."

#sudo systemctl start tinei
#sudo systemctl enable tinei
java -jar "$JAR_ABSOLUTE_PATH"