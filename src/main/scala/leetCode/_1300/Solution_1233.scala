package leetCode._1300

object Solution_1233 {
  def removeSubfolders(folder: Array[String]): List[String] = folder
    .sorted
    ./:(List.empty[String])((res, folder) => if (res.isEmpty || !folder.startsWith(res.last + "/")) res ::: List(folder) else res)
}
