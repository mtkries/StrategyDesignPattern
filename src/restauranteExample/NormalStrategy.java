package restauranteExample;

//Normal billing strategy (unchanged price)
class NormalStrategy implements BillingStrategy {

 @Override
 public double getActPrice(final double rawPrice) {
     return rawPrice;
 }

}