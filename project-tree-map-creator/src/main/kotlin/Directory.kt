sealed class Directory {
    abstract val name: String

    data class RootDirectory(
        override val name: String,
        val path: String
    ) : Directory()

    data class NodeDirectory(
        override val name: String,
        val parent: Directory,
    ) : Directory()

}
