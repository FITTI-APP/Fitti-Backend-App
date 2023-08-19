#!/bin/bash

pid=$(lsof -ti TCP:5512 -s TCP:LISTEN)

if [[ -z $pid ]]; then
  echo "Running session not found"
  exit 1
else
  if ! kill "$pid"; then
    echo "Fail to stop session"
    exit 1
  fi
fi

echo "Session stopped"
