package CNA;

public class ProductList extends Product{
int num;
    public ProductList(){

    }
    public ProductList(String name, double price){

        super(name,price);
    }
    public ProductList(int num, String name, double price, String category, String description){

        super(name, price, category, description);
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return num + "- " + super.getName()+"   "+super.getPrice()+"\nCategory: "+super.getCategory()+"\n"+super.getDescription();
    }

}
