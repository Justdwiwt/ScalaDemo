package leetCode._3300

object Solution_3206 {
  def numberOfAlternatingGroups(colors: Array[Int]): Int = {
    val extendedColors = colors ++ colors
    colors.indices.count(i => extendedColors(i) == extendedColors(i + 2) && extendedColors(i) != extendedColors(i + 1))
  }
}
