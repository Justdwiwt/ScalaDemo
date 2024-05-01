package leetCode._1200

object Solution_1166 {

  class FileSystem {

    private val fileMap = collection.mutable.HashMap.empty[String, Int] += "" -> -1

    def createPath(path: String, value: Int): Boolean = {
      if (fileMap.contains(path)) return false
      val lastIdx = path.lastIndexOf("/")
      val parentPath = path.substring(0, lastIdx)
      if (!fileMap.contains(parentPath)) return false
      fileMap += path -> value
      true
    }

    def get(path: String): Int =
      fileMap.getOrElse(path, -1)
  }

}
