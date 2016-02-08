#!/bin/bash
#sudo apt-get install inotify-tools
mvn package -DskipTests spring-boot:run &
while inotifywait -r -e modify src; do
  pkill -f spring-boot
  mvn package spring-boot:run  -DskipTests &
  xdotool search "Google Chrome" windowactivate --sync key 'ctrl+F5'

  #CHROME_WINDOW_ID=$(xdotool search --onlyvisible --class google-chrome | head -1)
  #xdotool key --window $CHROME_WINDOW_ID 'CTRL+r'
  ###mvn clean package
done
