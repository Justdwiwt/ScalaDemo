package leetCode

import scala.collection.mutable

object Solution_556 {
  def nextGreaterElement(n: Int): Int = {
    val arr = n.toString.toCharArray
    if (arr.isEmpty) return -1
    val q = Array.fill(arr.length)(-1)
    val st = mutable.Stack[(Int, Int)]()
    st.push((arr(arr.length - 1), arr.length - 1))
    var i = arr.length - 2
    while (i >= 0) {
      while (st.nonEmpty && st.top._1 > arr(i)) {
        val (_, j) = st.pop()
        if (q(j) == -1) {
          q(j) = i
        }
      }
      st.push((arr(i), i))
      i -= 1
    }
    val m = q.max
    if (m == -1) return -1
    var find = q.length - 1
    var flag = true
    while (find >= 0 && flag) {
      if (q(find) == m) flag = false
      find -= 1
    }
    find += 1
    if (find == -1) return -1
    val t = arr(find)
    arr(find) = arr(q(find))
    arr(q(find)) = t
    try {
      (arr.take(q(find) + 1) ++ arr.drop(q(find) + 1).sorted).foldLeft("")(_ + _).toInt
    }
    catch {
      case _: Throwable => -1
    }
  }
}
