#!/usr/bin/env bash

#mvn clean install

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/antiflytippingservice-0.0.1-SNAPSHOT.jar \
    root@92.255.107.128:/root/antiflytippingservice

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa root@92.255.107.128 << EOF

pgrep java | xargs kill -9
nohup java -jar antiflytippingservice/antiflytippingservice-0.0.1-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'