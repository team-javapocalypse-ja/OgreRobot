if [[ $1 == "start" ]]
then
echo "The applications is starting"
bash -c "exec -a acapi-web java -jar WebClient/target/web-client-1.0.jar &" 
bash -c "exec -a acapi-robot java -jar RobotCrawler/target/robot-crawler-1.0.jar &" 
fi
if [[ $1 == "stop" ]]
then
echo "The applications are stopping"
pkill -f acapi-web
pkill -f acapi-robot

fi



