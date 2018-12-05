#!/bin/bash
echo "Start Server Config"
mkdir classDir
javac -d classDir Cliente.java Servidor.java ServidorChat.java ServidorChatImpl.java

rmic -classpath classDir ServidorChatImpl
rmiregistry &

java -classpath classDir Servidor