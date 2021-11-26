class ProfileArgs(args: Array<String>) {
    var path: String = "~/Documents"
    var fileName: String = "output.pu"
        private set
    var depth: Int? = null
        private set
    init {
        args.forEach { arg ->
            val params = arg.split("=")
            when(params.firstOrNull()) {
                "--path" -> path = params.getOrNull(1) ?: return@forEach
                "--name", "-n" -> fileName = params.getOrNull(1) ?: "output.pu"
                "--depth", "-d" -> depth = params.getOrNull(1)?.toIntOrNull()
            }
        }
    }
}