# Sample servlet application

## Deploy to App Service

```sh:
mvn package azure-webapp:deploy
```

## Tips

### カスタムコンテナ

- AppInsights エージェント 組み込みあり
  - `tsubasaxzzz/mvntest`
- AppInsights エージェント 組み込みなし
  - `tsubasaxzzz/mvntest:no-insights`
  - 組み込みなしの場合は、App Service 側の設定で`Application Insights`を有効にする必要がある

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

## 参考

- https://docs.microsoft.com/ja-jp/azure/azure-monitor/app/azure-web-apps-java#troubleshooting
- https://docs.microsoft.com/ja-jp/azure/azure-monitor/app/java-standalone-arguments
