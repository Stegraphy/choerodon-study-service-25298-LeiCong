echo '查询组织结构'
$ curl -X GET --header 'Accept: application/json' --header 'Authorization: Bearer 1d77b148-ed70-476b-9a85-6eddce36dd2b' 'http://localhost:8080/todo/org/1'
echo "查询用户id为1（组织id为1）的用户"
$ curl -X GET --header 'Accept: application/json' --header 'Authorization: Bearer 1d77b148-ed70-476b-9a85-6eddce36dd2b' 'http://localhost:8080/todo/org/1'