# ProjectTreeMapCreator 
## jarファイルの作成
```shell
$ make creator.createJar
```

## PlantUML用のファイル出力方法
```shell
$ java -jar build/libs/ProjectTreeMapCreator-1.0-all.jar --name=example.pu --path=/Users/tamura-masayuki/IdeaProjects/ProjectTreeMapCreator --depth=3

or

$ java -jar lib/project-tree-map-creator/ProjectTreeMapCreator-1.0-all.jar -n=example.pu -p=/Users/tamura-masayuki/IdeaProjects/ProjectTreeMapCreator -d=2
```

## ProjectTreeMap画像の出力方法
```shell
$ make plantuml.buildAndRun
```

## 生成されるProjectTreeMap画像の例
![example](https://user-images.githubusercontent.com/93519300/143557970-901e65d5-cc6c-495d-a1b4-4ab37e39de0d.png)
