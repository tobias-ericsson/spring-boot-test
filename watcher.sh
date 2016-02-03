#!/bin/bash

while inotifywait -r -e modify src; do
  mvn package
  xdotool search "Google Chrome" windowactivate --sync key 'ctrl+F5'

  #CHROME_WINDOW_ID=$(xdotool search --onlyvisible --class google-chrome | head -1)
  #xdotool key --window $CHROME_WINDOW_ID 'CTRL+r'
  ###mvn clean package
done