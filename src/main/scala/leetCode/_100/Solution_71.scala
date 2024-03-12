package leetCode._100

object Solution_71 {
  def simplifyPath(path: String): String =
    "/" + path.split("/").filter(_.nonEmpty).filter(_ != ".")./:(Vector.empty[String])((r, cur) => cur match {
      case ".." => if (r.length > 1) r.init else Vector.empty[String]
      case _ => r :+ cur
    }).mkString("/")
}
