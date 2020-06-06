package leetCode

object Solution_1410 {
  def entityParser(text: String): String = {
    text.replace("&quot;", "\"").
      replace("&apos;", "'").
      replace("&gt;", ">").
      replace("&lt;", "<").
      replace("&frasl;", "/").
      replace("&amp;", "&")
  }
}
