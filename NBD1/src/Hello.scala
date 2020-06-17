import scala.annotation.tailrec

object Hello extends App {
  val days: List[String] = List("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela");

  println("zdanie1");
  println("--A--")
  val sb = new StringBuilder();
  var s = new String;
  for(day <- days){
    if(days.last == day){
      sb.insert(sb.size, day);
    }else{
      sb.insert(sb.size, day+",");
    }
  }
  s = sb.toString();
  println(s);
  println()
  println("--B--");
  sb.clear();
  for(day <- days){
    if (day.startsWith("p")){
      if(days.last == day){
        sb.insert(sb.size, day);
      }else{
        sb.insert(sb.size, day+",");
      }
    }
  }
  s = sb.toString();
  println(s);
  println()
  println("--C--");
  var counter = 0;
  sb.clear();
  while(counter < days.size){
    var day = days(counter);
    if(days.last == day){
      sb.insert(sb.size, day);
    }else{
      sb.insert(sb.size, day+",");
    }
    counter += 1;
  }
  s = sb.toString();
  println(s);
  println()

  println("Zadanie 2");
  println("--A--");
  s = recurr(days);
  println(s);
  println()
  println("--B--");
  println(reverse(days));
  println()
  println("Zadanie 3")
  sb.clear();
  s = tailrecurrent(days);
  println(s);
  println()
  println("Zadanie 4")
  println("--A--");
  sb.clear();
  days.foldLeft() { (z, i) =>
      sb.insert(sb.size, i + ",");
  }
  println(sb.toString().dropRight(1));
  println()
  println("--B--");
  sb.clear()
  days.foldRight() { (z, i) =>
    sb.insert(sb.size, z + ",");
  }
  println(sb.toString().dropRight(1));
  println()
  println("--C--");
  sb.clear();
  days.foldLeft() { (z, i) =>
    if(i.startsWith("p"))
      sb.insert(sb.size, i + ",");
    }
  println(sb.toString().dropRight(1));
  println()
  println("Zadanie 5");
  val products = Map("banan" -> 1.0, "pomidor" -> 2.0, "zieminak" -> 0.5);
  val cheaperProducts = products map{case (key, value) => (key, value * 0.9)}
  println("Regular map: " + products);
  println("10% cheaper" + cheaperProducts);
  println()
  println("Zadanie 6");
  val (t1, t2, t3) = (0, 0.12, true);
  println(t1 + " " + t2 + " " + t3);
  println()
  println("Zadanie 7");
  val x = Option(5);
  val y = x.map(_ + 10);
  println(y);
  println()
  println("Zadanie 8");
  var numbersList = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0);
  println("Before removing: " + numbersList);
  println("After removing: " + remove(numbersList));
  println()
  println("Zadanie 9");
  println("Before increasing by 1: " + numbersList)
  println("After incereasing by 1: " + plusOne(numbersList));
  println()
  println("Zadanie 10");
  var realNumbers = List(-13, -5, -1.123, 0, 23, 8, 11.5, 1, 1.23, -4.2345, 12);
  println("Before filter: " + realNumbers);
  println("After filter: " + absValueFilter(realNumbers));

  def absValueFilter(n: List[Double]) : List[Double]={
    var list = n.filter(x => x >= -5 && x <= 12);
    list.map(_.abs);
  }

  def plusOne(n: List[Int]) : List[Int]={
    n.map(_ + 1);
  }

 def recurr(n: List[String]) : String={
   if(n.isEmpty)""
   else if(n.size == 1)  n.head + recurr(n.tail);
   else n.head + "," + recurr(n.tail);
 }

  def remove[A](src: List[A], dest: List[A] = Nil): List[A] ={
    if(src != Nil){
      if(src.head == 0){
        remove(src.drop(1), dest)
      }else{
        remove(src.drop(1), src.head :: dest);
      }
    }
    else dest;
  }

  def reverse(src: List[String]):String = {
    if (src.tail == Nil) {
      src.head;
    } else {
      reverse(src.tail) +","+src.head;
    }
  }

  def tailrecurrent(list: List[String]) : String = {
    @tailrec
    def tailrecurrentInner(list: List[String], result: String) : String = {
      if(list.isEmpty) {
        result
      } else {
        tailrecurrentInner(list.tail, result + ", " + list.head)
      }
    }

    tailrecurrentInner(list.tail, list.head)
  }
}