trait Pracownik extends Osoba2{
  private var pensja :Int = _;
  override def podatek :Int = 20

  def getPensja: Int ={
    pensja
  }

  def setPensja(n:Int)={
    pensja = n;
  }
}
