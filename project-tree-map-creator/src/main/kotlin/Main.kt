fun main(args: Array<String>) {
    val profileArgs = ProfileArgs(args)
    val ignoreList = setOf(".git", ".circleci")
    DirectoryService.profileDirectories(
                    profileArgs.path,
                    IgnoreOption(ignoreDirectories = ignoreList, limitedDepth = profileArgs.depth)
            )
            .apply {
                printPath()
                exportPlantUml(profileArgs.fileName)
            }
}
