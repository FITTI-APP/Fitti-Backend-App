#!/bin/bash

LOCAL_PORT = 5510



if [[ -z "$AWS_ACCESS_KEY_ID" ]]; then
  export AWS_DEFAULT_REGION=ap-northeast-2
  export AWS_PROFILE=fitty
fi

aws ssm start-session \
--profile=fitty \
--target i-072c1871abe75ae7e \
--document-name AWS-StartPortForwardingSessionToRemoteHost \
--parameters '{"host":["fitty-develop-database.cmzpqp9pc6gs.ap-northeast-2.rds.amazonaws.com"],"portNumber":["3306"], "localPortNumber":["5510"]}'
