class KontoBankowe(val stan: Int, val setEmpty : Boolean) {
  private var stanKonta = 0;

  def this(stan: Int){
    this(stan, false)
    stanKonta = stan;
  }

  def this(setEmpty: Boolean){
    this(0, setEmpty);
    stanKonta = 0
  }

  def wplata(n: Int)={
    stanKonta += n;
  }

  def wyplata(n: Int)={
    stanKonta -= n;
  }

  def getStanKonta() : Int={
    stanKonta
  }
}
