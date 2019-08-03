#!/usr/bin/env bash
TOKEN=$(curl 'http://api.dev.devopseasy.com/oauth/oauth/token?client_id=client&client_secret=secret&grant_type=password&password=YWRtaW4%3D&username=admin' -X POST -H 'Accept: application/json, text/plain, */*' | jq -r '.access_token')
echo '查询组织结构'
curl -X GET --header 'Accept: application/json' --header 'Authorization: Bearer $TOKEN' 'http://localhost:8080/todo/organization/1'
echo "查询用户id为1（组织id为1）的用户"
curl -X GET --header 'Accept: application/json' --header 'Authorization: Bearer $TOKEN' 'http://localhost:8080/todo/organizations/1/users/1'
echo "插入查询到的用户数据"
curl -X POST --header 'Accept: application/json' --header 'Authorization: Bearer $TOKEN' 'http://localhost:8080/todo/organizations/1/users/1’
echo "通过id查询插入的用户数据"
curl -X GET --header 'Accept: application/json' --header 'Authorization: Bearer $TOKEN' 'http://localhost:8080/todo/userDto/1'




