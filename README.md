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

## UML図の出力方法
```shell
$ make plantuml.buildAndRun
```