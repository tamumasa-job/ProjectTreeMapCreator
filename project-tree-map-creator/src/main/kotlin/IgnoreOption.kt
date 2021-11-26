data class IgnoreOption(val ignoreDirectories: Set<String>, val limitedDepth: Int? = null) {
    fun checkIgnoreDirectory(name: String, depth: Int): Boolean =
        ignoreDirectories.contains(name) || depth == limitedDepth
}
