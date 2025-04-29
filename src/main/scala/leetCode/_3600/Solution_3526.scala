package leetCode._3600

object Solution_3526 {
  def getResults(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val treap = new FHQTreap(nums.length)
    nums.foreach(treap.add)
    val resultBuffer = collection.mutable.ArrayBuffer[Int]()
    queries.foreach {
      case Array(1, i, x) => treap.set(i + 1, x)
      case Array(2, l, r) => resultBuffer += treap.query(l + 1, r + 1)
      case Array(3, l, r) => treap.reverseRange(l + 1, r + 1)
    }
    resultBuffer.toArray
  }
}

class FHQTreap(len: Int) {
  private val key = new Array[Int](len + 2)
  private val lc = new Array[Int](len + 2)
  private val rc = new Array[Int](len + 2)
  private val sz = new Array[Int](len + 2)
  private val xor = new Array[Int](len + 2)
  private val priority = Array.fill(len + 2)(math.random())
  private val reverse = new Array[Boolean](len + 2)

  private var head = 0
  private var no = 0

  def set(o: Int, v: Int): Unit =
    if (o == 1) {
      split(0, 0, head, o)
      val lx = rc(0)
      val rx = lc(0)
      key(lx) = v
      xor(lx) = v
      head = merge(lx, rx)
    } else {
      split(0, 0, head, o)
      val mx = rc(0)
      val rx = lc(0)
      split(0, 0, mx, o - 1)
      val lx = rc(0)
      val mm = lc(0)
      key(mm) = v
      xor(mm) = v
      head = merge(merge(lx, mm), rx)
    }

  def query(l: Int, r: Int): Int =
    if (l == 1) {
      split(0, 0, head, r)
      val lx = rc(0)
      val rx = lc(0)
      val ans = xor(lx)
      head = merge(lx, rx)
      ans
    } else {
      split(0, 0, head, r)
      val mx = rc(0)
      val rx = lc(0)
      split(0, 0, mx, l - 1)
      val lx = rc(0)
      val mm = lc(0)
      val ans = xor(mm)
      head = merge(merge(lx, mm), rx)
      ans
    }

  def add(k: Int): Unit = {
    val (l, r) = {
      split(0, 0, head, sz(head))
      (rc(0), lc(0))
    }
    head = merge(merge(l, create(k)), r)
  }

  def reverseRange(l: Int, r: Int): Unit = {
    split(0, 0, head, r)
    val i3 = lc(0)
    val i2 = rc(0)
    split(0, 0, i2, l - 1)
    val i1 = rc(0)
    val mid = lc(0)
    reverse(mid) ^= true
    head = merge(merge(i1, mid), i3)
  }

  private def split(l: Int, r: Int, i: Int, rk: Int): Unit = {
    if (i == 0) {
      rc(l) = 0
      lc(r) = 0
      return
    }
    down(i)
    if (sz(lc(i)) + 1 <= rk) {
      rc(l) = i
      split(i, r, rc(i), rk - sz(lc(i)) - 1)
    } else {
      lc(r) = i
      split(l, i, lc(i), rk)
    }
    up(i)
  }

  private def merge(l: Int, r: Int): Int = {
    if (l == 0 || r == 0) return l + r
    if (priority(l) >= priority(r)) {
      down(l)
      rc(l) = merge(rc(l), r)
      up(l)
      l
    } else {
      down(r)
      lc(r) = merge(l, lc(r))
      up(r)
      r
    }
  }

  private def up(i: Int): Unit = {
    sz(i) = sz(lc(i)) + sz(rc(i)) + 1
    xor(i) = xor(lc(i)) ^ xor(rc(i)) ^ key(i)
  }

  private def down(i: Int): Unit =
    if (reverse(i)) {
      val tmp = lc(i)
      lc(i) = rc(i)
      rc(i) = tmp
      if (lc(i) != 0) reverse(lc(i)) ^= true
      if (rc(i) != 0) reverse(rc(i)) ^= true
      reverse(i) = false
    }

  private def create(k: Int): Int = {
    no += 1
    key(no) = k
    xor(no) = k
    sz(no) = 1
    no
  }
}
