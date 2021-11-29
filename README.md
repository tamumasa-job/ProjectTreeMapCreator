# ProjectTreeMapCreator 
## PlantUML用のファイル出力方法
```shell
$ java -jar lib/project-tree-map-creator/ProjectTreeMapCreator-1.0-all.jar --name=example.pu --path=/Users/tamura-masayuki/IdeaProjects/ProjectTreeMapCreator --depth=4
```
### パラメータ
```
--name or -n：出力ファイル名
--depth or -d：対象とするディレクトリの深さ
--path or -p：調査対象のディレクトリパス
```

## ProjectTreeMap画像の出力方法
```shell
$ make plantuml.run

or

$ make plantuml.docker.buildAndRun
```

## 生成されるProjectTreeMap画像の例
![example](https://user-images.githubusercontent.com/93519300/143811273-a94a8133-08eb-4a6e-b1be-f53a27c8c8d2.png)


## jarファイルの作成からやる必要がある場合
```shell
$ make creator.createJar
$ java -jar project-tree-map-creator/build/libs/ProjectTreeMapCreator-1.0-all.jar -n=example.pu -p=/Users/tamura-masayuki/IdeaProjects/ProjectTreeMapCreator -d=2
```
