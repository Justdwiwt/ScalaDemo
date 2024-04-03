package leetCode._700

object Solution_609 {
  def findDuplicate(paths: Array[String]): List[List[String]] = {
    val regex = "(.+)\\((.+)\\)".r

    paths
      .toList
      .flatMap(_.split(' ').toSeq match { case d +: fs => fs.map { case regex(path, content) => content -> (d + "/" + path) } })
      .groupBy(_._1)
      .values
      .foldLeft(List.empty[List[String]])((acc, group) => if (group.size > 1) acc :+ group.map(_._2) else acc)
  }
}
