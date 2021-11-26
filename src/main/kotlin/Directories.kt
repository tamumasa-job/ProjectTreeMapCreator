import java.io.File
import java.io.FileWriter

data class Directories(val directoryList: ArrayList<Directory>) {
    fun printForPlantUml() {
        val root = directoryList.filterIsInstance<Directory.RootDirectory>().firstOrNull() ?: return
        val output = arrayListOf<String>()
        recursiveTaskForPlantUml(output, root)
        output.forEach(::println)
    }

    fun printPath() {
        val root = directoryList.filterIsInstance<Directory.RootDirectory>().firstOrNull() ?: return
        val output = arrayListOf<String>()
        recursiveTaskForPath(output, root, root.path)
        output.forEach(::println)
    }

    private fun recursiveTaskForPath(output: ArrayList<String>, root: Directory, path: String) {
        output.add(path + "/" + root.name)
        directoryList
            .filter { it is Directory.NodeDirectory && it.parent == root }
            .forEach {
                recursiveTaskForPath(output, it, path + "/" + root.name)
            }
    }

    private fun recursiveTaskForPlantUml(output: ArrayList<String>, root: Directory, depth: Int = 0) {
        var outputString = "+"
        repeat(depth) {
            outputString += "+"
            if (it == depth - 1) outputString += " "
        }
        outputString += root.name
        output.add(outputString)
        directoryList.filter { it is Directory.NodeDirectory && it.parent == root }.forEach {
            recursiveTaskForPlantUml(output, it, depth = depth + 1)
        }
    }

    fun exportPlantUml(fileName: String) {
        val root = directoryList.filterIsInstance<Directory.RootDirectory>().firstOrNull() ?: return
        val output = arrayListOf<String>()
        recursiveTaskForPlantUml(output, root)
        val outputDir = File("plantuml")
        outputDir.mkdir()
        val file = File(outputDir, fileName)
        runCatching {
            FileWriter(file).use { writer ->
                writer.write("@startsalt\n{\n{T\n")
                writer.write(
                    buildString {
                        output.forEach { dirName ->
                            append("${dirName}\n")
                        }
                    }
                )
                writer.write("}\n}\n@endsalt")
            }
            file.createNewFile()
        }.onFailure {
            it.printStackTrace()
        }
    }
}