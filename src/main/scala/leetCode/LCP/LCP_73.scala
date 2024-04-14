package leetCode.LCP

object LCP_73 {
  def adventureCamp(a: Array[String]): Int = {
    val vis = collection.mutable.Set(a.head.split("->"): _*)
    var maxCnt = 0
    var ans = -1
    a.indices.drop(1).foreach(i => if (a(i) == "") {} else {
      var cnt = 0
      a(i).split("->").foreach(t => if (!vis(t)) {
        vis += t
        cnt += 1
      })
      if (cnt > maxCnt) {
        maxCnt = cnt
        ans = i
      }
    })
    ans
  }
}
