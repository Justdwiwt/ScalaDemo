package leetCode._200

object Solution_165 {
  def compareVersion(version1: String, version2: String): Int = version1
    .split("\\.")
    .zipAll(version2.split("\\."), "0", "0")
    .collectFirst {
      case (v1Revision, v2Revision) if v1Revision.toInt != v2Revision.toInt => if (v1Revision.toInt > v2Revision.toInt) 1 else -1
    }
    .getOrElse(0)
}
