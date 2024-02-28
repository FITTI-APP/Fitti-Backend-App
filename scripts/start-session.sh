#!/bin/bash

LOCAL_PORT=5510
DB_PORT=3306
HOST=awseb-e-jbmkfabqb8-stack-awsebrdsdatabase-36e4du1mqcmb.czfhscjza5go.ap-northeast-2.rds.amazonaws.com
TARGET_INSTANCE=i-09b8cb6e38e6d4a19


if [[ -z "$AWS_ACCESS_KEY_ID" ]]; then
  export AWS_DEFAULT_REGION=ap-northeast-2
  export AWS_PROFILE=fitti
fi

aws ssm start-session \
--profile=fitti \
--target "$TARGET_INSTANCE"  \
--document-name AWS-StartPortForwardingSessionToRemoteHost \
--parameters host="$HOST",portNumber="$DB_PORT",localPortNumber="$LOCAL_PORT" &
