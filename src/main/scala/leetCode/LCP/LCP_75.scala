package leetCode.LCP

import scala.collection.mutable

object LCP_75 {
  def challengeOfTheKeeper(mz: Array[String]): Int = {
    val m = mz.length
    val n = mz.head.length

    val arr = Array.fill(m, n)(-1)
    var s = (0, 0)
    var t = (0, 0)

    mz
      .indices
      .map { i => val row = mz(i); (i, row) }
      .flatMap { case (i, row) => row
        .indices
        .map { j => val v = row(j); (j, v) }
        .map { case (j, v) =>
          v match {
            case '.' =>
            case '#' => arr(i)(j) = Int.MaxValue
            case 'S' => s = (i, j)
            case 'T' => t = (i, j)
          }
        }
      }

    arr(t._1)(t._2) = 0
    val q = mutable.Queue.empty[(Int, Int)] += t
    var step = 1

    while (q.nonEmpty) {
      val tmp = q.dequeueAll(_ => true).toArray
      tmp
        .flatMap { case (i, j) => Array((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1))
          .withFilter { case (x, y) => x >= 0 && x < m && y >= 0 && y < n && arr(x)(y) == -1 }
          .map { case (x, y) =>
            arr(x)(y) = step
            q += ((x, y))
          }
        }
      step += 1
    }

    val g1 = arr.map(_.clone())

    mz.indices.flatMap(i => mz.head.indices
      .withFilter(j => arr(i)(j) != Int.MaxValue && arr(i)(j) != -1 && (i, j) != s && (i, j) != t)
      .map(j =>
        if (mz(m - 1 - i)(j) == '#' && mz(i)(n - 1 - j) == '#') arr(i)(j) = 0
        else if (mz(m - 1 - i)(j) == '#') arr(i)(j) = g1(i)(n - 1 - j)
        else if (mz(i)(n - 1 - j) == '#') arr(i)(j) = g1(m - 1 - i)(j)
        else {
          arr(i)(j) = g1(m - 1 - i)(j).max(g1(i)(n - 1 - j))
          if (g1(m - 1 - i)(j) < 0 || g1(i)(n - 1 - j) < 0) arr(i)(j) = -1
        })
    )

    def check(xx: Int): Boolean = {
      val seen = mutable.Set.empty[(Int, Int)] += s
      val q = mutable.Queue.empty[(Int, Int)] += s
      var found = false
      while (q.nonEmpty && !found) {
        q.dequeueAll(_ => true).toArray.foreach {
          case (i, j) => Array((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1))
            .withFilter { case (x, y) => x >= 0 && x < m && y >= 0 && y < n && arr(x)(y) <= xx && arr(x)(y) != -1 && !seen((x, y)) }
            .map { case (x, y) =>
              if ((x, y) == t) found = true
              seen += ((x, y))
              q += ((x, y))
            }
        }
      }
      found
    }

    (0 until step)
      .takeWhile(_ => true)
      .find(check)
      .getOrElse(-1)
  }
}
