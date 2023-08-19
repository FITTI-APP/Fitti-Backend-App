#!/bin/bash

aws ssm start-session \
--target i-077dc234214b32607 \
--document-name AWS-StartPortForwardingSessionToRemoteHost \
--parameters '{"host":["fitty-develop-database.cmzpqp9pc6gs.ap-northeast-2.rds.amazonaws.com"],"portNumber":["3306"], "localPortNumber":["5510"]}'

aws ssm start-session \
--target i-011aae92b218d1aa7 \
--document-name AWS-StartPortForwardingSessionToRemoteHost \
--parameters '{"host":["awseb-e-sm8j3aindp-stack-awsebrdsdatabase-hp55tcxbhajy.cmzpqp9pc6gs.ap-northeast-2.rds.amazonaws.com"],"portNumber":["3306"], "localPortNumber":["5511"]}'
