public class Dolar {
    private int amount;

    public Dolar(int amount) {
        this.amount = amount;
    }
    
  Dolar times(int multiplier){
        return new Dolar(amount * multiplier);
    }

    public int getAmount() {
        return amount;
    }
    
    @Override
    public boolean equals(Object object){
        Dolar dolar = (Dolar) object;
        return amount == dolar.amount;
    }
    
}
