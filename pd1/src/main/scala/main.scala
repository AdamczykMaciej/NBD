import scala.annotation.tailrec
import scala.math.abs
import scala.language.postfixOps

object main {

  def funcForConcat(x:List[String]): String = {
    var result = ""
    for(el <- x){
      result+=el+","
    }
    return result
  }

  def funcFor2Concat(x:List[String]): String = {
    var result = ""
    for(el <- x){
      if(el.startsWith("P"))
        result+=el+","
    }
    return result
  }

  def funcWhileConcat(x:List[String]): String = {
    var result = ""
    var i = 0
    while(i!=x.length) {
      result+=x(i)+","
      i=i+1
    }
    return result
  }

  def recursiveFunc(x:List[String], i:Integer=0, result:String=""): String ={
    if(i==x.length)
      return result
    recursiveFunc(x,i+1, result+x(i)+",")
  }

  def recursiveFunc2(x:List[String], i:Integer, result:String=""): String ={
    if(i<0)
      return result
    recursiveFunc2(x,i-1, result+x(i)+",")
  }

  @tailrec
  def tailRecursion(x:List[String], i:Integer=0, result:String=""): String ={
    if(i==x.length)
      return result
    tailRecursion(x,i+1, result+x(i)+",")
  }

  def foldLConcat(x:List[String]): String = {
    return x.foldLeft("")(_ + _+",")
  }

  def foldRConcat(x:List[String]): String = {
    return x.foldRight("")(_+","+ _)
  }

  def foldL2(x:List[String]): String = {
    return x.foldLeft(""){
      (z, f) => {
        if(f.startsWith("P"))
          z+f+",".toString
        else
          z
      }
    }
  }

  def printTuple(tuple3: (Any,Any, Any))={
    tuple3.productIterator.foreach(println)
  }

  @tailrec
  def removeZeros(x:List[Int], i:Integer=0, result:List[Int]=List()):List[Int]={
    if(i==x.length)
      return result
    if(x(i)!=0) {
      var p = x(i) :: result
      removeZeros(x, i + 1, p)
    }else {
      removeZeros(x, i + 1, result)
    }
  }

  def incrementBy1(x:List[Double]):List[Double] = {
    return x.map(_+1)
  }

  def filterAndAbs(x:List[Double]): List[Double] ={
    return x.filter(z => ( z >= -5 && z <= 12)).map(_ abs)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val x = List("Poniedzialek","Wtorek","Sroda","Czwartek","Piatek","Sobota", "Niedziela")
    println("1.)")
    println(funcForConcat(x))
    println(funcFor2Concat(x))
    println(funcWhileConcat(x))
    // Exercise 2
    println("2.)")
    println(recursiveFunc(x))
    println(recursiveFunc2(x, x.length-1))
    // Exercise 3
    println("3.)")
    println(tailRecursion(x))
    // Exercise 4
    println("4.)")
    println(foldLConcat(x))
    println(foldRConcat(x))
    println(foldL2(x))
    // Exercise 5
    var mapa = Map("car"->10.0, "ball" -> 20.0)
    mapa = mapa.map(n=>n._1 -> (n._2-0.1*n._2))
    println(mapa)
    // Exercise 6
    println("6.)")
    printTuple(("Something",1, 5.0))
    // Exercise 7
    println("7.)")
    val a:Option[Int] = Some(2)
    val b:Option[Int] = None
    val c = null
    println("a.getOrElse(0): " + a.getOrElse(0) )
    println("b.getOrElse(10): " + b.getOrElse(10) )
    println("c: "+c)
    // Exercise 8
    println("8.)")
    var lst = List(-5,-4,-3,-2,-1,0,1,2,3,4,5)
    println(removeZeros(lst))
    // Exercise 9
    println("9.)")
    var lst2 = List(-5.234,-4,-3.23132,-2,-1.213,0,1.112,2,3.4,4.9,5)
    print(incrementBy1(lst2))
    // Exercise 10
    println("\n10.)")
    println(filterAndAbs(lst2))
  }
}
