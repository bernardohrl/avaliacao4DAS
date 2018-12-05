#!/bin/bash
echo "Cleaning files and Process"
rm -r classDir
rm ServidorChatImpl_Stub.class

kill -9 $(lsof -ti :1099)