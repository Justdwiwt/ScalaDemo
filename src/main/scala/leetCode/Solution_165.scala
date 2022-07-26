package leetCode

object Solution_165 {
  def compareVersion(version1: String, version2: String): Int = version1
    .split('.')
    .zipAll(version2.split('.'), "0", "0")
    ./:(0) { case (acc, (v1, v2)) => if (acc != 0) return acc else v1.toInt.compare(v2.toInt) }
}
