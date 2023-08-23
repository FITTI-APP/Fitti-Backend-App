#!/bin/bash

LOCAL_PORT=5510
DB_PORT=3306
HOST=fitty-develop-database.cmzpqp9pc6gs.ap-northeast-2.rds.amazonaws.com
TARGET_INSTANCE=i-072c1871abe75ae7e


if [[ -z "$AWS_ACCESS_KEY_ID" ]]; then
  export AWS_DEFAULT_REGION=ap-northeast-2
  export AWS_PROFILE=fitty
fi

aws ssm start-session \
--profile=fitty \
--target "$TARGET_INSTANCE"  \
--document-name AWS-StartPortForwardingSessionToRemoteHost \
--parameters host="$HOST",portNumber="$DB_PORT",localPortNumber="$LOCAL_PORT" &
