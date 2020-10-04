package leetCode

object Solution_1233 {
  def removeSubfolders(folder: Array[String]): List[String] = {
    folder.sorted.foldLeft(List.empty[String]) { (res, folder) =>
      if (res.isEmpty || !folder.startsWith(res.last + "/")) res ::: List(folder) else res
    }
  }
}
