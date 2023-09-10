@echo off
set LOCAL_PORT=5510
set DB_PORT=3306
set HOST=fitty-develop-database.cmzpqp9pc6gs.ap-northeast-2.rds.amazonaws.com
set TARGET_INSTANCE=i-072c1871abe75ae7e

if "%AWS_ACCESS_KEY_ID%"=="" (
  set AWS_DEFAULT_REGION=ap-northeast-2
  set AWS_PROFILE=fitty
)

start aws ssm start-session ^
--profile=fitty ^
--target "%TARGET_INSTANCE%"  ^
--document-name AWS-StartPortForwardingSessionToRemoteHost ^
--parameters host="%HOST%",portNumber="%DB_PORT%",localPortNumber="%LOCAL_PORT%"
