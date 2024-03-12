package leetCode._1500

import scala.collection.mutable

object Solution_1410 {
  def entityParser(text: String): String = {
    val diff = mutable.HashMap(
      "&quot;" -> """\"""",
      "&apos;" -> "'",
      "&gt;" -> ">",
      "&lt;" -> "<",
      "&frasl;" -> "/"
    )

    diff.keySet./:(text)((b, key) => b.replaceAll(key, diff.getOrElse(key, ""))).replaceAll("&amp;", "&")
  }
}
