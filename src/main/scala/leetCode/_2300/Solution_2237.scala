package leetCode._2300

object Solution_2237 {
  def meetRequirement(n: Int, lights: Array[Array[Int]], requirement: Array[Int]): Int = {
    val diff = Array.fill(n + 1)(0)
    lights.foreach(light => {
      val p = light.head
      val r = light(1)
      diff.update(0.max(p - r), diff(0.max(p - r)) + 1)
      diff.update(n.min(p + r + 1), diff(n.min(p + r + 1)) - 1)
    })
    requirement.zip(diff).foldLeft((0, 0)) { case ((acc, cur), (r, d)) =>
      val newCur = cur + d
      (acc + (if (newCur >= r) 1 else 0), newCur)
    }._1
  }
}
