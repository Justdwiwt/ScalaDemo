package leetCode

object Solution_2287 {
  def rearrangeCharacters(s: String, target: String): Int = {
    val tf = target.getBytes.groupBy(identity).map { case (k, v) => (k, v.length) }
    val sf = s.getBytes.groupBy(identity).map { case (k, v) => (k, v.length) }
    var r = Int.MaxValue
    tf.foreach { case (b, fr) => r = r.min(sf.getOrElse(b, 0) / fr) }
    r
  }
}
