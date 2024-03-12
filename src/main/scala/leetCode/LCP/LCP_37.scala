package leetCode.LCP

object LCP_37 {
  def minRecSize(lines: Array[Array[Int]]): Double = {
    var mxX = Float.MinValue
    var mxY = Float.MinValue
    var mnX = Float.MaxValue
    var mnY = Float.MaxValue

    if (lines.length <= 2) return 0

    val mnDic = Array.fill(10000 + 1)(Int.MaxValue)
    val mxDix = Array.fill(10000 + 1)(Int.MinValue)

    var ks = Array.emptyIntArray

    lines.foreach(li => {
      val k = li.head
      val b = li(1)
      if (mnDic(k) == Int.MaxValue) ks :+= k
      mnDic(k) = mnDic(k).min(b)
      mxDix(k) = mxDix(k).max(b)
    })

    if (ks.length == 1) return 0

    ks = ks.sorted

    ks.indices.drop(1).foreach(i => {
      val curK = ks(i)
      val mnCurB = mnDic(curK)
      val mxCurB = mxDix(curK)
      val lastK = ks(i - 1)
      val mnLastB = mnDic(lastK)
      val mxLastB = mxDix(lastK)
      val diff = (lastK - curK).toFloat
      mnX = mnX.min((mxCurB - mnLastB) / diff)
      mxX = mxX.max((mnCurB - mxLastB) / diff)
      mnY = mnY.min((lastK * mxCurB - curK * mnLastB) / diff)
      mxY = mxY.max((lastK * mnCurB - curK * mxLastB) / diff)
    })
    (mxX - mnX) * (mxY - mnY)
  }
}
