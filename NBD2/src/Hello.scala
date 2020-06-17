object Hello extends App{
  val days: List[String] = List("poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela");
  println("Zadanie 1")
  for(day <- days){
    print(day+" ");
    println(patternMatch(day));
  }
  println()

  println("Zadanie 2");
  var acc = new KontoBankowe(1000);
  var acc2 = new KontoBankowe(true);
  println(acc.getStanKonta());
  println(acc2.getStanKonta());
  println()

  println("Zadanie 3");
  var o1 = new Osoba("Przemek", "Test1");
  var o2 = new Osoba("Przemek", "Test2");
  var o3 = new Osoba("Przemek", "Test3");
  var o4 = new Osoba("Przemek", "Test4");
  var o5 = new Osoba("Przemek", "Test5");
  println(personGreater(o1));
  println(personGreater(o2));
  println(personGreater(o3));
  println(personGreater(o4));
  println(personGreater(o5));
  println()

  println("Zadanie 4");
  println(anotherNiceFunction(2, niceFunction))
  println()

  println("Zadanie 5");
  val p = new Osoba2("Przemek", "Test") with Pracownik;
  val n = new Osoba2("Przemek", "Test2") with Nauczyciel;
  val s = new Osoba2("Przemek", "Test3") with Student;
  val sp = new Osoba2("Przemek", "Test4") with Pracownik with Student
  val sp2 = new Osoba2("Przemek", "Test4") with Student with Pracownik

  println("Podatek studenta: " + s.podatek + "%");
  println("Podatek nauczyciela: " + n.podatek + "%");
  println("Podatek pracownika: " + p.podatek + "%");
  println("Podatek pracownik with student: " + sp.podatek + "%");
  println("Podatek student with pracownik: " + sp2.podatek + "%");

  def anotherNiceFunction(n: Int, func: (Int) => Int): Int={
    func(func(func(n)));
  }

  def niceFunction(n: Int): Int={
    n*n;
  }

  def personGreater(n: Osoba): String={
    n match {
      case Osoba(_, "Test1") => "Dzień dobry " + n.lastName + " " + n.firstName
      case Osoba(_, "Test2") => "Witaj " + n.lastName + " " + n.firstName
      case Osoba(_, "Test3") => "Dobry wieczór " + n.lastName + " " + n.firstName;
      case _ => "Hej " + n.lastName + " " + n.firstName;
    }
  }

  def patternMatch(n: String) : String={
    n match{
      case "sobota" => "Weekend"
      case "niedziela" => "Weekend"
      case _ => "Praca"
    }
  }
}

