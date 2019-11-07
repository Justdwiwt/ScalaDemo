package leetCode

import scala.collection.mutable
import scala.util.Random

object Solution_710 {

  class Solution(_N: Int, _blacklist: Array[Int]) {

    var m = new mutable.HashMap[Int, Int]()
    var r = new Random()
    private val wlen = _N - _blacklist.length
    var w = new mutable.HashSet[Int]()
    (wlen until _N).foreach(i => w.add(i))
    _blacklist.foreach(i => w.remove(i))
    private val wi = w.iterator
    _blacklist.foreach(i => if (i < wlen) m.put(i, wi.next()))

    def pick(): Int = {
      val k = r.nextInt(wlen)
      m.getOrElse(k, k)
    }
  }

}
