import java.io.File
import java.util.ArrayList

object DirectoryService {
    fun profileDirectories(path: String, option: IgnoreOption? = null): Directories {
        val result = arrayListOf<Directory>()
        profileDirectory(path = path, directories = result, parent = null, option = option)
        return Directories(result)
    }

    private fun profileDirectory(
        path: String,
        directories: ArrayList<Directory>,
        depth: Int = 0,
        parent: Directory? = null,
        option: IgnoreOption? = null
    ) {
        val file = File(path)
        if (!file.isDirectory) return
        val dirName = path.split("/").lastOrNull() ?: return kotlin.run {
            println("予期していないパスが渡されました")
        }
        val directory = when (parent) {
            null -> Directory.RootDirectory(name = dirName, path = path)
            else -> Directory.NodeDirectory(name = dirName, parent = parent)
        }
        directories.add(directory)
        File(path).list()?.forEach { name ->
            if (option?.checkIgnoreDirectory(name, depth) == true) return@forEach
            profileDirectory(
                path = "${path}/${name}",
                directories = directories,
                depth = depth + 1,
                parent = directory,
                option = option
            )
        }
    }
}
