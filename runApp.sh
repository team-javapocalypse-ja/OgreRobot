if [[ $1 == "start" ]]
then
bash -c "exec -a acapi-web java -jar WebClient/target/web-client-1.0.jar &" >>acapi-web
bash -c "exec -a acapi-robot java -jar RobotCrawler/target/robot-crawler-1.0.jar &" >> acapi-robot
echo "The applications is started"
fi
if [[ $1 == "stop" ]]
then
pkill -f acapi-web
pkill -f acapi-robot
echo "The applications is stoped"
fi



