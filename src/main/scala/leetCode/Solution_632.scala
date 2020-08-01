package leetCode

object Solution_632 {

  class Node(_i: Int, _j: Int, _value: Int) {
    val i: Int = _i
    val j: Int = _j
    val value: Int = _value
  }

  def smallestRange(nums: List[List[Int]]): Array[Int] = {
    val inf = 0x3f3f3f
    var mx = -inf
    var start = -inf
    var end = inf
    val pq = new java.util.PriorityQueue[Node]((o1: Node, o2: Node) => Integer.compare(o1.value, o2.value))
    nums.indices.foreach(i => {
      val v = nums(i).head
      pq.offer(new Node(i, 0, v))
      mx = mx.max(v)
    })
    while (pq.size() == nums.length) {
      val node = pq.poll()
      val i = node.i
      val j = node.j
      val v = node.value
      if (mx - v < end - start) {
        start = v
        end = mx
      }
      if (j + 1 < nums(i).length) {
        val t = nums(i)(j + 1)
        pq.offer(new Node(i, j + 1, t))
        mx = mx.max(t)
      }
    }
    Array(start, end)
  }
}
