# Sample servlet application

## Deploy to App Service

```sh:
mvn package azure-webapp:deploy
```

## Tips

### カスタムコンテナ

#### ビルド

```sh:
docker build  -t tsubasaxzzz/mvntest  .
```

#### 起動

```sh:
docker run  -p 8080:8080 -e LOG_LEVEL=debug -e APPLICATIONINSIGHTS_CONNECTION_STRING="Application Insights の接続文字列(Instrumental keyではない)" tsubasaxzzz/mvntest
```

### App Service

- "/demo" にアクセスする
- LOG_LEVEL を設定する
- 接続文字列を設定する
