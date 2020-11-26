package leetCode

object Solution_1601 {
  def maximumRequests(n: Int, requests: Array[Array[Int]]): Int = {
    var res = 0
    (0 until 1 << requests.length).foreach(i => res = res.max(cal(n, requests, i)))
    res
  }

  def cal(n: Int, requests: Array[Array[Int]], mask: Int): Int = {
    val in = Array.fill(n)(0)
    val out = Array.fill(n)(0)
    requests.indices.foreach(i => {
      if (((1 << i) & mask) > 0) {
        out.update(requests(i)(0), out(requests(i)(0)) + 1)
        in.update(requests(i)(1), in(requests(i)(1)) + 1)
      }
    })
    in.indices.foreach(i => if (in(i) != out(i)) return -1)
    in.sum
  }
}
