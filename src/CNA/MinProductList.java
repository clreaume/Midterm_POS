package CNA;

public class MinProductList extends Product {
    int num;

    public MinProductList(int num,String name,Double price){
        super(name,price);
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
        return num +". "+ super.getName()+" "+super.getPrice();
    }
}

