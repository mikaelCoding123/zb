```angular2html
docker 后台启动redis
docker run -d -p 6379:6379 --name redis-redisbloom-6379 redislabs/rebloom:latest
```
```
----docker 安装带有布隆过滤器的redis
docker pull redislabs/rebloom:latest
  docker run -p 6379:6379 --name redis-redisbloom redislabs/rebloom:latest
  docker exec -it redis-redisbloom bash
  # redis-cli
  # 127.0.0.1:6379> bf.add tiancheng hello
```
```angular2html
问题 The container name "/redis-redisbloom-6379" is already in use by container
需要删除同名的
docker ps -a

docker rm 容器名

```