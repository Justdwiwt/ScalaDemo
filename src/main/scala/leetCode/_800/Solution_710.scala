package leetCode._800

import scala.collection.mutable
import scala.util.Random

object Solution_710 {

  class Solution(_N: Int, _blacklist: Array[Int]) {

    var m = new mutable.HashMap[Int, Int]()
    var r = new Random()
    private val wlen = _N - _blacklist.length
    var w = new mutable.HashSet[Int]()
    (wlen until _N).foreach(w.add(_))
    _blacklist.foreach(w.remove(_))
    private val wi = w.iterator
    _blacklist.foreach(i => if (i < wlen) m.put(i, wi.next()))

    def pick(): Int = {
      val k = r.nextInt(wlen)
      m.getOrElse(k, k)
    }
  }

}
